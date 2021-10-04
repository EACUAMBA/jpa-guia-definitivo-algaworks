package context._7_8_join_e_fetch._join;

import domain.model.Proprietario;
import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.util.List;

public class Join {
    private final EntityManager entityManager;

    public Join(){
        this.entityManager = JpaUtil.getEntityManager();

        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Veiculo> cq = cb.createQuery(Veiculo.class);

        Root<Veiculo> veiculoRoot = cq.from(Veiculo.class);

        javax.persistence.criteria.Join<Veiculo, Proprietario> proprietarioJoin = veiculoRoot.join("proprietario");

        cq.select(veiculoRoot);
        cq.where(cb.equal(proprietarioJoin.get("nome"), "Edilson"));

        TypedQuery<Veiculo> veiculoTypedQuery = this.entityManager.createQuery(cq);

        List<Veiculo> veiculoList = veiculoTypedQuery.getResultList();

        for (Veiculo veiculo: veiculoList){
            System.out.println(
                    "Proprietario: " + veiculo.getProprietario().getNome()
                            + "Modelo: " + veiculo.getModelo()
            );
        }

    }

    public static void main(String[] args) {
        Join join = new Join();

        JpaUtil.close();
    }
}
