package cn.car.manage.controller.item.guestbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.car.manage.annotation.ParameterName;
import cn.car.manage.beans.orm.item.guestbook.Comment;
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.service.item.guestbook.CommentService;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.RequestUtil;

/**
 * @Description:评论控制层
 * @author 李子辉
 * @date 2018年3月13日
 */
@Controller
@RequestMapping("/comment")
public class CommentController implements BaseController{

	@Autowired
	private CommentService commentService;          
	/**
	 * @Description:分页查询留言
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/commentPage")
	public ModelAndView getCommentByCommentNameAndCommentID(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		DataTableReturn<Comment> dataTableReturn = commentService.getCommentByCommentNameAndCommentID(request);
		view = RequestUtil.requestForward(response, dataTableReturn.toJSON(), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	
	/**
	 * @Description:根据留言ID查询留言
	 * @param request
	 * @param response
	 * @param guestBookID
	 * @return
	 */
	@RequestMapping(value="/getCommentByCommentID",params="commentID")
	public String getCommentByCommentID(HttpServletRequest request, HttpServletResponse response, int commentID) {
		Comment comment=commentService.getCommentByCommentID(commentID);
		request.setAttribute("comment", comment);
		
		return "forward:/toUpdateComment";
	}
	
	/**
	 * @Description:回复评论
	 * @param request
	 * @param response
	 * @param replyContent
	 * @param guestBookID
	 * @param forward
	 * @return
	 */
	@RequestMapping("/updateComment")
	public ModelAndView updateComment(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="replyContent") String replyContent,@ParameterName(value="commentID") int commentID, @RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		view=RequestUtil.requestForward(response, commentService.replyCommentContent(replyContent, commentID), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description:修改评论状态 
	 * @param request
	 * @param response
	 * @param guestBookID
	 * @param handleState
	 * @param forward
	 * @return
	 */
	@RequestMapping("/updateCommentState")
	public ModelAndView updateCommentState(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="commentID") int commentID,@ParameterName(value="handleState") int handleState, @RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		
		view=RequestUtil.requestForward(response,commentService.updateCommentState(handleState, commentID), REQUEST_RESULT_NAME, forward);
		return view;
	}
}
