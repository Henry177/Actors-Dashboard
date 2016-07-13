package bbd.dashboard;

public class Result<T> {

	private T value;
	private String errorMessage;
	
	public Result() {
		this(null);
	}
	
	public Result(T value) {
		this.value = value;
	}
	
	public boolean isError() {
		return value == null;
	}
	
	public T getValue() {
		return value;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		this.value = null;
	}

	
}
