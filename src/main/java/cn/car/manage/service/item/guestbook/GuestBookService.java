package cn.car.manage.service.item.guestbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


import cn.car.manage.beans.orm.customer.Customer;
import cn.car.manage.beans.orm.item.guestbook.GuestBook;
import cn.car.manage.mapper.customer.CustomerMapper;
import cn.car.manage.mapper.item.guestbook.GuestBookMapper;
import cn.car.manage.util.helper.DataTable;
import cn.car.manage.util.helper.DataTableReturn;
import cn.car.manage.util.helper.PageBeanUtil;
import cn.car.manage.util.helper.PagedResult;

/**
 * @Description:留言业务层
 * @author 
 * @date 2018年3月10日
 */
@Service
public class GuestBookService {

	@Autowired
	private GuestBookMapper guestBookMapper;
	@Autowired
	private CustomerMapper customerMappr;
	/**
	 * @Description:分页
	 * @author 
	 * @date 2018年3月10日
	 */

	public DataTableReturn<GuestBook> getGuestBookByGuestBookNameAndGuestBookID(HttpServletRequest request) {
		if (request == null) {
			return null;
		}
		DataTable dataTable = new DataTable(request);
		String userName = dataTable.getParameters().getOrDefault("userName", "").toString();
		String handleState=dataTable.getParameters().getOrDefault("handleState","0").toString();
		userName = userName.isEmpty() ? null : userName.trim();
		PageHelper.startPage(dataTable.getStart(), dataTable.getLength(), dataTable.getSort());
		
		List<GuestBook> list = guestBookMapper.getGuestBookByGuestBookNameAndGuestBookID(userName,Integer.parseInt(handleState));
		
		
		Page<GuestBook> page = (Page<GuestBook>) list;
		DataTableReturn<GuestBook> dtReturn = new DataTableReturn<GuestBook>(dataTable.getsEcho(), page.getTotal(),
				page.getTotal(), list);
		return dtReturn;
	}
	

	/**
	 * @Description:前台分页
	 * @author 
	 * @date 2018年3月10日
	 */

	public PagedResult<GuestBook> getAllGuestBook(Integer pageNo,Integer pageSize,String userName ) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize); //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		return PageBeanUtil.toPagedResult(guestBookMapper.getAllGuestBook(userName));
	}
	/**
	 * @Description:新增留言
	 * @author 
	 * @date 2018年3月13日
	 */
	public int addGuestBook(GuestBook guestBook){
		Customer customer=customerMappr.getCustomerInfoWithName(guestBook.getUserName());
		if(customer==null){
			return 0;
		}
		guestBook.setCustomerID(customer.getUserID());
		return guestBookMapper.addGuestBook(guestBook);
		
	}
	


	/**
	 * @Description:根据id查询留言
	 * @author 
	 * @date 2018年3月10日
	 */
	public GuestBook getGuestBookByGuestBookID(int guestBookID){
		return guestBookMapper.getGuestBookByGuestBookID(guestBookID);
		
	}
	

	/**
	 * @Description:删除留言
	 * @author 
	 * @date 2018年3月10日
	 */
	public int deleteGuestBookByGuestBookID(List<Integer> guestBookID){
		return guestBookMapper.deleteGuestBookByGuestBookID(guestBookID);
		
	}

	/**
	 * @Description:根据用户名称删除留言
	 * @author 
	 * @date 2018年3月10日
	 */
	public int deleteGuestBookByUserName(String userName){
		return guestBookMapper.deleteGuestBookByUserName(userName);
		
	}
	/**
	 * @Description:回复内容
	 * @author 
	 * @date 2018年3月10日
	 */
	public int replyGuestBookContent(String replyContent,int guestBookID){
		
		return guestBookMapper.replyGuestBookContent(replyContent, guestBookID);
		
	}
	
	/**
	 * @Description:修改状态
	 * @author 
	 * @date 2018年3月10日
	 */
	public int updateGuestBookState(int handleState,int guestBookID){
		return guestBookMapper.updateGuestBookState(handleState, guestBookID);
		
	}
}
