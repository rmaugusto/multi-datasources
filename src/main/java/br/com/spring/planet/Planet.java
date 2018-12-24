package br.com.spring.planet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double mass;
	private Double volume;
	
	public Long getId() {
		return id;
	}
	public Double getMass() {
		return mass;
	}
	public Double getVolume() {
		return volume;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMass(Double mass) {
		this.mass = mass;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
