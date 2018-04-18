package cn.car.manage.service.item.photo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.car.manage.beans.orm.item.photo.ItemPhoto;

import cn.car.manage.mapper.item.photo.ItemPhotoMapper;
import cn.car.manage.pub.enums.Status;

import cn.car.manage.util.helper.ReturnMessage;



@Service
public class ItemPhotoService {

	private static final String uploadPath = "resource/images/upload/";
	
	
	@Autowired
	private ItemPhotoMapper itemPhotoMapper;
	
	public ReturnMessage  addItemPhoto(MultipartFile[] files,int itemID,int purposeID,HttpServletRequest request) throws IllegalStateException, IOException{
		ReturnMessage msg = new ReturnMessage();
		
		ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i]; 
            String fileName=file.getOriginalFilename();

            if (!file.isEmpty()) {
                InputStream in = null;
                OutputStream out = null;

                try {
                	String path = request.getServletContext().getRealPath("/")+uploadPath;
                    
                    File serverFile = new File(path);
                    if (!serverFile.exists()){
                    	serverFile.mkdirs();
                    }
                    	
                    String newPath=path+fileName;
                    String inserPath=uploadPath+fileName;
                    in = file.getInputStream();
                    out = new FileOutputStream(newPath);
                    byte[] b = new byte[1024];
                    int len = 0;
                    while ((len = in.read(b)) > 0) {
                        out.write(b, 0, len);
                    }
                    ItemPhoto itemPhoto = new ItemPhoto();
                    itemPhoto.setItemID(itemID);
                    itemPhoto.setPhotoResource(inserPath);
                    itemPhoto.setPhotoUse(purposeID);
                    itemPhotoMapper.addItemPhoto(itemPhoto);
                    
                    out.close();
                    in.close();

                } catch (Exception e) {
                    arr.add(i);
                } finally {
                    if (out != null) {
                        out.close();
                        out = null;
                    }

                    if (in != null) {
                        in.close();
                        in = null;
                    }
                }
            } else {
                arr.add(i);
            }


        }

        if(arr.size() > 0) {
            msg.setStatus(Status.ERROR);
            msg.setError("Files upload fail");
            msg.setErrorKys(arr);
        } else {
            msg.setStatus(Status.SUCCESS);
            msg.setStatusMsg("Files upload success");
        }
        return msg;
  
	}
	
}
