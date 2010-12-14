from bottle import Bottle, run
from bottle import route, request
from java.util import HashMap
from se.kth.md import MatlabProxy, IBottleServer 


class MatlabApplication(Bottle):
    """
    Bottle application that runs in bottle server and stores MatlabProxy inside.
    The application sends queries to Matlab and gets answers from it.
    """
    def __init__(self, matlab_proxy, *args, **kwargs):
        super(MatlabApplication, self).__init__(*args, **kwargs)
        self.matlab_proxy = matlab_proxy
        
        @self.route('/ping')
        def send_data():            
            dict = HashMap()
            for key, value in request.GET:
                dict.put(key, value)        
            result = matlab_proxy.fireHTTPGetEvent(dict)
            return 'Result is %s' % result    

        
class Server(IBottleServer):    
    """
    Bottle Server that runs with MatlabApplication.
    It's runServer method supposed to be called from Matlab.
    """
    def __init__(self, matlab_proxy):
        self.matlab_proxy = matlab_proxy        
        self.application = MatlabApplication(matlab_proxy)
        
    def runServer(self, host='localhost', port=8080):    
        run(app=self.application, host=host, port=port)


    
  