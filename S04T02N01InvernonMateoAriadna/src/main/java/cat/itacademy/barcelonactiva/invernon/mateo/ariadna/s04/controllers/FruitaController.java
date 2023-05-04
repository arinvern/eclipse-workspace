package cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s04.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s04.model.domain.Fruita;
import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s04.model.services.FruitaService;

@RestController
public class FruitaController {
	
	
	@Autowired
	private FruitaService fruitaService;
	
	@GetMapping("/fruita/getAll")
	public List<Fruita> getAll() {
		return fruitaService.getAll();
	}

	@PostMapping("/fruita/add") // create
	public Fruita add(@RequestBody Fruita fruita) {
		return fruitaService.create(fruita);
	}

	@DeleteMapping("/fruita/delete/{id}") // delete
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		fruitaService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/fruita/update/{id}")
	public ResponseEntity<Void> update(@RequestBody Fruita fruita, @PathVariable("id") int id) {
		boolean updated = fruitaService.update(fruita, id);
		if (!updated) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/fruita/getOne/{id}")
	public ResponseEntity<Fruita> getFruitaById(@PathVariable("id") int id) {

		Optional<Fruita> fruitaData = fruitaService.findById(id);

		if (fruitaData.isPresent()) {
			return new ResponseEntity<>(fruitaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}