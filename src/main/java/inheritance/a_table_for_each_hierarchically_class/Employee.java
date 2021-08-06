package inheritance.a_table_for_each_hierarchically_class;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "employee_a_table_for_each_hierarchically_class")
@PrimaryKeyJoinColumn(name = "person_id")
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
