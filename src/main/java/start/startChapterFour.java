package start;

import model.Car;
import model.CarId;
import model.FuelType;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;

public class startChapterFour {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        savingData(entityManager);
        fetchingData(entityManager);
        savingWithEnumType(entityManager);

        entityManager.close();
        JpaUtil.close();
    }

    public static void savingWithEnumType(EntityManager entityManager){
        System.out.println("\nSaving with Enum type...");
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Car car = new Car();
        CarId carId = new CarId("Gaza", "987-35");
        car.setCarId(carId);
        car.setManufacturer("Isuzo");
        car.setModel("Dmax");
        car.setYearModel(2021);
        car.setYearManufactured(2021);
        car.setFuelType(FuelType.Alcohol);
        car.setPrice(BigDecimal.valueOf(230_000D));
        entityManager.persist(car);

        entityTransaction.commit();
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
