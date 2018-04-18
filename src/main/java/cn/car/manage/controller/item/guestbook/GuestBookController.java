package cn.car.manage.controller.item.guestbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import cn.car.manage.annotation.ParameterName;
import cn.car.manage.beans.orm.item.guestbook.GuestBook;
  
import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.service.item.guestbook.GuestBookService;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.PagedResult;
import cn.car.manage.util.helper.RequestUtil;

/**
 * @Description:留言业务层
 * @author 李子辉
 * @date 2018年3月13日
 */
@RequestMapping("/guestBook")
@Controller
public class GuestBookController implements BaseController{

	@Autowired
	private GuestBookService guestBookService;
	
	/**
	 * @Description:分页查询留言
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/guestBookPage")
	public ModelAndView getGuestBookByGuestBookNameAndGuestBookID(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		DataTableReturn<GuestBook> dataTableReturn = guestBookService.getGuestBookByGuestBookNameAndGuestBookID(request);
		view = RequestUtil.requestForward(response, dataTableReturn.toJSON(), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description:前台分页查询留言
	 * @param request
	 * @param response
	 * @param forward
	 * @return
	 */
	@RequestMapping("/guestAllBookPage")
    public ModelAndView getAllGuestBook(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="pageNumber") int pageNumber,@ParameterName(value="pageSize") int pageSize,@ParameterName(value="userName") String userName,@RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		
    		ModelAndView view = null;
			PagedResult<GuestBook> pageResult = guestBookService.getAllGuestBook(pageNumber, pageSize,userName);
			
			view = RequestUtil.requestForward(response, pageResult, REQUEST_RESULT_NAME, forward);
			return view;
    }
	/**
	 * @Description:删除留言
	 * @param request
	 * @param response
	 * @param guestBookIDs
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/deleteGuestBookByuserName",params = { "userName", "forward" })
	public ModelAndView deleteGuestBookByGuestBookID(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("userName") String userName,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response,guestBookService.deleteGuestBookByUserName(userName), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	/**
	 * @Description:删除留言
	 * @param request
	 * @param response
	 * @param guestBookIDs
	 * @param forward
	 * @return
	 */
	@RequestMapping(value="/deleteGuestBook",params = { "guestBookID[]", "forward" })
	public ModelAndView deleteGuestBookByUserName(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("guestBookID[]") List<Integer> guestBookID,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
				
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response,guestBookService.deleteGuestBookByGuestBookID(guestBookID), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description:根据留言ID查询留言
	 * @param request
	 * @param response
	 * @param guestBookID
	 * @return
	 */
	@RequestMapping(value="/getGuestBookByGuestBookID",params="guestBookID")
	public String getUserByUserID(HttpServletRequest request, HttpServletResponse response, int guestBookID) {
		GuestBook guestBook=guestBookService.getGuestBookByGuestBookID(guestBookID);
		request.setAttribute("guestBook", guestBook);
		
		return "forward:/toUpdateGuestBook";
	}
	
	/**
	 * @Description:回复留言
	 * @param request
	 * @param response
	 * @param replyContent
	 * @param guestBookID
	 * @param forward
	 * @return
	 */
	@RequestMapping("/updateGuestBook")
	public ModelAndView updateGuestBook(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="replyContent") String replyContent,@ParameterName(value="guestBookID") int guestBookID, @RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		
		view=RequestUtil.requestForward(response, guestBookService.replyGuestBookContent(replyContent, guestBookID), REQUEST_RESULT_NAME, forward);
		return view;
	}
	/**
	 * @Description:修改留言状态 
	 * @param request
	 * @param response
	 * @param guestBookID
	 * @param handleState
	 * @param forward
	 * @return
	 */
	@RequestMapping("/updateGuestBookState")
	public ModelAndView updateGuestBookState(HttpServletRequest request, HttpServletResponse response,
			@ParameterName(value="guestBookID") int guestBookID,@ParameterName(value="handleState") int handleState, @RequestParam(value = "forward", defaultValue = "JSON") String forward) {
		ModelAndView view = null;
		
		view=RequestUtil.requestForward(response,guestBookService.updateGuestBookState(handleState, guestBookID), REQUEST_RESULT_NAME, forward);
		return view;
	}
	
	/**
	 *@Description:新增留言
	 * @param request
	 * @param response
	 * @param itemOrder
	 * @return 
	 */
	@RequestMapping(value="/addGuestBook", params={"guestBook", "forward"})
	public ModelAndView addGuestBook(HttpServletResponse response, @ParameterName("guestBook") GuestBook guestBook,
			@RequestParam(value = "forward", defaultValue = "JSON") String forward){
		ModelAndView view = null;
		
		view = RequestUtil.requestForward(response, guestBookService.addGuestBook(guestBook), REQUEST_RESULT_NAME, forward);
		return view;
		
	}
}
