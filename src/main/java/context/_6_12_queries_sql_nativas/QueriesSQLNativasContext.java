package context._6_12_queries_sql_nativas;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class QueriesSQLNativasContext {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        Query query = entityManager.createNativeQuery("select * from veiculo", Veiculo.class);

        List<Veiculo> veiculoList = query.getResultList();

        for (Veiculo veiculo: veiculoList){
            System.out.println("ID: " + veiculo.getId());
            System.out.println("Modelo: " + veiculo.getModelo());
        }
    }
}
