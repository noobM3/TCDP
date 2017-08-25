package com.hangzhu.controller;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/file/")
public class FileUpLoadController {

	@RequestMapping("upload.do")
	@ResponseBody
	public String upload(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, Model model) {

		String  url="upload"+File.separator;
		// 得到服务器物理路径名/upload/
	
		String path = request.getSession().getServletContext()
				.getRealPath(File.separator+"upload"+File.separator);
		System.out.println("文件路径" + path);
		
		SimpleDateFormat  stFormat=new SimpleDateFormat("yyyymmddhhMMSS");
		String newfileName=stFormat.format(new Date());
		
		SimpleDateFormat  stFormat1=new SimpleDateFormat("yyyy");
		String year=stFormat1.format(new Date());
		//URL是文件的相对路径-- upload/2017/
		url+=year+File.separator;
		//path是文件的绝对路径-- D:/ ./TCDP/...../upload/2017/
		path+=File.separator+year;
		//判别文件夹是否存在，若不存在则创建该文件夹
		File file2=new File(path);
		if(!file2.exists())
			file2.mkdirs();
		
		//得到上传的文件名
		String fileName = file.getOriginalFilename();
		System.out.println("fileName:" + fileName);
		//得到文件后缀名--时间戳.后缀名
        newfileName+=fileName.substring(fileName.lastIndexOf("."), fileName.length());
        System.out.println("newfileName:" + newfileName);
		url+=newfileName;//  upload/2017/时间戳.后缀名
		
		File targetFile = new File(path, newfileName);
	
		
		try {
			//拷贝文件到目录路径
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		//String url = request.getContextPath() + "/upload/" + newfileName;
          
		//model.addAttribute("url", url);
		//model.addAttribute("filename", fileName);
		return "{\"success\":true}";
	}
  
		
	@RequestMapping("downLoad.do")
	public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {  
		 HttpHeaders headers = new HttpHeaders();  
		 headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);  
		
		 headers.setContentDispositionFormData("attachment", "sfsada.pdf");
		 
		 String path = request.getSession().getServletContext()
					.getRealPath("//upload//");
		 
		  File file=new File(path+"/2017/201717130408870.pdf");
		  
		return new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file),
		           headers, HttpStatus.CREATED);  
	}
	
}
