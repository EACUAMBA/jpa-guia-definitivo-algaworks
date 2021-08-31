package inheritance.a_table_for_each_hierarchically_class;

import javax.persistence.*;

@Entity(name = "person_a_table_for_each_hierarchically_class")
@Table(name = "person_a_table_for_each_hierarchically_class")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
