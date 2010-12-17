from se.kth.md.oslc import IServer
from wsgiref.simple_server import WSGIServer 
from threading import Thread  
        

class StoppableWSGIServer(WSGIServer):
    stopped = False

    def serve_forever(self):
        while not self.stopped:            
            self.handle_request()
            
    def force_stop(self):
        #called to clean-up the server
        self.server_close()
        self.stopped = True
                    

class ServerThread(Thread):
    
    def __init__(self, app, host='127.0.0.1', port=8080):
        Thread.__init__(self)
        self.host = host
        self.port = port
        self.app = app
        from wsgiref.simple_server import make_server        
        self.server = make_server(host, port, app, server_class=StoppableWSGIServer)
    
    def run(self):
        print "Oslc server starting up ..."
        print "Listening on http://%s:%d/" % (self.host, self.port)
        self.server.serve_forever()

        
class Server(IServer): 
    """    
    WSGI Server that runs with MatlabApplication.
    It's run method supposed to be called from Matlab.
    """
    def __init__(self, host='127.0.0.1', port=8080):                
        #self.application = MatlabApplication()
        self.application = None
        self.serverThread = ServerThread(self.application, host, port)   
        
    def run(self):   
        self.serverThread.start()        
        
    def stop(self):
        self.serverThread.server.force_stop()
          
    