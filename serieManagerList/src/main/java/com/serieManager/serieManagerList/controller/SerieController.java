package com.serieManager.serieManagerList.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serieManager.serieManagerList.app.Serie;
import com.serieManager.serieManagerList.app.SerieRepository;
import com.serieManager.serieManagerList.exception.SerieNotFoundException;

@RestController
@RequestMapping("/series")
class SerieController {

	private final SerieRepository repository;

	SerieController(SerieRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@GetMapping
	List<Serie> all() {
		return repository.findAll();
	}

	@PostMapping
	Serie newSerie(@RequestBody Serie newSerie) {
		return repository.save(newSerie);
	}

	// Single item

	@GetMapping("/{id}")
	Serie one(@PathVariable Long id) {

		return repository.findById(id)
			.orElseThrow(() -> new SerieNotFoundException(id));
	}

	@PutMapping("/{id}")
	Serie replaceSerie(@RequestBody Serie newSerie, @PathVariable Long id) {

		return repository.findById(id)
			.map(serie -> {
				serie.setNom(newSerie.getNom());
				serie.setNumero(newSerie.getNumero());
				serie.setActeurPrincipalSerie(newSerie.getActeurPrincipalSerie());
				serie.setVoOuNon(newSerie.getVoOuNon());
				return repository.save(serie);
			})
			.orElseGet(() -> {
				newSerie.setId(id);
				return repository.save(newSerie);
			});
	}

	@DeleteMapping("/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@GetMapping(path = "/rechercher",params = {"nom"})
		public List<Serie> getSerie(@RequestParam String nom){
		return repository.findByNom(nom);
	}
}