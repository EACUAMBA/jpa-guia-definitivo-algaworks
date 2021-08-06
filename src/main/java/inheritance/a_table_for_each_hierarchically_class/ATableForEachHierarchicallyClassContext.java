package inheritance.a_table_for_each_hierarchically_class;

import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ATableForEachHierarchicallyClassContext {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        saving(entityManager);
        printingPerson(entityManager);

        entityManager.close();
        JpaUtil.close();

    }
    public static void saving(EntityManager entityManager){
        Seller alcidioSeller = new Seller();
        alcidioSeller.setName("Alcidio Alexadre Cuamba");
        alcidioSeller.setProfitRate(10);
        alcidioSeller.setSellZone("Maputo");

        Employee edilsonEmployee = new Employee();
        edilsonEmployee.setName("Edilson Alexandre Cuamba");
        edilsonEmployee.setDepartment("Software Architecture");
        edilsonEmployee.setMonthlySalary(12_500.50D);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(alcidioSeller);
        entityManager.persist(edilsonEmployee);

        entityTransaction.commit();
    }

    public static void printingPerson(EntityManager entityManager){
        System.out.println("\nLooking for persons...");
        List<Person>  people = entityManager.createQuery("select p from person_a_table_for_each_hierarchically_class p", Person.class).getResultList();
        for(Person person : people) {
            if(person instanceof Employee) {
                Employee employee = (Employee) person;
                System.out.println("\nEmployee " + employee.getId() + " found, is " + employee.getName());
                System.out.println("\tDepartment: " + employee.getDepartment());
                System.out.println("\tMonthly Salary: " + NumberFormat.getCurrencyInstance(new Locale("pt", "MZ")).format(employee.getMonthlySalary()));
            }else if(person instanceof Seller){
                    Seller seller = (Seller)person;
                System.out.println("\nSeller "+ seller.getId() + " found, is " + seller.getName());
                System.out.println("\tProfit rate: " + seller.getProfitRate());
                System.out.println("\tSell zone: " + seller.getSellZone());
            }
        }
    }
}
