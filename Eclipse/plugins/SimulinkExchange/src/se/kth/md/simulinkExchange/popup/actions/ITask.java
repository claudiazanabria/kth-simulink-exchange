package se.kth.md.simulinkExchange.popup.actions;

/**
 * This class represents a single task executed by a TaskExector
 * @author alex
 *
 */
public interface ITask {

	String finalMessage();

	Object run(Object argument) throws Exception;

	String name();


}
