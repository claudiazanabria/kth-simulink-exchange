from wsgiref.simple_server import WSGIServer 
from threading import Thread

from matlab_app import MatlabApplication

from se.kth.md.oslc import IServer  
        

class StoppableWSGIServer(WSGIServer):
    stopped = False

    def serve_forever(self):
        while not self.stopped:            
            self.handle_request()
            
    def force_stop(self):
        #called to clean-up the server
        self.server_close()
        self.stopped = True
                    

class StoppableWSGIServerDaemon(Thread):
    
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

        
class ServerController(IServer): 
    """    
    WSGI Server that runs with MatlabApplication.
    It's run method supposed to be called from Matlab.
    """
    def __init__(self, host='127.0.0.1', port=8080):                
        self.application = MatlabApplication()        
        self.daemon = StoppableWSGIServerDaemon(self.application, host, port)   
        
    def run(self):   
        self.daemon.start()        
        
    def kill(self):
        self.daemon.server.force_stop()    
    
    def addRequestEventListener(self, listener):
        self.application.addHTTPGETEventListener(listener)
    
    def addRequestEventListener(listener):        
        self.application.removeHTTPGETEventListener(listener)
          
    