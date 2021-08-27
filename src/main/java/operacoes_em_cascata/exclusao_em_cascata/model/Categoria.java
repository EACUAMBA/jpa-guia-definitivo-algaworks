package operacoes_em_cascata.exclusao_em_cascata.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.action.internal.OrphanRemovalAction;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "exclusao_em_cascata_categoria")
@Table(name = "exclusao_em_cascata_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true/*Agora vai persistir todos os produtos que estiverem associados. Vai remover todos os produts que tiverem esta categoria.*/)
    private List<Produto> produtos;

}
