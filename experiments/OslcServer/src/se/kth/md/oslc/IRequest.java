package se.kth.md.oslc;

public interface IRequest {
	
	public Object getQuery();
	public void setQuery(Object query);
	public Object getAnswer();
	public void setAnswer(Object answer);
	public boolean isAnswer_ready();	
	void setAnswer_ready(boolean answer_ready);
	
	public void addServerListener(IServerApplication app);
	public void removeServerListener();
	public void notifyServerDataReady();

}
