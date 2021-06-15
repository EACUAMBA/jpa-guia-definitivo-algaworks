/*
 * Copyright (c) 2021.
 * Feito por Edilson Alexandre Cuamba aos 15/6/2021 9:5:47
 * Desenvolvedor Java | Spring & ZKoss | React JS & Native | UX & UI
 * (+258) 84 24 73 772 & (+258) 82 25 65 148
 * edilsoncuamba@gmail.com
 */

package start;

import model.Car;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;

public class startChapterThree {
    public static void main(String[] args) {
        verifyingFirstLevelCache();
        verifyDetachedObjects();
        verifyingAttachedObjects();
        verifyingAttachedObjectsAndFlushMethod();
        verifyingMergeMethodToAttacheObject();

        JpaUtil.close();
    }
    public static void verifyingMergeMethodToAttacheObject(){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        System.out.println("Verifying Merge Method With Detached Objects to Context JPA What Happen When We Call Merge After Change the Objects");
        Car car = entityManager.find(Car.class, 3L);
        System.out.println("Found car!\n" + car + "\nCalling commit to detach the object. Calling entityManager.close() to close jpa entity manager");

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Changing the object detached!");
        car.setId(null);
        car.setPrice(car.getPrice().add(BigDecimal.valueOf(5000.0)));

        System.out.println("Creating a new entity Manager and transaction.");
        EntityManager entityManagerNewOne = JpaUtil.getEntityManager();
        EntityTransaction entityTransactionNewOne = entityManagerNewOne.getTransaction();
        entityTransactionNewOne.begin();

        System.out.println("Using merge to attache the object. This will return new instance of car attached to the new context, if the car doesn't exist it will save it and return it!");
        Car carAttached = entityManagerNewOne.merge(car);

        System.out.println("Committing! After merge it!");
        entityTransactionNewOne.commit();
        entityManagerNewOne.close();

        System.out.println("Printing car now after all:\n" + carAttached);
    }
    public static void verifyingAttachedObjectsAndFlushMethod(){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        System.out.println("Verifying Attached Objects to Context JPA What Happen When We Call Flush After Change the Objects");
        Car car = entityManager.find(Car.class, 3L);
        System.out.println("Found car!\n" + car + "\nChanging the price!");
        car.setPrice(car.getPrice().add(BigDecimal.valueOf(5000.0)));

        System.out.println("Calling entityManager.flush() Method!");
        entityManager.flush();

        System.out.println("After changing the price:\n" + car + "\nYou saw it!\nCommitting the transaction.");

        System.out.println("Committing!");
        entityTransaction.commit();
        entityManager.close();
    }
    public static void verifyingAttachedObjects(){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        System.out.println("Verifying Attached Objects to Context JPA What Happen When We Commit After Change the Objects");
        Car car = entityManager.find(Car.class, 3L);
        System.out.println("Found car!\n" + car + "\nChanging the price!");
        car.setPrice(car.getPrice().add(BigDecimal.valueOf(5000.0)));

        System.out.println("After changing the price:\n" + car + "\nYou saw it!\nCommitting the transaction.");

        entityTransaction.commit();
        entityManager.close();
    }
    public static  void verifyDetachedObjects(){
        EntityManager entityManager = JpaUtil.getEntityManager();

        System.out.println("Verifying Detach Method and Contains!");
        Car car = entityManager.find(Car.class, 5L);
        System.out.println("Does in our context we have this car obtained now? " + entityManager.contains(car));

        entityManager.detach(car);
        System.out.println("We detached the object now, Will in our context have this object? " + entityManager.contains(car));

        Car carTwo = entityManager.find(Car.class, 5L);
        System.out.println("I got the same object/row/register in the database using the .find(Class, id) method,\n will be the same instance as the first car that we detached before? " + (car == carTwo));

        entityManager.close();
    }
    public static void verifyingFirstLevelCache(){
        EntityManager entityManager = JpaUtil.getEntityManager();

        System.out.println("Verifying First Level Cache!");

         Car car = entityManager.find(Car.class, 2L);
        System.out.println("Getting data for the first time!" + car);

        Car carTwo = entityManager.find(Car.class, 2L);
        System.out.println("Getting data for the second time!" + carTwo);

        System.out.println("Does car equal to carTwo = " + (car == carTwo));

        entityManager.close();
    }
}
