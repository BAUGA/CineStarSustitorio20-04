package api.Cinestar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import api.Cinestar.model.Cine;
import api.Cinestar.model.CineList;
import api.Cinestar.model.CinePeliculaList;
import api.Cinestar.model.CineTarifaList;
import api.Cinestar.model.Pelicula;
import api.Cinestar.model.PeliculaList;
import api.Cinestar.repository.ICine;
import api.Cinestar.repository.ICineList;
import api.Cinestar.repository.ICinePeliculaList;
import api.Cinestar.repository.ICineTarifaList;
import api.Cinestar.repository.IPelicula;
import api.Cinestar.repository.IPeliculaList;

@Configuration
@CrossOrigin
@RestController
@RequestMapping

public class CinestarController extends WebMvcAutoConfiguration {
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}
	
	  @GetMapping("/index")
	    public String cine() {
		return "pelicula";
	     }

		@Autowired
		private IPeliculaList iPeliculaList;
		
		@Autowired
		private IPelicula iPelicula;
		
		@Autowired
		private ICine iCine;
		
		@Autowired
		private ICineList iCineList;
		
		@Autowired
		private ICineTarifaList ICineTarifaList;
		
		@Autowired
		private ICinePeliculaList ICinePeliculaList;
		

		
		
		@GetMapping("/peliculas/{idx}")
		public List<PeliculaList> getPeliculas(@PathVariable("idx")String idx){
			if (idx != null && (idx.equals("cartelera")|| idx.equals("estrenos")))
				return (List<PeliculaList>) iPeliculaList.getPeliculas(idx.equals("cartelera")? 1 : 2);
			return null;
		}
		
		
		@GetMapping("/pelicula/{id}")
		public Pelicula getPelicula(@PathVariable("id") int id ){
			return (Pelicula) iPelicula.getPelicula(id);
		}
		
		@GetMapping("/cines")
		public List<CineList>  getCines(){
			return (List<CineList>) iCineList.getCines();
		}
		
		@GetMapping("/cine/{id}")
		public Cine getCine(@PathVariable("id") int id ){
			return (Cine) iCine.getCine(id);
		}
		
		@GetMapping("/cine/{id}/tarifas")
		public List<CineTarifaList> getCineTarifaList(@PathVariable("id") int id){
			return (List<CineTarifaList>) ICineTarifaList.getCineTarifaList(id);
			
		}
		@GetMapping("/cine/{id}/peliculas")
		public List<CinePeliculaList> getCinePeliculaLists(@PathVariable("id") int id){
			return (List<CinePeliculaList>) ICinePeliculaList.getCinePeliculaList(id);
		}
}
