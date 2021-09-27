package com.yannickroubieu.filmoz.dao;

import java.util.List;

import com.yannickroubieu.filmoz.bean.Film;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmDAO extends JpaRepository<Film, Integer> {

	List<Film> findByOrderByTitreAsc();
	List<Film> findByOrderByTitreDesc();
	List<Film> findByOrderByAnneeAsc();
	List<Film> findByOrderByAnneeDesc();
	List<Film> findByOrderByStyleLibelleAsc();
	List<Film> findByOrderByStyleLibelleDesc();
	List<Film> findByOrderByRealAsc();
	List<Film> findByOrderByRealDesc();
	List<Film> findByOrderByDureeAsc();
	List<Film> findByOrderByDureeDesc();
	List<Film> findByOrderByVuAsc();
	List<Film> findByOrderByVuDesc();
}
