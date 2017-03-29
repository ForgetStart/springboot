/**
 * 
 */
package com.cn.fd.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 		Description:	上传图片
 * </p>
 * 
 * @author fengda
 * @date 2017年3月22日 下午1:10:43
 */
@Controller
public class ImageController {

	@Value("${FILE_PATH}")
	private String FILE_PATH;
	
	@RequestMapping(value = "/image/upload", method = RequestMethod.POST)
	@ResponseBody
	public String upload(@RequestParam("image") MultipartFile file,
			HttpServletRequest req) throws Exception {
		
		if (!file.isEmpty()) {
			
			try {
				String name = file.getOriginalFilename();
				String imagePath = FILE_PATH + UUID.randomUUID() + "\\" + name;
				
				File imageFile = new File(imagePath);
				if(!imageFile.getParentFile().exists()){
					imageFile.getParentFile().mkdirs();
				}
				
				BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(imageFile));
				os.write(file.getBytes());
				
				//saveFile(imagePath, file.getBytes());
				
			} catch (Exception e) {
				e.printStackTrace();
				return "上传失败";
			}
			return "上传成功";
		} else {
			return "上传失败，因为文件是空的.";
		}
	}

	
	//保存文件的方法
	private void saveFile(String filePath, byte[] content) throws IOException {
		BufferedOutputStream bos = null;
		try {
			File file = new File(filePath);
			//判断文件路径是否存在
			if (!file.getParentFile().exists()) {
				//文件路径不存在时，创建保存文件所需要的路径
				file.getParentFile().mkdirs();
			}
			//创建文件（这是个空文件，用来写入上传过来的文件的内容）
			file.createNewFile();
			bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(content);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("文件不存在。");
		} finally {
			if (null != bos) {
				bos.close();
			}
		}
	}
	
	
	@RequestMapping("/image/index")
	public String image() {
		return "images";
	}
}
