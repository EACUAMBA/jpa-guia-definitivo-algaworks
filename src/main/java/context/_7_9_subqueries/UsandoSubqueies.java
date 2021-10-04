package context._7_9_subqueries;

import domain.model.Proprietario;
import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class UsandoSubqueies {
    private final EntityManager entityManager;

    public UsandoSubqueies(){
        {
            this.entityManager = JpaUtil.getEntityManager();

            CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();

            CriteriaQuery<Veiculo> cq = cb.createQuery(Veiculo.class);

            Subquery<Double> doubleSubquery = cq.subquery(Double.class);

            Root<Veiculo> veiculoRootFromSubquery = doubleSubquery.from(Veiculo.class);

            Root<Veiculo> veiculoRoot = cq.from(Veiculo.class);

            veiculoRoot.fetch("proprietario");
//            veiculoRoot.join("proprietario");

            doubleSubquery.select(cb.avg((veiculoRootFromSubquery.<Double>get("valor"))));

            cq.select(veiculoRoot);

            cq.where(cb.greaterThanOrEqualTo(
                    veiculoRoot.<Double>get("valor"),
                    doubleSubquery
            ));

            TypedQuery<Veiculo> veiculoTypedQuery = this.entityManager.createQuery(cq);

            List<Veiculo> veiculoList = veiculoTypedQuery.getResultList();

            for (Veiculo veiculo: veiculoList){
                System.out.println(
                        "Proprietario: " + veiculo.getProprietario().getNome()
                                + "Modelo: " + veiculo.getModelo()
                );
            }

        }
    }

    public static void main(String[] args) {
        UsandoSubqueies usandoSubqueies = new UsandoSubqueies();

    }
}
