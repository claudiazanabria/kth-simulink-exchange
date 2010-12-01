package se.kth.md.SimulinkOOAPI.util;

public interface ErrorMessages {
	
	public static final String SYS_REF_TARGET_EQUALS_PARENT = "Targeting system should not be equal to the parent system.";
	
	public static final String LINE_PORTS_BELONG_TO_SAME_SYSTEM = "Ports must belong to the same system.";
	public static final String LINE_CONNECT_DIFFERENT_LEVEL_PORTS = "Can connect system only to the first level children system.";
	public static final String LINE_CONNECT_SAME_LEVEL_PORTS = "Can connect ports on different systems of the same childen level.";
	
	public static final String PORT_ADD_TO_MODEL = "Port can not be added to model.";
	public static final String PORT_ADD_TO_LIBRARY = "Port can not be added to library.";
	public static final String LIBRARY_ADD_TO_LIBRARY = "Library can not be added to library.";
	public static final String LIBRARY_ADD_TO_SYSTEM = "Library can not be added to system.";
	public static final String LINE_ADD_TO_LIBRARY = "Line can not be added to library.";
	public static final String MODEL_ADD_TO_MODEL = "Model can not be added to model.";
	public static final String MODEL_ADD_TO_SYSTEM = "Model can not be added to system.";
	public static final String GAINBLOCK_ADD_TO_MODEL = "Gain block can not be added to model.";

}
