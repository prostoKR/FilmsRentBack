package lt.vtmc.restapi.controller;
import java.util.List;

//import javax.validation.Valid;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.vtmc.restapi.model.Film;
import lt.vtmc.restapi.model.Producer;
import lt.vtmc.restapi.payload.FilmRequest;
import lt.vtmc.restapi.repository.FilmRepository;
import lt.vtmc.restapi.repository.ProducerRepository;
	
	@CrossOrigin("*")
	@RestController
	@RequestMapping("/films")
public class FilmController extends ProducerController {
	

		@Autowired
		private FilmRepository filmRepo;
		
//		@Autowired
//		private ProducerRepository producerRepo;
	 
		@GetMapping
		public List<Film> getFilm() {
			return filmRepo.findAll();

		}

		@GetMapping("/{id}")
		public Film getFilm(@PathVariable Long id) {
			return filmRepo.findById(id).get();
		}

		@PostMapping
		public Film postFilm(@RequestBody FilmRequest filmRequest) {
			Film film = new Film();
			film.setTitle(filmRequest.getTitle());
			film.setStoryline(filmRequest.getStoryline());
			Producer producer = producerRepo.findProducerByName(filmRequest.getProducerName()).orElseThrow();
			film.setProducer(producer);
			return filmRepo.save(film);
		}

		@DeleteMapping("/{id}")
		
		public void deleteFilm(@PathVariable Long id) {
			filmRepo.deleteById(id);
		}
		
//		ResponseEntity
		@PutMapping("/{id}")
		public ResponseEntity<Film> updateFilms(@PathVariable Long id, @RequestBody Film filmDetails) {
			Film film = filmRepo.findById(id).orElseThrow() ;
			
			film.setTitle(filmDetails.getTitle());
			film.setStoryline(filmDetails.getStoryline());
			film.setProducer(filmDetails.getProducer());
			final Film updatedFilm = filmRepo.save(film);
	        return ResponseEntity.ok(updatedFilm);
		}
	}

