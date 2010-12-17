package se.kth.md.oslc;

public class GetRequest implements IRequest {
	private Object query;
	private Object answer;
	private boolean answer_ready = false;	
	
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

}
