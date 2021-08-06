package inheritance.each_table_for_each_concret_classe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "employee_each_table_for_each_concret_classe")
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
