package com.wxw.sdweb.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

public class MyTools {

	
	 public static java.sql.Date strToDate(String strDate) {  
	        String str = strDate;  
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	        java.util.Date d = null;  
	        try {  
	            d = format.parse(str);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        java.sql.Date date = new java.sql.Date(d.getTime());  
	        return date;  
	    } 
	 
	 public static String uploadFile(MultipartFile file, HttpServletRequest request) {
			String filename = file.getOriginalFilename();
			//System.out.println("filename:"+filename+"====================================");
			String prefix = filename.substring(filename.lastIndexOf("."));
			int endIndex = request.getRequestURL().length() - request.getRequestURI().length() + 1;
			String baseURL = request.getRequestURL().substring(0, endIndex)+"poster/";
			System.out.println("baseURL="+baseURL);
			String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/poster";
			
			
			System.out.println("path="+path);

			/*
			 * System.out.println(path);
			 * System.out.println("getRequestURL: "+request.getRequestURL());
			 * System.out.println("getRequestURI: "+request.getRequestURI());
			 * System.out.println("getQueryString: "+request.getQueryString());
			 * System.out.println("getRemoteAddr: "+request.getRemoteAddr());
			 * System.out.println("getRemoteHost: "+request.getRemoteHost());
			 * System.out.println("getRemotePort: "+request.getRemotePort());
			 * System.out.println("getRemoteUser: "+request.getRemoteUser());
			 * System.out.println("getLocalAddr: "+request.getLocalAddr());
			 * System.out.println("getLocalName: "+request.getLocalName());
			 * System.out.println("getLocalPort: "+request.getLocalPort());
			 * System.out.println("getMethod: "+request.getMethod());
			 * System.out.println("-------request.getParamterMap()-------");
			 */

			String newName = UUID.randomUUID().toString() + prefix;
			File file01 = new File(path, newName);
			try {
				file.transferTo(file01);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 文件写入

			return baseURL + newName;
		}

}
