package context._7_5_resultados_complexos_tuplas_e_construtores.tuplas;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TuplasContext {
    private final EntityManager entityManager;

    public TuplasContext(){
        long timeInit = System.currentTimeMillis();
        this.entityManager = JpaUtil.getEntityManager();

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Tuple> tupleCriteriaQuery = criteriaBuilder.createTupleQuery();

        Root<Veiculo> veiculoRoot = tupleCriteriaQuery.from(Veiculo.class);

        tupleCriteriaQuery.multiselect(
                veiculoRoot.get("modelo").alias("modeloVeiculo"),
                veiculoRoot.get("tipoCombustivel").alias("tipoCombustivel")
        );

        TypedQuery<Tuple> tupleTypedQuery = this.entityManager.createQuery(tupleCriteriaQuery);

        List<Tuple> tupleList = tupleTypedQuery.getResultList();

        for(Tuple tuple: tupleList){
            System.out.println(
                    "\nModelo: " + tuple.get("modeloVeiculo")
                    + "\nTipo de gasosa: " + tuple.get("tipoCombustivel")
            );
        }

        long timeNow = System.currentTimeMillis();
        System.out.printf("O processo levou %d s para ser concluido.", TimeUnit.MILLISECONDS.toSeconds((timeNow - timeInit)));
    }

    public static void main(String[] args) {
        new TuplasContext();
    }
}
