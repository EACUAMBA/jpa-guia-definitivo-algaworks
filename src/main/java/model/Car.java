package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

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

    public void setCarId(CarId carId){
        this.carId = carId;
    }
    public CarId getCarId(){
        return this.carId;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    public String getManufacturer(){
        return this.manufacturer;
    }

    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return this.model;
    }

    public void setYearManufactured(Integer yearManufactured){
        this.yearManufactured = yearManufactured;
    }
    public Integer getYearManufactured(){
        return this.yearManufactured;
    }

    public void setYearModel(Integer yearModel){
        this.yearModel = yearModel;
    }
    public Integer getYearModel() {
        return this.yearModel;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }
    public BigDecimal getPrice(){
        return this.price;
    }

    public void setFuelType(FuelType fuelType){
        this.fuelType = fuelType;
    }
    public FuelType getFuelType(){
        return this.fuelType;
    }

    @Override
    public boolean equals(Object o) {
       if(o == null) return false;
       if(!(o instanceof Car)) return false;
       Car car =  (Car)o;
       return this.carId.equals(car.carId);
    }

    @Override
    public int hashCode(){
        return
                this.yearManufactured != null ? this.yearManufactured.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + this.carId +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", yearManufactured=" + yearManufactured +
                ", yearModel=" + yearModel +
                ", price=" + price +
                '}';
    }
}
