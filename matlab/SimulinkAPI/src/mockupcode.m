
% Building your model
model = Factory.newModel()
% model is the root element

model.setName()
systemA = Factory.newSystem()
systemA.setName()

gainBlock = Factory.newGainBlock()
model.add(systemA)
model.add(systemBC)
systemA.add(gainBlock)

model.add(gainBlock)
model.remove(gainBlock)

Factory.newInport()

port = Factory.newOutport()
systemA.add(port)
port.setName( aUniqueNameForThisPort )

port = Factory.newOutport()
systemB.add(port)


port = Factory.newLconnPort()
Factory.newRconnPort()

line = Factory.newLine()
% How do get references to port objects?
array[] = systemA.getOutports()
portA = systemA.getOutportWithName( calle )
portB = systemA.getOutportWithUUID( 2432432 )

line.setSource( portA )
line.setDestinnation( portA )
line.fromTo(portA, portB)

%portA can you connect to portB?
if port type
portB.canYouConnetToOutport?

% some ports might accept more than one line

port.add(system)
arrayOfLines = port.getConnectedLines()

mux = Factory.newMultiplexer(3)

body = Factory.newBody()
joint
ground

library = Factory.newLibrary()
% adding a new object to library
ref = library.add( blockA )
% getting refs to Existing objects
ref = library.getReferenceToBlockWithUUID(24234)
ref = libary.getReferenceTolockWithName(adasd)

model.add(blockB)
% Creates a new reference in blockB.
blockB.add(ref)

ref = library.getBlockWithUUID(2423)
model.add( ref )

blockB.addGenericKeyValue('mass',[3 4 5; 5 6 7])
blockB.getValueForKey('mass')

library = new Library()
