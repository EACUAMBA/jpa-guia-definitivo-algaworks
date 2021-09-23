package context._7_2_filtros_e_queries_dinamicas;

import domain.model.TipoCombustivel;
import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ConsultasComCondicoesContext {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Veiculo> veiculoCriteriaQuery = criteriaBuilder.createQuery(Veiculo.class);

        Root<Veiculo> veiculoRoot = veiculoCriteriaQuery.from(Veiculo.class);

        Predicate predicate= criteriaBuilder.not(criteriaBuilder.equal(veiculoRoot.get("tipoCombustivel"), TipoCombustivel.DIESEL));

        veiculoCriteriaQuery.select(veiculoRoot);
        veiculoCriteriaQuery.where(predicate);

        TypedQuery<Veiculo> veiculoTypedQuery = entityManager.createQuery(veiculoCriteriaQuery);

        List<Veiculo> veiculoList = veiculoTypedQuery.getResultList();

        for (Veiculo veiculo: veiculoList)
            System.out.println("Modelo: " + veiculo.getModelo() + " \nID: " + veiculo.getId());

        entityManager.close();
        JpaUtil.close();

    }
}
