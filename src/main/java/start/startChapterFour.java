package start;

import model.*;
import util.JpaUtil;

import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class startChapterFour {
	public static void main(String[] args) throws IOException {
		EntityManager entityManager = JpaUtil.getEntityManager();
		savingData(entityManager);
		fetchingData(entityManager);
		savingWithEnumType(entityManager);
		Car car = savingwithLocalDate(entityManager);
		usingTransientAnnotation(entityManager, car);
		savingLargFilesWithLobAnnotation(entityManager);
		// savingImage(entityManager);
		// savingOwnersInfo(entityManager);
		savingWith_OneToOne_Relationship(entityManager);
		gettingInsuranceAndItsCars(entityManager); // Using bidirectional relationship
		savingWheelsWith_ManyToOne_Relationship(entityManager);
		manyToMany(entityManager);
		printingAcessoriesOfCar(entityManager);
		printingCarsOfAcessories(entityManager);

		entityManager.close();

		entityManager = JpaUtil.getEntityManager();
		gettingWheelsByHisCar(entityManager);

		entityManager.close();
		JpaUtil.close();
	}

	public static void printingCarsOfAcessories(EntityManager entityManager) {
		System.out.println("Printing Cars by its acessories!");

		Acessory acessory = new Acessory();
		acessory = entityManager.find(Acessory.class, 1L);

		for (Car car : acessory.getCars()) {
			System.out.printf("%n%s %s %s", "Dados do carro: ", car.getCarId().getProvincia(), car.getManufacturer());
		}
		System.out.println(acessory.getCars().getClass());
	}

	public static void printingAcessoriesOfCar(EntityManager entityManager) {
		System.out.println("Printing acessories by car.");
		Car car = entityManager.find(Car.class, new CarId("Zimbas", "197-092"));

		System.out.println("Acessorios do carro: " + car.getModel());
		for (Acessory acessory : car.getAcessories()) {
			System.out.printf("%n%s%s%n%s%s", "ID: ", acessory.getId(), "Nome: ", acessory.getDescription());
		}

		System.out.println(car.getAcessories().getClass());
	}

	public static void manyToMany(EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Acessory mp3 = new Acessory();
		mp3.setDescription("DVD 2021 Bluetooth");

		Acessory amplificador = new Acessory();
		amplificador.setDescription("Amplificador Piooner");

		Acessory almofadas = new Acessory();
		almofadas.setDescription("Almofadas de banco");

		Acessory papel = new Acessory();
		papel.setDescription("Papel higienico");

		entityManager.persist(papel);
		entityManager.persist(almofadas);
		entityManager.persist(amplificador);
		entityManager.persist(mp3);

		CarId carIdBaira = new CarId("Baira", "650-05");
		Car carBaira = entityManager.find(Car.class, carIdBaira);
		carBaira.getAcessories().add(papel);
		carBaira.getAcessories().add(mp3);
		carBaira.getAcessories().add(amplificador);

		CarId carIdNiassa = new CarId("Niassa", "270-03");
		Car carNiassa = entityManager.find(Car.class, carIdNiassa);
		carNiassa.getAcessories().add(papel);
		carNiassa.getAcessories().add(almofadas);

		CarId carId = new CarId("Zimbas", "197-092");
		Car car = new Car();
		car.setCarId(carId);
		car.setSubscriptionDate(LocalDate.now());
		car.setYearModel(1965);
		car.setManufacturer("Zort");
		car.setModel("Poert");
		car.setPrice(BigDecimal.valueOf(123_000_32.4D));
		car.setYearManufactured(2004);
		car.setFuelType(FuelType.Gas);
		car.getAcessories().add(papel);
		car.getAcessories().add(mp3);
		car.getAcessories().add(almofadas);
		car.getAcessories().add(amplificador);
		entityManager.persist(car);

		entityTransaction.commit();
		entityManager.detach(car);
		entityManager.detach(carBaira);
		entityManager.detach(carNiassa);
		entityManager.detach(papel);
		entityManager.detach(almofadas);
		entityManager.detach(amplificador);
		entityManager.detach(mp3);

	}

	public static void gettingWheelsByHisCar(EntityManager entityManager) {
		System.out.println("\n\n\n Getting wheels!");
		CarId carId = new CarId("Gaza", "750-01");

		Car car = entityManager.find(Car.class, carId);

		System.out.println(car.getCarId());
		System.out.println(car.getModel());
		System.out.println(car.getManufacturer());

		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(5));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(car.getWheelsList());

	}

	public static void savingWheelsWith_ManyToOne_Relationship(EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Wheels wheels = new Wheels();
		wheels.setManufacturer("BBS");
		wheels.setSize(10);
		wheels.setQuantity(4);

		CarId carId = new CarId("Gaza", "750-01");
		Car car = new Car();
		car.setCarId(carId);
		wheels.setCar(car);

		Wheels wheels2 = entityManager.find(Wheels.class, 1);
		wheels2.setCar(car);

		entityManager.persist(wheels);
		entityManager.persist(wheels2);
		entityTransaction.commit();

		// Muitas jantes podem pertencer a um e apenas um carro. Assim temo um carro que
		// que tem as duas jantes, BBS e BBSV#
	}

	public static void gettingInsuranceAndItsCars(EntityManager entityManager) {
		System.out.println("\n\nBidirectional Relationship!");
		InsuranceCar insuranceCar = entityManager.find(InsuranceCar.class, 1);
		System.out.printf("%s%nDetails: %s%nStart date: %s%nEnd Date: %s", insuranceCar.getCar().getCarId(),
				insuranceCar.getCar().getInsuranceCar().getDetails(),
				insuranceCar.getStartDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
				insuranceCar.getEndDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

	}

	public static void savingWith_OneToOne_Relationship(EntityManager entityManager) {
		System.out.println("\n Saving and getting car with insurance.\n");
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		InsuranceCar insuranceCar = new InsuranceCar();
		insuranceCar.setDetails("Car security for two years");
		insuranceCar.setStartDate(LocalDate.now());
		insuranceCar.setEndDate(LocalDate.now().plusYears(2));
		entityManager.persist(insuranceCar);

		CarId carId = new CarId("Tete", "197-09");
		Car car = new Car();
		car.setCarId(carId);
		car.setSubscriptionDate(LocalDate.now());
		car.setYearModel(1965);
		car.setManufacturer("Fabinco");
		car.setModel("FA12");
		car.setPrice(BigDecimal.valueOf(123_000_32.4D));
		car.setYearManufactured(2004);
		car.setFuelType(FuelType.Water);
		car.setInsuranceCar(insuranceCar);
		entityManager.persist(car);

		entityTransaction.commit();

		entityManager.detach(insuranceCar);
		entityManager.detach(car);

		System.out.println("\nPrinting Car with insurance!");

		List<Car> carList = entityManager.createQuery("select car from Car car", Car.class).getResultList();

		carList.stream()
				.forEach(carInsuranced -> System.out.printf("%s%nDetails: %s%nStart date: %s%nEnd Date: %s",
						carInsuranced.getCarId(),
						carInsuranced.getInsuranceCar() != null ? carInsuranced.getInsuranceCar().getDetails() : "",
						carInsuranced.getInsuranceCar() != null
								? car.getInsuranceCar().getStartDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
								: "",
						carInsuranced.getInsuranceCar() != null
								? car.getInsuranceCar().getEndDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
								: ""));
//        Car carInsuranced = entityManager.find(Car.class, carId);
//        System.out.printf("%s%nDetails: %s%nStart date: %s%nEnd Date: %s", carInsuranced.getCarId(), carInsuranced.getInsuranceCar().getDetails(), car.getInsuranceCar().getStartDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), car.getInsuranceCar().getEndDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		System.out.println("\n\nCars Printed\n");

	}

	public static void savingOwnersInfo(EntityManager entityManager) throws IOException {
		System.out.println("\nsaving Image after showing!");
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		System.out.println(System.getProperty("user.home"));

		Path pathImage = new File("photos/hammer.jpg").getAbsoluteFile().toPath();
		byte[] photo = Files.readAllBytes(pathImage);

		Owner owner = new Owner();
		owner.setName("Edilson");
		owner.setEmail("edilsoncuaba@cumab");
		owner.setPhone("+258842473772");

		CarId carId = new CarId("Manica", "123-132");
		Car car = new Car();
		car.setCarId(carId);
		car.setModel("H1");
		car.setManufacturer("Hammer");
		car.setYearManufactured(2005);
		car.setYearModel(2006);
		car.setPrice(BigDecimal.valueOf(250_000D));
		car.setSubscriptionDate(LocalDate.now());
		car.setOwner(owner);

		BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(photo));
		if (JOptionPane.showConfirmDialog(null, new JLabel(new ImageIcon(bufferedImage))) == JOptionPane.YES_OPTION)
			car.setPhoto(photo);

		entityManager.persist(car);
		entityTransaction.commit();
		entityManager.detach(car);

		Car car1 = entityManager.find(Car.class, car.getCarId());

		if (car1.getPhoto() != null) {
			bufferedImage = ImageIO.read(new ByteArrayInputStream(car1.getPhoto()));

			JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(bufferedImage)));
		} else {
			JOptionPane.showMessageDialog(null, "This car doesn't have image!");
		}
	}

	public static void savingImage(EntityManager entityManager) throws IOException {
		System.out.println("\nsaving Image after showing!");
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		System.out.println(System.getProperty("user.home"));

		Path pathImage = new File("photos/hammer.jpg").getAbsoluteFile().toPath();
		byte[] photo = Files.readAllBytes(pathImage);

		CarId carId = new CarId("Manica", "123-12");
		Car car = new Car();
		car.setCarId(carId);
		car.setModel("H1");
		car.setManufacturer("Hammer");
		car.setYearManufactured(2005);
		car.setYearModel(2006);
		car.setPrice(BigDecimal.valueOf(250_000D));
		car.setSubscriptionDate(LocalDate.now());
		car.setPhoto(photo);

		entityManager.persist(car);
		entityTransaction.commit();
		entityManager.detach(car);

		Car car1 = entityManager.find(Car.class, car.getCarId());

		if (car1.getPhoto() != null) {
			BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(car1.getPhoto()));

			JOptionPane.showConfirmDialog(null, new JLabel(new ImageIcon(bufferedImage)));
		} else {
			JOptionPane.showMessageDialog(null, "This car doesn't have image!");
		}
		entityManager.detach(car);
	}

	public static void savingLargFilesWithLobAnnotation(EntityManager entityManager) {
		System.out.println("\nSaving Large files With @LOB annotation");
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CarId carId = new CarId("Maputo", "333-33");
		Car car = new Car();

		car.setCarId(carId);
		car.setSubscriptionDate(LocalDate.now());
		car.setPrice(BigDecimal.valueOf(200_000D));
		car.setModel("Nogrunri");
		car.setManufacturer("Kilamba");
		car.setYearManufactured(2015);
		car.setYearModel(2015);
		car.setCompleteDescription("Deves ter");
		StringBuilder especificacao = new StringBuilder();
		especificacao.append(
				"O Hummer H1 é um modelo civil baseado no \"M998 High Mobility Multipurpose Wheeled Vehicle\" (HMMWV), popularmente conhecido como Humvee, veículo militar desenvolvido pela AM General, o H1 posui quatro principais tipos: dois lugares com teto metal , quatro lugares com teto de lona, quatro lugares com teto de metal e quatro lugares com teto tipo perua.[1]");
		especificacao.append("Edmunds' Expert Review\n"
				+ "Unless you're desperately in need of attention or you own a sprawling cattle ranch, leave the H1 to movie stars and army commandos.\n"
				+ "\n" + "2004 Highlights\n"
				+ "The original Hummer gets a slightly reworked dash with an in-dash six-disc CD changer. The 6.5-liter turbodiesel has been retuned to deliver more power and reduce emissions.");
		car.setSpecifications(especificacao.toString());
		entityManager.persist(car);
		entityTransaction.commit();
		entityManager.detach(car);

		Car car1 = entityManager.find(Car.class, car.getCarId());
		System.out.println("Car: " + car1.getModel());
		System.out.printf("%s%n%s", "--------------------------------------", car1.getSpecifications());

	}

	public static void usingTransientAnnotation(EntityManager entityManager, Car car) {
		System.out.printf("%nUsing transient attributes: %n", LocalDate.now());

		System.out.println("Printing car after saving");
		System.out.println(car);

		Car car1 = entityManager.find(Car.class, new CarId("Niassa", "208-23"));
		System.out.println("getting the car using find(Car.class, new CarId(\"Niassa\", \"208-23\"))");
		System.out.println(car1);
		System.out.println("See the difference?");
		System.out.println("Saved\n");
	}

	public static Car savingwithLocalDate(EntityManager entityManager) {
		System.out.printf("%nSaving with date: %n", LocalDate.now());
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CarId carId = new CarId("Niassa", "208-23");
		Car car = new Car();
		car.setCarId(carId);
		car.setSubscriptionDate(LocalDate.now());
		car.setPrice(BigDecimal.valueOf(200_000D));
		car.setModel("Nogrunda");
		car.setManufacturer("Kilamba");
		car.setYearManufactured(2015);
		car.setYearModel(2015);
		car.setCompleteDescription("Deves ter");
		entityManager.persist(car);

		entityTransaction.commit();
		System.out.println("Saved\n");
		entityManager.detach(car);
		return car;
	}

	public static void savingWithEnumType(EntityManager entityManager) {
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

	public static void fetchingData(EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CarId carId = new CarId("Niassa", "270-03");
		Car car = entityManager.find(Car.class, carId);

		System.out.printf("%n%s%n%s%s%n%s%s%n%s%s%n%s%s%n", "Fetching Car By CarId Class", "Car plate: ",
				car.getCarId().getMatricula(), "Province: ", car.getCarId().getProvincia(), "Manufacturer: ",
				car.getManufacturer(), "Model: ", car.getModel());

		entityTransaction.commit();
	}

	public static void savingData(EntityManager entityManager) {
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
