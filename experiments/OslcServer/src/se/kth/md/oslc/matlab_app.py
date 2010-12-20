from os.path import abspath, dirname, join
import time

from bottle import Bottle
from bottle import route, request, view

from java.util import HashMap
from se.kth.md.oslc import GetRequest, Server
import se.kth.md.oslc.Server
import se.kth.md.oslc.Server.RequestEvent


class MatlabApplication(Bottle):    
    """    
    The application sends queries to Matlab and gets answers from it.
    """    
    def __init__(self, *args, **kwargs):
        super(MatlabApplication, self).__init__(*args, **kwargs)    
        self.listeners = []        
        
        @self.route('/gain_block')        
        def send_data():                     
            dict = HashMap()            
            for key in request.GET:
                dict.put(key, request.GET[key])   
                          
            oslc_request = self.fireGetEvent(dict)            
            
            while not oslc_request.isAnswer_ready():
                time.sleep(100)            
            
            return 'Result %s' % oslc_request.getAnswer()
        
        @self.route('/images/:filename#.*\.png#')
        def send_image(filename):
            return static_file(filename, root=self.PATH_TO_STATIC_FILES, mimetype='image/png')

        @self.route('/media/:filename')
        def send_static(filename):            
            return static_file(filename, root=self.PATH_TO_STATIC_FILES)
        
    def fireGetEvent(self, data):         
        oslc_request = GetRequest()        
        oslc_request.setQuery(data)        
        event = se.kth.md.oslc.Server.RequestEvent(self, oslc_request)        
        for listener in self.listeners:
            listener.requestArrived(event)
        return oslc_request
    
    def addRequestEventListener(self, listener):
        self.listeners.append(listener)
    
    def removeRequestEventListener(listener):        
        self.listeners.remove(listener)