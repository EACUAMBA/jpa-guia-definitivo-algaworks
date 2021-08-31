package domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TotalCarroPorAno {
    private Integer anoFabricacao;
    private Double mediaPreco;
    private Long quantidadeCarros;
}
