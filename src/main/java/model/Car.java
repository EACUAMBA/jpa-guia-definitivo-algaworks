package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

//Plain Old Java Object - POJO -> We don't have modified constructor here.
@Entity
@Table(name = "tab_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
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

    @Override
    public boolean equals(Object o) {
       if(o == null) return false;
       if(!(o instanceof Car)) return false;
       Car car =  (Car)o;
       return this.id.equals(car.id);
    }

    @Override
    public int hashCode(){
        return
                this.yearManufactured != null ? this.yearManufactured.hashCode() : 0;
    }

}
