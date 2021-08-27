package operacoes_em_lote.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "operacoes_em_lote_usuario")
@Table(name = "operacoes_em_lote_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private boolean estado;
}
