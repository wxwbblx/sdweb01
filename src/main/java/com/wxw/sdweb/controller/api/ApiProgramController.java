package com.wxw.sdweb.controller.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wxw.sdweb.Result;
import com.wxw.sdweb.enums.ResultCode;
import com.wxw.sdweb.service.IMovieService;
import com.wxw.sdweb.service.IProgramService;
import com.wxw.sdweb.service.IVideoinforService;
import com.wxw.sdweb.util.ResultUtils;
import com.wxw.sdweb.vo.Movie;
import com.wxw.sdweb.vo.Program;
import com.wxw.sdweb.vo.Videoinfor;

@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ApiProgramController {
	@Autowired
	private IProgramService programService;
	@Autowired
	private IMovieService movieService;
	@Autowired
	private IVideoinforService videoinforService;

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/api/v1/programs/getnew", method = RequestMethod.GET)
	public Result objslist() {
		String ptype = "1";
		int isnew = 1;
		System.out.println("ApiProgramController ptype=" + ptype);
		List<Program> objs = programService.findByNew(ptype, isnew);
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/api/v1/programszh/getnew", method = RequestMethod.GET)
	public Result objszhlist() {
		String ptype = "2";
		int isnew = 1;
		List<Program> objs = programService.findByNew(ptype, isnew);
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/api/v1/movie/getall", method = RequestMethod.GET)
	public Result getCurrList() {
		String ptype = "3";
		List<Movie> objs = movieService.findByptype(ptype);
		for (int i = 0; i < objs.size(); i++) {
			List<Videoinfor> subobjs = videoinforService.findByVid(objs.get(i).getId());
			objs.get(i).setVideoinfor(subobjs);
		}
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/api/v1/movie/getnew", method = RequestMethod.GET)
	public Result getCurrNewList() {
		String ptype = "3";
		int isnew = 1;
		List<Movie> objs = movieService.findBynewptype(ptype, isnew);
		for (int i = 0; i < objs.size(); i++) {
			List<Videoinfor> subobjs = videoinforService.findByVid(objs.get(i).getId());
			objs.get(i).setVideoinfor(subobjs);
		}
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/api/v1/movie/gethot", method = RequestMethod.GET)
	public Result getCurrHotList() {
		String ptype = "3";
		int ishot = 1;
		List<Movie> objs = movieService.findByhotptype(ptype, ishot);
		for (int i = 0; i < objs.size(); i++) {
			List<Videoinfor> subobjs = videoinforService.findByVid(objs.get(i).getId());
			objs.get(i).setVideoinfor(subobjs);
		}
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/api/v1/movie/getnominate", method = RequestMethod.GET)
	public Result getCurrNominateList() {
		String ptype = "3";
		int isnominate = 1;
		List<Movie> objs = movieService.findBynominateptype(ptype, isnominate);
		for (int i = 0; i < objs.size(); i++) {
			List<Videoinfor> subobjs = videoinforService.findByVid(objs.get(i).getId());
			objs.get(i).setVideoinfor(subobjs);
		}
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/api/v1/moviezh/getall", method = RequestMethod.GET)
	public Result getCurrzhList() {
		String ptype = "4";
		List<Movie> objs = movieService.findByptype(ptype);
		for (int i = 0; i < objs.size(); i++) {
			List<Videoinfor> subobjs = videoinforService.findByVid(objs.get(i).getId());
			objs.get(i).setVideoinfor(subobjs);
		}
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/api/v1/moviezh/getnew", method = RequestMethod.GET)
	public Result getCurrzhNewList() {
		String ptype = "4";
		int isnew = 1;
		List<Movie> objs = movieService.findBynewptype(ptype, isnew);
		for (int i = 0; i < objs.size(); i++) {
			List<Videoinfor> subobjs = videoinforService.findByVid(objs.get(i).getId());
			objs.get(i).setVideoinfor(subobjs);
		}
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/api/v1/moviezh/gethot", method = RequestMethod.GET)
	public Result getCurrzhHotList() {
		String ptype = "4";
		int ishot = 1;
		List<Movie> objs = movieService.findByhotptype(ptype, ishot);
		for (int i = 0; i < objs.size(); i++) {
			List<Videoinfor> subobjs = videoinforService.findByVid(objs.get(i).getId());
			objs.get(i).setVideoinfor(subobjs);
		}
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/api/v1/moviezh/getnominate", method = RequestMethod.GET)
	public Result getCurrzhNominateList() {
		String ptype = "4";
		int isnominate = 1;
		List<Movie> objs = movieService.findBynominateptype(ptype, isnominate);
		for (int i = 0; i < objs.size(); i++) {
			List<Videoinfor> subobjs = videoinforService.findByVid(objs.get(i).getId());
			objs.get(i).setVideoinfor(subobjs);
		}
		if (null != objs) {
			return ResultUtils.success(objs);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/api/v1/movie/getById/{id}", method = RequestMethod.GET)
	public Result getCurrById(@PathVariable("id") int id) {

		Movie obj = movieService.findById(id);
		System.out.println("getCurrById"+obj.getId());

		List<Videoinfor> subobjs = videoinforService.findByVid(obj.getId());
		obj.setVideoinfor(subobjs);

		if (null != obj) {
			return ResultUtils.success(obj);
		} else {
			return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
		}
	}

	/*
	 * @SuppressWarnings("rawtypes")
	 * 
	 * @RequestMapping(value = "/api/v1/programs/getcurrlist", method =
	 * RequestMethod.GET) public Result getCurrList() { String pdate = new
	 * java.sql.Date(new Date().getTime()).toString(); List<Program> objs =
	 * programService.findByDate(pdate); if (null != objs) { return
	 * ResultUtils.success(objs); } else { return
	 * ResultUtils.warn(ResultCode.PARAMETER_ERROR); } }
	 * 
	 * @SuppressWarnings("rawtypes")
	 * 
	 * @RequestMapping(value = "/api/v1/programs/getdate/{pdate}", method =
	 * RequestMethod.GET) public Result objslist(@PathVariable("pdate") String
	 * pdate) { List<Program> objs = programService.findByDate(pdate); if (null !=
	 * objs) { return ResultUtils.success(objs); } else { return
	 * ResultUtils.warn(ResultCode.PARAMETER_ERROR); } }
	 * 
	 * @SuppressWarnings("rawtypes")
	 * 
	 * @RequestMapping(value = "/api/v1/programs/getnew", method =
	 * RequestMethod.GET) public Result objsnewlist() { List<Program> objs =
	 * programService.findByIsnew(1); if (null != objs) { return
	 * ResultUtils.success(objs); } else { return
	 * ResultUtils.warn(ResultCode.PARAMETER_ERROR); } }
	 * 
	 * @SuppressWarnings("rawtypes")
	 * 
	 * @RequestMapping(value = "/api/v1/programs/getnew/{isnew}", method =
	 * RequestMethod.GET) public Result objsnewlist(@PathVariable("isnew") int
	 * isnew) { List<Program> objs = programService.findByIsnew(isnew); if (null !=
	 * objs) { return ResultUtils.success(objs); } else { return
	 * ResultUtils.warn(ResultCode.PARAMETER_ERROR); } }
	 */
}
