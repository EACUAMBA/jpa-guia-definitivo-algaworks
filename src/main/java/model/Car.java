package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

//Plain Old Java Object - POJO -> We don't have modified constructor here.
@Entity
@Table(name = "tab_car")
public class Car {
    @EmbeddedId
    private CarId carId;

    @Column(length = 60, nullable = false)
    private String manufacturer;
    @Column(length = 60, nullable = false)
    private String model;
    @Column(name = "year_manufactured", nullable = false)
    private Integer yearManufactured;
    @Column(name = "year_model", nullable = false)
    private Integer yearModel;
    @Column(precision = 10, scale = 2, nullable = true)
    private BigDecimal price;
    @Column(name = "fuel_type", nullable = true)
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    //@Temporal(TemporalType.DATE) Usamos somente quando a variavel é Date ou Calendar
    @Column(name = "data_cadastro", nullable = true)
    private LocalDate subscriptionDate;
    @Transient
    private String completeDescription;
    @Lob
    private String specifications;
    @Lob
    private byte[] photo;

    @Embedded
    private Owner owner;

    @OneToOne()
    @JoinColumn(name = "insurance_car_id")
    private InsuranceCar insuranceCar;

    @OneToMany(mappedBy = "car")
    private List<Wheels> wheelsList;

    public void setCarId(CarId carId) {
        this.carId = carId;
    }

    public CarId getCarId() {
        return this.carId;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setYearManufactured(Integer yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    public Integer getYearManufactured() {
        return this.yearManufactured;
    }

    public void setYearModel(Integer yearModel) {
        this.yearModel = yearModel;
    }

    public Integer getYearModel() {
        return this.yearModel;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public FuelType getFuelType() {
        return this.fuelType;
    }

    public void setCompleteDescription(String completeDescription) {
        this.completeDescription = completeDescription;
    }

    public String getCompleteDescription() {
        return this.completeDescription;
    }

    public void setSubscriptionDate(LocalDate dataCadastro) {
        this.subscriptionDate = dataCadastro;
    }

    public LocalDate getSubscriptionDate() {
        return this.subscriptionDate;
    }

    public void setSpecifications(String especificacoes) {
        this.specifications = especificacoes;
    }

    public String getSpecifications() {
        return this.specifications;
    }

    public void setPhoto(byte[] photo){
        this.photo = photo;
    }
    public byte[] getPhoto(){
        return this.photo;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public InsuranceCar getInsuranceCar() {
        return insuranceCar;
    }

    public void setInsuranceCar(InsuranceCar insuranceCar) {
        this.insuranceCar = insuranceCar;
    }

    public List<Wheels> getWheelsList() {
        return wheelsList;
    }

    public void setWheelsList(List<Wheels> wheelsList) {
        this.wheelsList = wheelsList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return this.carId.equals(car.carId);
    }

    @Override
    public int hashCode() {
        return
                this.yearManufactured != null ? this.yearManufactured.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", yearManufactured=" + yearManufactured +
                ", yearModel=" + yearModel +
                ", price=" + price +
                ", fuelType=" + fuelType +
                ", subscriptionDate=" + subscriptionDate +
                ", completeDescription='" + completeDescription + '\'' +
                ", specifications='" + specifications + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", owner=" + owner +
                ", insuranceCar=" + insuranceCar +
                ", wheelsList=" + wheelsList +
                '}';
    }
}
