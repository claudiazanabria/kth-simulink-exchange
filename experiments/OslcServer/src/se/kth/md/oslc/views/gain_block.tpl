<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html lang="en">
<head>
  <title>Simulink Object</title>
  <meta http-equiv=content-type content="text/html; charset=utf-8">
  <link rel="stylesheet" type="text/css" media="all" href="/media/reset.css" />
  <link rel="stylesheet" type="text/css" media="all" href="/media/text.css" />
  <link rel="stylesheet" type="text/css" media="all" href="/media/960_24_col.css" />  
  <link rel="stylesheet" type="text/css" href="/media/style.css" MEDIA=screen> </link>  
</head>

<div class="container_24">

        <div class="grid_24 ">        
           <h1>The requested Object </h1>            
        </div>          
        <div class="clear">&nbsp;</div>

        
        <div class="grid_24 twocolbackground">
        
                <div class="grid_6 alpha">
                    <div class="leftcolumn">                        
						  
                    </div>
                </div><!-- end grid_6 alpha -->

                <div class="grid_18 omega">
                      <h1>DETAILS</h1>		  
                      %if object == None:
                          Not found
                      
                      %else:
                          <table>
	                      <tr><th>Name:</th><td>{{ object.getName() }}</td></tr>
	                      <tr><th>UUID:</th><td>{{ object.getUuid() }}</td></tr>
	                      	                          
	                      </table>	                       
	                  %end                    
	                       
                </div>
                               
                <div class="clear">&nbsp;</div>

        </div><!-- end grid_24 -->
        
        <div class="clear">&nbsp;</div>           
        
        
</div><!-- end container_24 -->

</html>