package domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "acessorio")
public class Acessorio {
    private Long id;
    private String descicao;

    @ManyToMany(mappedBy = "acessorios")
    private Set<Veiculo> veiculos = new HashSet<>();

}
