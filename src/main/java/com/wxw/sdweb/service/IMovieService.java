package com.wxw.sdweb.service;

import java.util.List;

import com.wxw.sdweb.vo.Movie;


public interface IMovieService {

	Movie findById(int id);
	
	List<Movie> findByptype(String ptype);
	
	List<Movie> findAll();
	
	int delete(int id);

	int insert(Movie movie);

	int update(Movie movie);
	
}
