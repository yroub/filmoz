package com.yannickroubieu.filmoz.service;

import java.util.List;

import com.yannickroubieu.filmoz.bean.Style;
import com.yannickroubieu.filmoz.dao.StyleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class GestionStyle {

	@Autowired
	StyleDAO dao;
	
	public List<Style> listeStyles(){
		return dao.findAll();
	}
	
	
	public Style trouverStyle(int i){
		return dao.getById(i);
	}

	public void ajoutStyle(Style s){
		dao.save(s);
	}
	
	public void modifierStyle(Style s){
		dao.save(s);
	}
	
	public void supprimerStyle(Style s){
		dao.delete(s);
	}
	
	public List<Style> trier(String type){
		List<Style> liste = null;
		switch (type){
		case "iA" : liste = dao.findByOrderByIdAsc(); break;
		case "iD" : liste = dao.findByOrderByIdDesc(); break;
		case "lA" : liste = dao.findByOrderByLibelleAsc(); break;
		case "lD" : liste = dao.findByOrderByLibelleDesc(); break;
		default : liste = dao.findAll();
		}
		return liste;
	}
	
}
