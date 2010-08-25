package se.kth.md.simulinkExchange.popup.actions.atl;

public class Person {

	IChild child;
	
	public Person() {
		child = new Child();
	}
	
	public void shout(IChild child) {
		child.doSomething();
		child.doOther();
	}
}