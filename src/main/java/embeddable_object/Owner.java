package embeddable_object;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "owner_embeddable_object")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ElementCollection //Dizendo que este elemento será uma lista
    @CollectionTable(name = "owner_phone_embeddable_object", joinColumns = @JoinColumn(name = "owner_id")) //Fazendo o relacionamento, dizendo que o atributo ou foregin key do owner, dono do telefone será owner_id
//    @AttributeOverrides({
//            @AttributeOverride(name = "phone",
//            column = @Column(name = "number_overrided", length = 250, nullable = false)
//            )
//    }) //Esta propriedade não é obrigatoria, ela é usada para sobre escrever uma coluna.
    private List<Phone> phoneList = new ArrayList<>();

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

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
