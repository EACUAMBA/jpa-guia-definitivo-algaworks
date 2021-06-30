/*
 * Copyright (c) 2021.
 * Feito por Edilson Alexandre Cuamba aos 30/6/2021 10:56:2
 * Desenvolvedor Java | Spring & ZKoss | React JS & Native | UX & UI
 * (+258) 84 24 73 772 & (+258) 82 25 65 148
 * edilsoncuamba@gmail.com
 */

package model;

import javax.persistence.*;

@Entity
@Table(name = "tab_wheels")
public class Wheels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String manufacturer;
    private Integer size;
    private Integer quantity;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "car_matricula_id", referencedColumnName = "matricula"), // Serve para difenir o nome da coluna quando usamos chaves compostas
            @JoinColumn(name = "car_provincia_id", referencedColumnName = "provincia")
    })
    private Car car;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Wheels{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", size=" + size +
                ", quantity=" + quantity +
                //", car=" + car +
                '}';
    }
}
