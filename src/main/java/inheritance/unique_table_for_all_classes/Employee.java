package inheritance.unique_table_for_all_classes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "employee_unique_table_for_all_classes")
@DiscriminatorValue(value = "Employee")
public class Employee extends Person {
    @Column(name = "department")
    private String department;

    @Column(name = "monthly_salary")
    private Double monthlySalary;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
