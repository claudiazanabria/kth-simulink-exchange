## A note about installing Eclipse plugins ##

Install the needed Eclipse plugins by using the update sites noted below. Choose _Help->Install New Software_ in Eclipse, to initiate the process. Restart after each new plugin install is recommended by Eclipse, but most of the times, you can get away by installing all of the plugins and restarting only once.

Uncheck "Show only the latest versions of available software" to install old versions.

To check the version of an installed plugin use Help->About Eclipse, choose "Installation details", and check the features and plugins tab.

## 1. Eclipse Modeling Tools ##

Start from the Eclipse Helios environment tailored for modelling (SR2),  download and unzip.

(Note your INSTALL\_FOLDER and WORKSPACE\_FOLDER, it will be needed below.)

## 2. Papyrus & ATL ##

Install Papyrus and ATL from Eclipse Modeling Components Discovery.

## 3. EAST-ADL ##

Install EAST-AL from the maenad update site, available on MAENAD SVN. 2.1.18 is used here.

## 4. Simulink Exchange ##

See BuildandInstallNotes

## 5. MATLAB ##

Our code takes advantage of MATLAB's [Object Oriented](http://en.wikipedia.org/wiki/Object-oriented_programming) Programming Facilities, something old versions of MATLAB do not support.

This project use MATLAB Version 2009a.

Start MATLAB, go to the folder "WORKSPACE\_FOLDER\PROJECT\_NAME\trunk\matlab", and run the ecore\_init.m file. There will now be added context menus, and to the File menu in Simulink (an model must be available for it to work). Install the MATLAB xUnit Test Framework from here:
http://www.mathworks.com/matlabcentral/fileexchange/22846-matlab-xunit-test-framework
Version 3.0.2 is used.

## 6. Unit test tools ##

  * Junit4 is included with Eclipse. The version used is 4.5.0.
  * JExample: is included in the Simulink Exchange plugin. The version used is version 4.5.392.
  * For MATLAB, the MATLAB xUnit Test Framework is used, see the note above

## 7. Documentation ##

The Java part of the documentation is generated with [Doxygen](http://www.stack.nl/~dimitri/doxygen/index.html). To install, download the appropriate file found by following [this link](http://www.stack.nl/~dimitri/doxygen/download.html#latestsrc). The version used is 1.6.3.

[GraphViz](http://www.graphviz.org/About.php) is used by Doxygen to generate diagrams.
To install, download the appropriate file found by following [this link](http://www.graphviz.org/Download..php). The version used is 2.26.3.

## 8. Import code ##

The last step is to import the code into your Eclipse setup.

  * In Eclipse, use File->Import
  * Choose General->Existing Projects into Workspace, click Next.
  * Select root directory: SVN\_ROOT\Eclipse\plugins\SimulinkExchange
  * Make sure Copy projects into workspace is unchecked, click Finish.

Now the Development Environment should be complete.

## Getting started ##
Check this page for more [tips and tricks](DevelopmentGettingStarted.md).