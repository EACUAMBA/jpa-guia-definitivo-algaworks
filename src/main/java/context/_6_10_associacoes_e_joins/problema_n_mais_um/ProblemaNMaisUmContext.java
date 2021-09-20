package context._6_10_associacoes_e_joins.problema_n_mais_um;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProblemaNMaisUmContext {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        TypedQuery<Veiculo> veiculoTypedQuery = entityManager.createQuery("select v from Veiculo v inner join fetch  v.proprietario", Veiculo.class);

        List<Veiculo> veiculos = veiculoTypedQuery.getResultList();

        for(Veiculo v: veiculos){
            System.out.println("O veiculo " + v.getModelo() + " tem como proprietario " + v.getProprietario().getNome());
        }
    }
}
