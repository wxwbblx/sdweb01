package com.wxw.sdweb.controller.admin;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.wxw.sdweb.service.IMenuService;
import com.wxw.sdweb.service.IProgramService;
import com.wxw.sdweb.util.MyTools;
import com.wxw.sdweb.vo.Menu;
import com.wxw.sdweb.vo.Program;

@Controller
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ProgramController {

	@Autowired
	private IProgramService programService;
	@Autowired
	private IMenuService menuService;

	/**
	 * 成员变量
	 */
	private int ptype = 1;
	private int ptypezh = 2;

	// ===================影视热播=================================
	/**
	 * 节目清单页面加载 作者：王宣武
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/loadProgram")
	@ResponseBody
	public ModelAndView loadProgarm(Map<String, Object> map) {

		String ptype01 = "" + ptype;
		List<Program> objs = programService.findByType(ptype01);
		ModelAndView mv = new ModelAndView("/admin/video/program_list");
		map.put("objs", objs);
		return mv;

	}

	/**
	 * 节目清单添加页面加载 作者：王宣武
	 * 
	 */
	@RequestMapping(value = "/admin/prog_add_load")
	@ResponseBody
	public ModelAndView loadProgAddLoad(Map<String, Object> map) {
		Menu obj = menuService.findById(ptype);
		ModelAndView mv = new ModelAndView("/admin/video/program_add");
		map.put("obj", obj);
		return mv;
	}

	/**
	 * 功能：节目清单数据提交 作者：王宣武
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/admin/prog_add", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView loadProgAdd(Map<String, Object> map, @RequestParam("pname") String pname,
			@RequestParam("pdate") String pdate, @RequestParam("pstime") String pstime,
			@RequestParam("plength") int plength, @RequestParam("isnew") String isnew,
			@RequestParam("remark") String remark, @RequestParam("ptype") String ptype, HttpServletRequest request) {
		Program program = new Program();
		program.setPname(pname);
		program.setPdate(MyTools.strToDate(pdate));
		program.setPlength(plength);
		program.setPtype(ptype);
		program.setPstime(pstime);
		program.setIsnew(isnew);
		program.setRemark(remark);

		System.out.println(program);
		// ============================================
		int rows = programService.insert(program);
		ModelAndView mv = null;
		if (rows == 0) {
			mv = new ModelAndView("/admin/video/program_add");
		} else {
			mv = new ModelAndView("redirect:/admin/loadProgram");
		}
		return mv;

	}

	/**
	 * 功能：节目清单数据删除 作者：王宣武
	 * 
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/prog_del", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView loadProgDel(Map<String, Object> map, @RequestParam("id") int id) {
		programService.delete(id);
		ModelAndView mv = null;
		mv = new ModelAndView("redirect:/admin/loadProgram");
		return mv;
	}

	/*
	 * 功能：节目清单数据加载 作者：王宣武 日期：2018-01-01
	 * 
	 * @param map
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/prog_update_load", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView loadProgUpdate(Map<String, Object> map, @RequestParam("id") int id) {
		Program program = new Program();
		program = programService.find(id);
		Menu obj = menuService.findById(ptype);
		ModelAndView mv = null;
		mv = new ModelAndView("/admin/video/program_update");
		map.put("pro", program);
		map.put("obj", obj);
		return mv;

	}

	/**
	 * 功能：节目清单数据修改 作者：王宣武 日期：2018-01-01
	 * 
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/prog_update", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView ProgUpdate(Map<String, Object> map, @RequestParam("id") Integer id,
			@RequestParam("pname") String pname, @RequestParam("pdate") String pdate,
			@RequestParam("pstime") String pstime, @RequestParam("plength") int plength,
			@RequestParam("isnew") String isnew, @RequestParam("remark") String remark,
			@RequestParam("ptype") String ptype, HttpServletRequest request) {
		Program program = new Program();
		program.setId(id);
		program.setPname(pname);
		program.setPdate(MyTools.strToDate(pdate));
		program.setPlength(plength);
		program.setPtype(ptype);
		program.setPstime(pstime);
		program.setIsnew(isnew);
		program.setRemark(remark);
		int rows = programService.update(program);
		ModelAndView mv = null;
		if (rows == 0) {
			mv = new ModelAndView("/admin/video/program_add");
		} else {
			mv = new ModelAndView("redirect:/admin/loadProgram");
		}
		return mv;

	}

	// ===================影视专区=================================

	/*
	 * 节目清单页面加载 作者：王宣武
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/zh/loadProgram")
	@ResponseBody
	public ModelAndView loadProgarmzh(Map<String, Object> map) {
		String ptype01 = "" + ptypezh;
		List<Program> objs = programService.findByType(ptype01);
		ModelAndView mv = new ModelAndView("/admin/videozh/program_list");
		map.put("objs", objs);
		return mv;

	}

	/*
	 * 节目清单添加页面加载 作者：王宣武
	 * 
	 */
	@RequestMapping(value = "/admin/zh/prog_add_load")
	@ResponseBody
	public ModelAndView loadProgAddLoadzh(Map<String, Object> map) {

		Menu obj = menuService.findById(ptypezh);
		ModelAndView mv = new ModelAndView("/admin/videozh/program_zh_add");
		map.put("obj", obj);
		return mv;
	}

	/*
	 * 功能：节目清单数据提交 作者：王宣武
	 * 
	 * @param map
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/zh/prog_add", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView loadProgAddzh(Map<String, Object> map, @RequestParam("pname") String pname,
			@RequestParam("pdate") String pdate, @RequestParam("pstime") String pstime,
			@RequestParam("plength") int plength, @RequestParam("isnew") String isnew,
			@RequestParam("remark") String remark, @RequestParam("ptype") String ptype, HttpServletRequest request) {
		Program program = new Program();
		program.setPname(pname);
		program.setPdate(MyTools.strToDate(pdate));
		program.setPlength(plength);
		program.setPtype(ptype);
		program.setPstime(pstime);
		program.setIsnew(isnew);
		program.setRemark(remark);

		// ============================================
		int rows = programService.insert(program);
		ModelAndView mv = null;
		if (rows == 0) {
			mv = new ModelAndView("/admin/video/program_add");
		} else {
			mv = new ModelAndView("redirect:/admin/zh/loadProgram");
		}
		return mv;

	}

	/*
	 * 功能：节目清单数据删除 作者：王宣武
	 * 
	 * @param map
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/zh/prog_del", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView loadProgDelzh(Map<String, Object> map, @RequestParam("id") int id) {
		programService.delete(id);
		ModelAndView mv = null;
		mv = new ModelAndView("redirect:/admin/zh/loadProgram");
		return mv;
	}
	
	
	 /* 功能：节目清单数据加载 作者：王宣武 日期：2018-01-01
	 * 
	 * @param map
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/zh/prog_update_load", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView loadProgUpdatezh(Map<String, Object> map, @RequestParam("id") int id) {
		Program program = new Program();
		program = programService.find(id);
		Menu obj = menuService.findById(ptypezh);
		ModelAndView mv = null;
		mv = new ModelAndView("/admin/videozh/program_updatezh");
		map.put("pro", program);
		map.put("obj", obj);
		return mv;

	}

	/* 功能：节目清单数据修改 作者：王宣武 日期：2018-01-01
	 * 
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/zh/prog_update", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView ProgUpdatezh(Map<String, Object> map, @RequestParam("id") Integer id,
			@RequestParam("pname") String pname, @RequestParam("pdate") String pdate,
			@RequestParam("pstime") String pstime, @RequestParam("plength") int plength,
			@RequestParam("isnew") String isnew, @RequestParam("remark") String remark,
			@RequestParam("ptype") String ptype, HttpServletRequest request) {
		Program program = new Program();
		program.setId(id);
		program.setPname(pname);
		program.setPdate(MyTools.strToDate(pdate));
		program.setPlength(plength);
		program.setPtype(ptype);
		program.setPstime(pstime);
		program.setIsnew(isnew);
		program.setRemark(remark);
		int rows = programService.update(program);
		ModelAndView mv = null;
		if (rows == 0) {
			mv = new ModelAndView("/admin/video/program_add");
		} else {
			mv = new ModelAndView("redirect:/admin/zh/loadProgram");
		}
		return mv;

	}
	
}
