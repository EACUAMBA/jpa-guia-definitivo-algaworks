package domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String fabricante;
    private String modelo;

    @Column(name = "ano_fabrico", nullable = false)
    private Integer anoFabrico;

    @Column(name = "ano_modelo", nullable = true)
    private Integer anoModelo;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "tipo_combustivel", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "descricao_completa")
    private String descricaoComplete;

    @Lob
    private String especificacoes;

    @Lob
    private byte[] foto;

    @ManyToOne
    @JoinColumn(name = "proprietario_codigo")
    private Proprietario proprietario;

    @ManyToMany
    @JoinTable(name = "veiculo_acessorio", joinColumns = {
            @JoinColumn(name = "veiculo_codigo")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "acessorio_codigo")
    })
    private Set<Acessorio> acessorios;


}
