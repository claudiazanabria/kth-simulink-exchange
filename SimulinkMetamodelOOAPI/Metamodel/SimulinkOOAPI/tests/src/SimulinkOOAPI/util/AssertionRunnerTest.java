package SimulinkOOAPI.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class AssertionRunnerTest {
	
	@Test
	public void testAssertOrCorrectAssertions(){
		AssertionRunner.Assertion a1 = new AssertionRunner.Assertion("a", true);
		AssertionRunner.Assertion a2 = new AssertionRunner.Assertion("b", true);
		AssertionRunner.assertOr(a1, a2);
	}
	
	@Test
	public void testAssertOrFailAssertion(){
		AssertionRunner.Assertion a1 = new AssertionRunner.Assertion("a", true);
		AssertionRunner.Assertion a2 = new AssertionRunner.Assertion("b", true);
		AssertionRunner.Assertion a3 = new AssertionRunner.Assertion("c", false);		
		AssertionRunner.assertOr(a1, a2, a3);
		
	}
	
	@Test
	public void testAssertOrFailAssertions(){
		AssertionRunner.Assertion a1 = new AssertionRunner.Assertion("a", false);
		AssertionRunner.Assertion a2 = new AssertionRunner.Assertion("b", false);
		AssertionRunner.Assertion a3 = new AssertionRunner.Assertion("c", false);
		try{
			AssertionRunner.assertOr(a1, a2, a3);
		}catch(IllegalArgumentException e){
			assertEquals(a3.getMessage(), e.getMessage());
		}
	}
	
	@Test
	public void testAssertAndCorrectAssertions(){
		AssertionRunner.Assertion a1 = new AssertionRunner.Assertion("a", true);
		AssertionRunner.Assertion a2 = new AssertionRunner.Assertion("b", true);
		AssertionRunner.assertAnd(a1, a2);
	}
	
	@Test
	public void testAssertAndFailAssertion(){
		AssertionRunner.Assertion a1 = new AssertionRunner.Assertion("a", true);
		AssertionRunner.Assertion a2 = new AssertionRunner.Assertion("b", true);
		AssertionRunner.Assertion a3 = new AssertionRunner.Assertion("c", false);
		try{
			AssertionRunner.assertAnd(a1, a2, a3);
		}catch(IllegalArgumentException e){
			assertEquals(a3.getMessage(), e.getMessage());
		}
	}
	
	@Test
	public void testAssertAndFailAssertions(){
		AssertionRunner.Assertion a1 = new AssertionRunner.Assertion("a", false);
		AssertionRunner.Assertion a2 = new AssertionRunner.Assertion("b", false);
		AssertionRunner.Assertion a3 = new AssertionRunner.Assertion("c", false);
		try{
			AssertionRunner.assertAnd(a1, a2, a3);
		}catch(IllegalArgumentException e){
			assertEquals(a1.getMessage(), e.getMessage());
		}
	}

}
