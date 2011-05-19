package se.kth.md.simulinkExchange.simulink;

import java.lang.Object;
import java.util.HashMap;
import java.util.UUID;

public class UserData extends HashMap<String, Object> {

	private static final long serialVersionUID = 8929529445623898408L;

	public UserData() {
		super(3);
		super.put( "UUID", UUID.randomUUID() );
	}
}
