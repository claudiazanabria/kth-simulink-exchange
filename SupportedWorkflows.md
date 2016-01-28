# Supported workflows #

## Common for both workflows ##

We are going to run MATLAB code, that is found in the _code_ folder.
Make sure you add this path to the MATLAB path (How?)
All commands described here are defined within this _code_ folder.

Our MATLAB code will use Java code. For this, a [Java virtual machine](http://en.wikipedia.org/wiki/Java_Virtual_Machine) (JVM) is started by MATLAB, so we need to tell the JVM where to find our Java code. Java code is usually distributed in [JAR](http://en.wikipedia.org/wiki/JAR_(file_format)) files. The files we are using are within the _libs_ folder.

Run the following MATLAB command to tell the JVM about our JARS.
```
ClassPathSetter( path_To_libs_Folder_Containing_JARS )
```

## Starting from a Simulink model ##

### MATLAB side ###
Some [modifications are necessary](ImportingExistingSimulinkModels.md) before an existing Simulink model can be used. Do them before you continue.

Make the folder where the model lives your current folder (_cd_).

Use the following command to create an ecore file from an mdl model. If everything went fine, you'll find a .simulink file in your current directory.
```
EcoreCreator.fromFile( 'name_of_model' )
```

### Eclipse side ###

You need to import the .simulink file into the Eclipse workspace. To do this, you can simple drag the file into an existing or new project. Another alternative, is to store you mdl files within an Eclipse project from the beginning, so you don't need to move files around anymore.

Now you need to run an ATL transformation, with an Eclipse [ATL run-configuration](ATLRunConfguration.md). This will create a .uml file.

Change to the Papyrus perspective in Eclipse, and right-clicking on the uml file, create a new Papyrus model from a uml file. Now you should have all the components, but you have to manually create a composite diagram and drag the components into the diagram yourself.


## Starting from an EAST-ADL model ##

### Eclipse side ###

You need to run an ATL transformation, with an Eclipse [ATL run-configuration](ATLRunConfguration.md). This will create a .simulink file.

### MATLAB side ###

Close all models that are open, even those that are invisible. For this you can use the following commmand:
```
closeAll
```

Create a new folder to store the simulink files that will be created, and make it your current directory.

Get the full path to the .simulink file created by the ATL transformation, you will need it for the next command:

```
ModelCreator.fromFile( 'full_path.simluink' )
```

The top level model should open automatically now.

## Notes ##

There is code in the repository (where?) to add an option when you right-click on a file to run an ATL transformation automatically.