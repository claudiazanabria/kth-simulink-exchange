# Quick overview of classes and their interaction #

## 1. Eclipse Plugins ##

### Activator: Loading and unloading ###
An Eclipse plugins usually contains an Activator class, called by the Eclipse framework upon loading/unloading the plugin. This class is also used as a static reference from the rest of the plugin. More on this later on.

The file plugin.xml describes the plugin's build options, dependencies and contributions to the Eclipse environment.

### GUI contributions, a pop-up menu ###

The Extensions tab on plugin.xml is where the GUI extensions are defined.

[http://docs.google.com/leaf?id=0B0q8fV0DsS5tODI3YTc2MWUtZmU5OC00YWE0LWIwYWQtOWZlY2RkNDdmOGRi&hl=en](image.md)

Within plugin.xml

# Details #

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages