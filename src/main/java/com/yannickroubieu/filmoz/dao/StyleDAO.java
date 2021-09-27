package com.yannickroubieu.filmoz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yannickroubieu.filmoz.bean.Style;

public interface StyleDAO extends JpaRepository<Style, Integer> {

	List<Style> findByOrderByIdAsc();
	List<Style> findByOrderByIdDesc();
	List<Style> findByOrderByLibelleAsc();
	List<Style> findByOrderByLibelleDesc();
}
