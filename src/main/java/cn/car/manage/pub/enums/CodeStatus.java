package cn.car.manage.pub.enums;


/**
 * 
 * @Description: 状态码的处理结果 
 * @User: 
 * @Date: 2016年3月21日 下午1:52:52
 */
public enum CodeStatus {

	/**
	 * 成功
	 */
	SUCCSSS(0),
	/**
	 * 失败
	 */
	FAILURE(1),
	/**
	 * 警告
	 */
	WARNING(2),
	/**
	 * 信息
	 */
	INFO(3);
	
	private int value;
	
	private CodeStatus(int value){
		this.value = value;
	}
	
	public boolean equals(int value){
		return this.value == value;
	}
	
	public boolean equals(CodeStatus status){
		return this.value == status.value;
	}
	
	public int getValue(){
		return this.value;
	}
}
