package br.com.spring.planet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlanetService {

	@Autowired
	private PlanetRepository planetRepo;

	@Transactional("tm1")
	public Planet save(Planet p) {
		return planetRepo.save(p);
	}

}
