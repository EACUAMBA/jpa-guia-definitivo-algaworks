package context._7_8_join_e_fetch._fetch;

import context._7_7_ordenacao_de_resultado.OrdenacaoDeResultado;
import domain.model.Proprietario;
import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class Fetch {
    private final EntityManager entityManager;

    public Fetch(){
        this.entityManager = JpaUtil.getEntityManager();

        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Veiculo> cq = cb.createQuery(Veiculo.class);

        Root<Veiculo> veiculoRoot = cq.from(Veiculo.class);

        Join<Veiculo, Proprietario> proprietarioJoin = (Join) veiculoRoot.fetch("proprietario");

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
        Fetch fetch = new Fetch();
        JpaUtil.close();
    }
}
