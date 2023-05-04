package cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s04.model.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s04.model.domain.Fruita;
import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s04.model.repository.FruitaRepository;

@Service
public class FruitaService {

	@Autowired
	private FruitaRepository fruitaRepository;

	public Fruita create(Fruita fruita) {
		return fruitaRepository.save(fruita);
	}

	public boolean delete(int id) {
		if (fruitaRepository.existsById(id)) {
			fruitaRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Optional<Fruita> findById(int id) {
		return fruitaRepository.findById(id);
	}

	public List<Fruita> getAll() {
		return fruitaRepository.findAll();
	}

	public boolean update(Fruita fruita, int id) {
		Optional<Fruita> fruitaData = fruitaRepository.findById(id);
		if (fruitaData.isPresent()) {
			Fruita existingFruita = fruitaData.get();
			existingFruita.setNom(fruita.getNom());
			existingFruita.setQuantitatQuilos(fruita.getQuantitatQuilos());
			fruitaRepository.save(existingFruita);
			return true;
		} else {
			return false;
		}
	}
}