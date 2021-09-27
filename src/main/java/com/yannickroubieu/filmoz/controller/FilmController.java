package com.yannickroubieu.filmoz.controller;

import com.yannickroubieu.filmoz.bean.Film;
import com.yannickroubieu.filmoz.bean.Style;
import com.yannickroubieu.filmoz.service.GestionFilm;
import com.yannickroubieu.filmoz.service.GestionStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@Controller
// @RequestMapping(path="/app")
public class FilmController {

	@Autowired
	GestionFilm gf;
	@Autowired
	GestionStyle gs;

	@PostConstruct
	private void init() {
	}

	@RequestMapping(path = "/lister", method = RequestMethod.GET)
	public ModelAndView afficherFilms() {
		List<Film> listeF = gf.listeFilms();
		return new ModelAndView("listeFilms", "listeF", listeF);
	}

	@RequestMapping(value = "/trier", method = RequestMethod.GET)
	public ModelAndView trierFilm(String par) {
		List<Film> listeF = gf.trier(par);
		return new ModelAndView("listeFilms", "listeF", listeF);
	}

	@RequestMapping(value = "/ajouter", method = RequestMethod.GET)
	public ModelAndView ajouterFilm() {
		Film f = new Film();
		ModelAndView mav = new ModelAndView("ajouterFilm", "film", f);
		List<Style> listeStyles = gs.listeStyles();
		mav.getModelMap().addAttribute("listeStyles", listeStyles);
		return mav;
	}

	@RequestMapping(value = "/ajouterValid", method = RequestMethod.POST)
	public ModelAndView ajoutFilmValid(@Valid Film film, BindingResult br, ModelMap model) {
		if (br.hasErrors()) {
			ModelAndView mv = new ModelAndView("ajouterFilm", br.getModel());
			return mv;
		} else {
			gf.ajoutFilm(film);
			return afficherFilms();
		}
	}

	@RequestMapping(value = "/supprimer", method = RequestMethod.GET)
	public ModelAndView supprimerFilm(String index) {
		int i = Integer.parseInt(index.substring(1));
		Film courant = gf.trouverFilm(i);
		gf.supprimerFilm(courant);

		return afficherFilms();
	}

	@RequestMapping(value = "/afficher", method = RequestMethod.GET)
	public ModelAndView afficher(Integer index) {
		Film film = null;
		if (index != null) {
			film = gf.trouverFilm(index);
			return new ModelAndView("afficherFilm", "film", film);
		} else
			return afficherFilms();
	}

	@RequestMapping(value = "/editer", method = RequestMethod.GET)
	public ModelAndView editerFilm(String index) {
		int i = Integer.parseInt(index.substring(1));
		ModelAndView mav = new ModelAndView("editerFilm", "film", gf.trouverFilm(i));
		List<Style> listeStyles = gs.listeStyles();
		mav.getModelMap().addAttribute("listeStyles", listeStyles);
		return mav;
	}

	@RequestMapping(value = "/editerValid", method = RequestMethod.POST)
	public ModelAndView listeBouteilleValid(Film f) {
		// System.out.println(f);
		gf.modifierFilm(f);
		return afficherFilms();
	}

}
