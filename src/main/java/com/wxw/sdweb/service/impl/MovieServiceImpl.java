package com.wxw.sdweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.wxw.sdweb.dao.MovieMapper;
import com.wxw.sdweb.service.IMovieService;
import com.wxw.sdweb.vo.Movie;

@ComponentScan({ "com.wxw.sdweb.mapper" })
@Service(value = "movieService")
public class MovieServiceImpl implements IMovieService {
     
	
	@Autowired
	private MovieMapper movieDao;
	
	
	@Override
	public List<Movie> findAll() {
		List<Movie> objs=movieDao.findAll();
		return objs;
	}

}
