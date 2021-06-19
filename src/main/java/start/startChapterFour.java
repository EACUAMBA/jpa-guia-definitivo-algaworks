package start;

import model.Car;
import model.CarId;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;

public class startChapterFour {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        savingData(entityManager);
        fetchingData(entityManager);
        entityManager.close();
        JpaUtil.close();
    }

    public static void fetchingData(EntityManager entityManager){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        CarId carId = new CarId("Niassa", "270-03");
        Car car = entityManager.find(Car.class, carId);

        System.out.printf("%n%s%n%s%s%n%s%s%n%s%s%n%s%s%n", "Fetching Car By CarId Class", "Car plate: ", car.getCarId().getMatricula(), "Province: ", car.getCarId().getProvincia(), "Manufacturer: ", car.getManufacturer(), "Model: ", car.getModel());

        entityTransaction.commit();
    }

    public static void savingData(EntityManager entityManager){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        System.out.println("\nSaving Car");
        Car car = new Car();
        car.setCarId(new CarId("Maputo", "424-32"));
        car.setManufacturer("Nissan");
        car.setModel("Navara");
        car.setPrice(BigDecimal.valueOf(125_000D));
        car.setYearModel(2009);
        car.setYearManufactured(2012);

        entityManager.persist(car);

        entityTransaction.commit();
    }
}
