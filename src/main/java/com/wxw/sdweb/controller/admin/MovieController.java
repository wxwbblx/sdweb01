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

import com.wxw.sdweb.service.IMenuService;
import com.wxw.sdweb.service.IMovieService;
import com.wxw.sdweb.service.IVideoinforService;
import com.wxw.sdweb.util.MyTools;
import com.wxw.sdweb.vo.Menu;
import com.wxw.sdweb.vo.Movie;
import com.wxw.sdweb.vo.Program;
import com.wxw.sdweb.vo.Videoinfor;

@Controller
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MovieController {

	@Autowired
	private IMovieService movieService;

	@Autowired
	private IMenuService menuService;
	@Autowired
	private IVideoinforService  videoinforService;
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
		List<Movie> objs = movieService.findAll();
		ModelAndView mv = new ModelAndView("/admin/movie/movie_list");
		map.put("objs", objs);
		return mv;

	}

	/**
	 * 节目清单添加页面加载 作者：王宣武
	 * 
	 */
	@RequestMapping(value = "/admin/movie/movie_add_load")
	@ResponseBody
	public ModelAndView loadMovieAdd(Map<String, Object> map) {
		Menu obj = menuService.findById(ptype);
		ModelAndView mv = new ModelAndView("/admin/movie/movie_add");
		map.put("obj", obj);
		return mv;
	}

	/**
	 * 功能：节目清单数据提交 作者：王宣武
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/admin/movie/movie_add", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView MovieAdd(Map<String, Object> map, @RequestParam("vname") String vname,
			@RequestParam("vtype") String vtype, @RequestParam("ptype") String ptype, @RequestParam("vtime") int vtime,
			@RequestParam("releasetime") String releasetime, @RequestParam("region") String region,
			@RequestParam("director") String director, @RequestParam("tostar") String tostar,
			@RequestParam("synopsis") String synopsis, @RequestParam("isnew") int isnew,
			@RequestParam("ishot") int ishot, @RequestParam("isnominate") int isnominate,
			@RequestParam("sylloge") int sylloge, @RequestParam("updatetext") int updatetext,
			@RequestParam("remark") String remark, @RequestParam("file") MultipartFile file,
			HttpServletRequest request) {
		String vurl = "www.163.com"; // @RequestParam("vurl") String vurl,

		String furl = MyTools.uploadFile(file, request);
		Movie movie = new Movie();
		movie.setVname(vname);
		movie.setVtype(vtype);
		movie.setPtype(ptype);
		movie.setVtime(vtime);
		movie.setReleasetime(releasetime);
		movie.setRegion(region);
		movie.setDirector(director);
		movie.setTostar(tostar);
		movie.setSynopsis(synopsis);
		movie.setPoster(furl);
		movie.setVurl(vurl);
		movie.setIshot(ishot);
		movie.setIsnew(isnew);
		movie.setIsnominate(isnominate);
		movie.setSylloge(sylloge);
		movie.setUpdatetext(updatetext);
		movie.setRemark(remark);

		// System.out.println(movie);
		// ============================================
		int rows = movieService.insert(movie);
		ModelAndView mv = null;
		if (rows == 0) {
			mv = new ModelAndView("/admin/video/program_add");
		} else {
			mv = new ModelAndView("redirect:/admin/movie/loadmovies");
		}
		return mv;

	}
	
  //	
	 /* 节目清单添加页面加载 作者：王宣武
	 * 
	 */
	@RequestMapping(value = "/admin/movie/movie_update_load")
	@ResponseBody
	public ModelAndView loadMovieUpdate(Map<String, Object> map) {
		Menu obj = menuService.findById(ptype);
		ModelAndView mv = new ModelAndView("/admin/movie/movie_update");
		map.put("obj", obj);
		return mv;
	}

	/**
	 * 节目清单添加页面加载 作者：王宣武
	 * 
	 */
	@RequestMapping(value = "/admin/movie/movie_del", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView movieDel(Map<String, Object> map, @RequestParam("id") int id) {
		movieService.delete(id);
		ModelAndView mv = null;
		mv = new ModelAndView("redirect:/admin/movie/loadmovies");
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
		// List<Program> objs = programService.findByType(ptype01);
		ModelAndView mv = new ModelAndView("/admin/moviezh/moviezh_list");
		// map.put("objs", objs);
		return mv;

	}
	
	// ===================视频详细信息=================================
	
	/**
	 * 综合专区清单页面加载 作者：王宣武
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/video/loadvideo", method = RequestMethod.GET )
	@ResponseBody
	public ModelAndView loadVideo(Map<String, Object> map,@RequestParam("id") int id) {

		
		 List<Videoinfor> objs = videoinforService.findByVid(id);		 
		ModelAndView mv = new ModelAndView("/admin/movie/videoinfor");
		 map.put("objs", objs);
		return mv;

	}
	
	
	
	
}
