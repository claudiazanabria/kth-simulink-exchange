This page ties the parts mentioned in the overview to the different locations in the SVN, then details the important classes found there.

### Description ###
A Java implementation which ties an Eclipse pop-up menu to ".uml" and ".simulink" files.

<b>Location:</b> SVN\_REPO/trunk/Eclipse/plugins/SimulinkExchange/src/se/kth/md/simulinkExchange/popup/

<b>Info:</b>



### Description ###
An ATL Description of a Transformation between EAST-ADL and SimuLink models.

<b>Location:</b> SVN\_REPO/trunk/Eclipse/plugins/SimulinkExchange/src/se/kth/md/simulinkExchange/atl/

<b>Info:</b>



### Description ###
A Java implementation which verifies meta-model compliance for EAST-ADL and Simulink models.

<b>Location:</b> SVN\_REPO/trunk/Eclipse/plugins/SimulinkExchange/src/se/kth/md/simulinkExchange/management/ModelValidator.java

<b>Info:</b>



### Description ###
A Java implementation which adds missing layout information to ".simulink" files.

<b>Location:</b> SVN\_REPO/trunk/Eclipse/plugins/SimulinkExchange/src/se/kth/md/simulinkExchange/conversion/simulink/preprocessing/

<b>Info:</b>


### Description ###
A MATLAB implementation which sets up the MATLAB environment (adds to the GUI, adds Java classpath and adds the MATLAB source path).

<b>Location:</b> SVN\_REPO/trunk/matlab/ecore\_init.m

<b>Info:</b>



### Description ###
A Java implementation which reads the offered ECore models in the ".simulink" files into memory and allows MATLAB to query the structure.

<b>Location:</b> SVN\_REPO/trunk/Eclipse/plugins/SimulinkExchange/src/se/kth/md/simulinkExchange/management/

<b>Info:</b> ModelCreator.m creates SimuLink Objects when doing the transformation <b>to</b> SimuLink. EcoreCreator.m reads SimuLink Objects when doing the transformation <b>from</b> SimuLink.

### Description ###
A MATLAB implementation (".m" files) which creates Simulink objects from the queried structure.

<b>Location:</b> SVN\_REPO/trunk/matlab/code/

<b>Info:</b>



### Description ###
The MATLAB implementation mentioned above also allows tagging parts of models for exchange and converting MATLAB Subsystems into MATLAB Libraries (the later because this project does not support transformation of regular MATLAB Subsystems).

<b>Location:</b> TODO: Should be added into SVN

<b>Info:</b>


### Description ###
A Java implementation which creates ECore models through an external API.

<b>Location:</b> SVN\_REPO/trunk/Eclipse/plugins/SimulinkExchange/src/se/kth/md/simulinkExchange/conversion/simulink/

<b>Info:</b>