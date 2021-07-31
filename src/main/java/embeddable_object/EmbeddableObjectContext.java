package embeddable_object;

import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EmbeddableObjectContext {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        saving(entityManager);
        findAndPrintingOwner(entityManager);

        entityManager.close();
        JpaUtil.close();
    }
    private static void saving(EntityManager entityManager){
        Owner edilson = new Owner();
        edilson.setName("Edilson Alexandre Cuamba");

        Phone edilsonPhone1 = new Phone("+258", "84", "2473772");
        Phone edilsonPhone2 = new Phone("+258", "82", "2565148");
        edilson.getPhoneList().add(edilsonPhone1);
        edilson.getPhoneList().add(edilsonPhone2);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(edilson);

        entityTransaction.commit();
    }

    private static void findAndPrintingOwner(EntityManager entityManager){
        Owner edilson = null;
        System.out.println("\nLooking for the owner...");
        edilson = entityManager.find(Owner.class, 1);
        System.out.println("The owner is " + edilson.getName());
        System.out.println("Printing their phone numbers:");
        for(Phone phone : edilson.getPhoneList())
        System.out.println("\t"+ phone.getCountryCode() + " " + phone.getOperatorCode() + " " + phone.getPhone());
        System.out.println("");

    }
}
