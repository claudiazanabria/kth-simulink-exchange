from os.path import abspath, dirname, join
import time

from bottle import Bottle
from bottle import route, request, view

from java.util import HashMap
from se.kth.md.oslc import HTTPGetEvent


class MatlabApplication(Bottle):    
    """    
    The application sends queries to Matlab and gets answers from it.
    """    
    def __init__(self, *args, **kwargs):
        super(MatlabApplication, self).__init__(*args, **kwargs)    
        self.listeners = ()
        self.event = None
        
        @self.route('/gain_block')        
        def send_data():                     
            dict = HashMap()            
            for key in request.GET:
                dict.put(key, request.GET[key])                     
            self.fireHTTPGetEvent(dict)     
            time.sleep(60)
            return "Hi"
        
        @self.route('/images/:filename#.*\.png#')
        def send_image(filename):
            return static_file(filename, root=self.PATH_TO_STATIC_FILES, mimetype='image/png')

        @self.route('/media/:filename')
        def send_static(filename):            
            return static_file(filename, root=self.PATH_TO_STATIC_FILES)
        
    def fireHTTPGetEvent(self, data):        
        self.event = HTTPGetEvent(self, data)        
        for listener in self.listeners:
            listener.GETRequestArrived(event)
    
    def addHTTPGETEventListener(self, listener):
        self.listeners.append(listener)
    
    def removeHTTPGETEventListener(listener):        
        self.listeners.remove(listener)