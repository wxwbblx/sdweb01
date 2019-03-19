package com.wxw.sdweb.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wxw.sdweb.service.IBregionService;
import com.wxw.sdweb.service.IVideotypeServcie;
import com.wxw.sdweb.util.MyTools;
import com.wxw.sdweb.vo.Bregion;
import com.wxw.sdweb.vo.Menu;
import com.wxw.sdweb.vo.Movie;
import com.wxw.sdweb.vo.Videotype;

@Controller
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SyssetController {

	@Autowired
	private IBregionService bregionService;

	@Autowired
	private IVideotypeServcie videotypeServcie;

	// ===================地区专区=================================
	/**
	 * 视频专区清单页面加载 作者：王宣武
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/region/loadregions")
	@ResponseBody
	public ModelAndView loadRegion(Map<String, Object> map) {

		System.out.println("loadRegion");

		List<Bregion> objs = bregionService.findAll();
		ModelAndView mv = new ModelAndView("/admin/basedata/region/region_list");
		map.put("objs", objs);
		return mv;

	}

	/**
	 * 节目清单添加页面加载 作者：王宣武 , method = RequestMethod.GET
	 */
	@RequestMapping(value = "/admin/region/region_add_load")
	@ResponseBody
	public ModelAndView loadRegionAdd(Map<String, Object> map) {

		ModelAndView mv = new ModelAndView("/admin/basedata/region/region_add");
		// map.put("obj", obj);
		return mv;
	}

	/**
	 * 功能：节目清单数据提交 作者：王宣武
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/admin/region/region_add", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView regionAdd(Map<String, Object> map, @RequestParam("lname") String lname,
			@RequestParam("remark") String remark, HttpServletRequest request) {

		Bregion region = new Bregion();
		region.setLname(lname);
		region.setRemark(remark);
		int rows = bregionService.insert(region);
		ModelAndView mv = null;
		if (rows == 0) {
			mv = new ModelAndView("/admin/video/program_add");
		} else {
			mv = new ModelAndView("redirect:/admin/region/loadregions");
		}
		return mv;

	}

	/*
	 * 节目清单添加页面加载 作者：王宣武
	 * 
	 */
	@RequestMapping(value = "/admin/region/region_update_load", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView loadRegionUpdate(Map<String, Object> map, @RequestParam("id") int id) {
		Bregion bregion = bregionService.findById(id);
		map.put("bregion", bregion);
		ModelAndView mv = new ModelAndView("/admin/basedata/region/region_update");
		return mv;
	}

	/*
	 * 功能：节目清单数据修改 作者：王宣武
	 * 
	 * @param map
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/region/region_update", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView RegionUpdate(Map<String, Object> map, @RequestParam("id") int id,
			@RequestParam("lname") String lname, @RequestParam("remark") String remark, HttpServletRequest request) {
		Bregion bregion = new Bregion();
		System.out.println("==============================id:" + id);
		bregion.setId(id);
		bregion.setLname(lname);
		bregion.setRemark(remark);

		int rows = bregionService.update(bregion);
		// int rows=1;
		ModelAndView mv = null;
		if (rows == 0) {
			mv = new ModelAndView("/admin/video/program_add");
		} else {
			mv = new ModelAndView("redirect:/admin/region/loadregions");
		}
		return mv;

	}

	/**
	 * 地区删除 作者：王宣武
	 * 
	 */
	@RequestMapping(value = "/admin/region/region_del", method = RequestMethod.GET)

	@ResponseBody
	public ModelAndView movieDel(Map<String, Object> map, @RequestParam("id") int id) {
		bregionService.delete(id);
		ModelAndView mv = null;
		mv = new ModelAndView("redirect:/admin/region/loadregions");
		return mv;
	}

	// ===================视频类型=================================
	/**
	 * 视频专区清单页面加载 作者：王宣武
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/vtype/loadvtype")
	@ResponseBody
	public ModelAndView loadVideotype(Map<String, Object> map) {

		System.out.println("loadVideotype");

		List<Videotype> objs = videotypeServcie.findAll();
		ModelAndView mv = new ModelAndView("/admin/basedata/vtype/vtype_list");
		map.put("objs", objs);
		return mv;

	}

	/**
	 * 节目清单添加页面加载 作者：王宣武 , method = RequestMethod.GET
	 */
	@RequestMapping(value = "/admin/vtype/region_add_load")
	@ResponseBody
	public ModelAndView loadVtypeAdd(Map<String, Object> map) {

		ModelAndView mv = new ModelAndView("/admin/basedata/vtype/vtype_add");
		// map.put("obj", obj);
		return mv;
	}

	/**
	 * 功能：节目清单数据提交 作者：王宣武
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/admin/vtype/vtype_add", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView vtypeAdd(Map<String, Object> map, @RequestParam("vtype") String vtype,
			@RequestParam("remark") String remark, HttpServletRequest request) {

		Videotype videotype = new Videotype();
		videotype.setVtype(vtype);
		videotype.setRemark(remark);
		int rows = videotypeServcie.insert(videotype);
		ModelAndView mv = null;
		if (rows == 0) {
			mv = new ModelAndView("/admin/video/program_add");
		} else {
			mv = new ModelAndView("redirect:/admin/vtype/loadvtype");
		}
		return mv;

	}

	/*
	 * 节目清单添加页面加载 作者：王宣武
	 * 
	 */
	@RequestMapping(value = "/admin/vtype/vtype_update_load", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView loadVtypeUpdate(Map<String, Object> map, @RequestParam("id") int id) {
		Videotype videotype = videotypeServcie.findById(id);
		map.put("videotype", videotype);
		ModelAndView mv = new ModelAndView("/admin/basedata/vtype/vtype_update");
		return mv;
	}

	/*
	 * 功能：节目清单数据修改 作者：王宣武
	 * 
	 * @param map
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/vtype/vtype_update", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView VtypeUpdate(Map<String, Object> map, @RequestParam("id") int id,
			@RequestParam("vtype") String vtype, @RequestParam("remark") String remark, HttpServletRequest request) {
		Videotype videotype = new Videotype();
		System.out.println("==============================id:" + id);
		videotype.setId(id);
		videotype.setVtype(vtype);
		videotype.setRemark(remark);

		int rows = videotypeServcie.update(videotype);
		// int rows=1;
		ModelAndView mv = null;
		if (rows == 0) {
			mv = new ModelAndView("/admin/video/program_add");
		} else {
			mv = new ModelAndView("redirect:/admin/vtype/loadvtype");
		}
		return mv;

	}

	/**
	 * 地区删除 作者：王宣武
	 * 
	 */
	@RequestMapping(value = "/admin/vtype/vtype_del", method = RequestMethod.GET)

	@ResponseBody
	public ModelAndView vtypeDel(Map<String, Object> map, @RequestParam("id") int id) {
		videotypeServcie.delete(id);
		ModelAndView mv = null;
		mv = new ModelAndView("redirect:/admin/vtype/loadvtype");
		return mv;
	}

	// ====================关于我们================================

	@RequestMapping(value = "/admin/about")
	@ResponseBody
	public ModelAndView load(Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("/admin/sysset/about");
		map.put("pagetitle", "关于我们");
		map.put("title", "关于我们");
		map.put("copyright", "Copyright 2018 by wxw. All rights reserved.");
		return mv;

	}

	@RequestMapping(value = "/admin/get_region")
	@ResponseBody
	public ModelAndView getRegionList(Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("/admin/region/regionlist");
		map.put("pagetitle", "关于我们");
		map.put("title", "关于我们");
		map.put("copyright", "Copyright 2018 by wxw. All rights reserved.");
		return mv;

	}

}
