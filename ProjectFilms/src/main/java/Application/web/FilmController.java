package Application.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Application.domain.Film;
import Application.domain.FilmRepository;
import Application.domain.GenreRepository;





@Controller
public class FilmController {
	@Autowired
	private FilmRepository repository;
	
	@Autowired
	private GenreRepository grepository; 
	
	@RequestMapping(value="/filmlist")
    public String FilmList(Model model) {	
		
        model.addAttribute("films", repository.findAll());
        return "filmlist";
    }
	
	  
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	// RESTful service to get all films
    @RequestMapping(value="/films", method = RequestMethod.GET)
    public @ResponseBody List<Film> FilmListRest() {	
        return (List<Film>) repository.findAll();
    }    

	// RESTful service to get film by id
    @RequestMapping(value="/film/{id}", method = RequestMethod.GET)
    public @ResponseBody Film findFilmRest(@PathVariable("id") Long filmId) {	
    	return repository.findOne(filmId);
    }       
    
    // Add new film
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/add")
    public String addFilm(Model model){
    	model.addAttribute("film", new Film());
    	model.addAttribute("genres", grepository.findAll());
        return "addfilm";
    }     
    
    @RequestMapping(value = "/edit/{id}")
    public String editFilm(@PathVariable("id") Long filmId , Model model){
    	Film film = repository.findOne(filmId);
    	
    	model.addAttribute("film", film);
    	model.addAttribute("genres", grepository.findAll());
        return "editfilm";
    }     
    
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Film film){
        repository.save(film);
        return "redirect:filmlist";
    }    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteFilm(@PathVariable("id") Long filmId, Model model) {
    	repository.delete(filmId);
        return "redirect:../filmlist";
    }  

}
