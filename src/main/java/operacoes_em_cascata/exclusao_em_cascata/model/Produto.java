package operacoes_em_cascata.exclusao_em_cascata.model;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity(name = "exclusao_em_cascata_produto")
@Table(name = "exclusao_em_cascata_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = true)
    private String nome;

    @ManyToOne(optional = true, cascade = CascadeType.PERSIST /*Esta anotação diz ao JPQ para salver este objecto.*/)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
