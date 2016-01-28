# M6 release #

Officially supported project version is located at https://kth-simulink-exchange.googlecode.com/svn/branches/alex/M6/plugins.

It was tagged with "M6SupportingHeliosAndPapyrus2-1-8".

This has to be merged into trunk.

**Directory structure:**

  * ATL - contains atl transformations from east to simulink and vice versa.
> > Besides, it contains test .simulink and .uml files.

  * metamodel - Simulink ECore model with the generated code for the model and for the editor.

  * SimulinkExchange - Eclipse plugin that provides a right-click popup menu for the transformations.
> > SimulinkExchange/resources - ATL transformation, test files.

  * SimulinkExchangeFeature - Eclipse feature for SimulinkExchange plugin. Need this for Eclipse build.

  * SimulinkExchangeUpdateSite - Eclipse update site for Simulink Exchange project.

  * emfExtensions
    * ModelManagement - convenience wrapper around EMF: reads, writes and validates models from memory and files.
> > Looks like this project was extracted from SimulinkExchange, however SimulinkExchange still contains this code, i e duplicates it.

  * ModelManagementTests - junit tests for model management. (Test run result: 4 errors from 6 tests).

> The tests are running with JExample and ClassNotFoundExceptions ocuured in the tests. Probably, some set up for the tests run configuration is required to make the tests pass.

  * ModelConversion - utilities for Simulink model elements processing before the conversion.
> > This code is duplicated in SimulinkExchange.

  * Carlota. A combination of two projects: ModelManagement and ModelConversion.
> > Project has compilation errors after importing to Eclipse workspace (missing dependencies from Eclipse EMF)

  * deployment - The latest build for install to Eclipse.
> > NOTE: features folder is missing in the deployment, plugins installed without features did not start. We had to rebuild all with Update Site.

  * ExternalLibs - external Java pependencies

**The result of running M6 plugins:**

Checked the conversion from Simulink to EAST-ADL and vise versa on test files that are located at 'SimulinkExchange/resources'. It works.


# The refactored code #

The refactored code we worked on is located at https://kth-simulink-exchange.googlecode.com/svn/branches/alex/Eclipse/plugins

**Directory structure:**

  * ExternalLibs - external Java pependencies

  * metamodel - Simulink ECore model with the generated code for the model and for the editor.

  * ECoreModelWrapper - convenience wrapper around EMF: reads, writes and validates models from memory and files.

  * ATLRunner - programmatically runs the ATL transformations

  * SimulinkExchange - Eclipse plugin that provides a right-click popup menu for the transformations.

  * SimulinkExchangeFeature - Eclipse feature for SimulinkExchange plugin. Need this for Eclipse build.

  * SimulinkExchangeUpdateSite - Eclipse update site for Simulink Exchange project.


However, these plugins still have dependencies on the old papyrus version, which was supported by Eclipse Galileo.
Tried to run it on Eclipse Galileo, but it did not work, probably because the test files are supposed to use 2.1.8 papyrus east-adl extension.
This plugin needs to be moved to eclipse Helios and it has to support 2.1.8 version of papyrus east-adl.