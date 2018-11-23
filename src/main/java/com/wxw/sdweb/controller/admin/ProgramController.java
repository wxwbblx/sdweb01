package com.wxw.sdweb.controller.admin;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wxw.sdweb.service.IProgramService;
import com.wxw.sdweb.vo.Program;

@Controller
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ProgramController {

	@Autowired
	private IProgramService programService;

	/**
	 * 节目清单页面加载
	 * 作者：王宣武 
	 * @return
	 */
	@RequestMapping(value = "/admin/loadProgram")
	@ResponseBody
	public ModelAndView loadProgarm(Map<String, Object> map) {

		List<Program> objs = programService.findAll();
		ModelAndView mv = new ModelAndView("/admin/video/program_list");
		map.put("objs", objs);
		return mv;

	}
	
	/**
	 * 节目清单添加页面加载
	 * 作者：王宣武
	 * 
	 */
	@RequestMapping(value = "/admin/prog_add_load")
	@ResponseBody
	public ModelAndView loadProgAddLoad(Map<String, Object> map) {

		
		//return program.getId();
		
		List<Program> objs = programService.findAll();		
		ModelAndView mv = new ModelAndView("/admin/video/program_add");
		map.put("objs", objs);
		return mv;

	}
	
	
	
	/**
	 * 功能：节目清单数据提交
	 * 作者：王宣武
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/admin/prog_add", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView loadProgAdd(Map<String, Object> map) {
        Program program=new Program();	
        Date date= new java.sql.Date(new java.util.Date().getTime());
        program.setPdate(date);
        program.setPlength(60);
        program.setPstime(null);
        program.setRemark("beizhu");
        System.out.println(program);
		int rows = programService.insert(program);
		ModelAndView mv=null;
		if(rows==0) {
			 mv = new ModelAndView("/admin/video/program_add");
		}
		else
		{
			mv = new ModelAndView("redirect:/admin/loadProgram");
		}
		return mv;

	}
	
	
	/**
	 * 功能：节目清单数据删除
	 * 作者：王宣武
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/prog_del", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView loadProgDel(Map<String, Object> map,@RequestParam("id") int id) {
		programService.delete(id);
		ModelAndView mv=null;
		mv = new ModelAndView("redirect:/admin/loadProgram");
		return mv;
	}
	
	
	/**
	 * 功能：节目清单数据修改
	 * 作者：王宣武
	 * 日期：2018-01-01
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/prog_update", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView loadProgUpdate(Map<String, Object> map,@RequestParam("id") int id) {
		Program program=new Program();	
		int rows = programService.update(program);
		ModelAndView mv=null;
		if(rows==0) {
			 mv = new ModelAndView("/admin/video/program_add");
		}
		else
		{
			mv = new ModelAndView("redirect:/admin/prog_add_load");
		}
		return mv;

	}
	
	
	private Date parseHHMMss(String time)
	{
		 String time01 =time;// "15:30:18";
		 DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		 Date date = null;
		try {
			date = (Date) sdf.parse(time01);
		} catch (ParseException e) {
			e.printStackTrace();
		}            
		return date;
	}
}
