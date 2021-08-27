package operacoes_em_cascata.persistencia_em_cascata.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "persistencia_em_cascata_categoria")
@Table(name = "persistencia_em_cascata_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.PERSIST /*Agora vai persistir todos os produtos que estiverem associados.*/)
    private List<Produto> produtos;

}
