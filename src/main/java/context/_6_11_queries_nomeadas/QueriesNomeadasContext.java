package context._6_11_queries_nomeadas;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class QueriesNomeadasContext {
    //Como parte deste subcapitulo vá para a classe domain.model.Veiculo entre o comentario '_6_11_queries_nomeadas', tem a anotação usada para criar uma NamedQuery
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        TypedQuery<Veiculo> veiculoTypedQuery = entityManager.createNamedQuery("Veiculo.comProprietarioPorValor", Veiculo.class);
        veiculoTypedQuery.setParameter("valor", BigDecimal.valueOf(5_000_000D));

        List<Veiculo> veiculoList = veiculoTypedQuery.getResultList();

        System.out.println();
        for(Veiculo veiculo : veiculoList){
            System.out.println("ID do veiculo: " + veiculo.getId());
            System.out.println("Modelo do veiculo: " + veiculo.getModelo());
        }
        System.out.println();
    }
/*
Podemos armazenar todas as nossas queries nomeiadas em um arquivo veja a estrutura do arquivo no resources meta-inf orm.xml;

 */

}
