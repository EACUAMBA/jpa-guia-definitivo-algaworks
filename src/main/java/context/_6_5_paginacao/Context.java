package context._6_5_paginacao;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class Context {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        TypedQuery<Veiculo> veiculoTypedQuery = entityManager.createQuery("select v from Veiculo v", Veiculo.class);
        ((TypedQuery) veiculoTypedQuery).setFirstResult(0);
        veiculoTypedQuery.setMaxResults(10);

        List<Veiculo> veiculoList = veiculoTypedQuery.getResultList();

        for(Veiculo veiculo: veiculoList){
            System.out.printf("ID - %d%nModelo - %s%n%n", veiculo.getId(), veiculo.getModelo());
        }


    }
}
