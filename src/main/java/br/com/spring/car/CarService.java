package br.com.spring.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepo;

	@Transactional("tm2")
	public Car save(Car p) {
		return carRepo.save(p);
	}

}
