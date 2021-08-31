/*
* Copyright 
* Aos Jul 11, 2021
* Autor(Edilson Alexandre Cuamba)
* Thunder Mozambique
* 2021
* User(Edilson A. Cuamba)
*/

package model.owner_phone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class OwnerPhone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7932027606981529549L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ElementCollection
	@CollectionTable(name="owner_phone", joinColumns=@JoinColumn(name="owner_id"))
	@Column(name="phone_number", length=250)
	 private List<String> contacts = new ArrayList<String>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getContacts() {
		return contacts;
	}

	public void setContacts(List<String> contacts) {
		this.contacts = contacts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
