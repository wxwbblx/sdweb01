package com.wxw.sdweb.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wxw.sdweb.service.IMovieService;
import com.wxw.sdweb.vo.Movie;
import com.wxw.sdweb.vo.Program;

@Controller
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MovieController {

	@Autowired
	private IMovieService movieService;
	
	/**
	 * 成员变量
	 */
	private int ptype = 3;
	private int ptypezh = 4;

	// ===================视频专区=================================
	/**
	 * 视频专区清单页面加载 作者：王宣武
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/movie/loadmovies")
	@ResponseBody
	public ModelAndView loadMovies(Map<String, Object> map) {

		String ptype01 = "" + ptype;
		List<Movie> objs=movieService.findAll();
		ModelAndView mv = new ModelAndView("/admin/movie/movie_list");
		map.put("objs", objs);
		return mv;

	}
	
	
	
	
	// ===================综合专区=================================
	/**
	 * 综合专区清单页面加载 作者：王宣武
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/moviezh/loadmovies")
	@ResponseBody
	public ModelAndView loadMovieszh(Map<String, Object> map) {

		String ptype01 = "" + ptypezh;
		//List<Program> objs = programService.findByType(ptype01);
		ModelAndView mv = new ModelAndView("/admin/moviezh/moviezh_list");
		//map.put("objs", objs);
		return mv;

	}
}
