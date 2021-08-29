package _5_7_cache_de_segundo_nivel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "cache_de_segundo_nivel_centro_custo")
@Table(name = "cache_de_segundo_nivel_centro_custo")
@Cacheable(value = true) // Dizendo que devera ser armazenado no cache
public class CentroCusto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designacao;
}
