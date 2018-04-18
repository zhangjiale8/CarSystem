package cn.car.manage.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

import cn.car.manage.pub.interfaces.BaseController;
import cn.car.manage.util.helper.ItemOrderCodeUtil;
import cn.car.manage.util.helper.OutLibraryOrderCodeUtil;


/**
 * @Description:商品订单号出库单号进库单号自动生成控制层
 * @author 
 * @date 2018年3月10日
 */
@Controller
@RequestMapping("/createNum")
public class CreateNumController implements BaseController{

	private final OutLibraryOrderCodeUtil idg = OutLibraryOrderCodeUtil.INSTANCE;

	private ItemOrderCodeUtil itemOrderCode=new ItemOrderCodeUtil();
	@RequestMapping(value="/number")
	public @ResponseBody String createNum(){
		return new Gson().toJson(idg.nextId());
	}
	@RequestMapping(value="/itemOrderCode")
	public @ResponseBody String itemOrderCode(){
		return new Gson().toJson(itemOrderCode.nextId());
	}
}
