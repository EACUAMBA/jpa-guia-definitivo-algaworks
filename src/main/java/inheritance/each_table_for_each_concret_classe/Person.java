package inheritance.each_table_for_each_concret_classe;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "person_each_table_for_each_concret_classe")
@Table(name = "person_each_table_for_each_concret_classe")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment") //Está forma de geração de valores para chave primaria não é padronizada pelo JPA é uma função do Hibernate. porque agoa teremos duas tabelas que representam uma entidade que é a Person, essa entidade não pode ter duas instancias com o mesmo ID mesmo que guardadmos cada person em tabelas diferentes.
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
