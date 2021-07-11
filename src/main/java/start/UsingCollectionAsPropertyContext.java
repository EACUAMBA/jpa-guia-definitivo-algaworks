/*
* Copyright 
* Aos Jul 11, 2021
* Autor(Edilson Alexandre Cuamba)
* Thunder Mozambique
* 2021
* User(Edilson A. Cuamba)
*/

package start;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.owner_phone.OwnerPhone;
import util.JpaUtil;

public class UsingCollectionAsPropertyContext {
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		entityManager = JpaUtil.getEntityManager();
		save();
		read();
		
		entityManager.close();
		JpaUtil.close();
	}
	
	private static void read() {
		System.out.print("\nImprimindo telefones de ");
		OwnerPhone ownerPhone = entityManager.find(OwnerPhone.class, 31L);
		System.out.println(ownerPhone.getName());
		for (String phone : ownerPhone.getContacts()) {
			System.out.println("Phone: " + phone);
		}
		
	}

	private static void save() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		OwnerPhone ownerPhone = new OwnerPhone();
		ownerPhone.setName("Luisão");
		ownerPhone.getContacts().add("123456789");
		ownerPhone.getContacts().add("12422123456712121289");
		ownerPhone.getContacts().add("123123123123000123");
		ownerPhone.getContacts().add("987654");
		ownerPhone.getContacts().add("1234531234");
		
		OwnerPhone ownerPhone2 = new OwnerPhone();
		ownerPhone2.setName("Zuca");
		ownerPhone2.getContacts().add("123");
		
		OwnerPhone ownerPhone3 = new OwnerPhone();
		ownerPhone3.setName("Polito");
		ownerPhone3.getContacts().add("123456712121289");
		
		entityManager.persist(ownerPhone);
		entityManager.persist(ownerPhone2);
		entityManager.persist(ownerPhone3);
		
		entityTransaction.commit();
		
		entityManager.detach(ownerPhone);
		entityManager.detach(ownerPhone2);
		entityManager.detach(ownerPhone3);
	}
	
}
