package metodos_de_callback;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "callback_animal")
@Table(name = "callback_animal")

@EntityListeners(AnimalAuditor.class)
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designacao;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "ultima_modificacao")
    private LocalDateTime ultimaModificacao;

    @Transient
    private long idade;


}
