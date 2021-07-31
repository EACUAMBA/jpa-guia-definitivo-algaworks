package inheritance.superclass_property_inheritance;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@MappedSuperclass
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
