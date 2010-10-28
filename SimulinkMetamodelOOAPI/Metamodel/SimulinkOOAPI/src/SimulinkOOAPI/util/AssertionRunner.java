package SimulinkOOAPI.util;

public class AssertionRunner {
	
	public static Assertion assertion(String message, boolean condition){
		return new Assertion(message, condition);
	}
	
	public static void assertAnd(Assertion... assertions) {		
		for (Assertion a: assertions){
			if (!a.isCondition()){
				throw new IllegalArgumentException(a.getMessage());
			}
		}		
	}
	
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
