package domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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
    joinColumns = {@JoinColumn(name="proprietario_id")})
@Column(name = "numero")
    private List<String> telefones = new ArrayList<>();
}
