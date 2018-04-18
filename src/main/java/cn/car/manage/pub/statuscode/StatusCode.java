package cn.car.manage.pub.statuscode;


/**
 * 
 * @Description: 后台业务处理结果状态码 
 * @User: 
 * @Date: 2016年3月21日 上午9:40:52
 */
public class StatusCode {

	/**
	 * 状态码
	 */
	private int code;
	
	/**
	 * 状态码对应的说明信息(用于前端显示)
	 */
	private String message;
	
	/**
	 * 标识状态码的状态, 0:成功, 1:失败, 2:警告
	 */
	private int status;
	
	
	/**
	 * 详细信息,用于说明产生的原因,如果为成功状态可以不填写
	 */
	private String detail;
	

	
	@Override
	public String toString() {
		return "{\"code\":" + code + ", \"message\":\"" + message + "\", \"detail\":\"" + detail + "\"}";
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}


	public StatusCode(int code, String message, int status, String detail) {
		super();
		this.code = code;
		this.message = message;
		this.status = status;
		this.detail = detail;
	}

	public StatusCode() {
		super();
		// TODO Auto-generated constructor stub
	}
}
