package cn.car.manage.mapper.item.guestbook;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.guestbook.Comment;
@Repository
public interface CommentMapper {

	/**
	 * @Description:分页
	 * @author 
	 * @date 2018年3月10日
	 */
	public List<Comment> getCommentByCommentNameAndCommentID(@Param("userName")String userName,@Param("handleState")int handleState);
	
	/**
	 * @Description:新增留言
	 * @author 
	 * @date 2018年3月13日
	 */
	public int addComment(Comment comment);
	
	
	/**
	 * @Description:根据id查询留言
	 * @author 
	 * @date 2018年3月10日
	 */
	public Comment getCommentByCommentID(@Param("commentID") int commentID);
	
	/**
	 * @Description:删除评论
	 * @author 
	 * @date 2018年3月10日
	 */
	public int deleteCommentByCommentID(List<Integer> commentID);
	
	/**
	 * @Description:回复评论
	 * @author 
	 * @date 2018年3月10日
	 */
	public int replyCommentContent(@Param("replyContent")String replyContent,@Param("commentID")int commentID);
	
	/**
	 * @Description:修改状态
	 * @author 
	 * @date 2018年3月10日
	 */
	public int updateCommentState(@Param("handleState")int handleState,@Param("commentID")int commentID);

	/**
	 * @Description:根据用户名查询
	 * @author 
	 * @date 2018年3月13日
	 */
	public List<Comment> getCommentByUserName(@Param("userName")String userName);
	
	/**
	 * @Description:根据用户名删除留言
	 * @author 
	 * @date 2018年3月13日
	 */
	public int deleteCommentByUserName(@Param("userName") String userName);
}
