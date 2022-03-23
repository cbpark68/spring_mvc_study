package main.web;

public class RequestResult<T> {
	private boolean success;
	private String message;
	private T data;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public static <T>RequestResult<T> success(T data) {
		RequestResult<T> result = new RequestResult<T>();
		result.setSuccess(true);
		result.setData(data);
		
		return result;
	}
	
	public static <T>RequestResult<T> failure(String message) {
		RequestResult<T> result = new RequestResult<T>();
		result.setSuccess(false);
		result.setMessage(message);
		
		return result;
	}
}
