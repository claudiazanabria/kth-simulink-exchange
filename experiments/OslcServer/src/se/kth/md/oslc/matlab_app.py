from os.path import abspath, dirname, join

from bottle import Bottle
from bottle import route, request, view

from java.util import HashMap
from se.kth.md.SimulinkOOAPI import IGainBlock
from se.kth.md.SimulinkOOAPI.util import YorkModel

class MatlabApplication(Bottle):    
    """    
    The application sends queries to Matlab and gets answers from it.
    """    
    # Set PATH to absolute path of current directory
    PATH = abspath(dirname(__file__))    
    PATH_TO_STATIC_FILES = join(PATH, 'views')     
   
    def __init__(self, *args, **kwargs):
        super(MatlabApplication, self).__init__(*args, **kwargs)    
        
        @self.route('/gain_block')
        @view('gain_block') #renders gain_block.tpl
        def send_data():                     
            dict = HashMap()            
            for key in request.GET:
                dict.put(key, request.GET[key])             
            return {'object': self.get_gain_block(dict)}       
        
        @self.route('/images/:filename#.*\.png#')
        def send_image(filename):
            return static_file(filename, root=self.PATH_TO_STATIC_FILES, mimetype='image/png')

        @self.route('/media/:filename')
        def send_static(filename):            
            return static_file(filename, root=self.PATH_TO_STATIC_FILES)
        
    def get_gain_block(self, dict):
        """
        Temporary method for the testing.
        Simulink objects have to be requested from Matlab
        """            
        model = YorkModel.buildWithSimulinkOOAPI()
        print dict
        if 'name' in dict:
            return model.childWith(dict['name'])
            
        if 'gain' in dict:
            for gain_block in model.getChildrenOfTypeGainBlock():
                if gain_block.getGain() == dict['gain']:
                    return gain_block
        return None
        