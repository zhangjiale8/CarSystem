package cn.car.manage.beans.orm.item.photo;

public class UploadReturn {

	private int result;
	private String message;

	public UploadReturn() {
		super();
	}

	public UploadReturn(int result, String message) {
		super();
		this.result = result;
		this.message = message;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UploadReturn [result=" + result + ", message=" + message + "]";
	}

}
