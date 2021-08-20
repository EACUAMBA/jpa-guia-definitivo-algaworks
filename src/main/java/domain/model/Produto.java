package domain.model;



import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "lazyloading_eagerloading_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = true)
    private String nome;

    @ManyToOne(optional = false, fetch = FetchType.LAZY) // Estamos dizendo se é obrigatorio ou nao um produto ter uma categoria
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
