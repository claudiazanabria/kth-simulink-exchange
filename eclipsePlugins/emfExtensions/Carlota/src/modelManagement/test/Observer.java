package modelManagement.test;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import Simulink.ProtoObject;
import Simulink.SimulinkPackage;

public class Observer implements Adapter {

	Notifier aNotifier;
	
	@Override
	public Notifier getTarget() {
		return null;
	}

	@Override
	public boolean isAdapterForType(Object obj) {
		return true;
/*		if ( obj instanceof ProtoObject ) {
			return true;
		}
		return false;
*/	}

	@Override
	public void notifyChanged(Notification notification) {
  	  String newValue = notification.getNewStringValue();
	  String oldValue = notification.getOldStringValue();
	  System.out.format("%s --> %s\n", oldValue, newValue);

		if ( ! notification.isTouch() ) {
			//ProtoObject obj = (ProtoObject)notification.getNotifier();
			    switch (notification.getFeatureID(ProtoObject.class))
			    {
			      case SimulinkPackage.PROTO_OBJECT__UUID:
			        break;
			     }
		}
	}

	@Override
	public void setTarget(Notifier notifier) {}

}
