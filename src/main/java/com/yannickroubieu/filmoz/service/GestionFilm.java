package com.yannickroubieu.filmoz.service;

import java.util.List;

import com.yannickroubieu.filmoz.bean.Film;
import com.yannickroubieu.filmoz.dao.FilmDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionFilm {

	@Autowired
	FilmDAO dao;
	
	public List<Film> listeFilms(){
		return dao.findAll();
	}
	
	public Film trouverFilm(int i){
		return dao.getById(i);
	}
	
	
	public void ajoutFilm(Film f){
		dao.save(f);
	}
	
	public void modifierFilm(Film f){
//		Film film = dao.getById(f.getId());
//		film.setActeurs(f.getActeurs());
//		film.setAnnee(f.getAnnee());
//		film.setDuree(f.getDuree());
//		film.setReal(f.getReal());
//		film.setStyle(f.getStyle());
//		film.setSynopsis(f.getSynopsis());
//		film.setTitre(f.getTitre());
//		film.setVu(f.isVu());
//		dao.save(film);
		dao.save(f);
	}
	
	public void supprimerFilm(Film f){
		dao.delete(f);
	}

	public List<Film> trier(String par) {
		List<Film> liste = null;
		
		switch (par) {
		case "tA": liste = dao.findByOrderByTitreAsc(); break;
		case "tD": liste = dao.findByOrderByTitreDesc(); break;
		case "aA": liste = dao.findByOrderByAnneeAsc(); break;
		case "aD": liste = dao.findByOrderByAnneeDesc(); break;
		case "sA": liste = dao.findByOrderByStyleLibelleAsc(); break;
		case "sD": liste = dao.findByOrderByStyleLibelleDesc(); break;
		case "rA": liste = dao.findByOrderByRealAsc(); break;
		case "rD": liste = dao.findByOrderByRealDesc(); break;
		case "dA": liste = dao.findByOrderByDureeAsc(); break;
		case "dD": liste = dao.findByOrderByDureeDesc(); break;
		case "vA": liste = dao.findByOrderByVuAsc(); break;
		case "vD": liste = dao.findByOrderByVuDesc(); break;
		default : liste = dao.findAll();

		}
		
		return liste;
	}
	
	
	
}
