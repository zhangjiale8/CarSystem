package cn.car.manage.beans.orm.item.guestbook;

/**
 * @Description:商品评论列表
 * @author 李子辉
 * @date 2018年3月10日
 */
public class Comment {

	//评论ID
	private int commentID;
	
	//评论内容
	private String commentContent;
	
	//评论日期
	private String commentDate;
	
	//客户ID
	private int customerID;
		
	//评论等级
	private int commentLevel;//1:好评  2：差评
	
	//回复内容
	private String replyContent;
	
	//回复日期
	private String replyDate;

	private String userName;
	
	private int handleState;
	
	public Comment() {
		super();
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
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
		return "Comment [commentID=" + commentID + ", commentContent=" + commentContent + ", commentDate=" + commentDate
				+ ", customerID=" + customerID + ", commentLevel=" + commentLevel + ", replyContent=" + replyContent
				+ ", replyDate=" + replyDate + ", userName=" + userName + ", handleState=" + handleState + "]";
	}

	
	

	
	
	
	
}
