from os.path import abspath, dirname, join

from bottle import static_file
from bottle import Bottle, run
from bottle import route, request, view

from java.util import HashMap
from se.kth.md import MatlabProxy, IBottleServer 
from se.kth.md.SimulinkOOAPI import IGainBlock
from se.kth.md.SimulinkOOAPI.util import YorkModel


class MatlabApplication(Bottle):    
    # Set PATH to absolute path of current directory
    PATH = abspath(dirname(__file__))    
    PATH_TO_STATIC_FILES = join(PATH, 'views') 
    
    """
    Bottle application that runs in bottle server and stores MatlabProxy inside.
    The application sends queries to Matlab and gets answers from it.
    """
    def __init__(self, matlab_proxy, *args, **kwargs):
        super(MatlabApplication, self).__init__(*args, **kwargs)
        self.matlab_proxy = matlab_proxy
        
        def get_gain_block(self, dict):
            """
            Temporary method for the testing.
            Simulink objects have to be requested from Matlab
            """
            
            model = YorkModel.buildWithSimulinkOOAPI()
            if 'name' in dict:
                return model.childWith(dict['name'])
            
            if 'gain' in dict:
                for gain_block in model.getChildrenOfTypeGainBlock():
                    if gain_block.getGain() == dict['gain']:
                        return gain_block
            return None
    
        
        @self.route('/gain_block')
        @view('gain_block') #renders gain_block.tpl
        def send_data():            
            dict = HashMap()            
            for key in request.GET:
                dict.put(key, request.GET[key])        
            result = matlab_proxy.fireHTTPGetEvent(dict)
            #return 'Result is %s' % result
            
            #res = self.get_gain_block(dict)
            model = YorkModel.buildWithSimulinkOOAPI()
            
            if 'name' in dict:                
                 return {'object': model.childWith(dict['name'])}
            
            if 'gain' in dict:
                for gain_block in model.getChildrenOfTypeGainBlock():
                    if gain_block.getGain() == int(dict['gain']):                        
                        return {'object': gain_block}
            
            return {'object': None}       
        
        @self.route('/images/:filename#.*\.png#')
        def send_image(filename):
            return static_file(filename, root=self.PATH_TO_STATIC_FILES, mimetype='image/png')

        @self.route('/media/:filename')
        def send_static(filename):            
            return static_file(filename, root=self.PATH_TO_STATIC_FILES)  
        
        
        
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
