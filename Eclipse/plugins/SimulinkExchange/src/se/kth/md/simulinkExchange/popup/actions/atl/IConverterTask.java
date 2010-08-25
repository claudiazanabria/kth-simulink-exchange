package se.kth.md.simulinkExchange.popup.actions.atl;

public interface IConverterTask {

	String finalMessage();

	Object run(Object argument) throws Exception;

	String name();


}
