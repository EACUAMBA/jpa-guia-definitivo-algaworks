package context._7_7_ordenacao_de_resultado;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.lang.reflect.Type;
import java.util.List;

public class OrdenacaoDeResultado {
    private final EntityManager entityManager;

    public OrdenacaoDeResultado(){
        this.entityManager = JpaUtil.getEntityManager();

        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Veiculo> cq = cb.createQuery(Veiculo.class);

        Root<Veiculo> veiculoRoot = cq.from(Veiculo.class);

        Order order = cb.desc(veiculoRoot.<String>get("anoFabrico"));

        cq.select(veiculoRoot);
        cq.orderBy(order);

        TypedQuery<Veiculo> veiculoTypedQuery = this.entityManager.createQuery(cq);

        List<Veiculo> veiculoList = veiculoTypedQuery.getResultList();

        for (Veiculo veiculo: veiculoList){
            System.out.println(
                    "ID: " + veiculo.getId()
                    + "Ano fabrico: " + veiculo.getAnoFabrico()
            );
        }

    }

    public static void main(String[] args) {
        OrdenacaoDeResultado odr = new OrdenacaoDeResultado();

        odr.entityManager.close();

        JpaUtil.close();
    }
}
