package cn.car.manage.controller.item.photo;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import cn.car.manage.service.item.photo.ItemPhotoService;
import cn.car.manage.util.helper.ReturnMessage;

/**
 * @Description:绑定图片
 * @author 
 * @date 2018年3月16
 */
@Controller
@RequestMapping("/photo")
public class ItemPhotoController {

	@Autowired
	private ItemPhotoService itemPhotoService;
	
	
	/**
	 * @Description: 添加图片页面
	 * @Date: 2018年3月6日 上午午10:19:49
	 * @return
	 */
	@RequestMapping(value = { "/addPhoto"},params={"itemID"})
	public String addPhoto(HttpServletResponse response,HttpServletRequest request,int itemID){
		request.setAttribute("itemID", itemID);
		return "backStage/itemPhoto";
		
	}
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    @ResponseBody
    public ReturnMessage uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files,@RequestParam("itemID")int itemID,@RequestParam("purposeID")int purposeID,HttpServletRequest request) throws IOException {
        ReturnMessage msg = itemPhotoService.addItemPhoto(files, itemID, purposeID, request);
       
        return msg;
    }
	
}
