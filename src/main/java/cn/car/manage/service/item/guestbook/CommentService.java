package cn.car.manage.service.item.guestbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.car.manage.beans.orm.item.guestbook.Comment;
import cn.car.manage.mapper.item.guestbook.CommentMapper;
import cn.car.manage.util.helper.DataTable;
import cn.car.manage.util.helper.DataTableReturn;

/**
 * @Description:评论务层
 * @author 
 * @date 2018年3月10日
 */
@Service
public class CommentService {

	@Autowired
	private CommentMapper commentMapper;
	/**
	 * @Description:分页
	 * @author 
	 * @date 2018年3月10日
	 */

	public DataTableReturn<Comment> getCommentByCommentNameAndCommentID(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		DataTable dataTable = new DataTable(request);
		String userName = dataTable.getParameters().getOrDefault("userName", "").toString();
		String handleState=dataTable.getParameters().getOrDefault("handleState","0").toString();
		userName = userName.isEmpty() ? null : userName.trim();
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		
		List<Comment> list = commentMapper.getCommentByCommentNameAndCommentID(userName,Integer.parseInt(handleState));
		
		
		Page<Comment> page = (Page<Comment>) list;
		DataTableReturn<Comment> dtReturn = new DataTableReturn<Comment>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		return dtReturn;
	}
	

	/**
	 * @Description:新增留言
	 * @author 
	 * @date 2018年3月13日
	 */
	public int addComment(Comment comment){
		return 0;
		
	}
	


	/**
	 * @Description:根据id查询留言
	 * @author 
	 * @date 2018年3月10日
	 */
	public Comment getCommentByCommentID(int commentID){
		return commentMapper.getCommentByCommentID(commentID);
		
	}
	

	/**
	 * @Description:删除留言
	 * @author 
	 * @date 2018年3月10日
	 */
	public int deleteCommentByCommentID(List<Integer> commentID){
		return commentMapper.deleteCommentByCommentID(commentID);
		
	}

	/**
	 * @Description:根据用户名称删除留言
	 * @author 
	 * @date 2018年3月10日
	 */
	public int deleteCommentByUserName(String userName){
		return commentMapper.deleteCommentByUserName(userName);
		
	}
	/**
	 * @Description:回复内容
	 * @author 
	 * @date 2018年3月10日
	 */
	public int replyCommentContent(String replyContent,int commentID){
		
		return commentMapper.replyCommentContent(replyContent, commentID);
		
	}
	
	/**
	 * @Description:修改状态
	 * @author 
	 * @date 2018年3月10日
	 */
	public int updateCommentState(int handleState,int commentID){
		return commentMapper.updateCommentState(handleState, commentID);
		
	}
}
