package cn.car.manage.mapper.item.guestbook;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.car.manage.beans.orm.item.guestbook.GuestBook;

/**
 * @Description:留言数据层
 * @author 
 * @date 2018年3月10日
 */
@Repository
public interface GuestBookMapper {
	
	/**
	 * @Description:分页
	 * @author 
	 * @date 2018年3月10日
	 */
	public List<GuestBook> getGuestBookByGuestBookNameAndGuestBookID(@Param("userName")String userName,@Param("handleState")int handleState);
	/**
	 * @Description:分页
	 * @author 
	 * @date 2018年3月10日
	 */
	public List<GuestBook> getAllGuestBook(@Param("userName")String userName);
	/**
	 * @Description:新增留言
	 * @author 
	 * @date 2018年3月13日
	 */
	public int addGuestBook(GuestBook guestBook);
	
	
	/**
	 * @Description:根据id查询留言
	 * @author 
	 * @date 2018年3月10日
	 */
	public GuestBook getGuestBookByGuestBookID(@Param("guestBookID") int guestBookID);
	
	/**
	 * @Description:删除留言
	 * @author 
	 * @date 2018年3月10日
	 */
	public int deleteGuestBookByGuestBookID(List<Integer> guestBookID);
	
	/**
	 * @Description:回复内容
	 * @author 
	 * @date 2018年3月10日
	 */
	public int replyGuestBookContent(@Param("replyContent")String replyContent,@Param("guestBookID")int guestBookID);
	
	/**
	 * @Description:修改状态
	 * @author 
	 * @date 2018年3月10日
	 */
	public int updateGuestBookState(@Param("handleState")int handleState,@Param("guestBookID")int guestBookID);

	/**
	 * @Description:根据用户名查询
	 * @author 
	 * @date 2018年3月13日
	 */
	public List<GuestBook> getGuestBookByGuestBookName(@Param("userName")String userName);
	
	/**
	 * @Description:根据用户名删除留言
	 * @author 
	 * @date 2018年3月13日
	 */
	public int deleteGuestBookByUserName(@Param("userName") String userName);
}
