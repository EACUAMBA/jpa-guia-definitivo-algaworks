package metodos_de_callback;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AnimalAuditor {

    @PrePersist
    @PreUpdate
    public void configuraAlteracoesData(Animal animal){
        animal.setUltimaModificacao(LocalDateTime.now().minusDays(2));
    }

    @PostLoad
    @PostUpdate
    @PostPersist
    private void settingIdade(Animal animal){
        animal.setIdade(ChronoUnit.YEARS.between(animal.getDataNascimento(), LocalDate.now()));
    }
}
