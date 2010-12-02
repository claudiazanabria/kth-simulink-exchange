package se.kth.md.SimulinkOOAPI.exceptions;

public interface ErrorMessages {
	
	public static final String INVALID_SIMULINK_NAME = "Name must not start with a number and must not contain spaces and special symbols except for . _ -";
	
	public static final String SYS_REF_TARGET_EQUALS_PARENT = "Targeting system should not be equal to the parent system.";
	
	public static final String LINE_PORTS_BELONG_TO_SAME_SYSTEM = "Ports must belong to the same system.";
	public static final String LINE_CONNECT_DIFFERENT_LEVEL_PORTS = "Can connect system only to the first level children system.";
	public static final String LINE_CONNECT_SAME_LEVEL_PORTS = "Can connect ports on different systems of the same childen level.";	
	
}
