package com.wxw.sdweb.controller.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wxw.sdweb.service.IAdvertService;
import com.wxw.sdweb.vo.Advert;
import com.wxw.sdweb.vo.Program;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

/***********************************************
 * 
 * 功能：Apimain主控制器 作者：王宣武 日期：2018-01-01
 * *********************************************
 */
@Controller
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AdvertController {

	@Autowired
	private IAdvertService advertService;

	/***********************************************
	 * 功能：广告API 作者：王宣武 日期：2018-01-01
	 */

	/**
	 * 广告加载 王宣武 2018-01-01
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/admin/ad/load", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView load(Map<String, Object> map) {

		List<Advert> objs = advertService.findAll();
		ModelAndView mv = new ModelAndView("/admin/advert/advertlist");
		map.put("title", "广告列表01");
		map.put("objs", objs);
		return mv;
	}

	/**
	 * 广告添加页面加载 作者：王宣武
	 * 
	 */
	@RequestMapping(value = "/admin/ad/load_add")
	@ResponseBody
	public ModelAndView loadAdvertAdd(Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("/admin/advert/advert_add");
		map.put("title", "广告添加");
		return mv;
	}

	/**
	 * 广告添加 作者：王宣武
	 * 
	 */
	@RequestMapping(value = "/admin/ad/add", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView advert_add(Map<String, Object> map, @RequestParam("adname") String adname,
			@RequestParam("adtitle") String adtitle, @RequestParam("adtype") String adtype,
			@RequestParam("adpage") String adpage, @RequestParam("adtime") String adtime,
			@RequestParam("file") MultipartFile file, @RequestParam("isenable") String isenable,
			@RequestParam("remark") String remark, HttpServletRequest request) {
		String furl = uploadFile(file, request);

		// final File excelFile = file.createTempFile(UUIDGenerator.getUUID(), prefix);

		Advert obj = new Advert();
		obj.setAdname(adname);
		obj.setAdtitle(adtitle);
		obj.setAdtype(adtype);
		obj.setAdpage(adpage);
		obj.setAdtime(adtime);
		obj.setAdurl(furl);
		obj.setIsenable(isenable);
		obj.setRemark(remark);

		int row = advertService.insert(obj);
		ModelAndView mv = new ModelAndView("redirect:/admin/ad/load");
		return mv;
	}

	/**
	 * 功能：广告数据删除 作者：王宣武
	 * 
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/ad/del", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView loadAdvertDel(Map<String, Object> map, @RequestParam("id") int id) {
		advertService.delete(id);
		ModelAndView mv = null;
		mv = new ModelAndView("redirect:/admin/ad/load");
		return mv;
	}

	/**
	 * 广告修改页面加载 作者：王宣武
	 * 
	 */
	@RequestMapping(value = "/admin/ad/load_update", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView loadAdvertUpdate(Map<String, Object> map, @RequestParam("id") int id) {

		Advert obj = advertService.find(id);
		if (null == obj) {
			System.out.println("ahah");
		}

		ModelAndView mv = new ModelAndView("/admin/advert/advert_update");
		map.put("title", "广告修改");
		map.put("obj", obj);
		return mv;
	}

	/**
	 * 功能：广告数据修改 作者：王宣武 日期：2018-01-01
	 * 
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/ad/update", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView loadProgUpdate(Map<String, Object> map, @RequestParam("id") int id,
			@RequestParam("adname") String adname, @RequestParam("adtitle") String adtitle,
			@RequestParam("adtype") String adtype, @RequestParam("adpage") String adpage,
			@RequestParam("adtime") String adtime, @RequestParam("file") MultipartFile file,
			@RequestParam("isenable") String isenable, @RequestParam("remark") String remark,
			HttpServletRequest request) {
		Advert obj = new Advert();
		obj.setId(id);
		obj.setAdname(adname);
		obj.setAdtitle(adtitle);
		obj.setAdtype(adtype);
		obj.setAdpage(adpage);
		obj.setAdtime(adtime);
		//obj.setAdurl(furl);
		obj.setIsenable(isenable);
		obj.setRemark(remark);
		int rows = advertService.update(obj);
		ModelAndView mv = null;
		if (rows == 0) {
			mv = new ModelAndView("/admin/video/program_add");
		} else {
			mv = new ModelAndView("redirect:/admin/ad/load");
		}
		return mv;
	}

	private String uploadFile(MultipartFile file, HttpServletRequest request) {
		String filename = file.getOriginalFilename();
		String prefix = filename.substring(filename.lastIndexOf("."));
		int endIndex = request.getRequestURL().length() - request.getRequestURI().length() + 1;
		String baseURL = request.getRequestURL().substring(0, endIndex);

		String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";

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
