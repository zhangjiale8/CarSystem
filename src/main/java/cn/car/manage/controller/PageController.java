package cn.car.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.car.manage.annotation.PermissionIgnore;


@Controller
public class PageController {

//前端页面开始
	/**
	 * 
	 * @Description: 首页
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@PermissionIgnore
	@RequestMapping(value = { "/", "", "/index" })
	public ModelAndView index(){

		return new ModelAndView("frontEndPage/index");
		
	}
	/**
	 * @Description: 登录页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@PermissionIgnore
	@RequestMapping(value = { "/toRegister"})
	public ModelAndView register(){

		return new ModelAndView("register");
		
	}
	/**
	 * @Description: 登录页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@PermissionIgnore
	@RequestMapping(value = { "/login"})
	public ModelAndView login(){

		return new ModelAndView("login");
		
	}
	/**
	 * @Description: 商品列表页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */

	@PermissionIgnore
	@RequestMapping("/itemList")
	public ModelAndView itemList(){

		return new ModelAndView("frontEndPage/itemList");
		
	}
	/**
	 * @Description: 商品配件列表页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */

	@PermissionIgnore
	@RequestMapping("/itemListFitting")
	public ModelAndView itemListFitting(){

		return new ModelAndView("frontEndPage/itemListFitting");
		
	}
	/**
	 * @Description: 错误页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@PermissionIgnore
	@RequestMapping(value = { "/404"})
	public ModelAndView eeror(){

		return new ModelAndView("frontEndPage/404");
		
	}
	/**
	 * @Description: 商品信息页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping("/itemInfo")
	public ModelAndView itemInfo(){

		return new ModelAndView("frontEndPage/itemInfo");
		
	}
	/**
	 * @Description: 订单信息页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping("/itemOrderInfo")
	public ModelAndView itemOrderInfo(){

		return new ModelAndView("frontEndPage/itemOrderInfo");
		
	}
	/**
	 * @Description: 账户管理页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/manage"})
	public ModelAndView manage(){

		return new ModelAndView("frontEndPage/manage");
		
	}
	/**
	 * @Description: 会员中心页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/memberCenter"})
	public ModelAndView memberCenter(){

		return new ModelAndView("frontEndPage/memberCenter");
		
	}
	/**
	 * @Description: 需求页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/needs"})
	public ModelAndView needs(){

		return new ModelAndView("frontEndPage/needs");
		
	}
	/**
	 * @Description: 去新增留言本页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toAddGuestBook"})
	public ModelAndView addGuestBook(){

		return new ModelAndView("frontEndPage/addGuestBook");
		
	}
	/**
	 * @Description: 留言本页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/getGuestBook"})
	public ModelAndView getGuestBook(){

		return new ModelAndView("frontEndPage/guestBook");
		
	}
	/**
	 * @Description: 留言本页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/getGuestBookuser"})
	public ModelAndView getGuestBookuser(){

		return new ModelAndView("frontEndPage/userguestBook");
		
	}
//前端页面结束
	
//后台管理页面开始
	/**
	 * @Description: 后台管理首页
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/backStage"})
	public ModelAndView backIndex(HttpServletResponse response, HttpServletRequest request){
		int roleID = (Integer) request.getSession().getAttribute("roleID");
		if(roleID==1){
			
			return new ModelAndView("backStage/index");
		}else{
			
			return new ModelAndView("/login");
		}
		
		
	}
	/**
	 * @Description: 主页
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/home"})
	public ModelAndView home(){

		return new ModelAndView("backStage/home");
		
	}
//产品管理页面	
	/**
	 * @Description: 品牌管理页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/brandManage"})
	public ModelAndView brandManage(){

		return new ModelAndView("backStage/brandManage");
		
	}
	
	/**
	 * @Description: 品牌管理页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toAddBrand"})
	public ModelAndView toAddBrand(){

		return new ModelAndView("backStage/addBrand");
		
	}
	/**
	 * @Description: 产品类型管理页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/categoryManage"})
	public ModelAndView categoryManage(){

		return new ModelAndView("backStage/categoryManage");
		
	}
	/**
	 * @Description: 产品类型管理页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/productCategoryAdd"})
	public ModelAndView productCategoryAddy(){

		return new ModelAndView("backStage/productCategoryAdd");
		
	}
	/**
	 * @Description: 添加品牌页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/addBrand"})
	public ModelAndView addBrand(){

		return new ModelAndView("backStage/addBrand");
		
	}
	
	
	/**
	 * @Description: 修改品牌页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toBrandEdit"})
	public ModelAndView toupdateBrand(){

		return new ModelAndView("backStage/brandEdit");
		
	}
//销售管理页面
	
	/**
	 * @Description: 整车销售页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/vehicleSale"})
	public ModelAndView vehicleSales(){

		return new ModelAndView("backStage/vehicleSale");
		
	}
	/**
	 * @Description: 配件销售页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/lookCarManage"})
	public ModelAndView lookCarManage(){

		return new ModelAndView("backStage/makeAppointment");
		
	}
	/**
	 * @Description: 预约管理页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/fittingSale"})
	public ModelAndView fittingSale(){

		return new ModelAndView("backStage/fittingSale");
		
	}
	/**
	 * @Description: 修改状态页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toItemOrderState"})
	public ModelAndView updateItemOrderState(){

		return new ModelAndView("backStage/itemOrderState");
		
	}
	/**
	 * @Description: 修改订单页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toUpdateItemOrder"})
	public ModelAndView toUpdateItemOrder(){

		return new ModelAndView("backStage/itemOrderEdit");
		
	}
	/**
	 * @Description: 新增订单页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toAddItemOrder"})
	public ModelAndView toAddItemOrder(){

		return new ModelAndView("backStage/addItemOrder");
		
	}
//进库管理页面
	/**
	 * @Description: 整车进库页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/vehicleIntoLibrary"})
	public ModelAndView vehicleIntoLibrary(){

		return new ModelAndView("backStage/vehicleEnterOrderLibrary");
		
	}
	
	/**
	 * @Description: 配件进库页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/fittingIntoLibrary"})
	public ModelAndView fittingIntoLibrary(){

		return new ModelAndView("backStage/fittingEnterOrderLibrary");
		
	}
	
	/**
	 * @Description: 新增整车商品页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toAddVehicleItem"})
	public ModelAndView toAddVehicleItem(){

		return new ModelAndView("backStage/addVehicleItem");
		
	}
	/**
	 * @Description: 新增零部件商品页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toAddFittingItem"})
	public ModelAndView toAddFittingItem(){

		return new ModelAndView("backStage/addFittingItem");
		
	}
	
	/**
	 * @Description: 入库单修改页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	
	@RequestMapping(value = { "/toUpdateItemEnterLibraryOrder"})
	public ModelAndView toUpdateItemEnterLibraryOrder(){
		
		return new ModelAndView("backStage/itemEnterLibraryOrderEdit");
	}
//出库管理页面
	/**
	 * @Description: 整车出库单页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/vehicleOutLibrary"})
	public ModelAndView vehicleOutLibrary(){

		return new ModelAndView("backStage/vehicleOutOrderLibrary");
		
	}
	/**
	 * @Description: 去整车出库页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toVehicleOutLibrary"})
	public ModelAndView toOutLibrary(){

		return new ModelAndView("backStage/itemOutLibrary");
		
	}
	/**
	 * @Description: 去修改数量页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/addItemOutLibraryOrder"})
	public ModelAndView toUpdateItemNum(){

		return new ModelAndView("backStage/addItemOutLibraryOrder");
		
	}
	/**
	 * @Description: 配件出库单页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/fittingOutLibrary"})
	public ModelAndView fittingOutLibrary(){

		return new ModelAndView("backStage/fittingOutOrderLibrary");
		
	}

	/**
	 * @Description: 去零件出库页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toFittingOutLibrary"})
	public ModelAndView toFittingOutLibrary(){

		return new ModelAndView("backStage/itemOutLibrary");
		
	}
	/**
	 * @Description: 出库单修改页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	
	@RequestMapping(value = { "/toUpdateItemOutLibraryOrder"})
	public ModelAndView toUpdateItemOutLibraryOrder(){
		
		return new ModelAndView("backStage/itemOutLibraryOrderEdit");
	}
//库存管理页面
	
	/**
	 * @Description: 配件库存页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/fittingStock"})
	public ModelAndView fittingStock(){

		return new ModelAndView("backStage/fittingStock");
		
	}
	/**
	 * @Description: 整车库存页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/vehicleStock"})
	public ModelAndView vehicleStock(){

		return new ModelAndView("backStage/vehicleStock");
		
	}
	
	/**
	 * @Description: 仓库管理页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/wareHouseManage"})
	public ModelAndView wareHouseManage(){

		return new ModelAndView("backStage/wareHouseManage");
		
	}
	/**
	 * @Description: 新增仓库页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toAddWareHouse"})
	public ModelAndView addWareHouse(){

		return new ModelAndView("backStage/addWareHouse");
		
	}
	/**
	 * @Description: 转移商品仓库页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toUpdateitemWareHousePosition"})
	public ModelAndView toUpdateitemWareHousePosition(){

		return new ModelAndView("backStage/wareHouseEdit");
		
	}
//维修管理页面
	
	/**
	 * @Description: 维修订单管理页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/repairOrderManage"})
	public ModelAndView repairOderManager(){

		return new ModelAndView("backStage/repairOrderManage");
		
	}
	
	/**
	 * @Description: 创建维修订单页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/addRepairOrder"})
	public ModelAndView addRepairOder(){

		return new ModelAndView("backStage/makeAppointmentRepair");
		
	}
	/**
	 * @Description: 维修订单新增页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toAddRepairOrder"})
	public ModelAndView tOAddRepair(){

		return new ModelAndView("backStage/addRepairOrder");
		
	}
	/**
	 * @Description: 维修订单修改页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toUpdateRepairOrder"})
	public ModelAndView toUpdateRepair(){

		return new ModelAndView("backStage/repairOrderEdit");
		
	}
	/**
	 * @Description: 维修订单状态修改页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toRepairOrderState"})
	public ModelAndView toRepairOrderState(){

		return new ModelAndView("backStage/repairOrderState");
		
	}
	
//留言管理页面
	
	/**
	 * @Description: 留言本
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/guestBook"})
	public ModelAndView guestBook(){

		return new ModelAndView("backStage/guestBook");
		
	}
	
	/**
	 * @Description: 去留言编辑页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toUpdateGuestBook"})
	public ModelAndView toUpdateGuestBook(){

		return new ModelAndView("backStage/guestBookEdit");
		
	}
	/**
	 * @Description: 意见反馈页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/feedBack"})
	public ModelAndView feedBack(){

		return new ModelAndView("backStage/feedBack");
		
	}
	
	/**
	 * @Description: 去评论回复页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toUpdateComment"})
	public ModelAndView comment(){

		return new ModelAndView("backStage/commentEdit");
		
	}
//客户管理页面
	
	/**
	 * @Description: 客户信息页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/customerInfo"})
	public ModelAndView customerInfo(){

		return new ModelAndView("backStage/customerInfo");
		
	}
	/**
	 * @Description: 客户统计分析页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/customerStatistics"})
	public ModelAndView customerStatistics(){

		return new ModelAndView("backStage/customerStatistics");
		
	}
	
//系统管理页面
	/**
	 * @Description: 管理员信息页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/adminInfo"})
	public ModelAndView adminInfo(){

		return new ModelAndView("backStage/adminInfo");
		
	}
	/**
	 * @Description: 管理员信息页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/adminInfoEdit"})
	public ModelAndView adminInfoEdit(){

		return new ModelAndView("frontEndPage/adminInfoEdit");
		
	}
	/**
	 * @Description: 管理员列表页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/administrators"})
	public ModelAndView adminstrator(){

		return new ModelAndView("backStage/administrators");
		
	}
	@RequestMapping("/toUpdate")
	public String toupdate(){
		
		return "backStage/userEdit";
		
	}
	@RequestMapping("/toUpdateCustomer")
	public String toupdateCustomer(){
		
		return "backStage/customerEdit";
		
	}
	/**
	 * @Description: 添加管理员页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/toAddUser"})
	public ModelAndView toAddUser(){

		return new ModelAndView("backStage/addUser");
		
	}
	/**
	 * @Description: 修改密码
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@PermissionIgnore
	@RequestMapping(value = { "/getUserInfoPass"})
	public ModelAndView getUserInfoPass(){

		return new ModelAndView("frontEndPage/userInfoPass");
		
	}
	
}

