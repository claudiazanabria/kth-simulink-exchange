## A note about installing Eclipse plugins ##

Install the needed Eclipse plugins by using the update sites noted below. Choose _Help->Install New Software_ in Eclipse, to initiate the process. Restart after each new plugin install is recommended by Eclipse, but most of the times, you can get away by installing all of the plugins and restarting only once.

Uncheck "Show only the latest versions of available software" to install old versions.

To check the version of an installed plugin use Help->About Eclipse, choose "Installation details", and check the features and plugins tab.

## 1. Eclipse Modeling Tools ##

Start from the Eclipse Galileo environment tailored for modelling (SR2), found [here for windows](http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/galileo/SR2/eclipse-modeling-galileo-SR2-incubation-win32.zip). Download and unzip.

(Note your INSTALL\_FOLDER and WORKSPACE\_FOLDER, it will be needed below.)

## 2. Papyrus ##

Install [Papyrus UML](http://www.papyrusuml.org) tool by using their update site. The  address is: http://www.papyrusuml.org/home/liblocal/docs/updates/papyrus. Install all of the components available. Current version of Papyrus is 1.12.3. You do not need to restart Eclipse for the next step, choose to apply changes instead.

## 3. EAST-ADL ##

Install he EAST-ADL profile through the update site, as previously done for Papyrus. The address is: http://www.papyrusuml.org/home/liblocal/docs/updates/papyrus-extensions. Only the EAST-ADL component is needed. Currently we use EAST-ADL 2.1.5. You do not need to restart Eclipse for the next step, choose to apply changes instead.

## 3. Subclipse ##

Now you need to install a SVN Client and pull down the project contents. The client used by this project is Subclipse, version 1.6.10.

**Installation:** Update Papyrus using the "http://subclipse.tigris.org/update_1.6.x" Update Site. The integration with Mylyn has not been tested, so uncheck this package while installing Subclipse plugin.

**Project Contents**: Pull down the code:
  * File->New->Project, choose "Checkout Projects from SVN"
  * Enter "https://kth-simulink-exchange.googlecode.com/svn/"
  * Use the "trunk" folder
  * Check out as a project in the workspace
  * Note your PROJECT\_NAME, it will be needed below.
  * The root of the SVN is referred to as SVN\_ROOT.

## 4. Simulink Exchange ##

The metamodels and all the code is provided as a single plugin, installable from the following update site:
http://kth-simulink-exchange.googlecode.com/svn/trunk/Eclipse/plugins/SimulinkExchangeUpdateSite.
Do not forget to restart Eclipse, as you will not be installing anything else.

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