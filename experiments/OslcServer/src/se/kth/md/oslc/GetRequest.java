package se.kth.md.oslc;

public class GetRequest implements IRequest {
	private Object query;
	private Object answer;
	private boolean answer_ready = false;	
	private IServerApplication listener;
	
	public Object getQuery() {
		return query;
	}
	public void setQuery(Object query) {
		this.query = query;
	}
	public Object getAnswer() {
		return answer;
	}
	public void setAnswer(Object answer) {
		this.answer = answer;
	}
	public boolean isAnswer_ready() {
		return answer_ready;
	}
	public void setAnswer_ready(boolean answer_ready) {
		this.answer_ready = answer_ready;
	}
	
	@Override
	public void addServerListener(IServerApplication app) {		
		this.listener = app;
		
	}
	
	@Override
	public void removeServerListener() {
		this.listener = null;		
	}
	
	@Override
	public void notifyServerDataReady() {
		if (this.listener!=null)
			this.listener.handleDataReady(this);
		
	}

}
