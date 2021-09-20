package context._6_8_funcoes_de_agregacao;

import domain.dto.TotalCarroPorAno;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class Context {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        TypedQuery<TotalCarroPorAno> totalCarroPorAnoTypedQuery = entityManager.createQuery("" +
                "select " +
                "new domain.dto.TotalCarroPorAno(v.anoFabrico, avg(v.valor), count(v)) " +
                "from Veiculo v group by v.anoFabrico", TotalCarroPorAno.class);

        List<TotalCarroPorAno> totalCarroPorAnoList = totalCarroPorAnoTypedQuery.getResultList();

        for(TotalCarroPorAno totalCarroPorAno: totalCarroPorAnoList){
            System.out.printf(
                    "%nAno de Frabricacao: %d, Quantidade de carros: %d, Media do preço: %f",
                    totalCarroPorAno.getAnoFabricacao(), totalCarroPorAno.getQuantidadeCarros(), totalCarroPorAno.getMediaPreco()
            );
        }

        entityManager.close();
        JpaUtil.close();
    }

}
