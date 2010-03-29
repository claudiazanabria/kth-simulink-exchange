package modelManagement.simulink;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class ListOrganizerTest {

	@Test
	public void testMierda() {
		ArrayList<Integer> l = new ArrayList<Integer>(4);
		List<Integer> r = new ArrayList<Integer>(4);
		l.add(3);
		l.add(5);
		l.add(7);
		l.add(9);
		r = l.subList(0, 1);
		r = l.subList(2, 4);
		
	}

}
