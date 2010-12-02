package se.kth.md.SimulinkOOAPI.util;

/**
 * Class for checking a set of conditions and raising IllegalArgumentException if they are not satisfied.
 */
public class AssertionRunner {
	
	public static Assertion assertion(String message, boolean condition){
		return new Assertion(message, condition);
	}
	
	/**
	 * Throws IllegalArgumentException if there is at least one failed assertion within assertions.	 
	 */
	public static void assertAnd(Assertion... assertions) {		
		for (Assertion a: assertions){
			if (!a.isCondition()){
				throw new IllegalArgumentException(a.getMessage());
			}
		}		
	}
	
	/**
	 * Throws IllegalArgumentException if all the assertions are failed.	 
	 */
	public static void assertOr(Assertion... assertions) {
		String message = null;
		for (Assertion a: assertions){
			if (!a.isCondition()){
				message = a.getMessage();
			}else{
				message = null;
				break;
			}
		}
		if (message !=null)
			throw new IllegalArgumentException(message);
	}
	
	public static class Assertion {
		private String message;
		private boolean condition;
		
		protected Assertion(String message, boolean condition){
			this.message = message;
			this.condition = condition;
		}
		
		protected String getMessage() {
			return message;
		}

		protected boolean isCondition() {
			return condition;
		}		
	}

}
