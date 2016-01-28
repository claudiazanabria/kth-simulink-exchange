# Tips and Tricks #

## SVN ##

My preferred workflow now is to checkout the whole repository with TortoiseSVN. Then from Eclipse, import the projects I want to work with.

## Eclipse ##

### Importing projects ###
Select from the menu: File->Import->General->Existing projects into wrokspace.

### Uninstalling plugins ###

There are two ways, depending on how you installed the plugin.

  1. Through an update site. Then, the plugin is contained within a feature, and you will uninstall the whole feature. Go to Help->About Eclipse->Installation Details. The first tab "Installed Software" will show the features that can be removed. Select a feature and the uninstall button will become available.
  1. By dropping a JAR or folder in the Eclipse plugin directory. Then, simply close Eclipse and remove the folder/JAR.

### Demo Project ###
There is a demo project with all the files you need for a test run, in [SVN\_REPO/trunk/Eclipse/Demo Project](http://code.google.com/p/kth-simulink-exchange/source/browse/#svn/trunk/Eclipse/Demo%20Project).

### ATL transformations ###

If you want to run an ATL transformation, and you have not packaged and installed it in an Eclipse plugin, you will need the ATL source code.

The source code for our transformations is in the Eclipse project: [ATLtrafos](http://code.google.com/p/kth-simulink-exchange/source/browse/#svn/trunk/Eclipse/plugins/ATL/transformations).

### Packaging code for MATLAB ###

When you modify the Java code that Matlab uses, you need to package it in a JAR file, and place it in the matlab/lib folder. This [video](http://kth-simulink-exchange.googlecode.com/svn/wiki/videos/CreateJARforMatlab/CreateJARforMatlab.htm) shows how to do it.

## MATLAB ##

When you start you session, you need to tell MATLAB where to find a few JAR files. These are located within the [SVN\_REPO/matlab/lib](http://code.google.com/p/kth-simulink-exchange/source/browse/#svn/trunk/matlab/libs) folder.

**Note** that the folder serparator is different that the windows default: /.
```
ClassPathSetter('F:/CheckOut/kth-simulink-exchange/trunk/matlab/libs')
```

This command is found in the [SVN\_REPO/matlab/code](http://code.google.com/p/kth-simulink-exchange/source/browse/#svn/trunk/matlab/code) folder, which you should have added to your MATLAB path.
To see whether the command succedded, you can type the following command and check the JAR files added to the Dynamic path. Specially important is to see that you do not older versions together with newer ones, only ONE version per file.
```
javaclasspath
...
		DYNAMIC JAVA PATH

	F:\CheckOut\kth-simulink-exchange\trunk\matlab\libs\SimulinkModelManagement_v3.4.jar                          
	F:\CheckOut\kth-simulink-exchange\trunk\matlab\libs\com.cea.papyrus.uml4eastadl.extension_1.10.0.jar          
	F:\CheckOut\kth-simulink-exchange\trunk\matlab\libs\com.cea.papyrus.uml4sysml.extension_1.1.6.200911231247.jar
	F:\CheckOut\kth-simulink-exchange\trunk\matlab\libs\commons-io-1.4.jar                                        
	F:\CheckOut\kth-simulink-exchange\trunk\matlab\libs\org.eclipse.emf.common_2.4.0.v200902171115.jar            
	F:\CheckOut\kth-simulink-exchange\trunk\matlab\libs\org.eclipse.emf.ecore.change_2.4.0.v200902171115.jar      
	F:\CheckOut\kth-simulink-exchange\trunk\matlab\libs\org.eclipse.emf.ecore.xmi_2.4.1.v200902171115.jar         
	F:\CheckOut\kth-simulink-exchange\trunk\matlab\libs\org.eclipse.emf.ecore_2.4.2.v200902171115.jar             
	F:\CheckOut\kth-simulink-exchange\trunk\matlab\libs\se.kth.attest2.metamodel.Simulink.edit_3.2.1.jar          
	F:\CheckOut\kth-simulink-exchange\trunk\matlab\libs\se.kth.attest2.metamodel.Simulink.editor_3.2.1.jar        
	F:\CheckOut\kth-simulink-exchange\trunk\matlab\libs\se.kth.attest2.metamodel.Simulink_3.2.1.jar               
>> 
```



## User libraries in Eclipse ##

If you depend on JAR files, and you move between several computers, it might be useful to add these JARs to a User Library. These are collection of JAR files known to the Eclipse environemnt, so when building the project, all JARs can be found. Please note that this is stored within each Eclipse and not in the workspace.


## JUnit and jMock ##

Make sure that you include the jMock dependency before JUnit.
[thread with info about it.](http://old.nabble.com/SecurityException-when-using-ClassImposteriser-td24304562.html)