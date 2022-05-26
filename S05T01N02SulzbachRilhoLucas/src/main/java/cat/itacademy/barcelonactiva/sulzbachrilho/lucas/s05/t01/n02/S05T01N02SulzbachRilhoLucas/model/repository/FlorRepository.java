package cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.repository;

import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.domain.FlorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepository extends JpaRepository <FlorEntity, Integer> {
}
