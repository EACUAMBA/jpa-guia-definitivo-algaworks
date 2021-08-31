package domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "proprietario")
public class Proprietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @OneToMany(mappedBy = "proprietario")
    private List<Veiculo> veiculos;

    @ElementCollection
    @CollectionTable(name = "proprietario_telefone",
    joinColumns = {@JoinColumn(name="proprietario_id")},
    @AttributeOverrides({
            @AttributeOverride(name = "numero",
            column = @Column(name = "telefone_numero", length = 20, nullable = false))
    }))
    private List<Telefone> telefones;
}
