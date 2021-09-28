package context._7_3_projecoes;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProjecoesContext {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<String> stringCriteriaQuery = criteriaBuilder.createQuery(String.class);

        Root<Veiculo> veiculoRoot = stringCriteriaQuery.from(Veiculo.class);

        stringCriteriaQuery.select(veiculoRoot.<String>get("modelo"));

        TypedQuery<String> stringTypedQuery = entityManager.createQuery(stringCriteriaQuery);

        List<String> modelos = stringTypedQuery.getResultList();

        for (String modelo : modelos){
            System.out.println("Modelos: " + modelo);
        }

        entityManager.close();

        JpaUtil.close();

    }
}
