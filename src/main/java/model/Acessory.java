/*
* Copyright 
* Aos Jul 10, 2021
* Autor(Edilson Alexandre Cuamba)
* Thunder Mozambique
* 2021
* User(Edilson A. Cuamba)
*/

package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tab_acessory")
public class Acessory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@ManyToMany(mappedBy = "acessories")
	private Set<Car> cars;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
