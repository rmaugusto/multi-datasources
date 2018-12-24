package br.com.spring.planet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository  extends JpaRepository<Planet, Long> {

}
