/*
 * Copyright (c) 2021.
 * Feito por Edilson Alexandre Cuamba aos 30/6/2021 9:23:57
 * Desenvolvedor Java | Spring & ZKoss | React JS & Native | UX & UI
 * (+258) 84 24 73 772 & (+258) 82 25 65 148
 * edilsoncuamba@gmail.com
 */

package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tab_insurance_car")
public class InsuranceCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String details;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToOne(mappedBy = "insuranceCar")
    private Car car;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "InsuranceCar{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                //", car=" + car +
                '}';
    }
}
