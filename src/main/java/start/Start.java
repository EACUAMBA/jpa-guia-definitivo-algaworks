package start;

import model.Car;
import org.hibernate.Transaction;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import util.JpaUtil;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Start {
    private static final EntityManager entityManager = JpaUtil.getEntityManager();
    public static void main(String[] args) {
        Car car = new Car();
        car.setManufacturer("Honda");
        car.setModel("Civic");
        car.setYearManufactured(2005);
        car.setYearModel(2004);
        car.setPrice(BigDecimal.valueOf(70_000));

        insertCar(car);
        findAllUsingJPQL();
        findCarById(3L);
        gettingReferencedCarById(6L);
        updatingCar();
        deleteCar(7L);
        findAllUsingJPQL();

        entityManager.close();
        JpaUtil.close();
    }

public static void deleteCar(Long id){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Car car = entityManager.find(Car.class, id);
        entityManager.remove(car);

        entityTransaction.commit();
}
    public static void updatingCar(){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Car car = entityManager.find(Car.class, 5L);

        System.out.printf("%s%n", car.getModel());
        car.setModel(car.getModel() + " Updated");
        System.out.printf("%s%n", car.getModel());

        entityTransaction.commit();
    }
    public static void findAllUsingJPQL(){
        Query query = entityManager.createQuery("SELECT car FROM Car car");
        List<Car> carList = query.getResultList();

        for (Car car : carList){
            System.out.printf("%n%s%n", "Printing car " + car.getId());
            System.out.printf("%s%s%s%s%s%s%s%s%n", "Car model ", car.getModel(), ", manufactured by ", car.getManufacturer(), " in ", String.format("%d/%d", car.getYearModel(), car.getYearManufactured()), ", with price starts at ", NumberFormat.getCurrencyInstance(new Locale("pt", "MZ")).format(car.getPrice()));
        }
    }

    public static void gettingReferencedCarById(Long id){
        Car car = entityManager.getReference(Car.class, id);
        System.out.printf("%s%n", "Have the getReference method perform the SELECT? I just call getReference now.");
        System.out.printf("%s%d%s%s%n", "We found a car using getReference method with the id = ", car.getId(), ", the model is ", car.getModel() + ".");

    }
    public static void findCarById(Long id){
        Car car = entityManager.find(Car.class, id);
        System.out.printf("%s%d%s%s%n", "We found a car using the id = ", car.getId(), ", the model is ", car.getModel() + ".");

    }
    public static void insertCar(Car car){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(car);
        entityTransaction.commit();
    }
}
