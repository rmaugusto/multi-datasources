package br.com.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.spring.car.Car;
import br.com.spring.car.CarService;
import br.com.spring.planet.Planet;
import br.com.spring.planet.PlanetService;

@SpringBootApplication
public class MainApp implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PlanetService ps;

	@Autowired
	CarService cs;
	
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		Planet p = new Planet();
		p.setName("Mars");
		p.setMass(6.4169d);
		ps.save(p);
		
		Car c = new Car();
		c.setName("Golf");
		c.setManufacturer("Volkswagen");
		cs.save(c);
		
		
//		logger.info("Student id 10001 -> {}", repository.findById(10001L));
	}
}