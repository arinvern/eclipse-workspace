package cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s04.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s04.model.domain.Fruita;

@Repository
public interface FruitaRepository extends JpaRepository<Fruita, Integer> {
}