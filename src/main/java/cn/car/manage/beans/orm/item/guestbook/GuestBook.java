package cn.car.manage.beans.orm.item.guestbook;

/**
 * @Description:留言信息类
 * @author 李子辉
 * @date 2018年3月10日
 */
public class GuestBook {

	//留言簿ID
	private int guestBookID;
	
	//留言内容
	private String guestBookContent;
	
	//用户ID
	private int customerID;
	
	//留言时间
	private String guestBookDate;
	
	//回复内容
	private String replyContent;
	
	private String replyDate;
	//用户名
	private String userName;
	//处理状态
	private int handleState;

	public GuestBook() {
		super();
	}

	

	public int getGuestBookID() {
		return guestBookID;
	}

	public void setGuestBookID(int guestBookID) {
		this.guestBookID = guestBookID;
	}

	public String getGuestBookContent() {
		return guestBookContent;
	}

	public void setGuestBookContent(String guestBookContent) {
		this.guestBookContent = guestBookContent;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	

	public String getGuestBookDate() {
		return guestBookDate;
	}



	public void setGuestBookDate(String guestBookDate) {
		this.guestBookDate = guestBookDate;
	}



	public String getReplyDate() {
		return replyDate;
	}



	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}



	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getHandleState() {
		return handleState;
	}

	public void setHandleState(int handleState) {
		this.handleState = handleState;
	}



	@Override
	public String toString() {
		return "GuestBook [guestBookID=" + guestBookID + ", guestBookContent=" + guestBookContent + ", customerID="
				+ customerID + ", guestBookDate=" + guestBookDate + ", replyContent=" + replyContent + ", userName="
				+ userName + ", handleState=" + handleState + "]";
	}

	
	
	
}
