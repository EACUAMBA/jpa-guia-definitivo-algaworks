package context._6_6_projecao;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class Context {
    public static void main(String[] args) {
        //Projeção - é uma maneira de retornar apenas os dados que precisamos de uma entidade, sem outros desnecessarios, com a projeção podemos fazer uma pesquisa que irá ser barata pois somente irá buscar aquilo que vamos usar.

        EntityManager entityManager = JpaUtil.getEntityManager();

        TypedQuery<String> stringTypedQuery = entityManager.createQuery("select v.modelo from Veiculo v", String.class);

        List<String> resultList= stringTypedQuery.getResultList();
        for (String modelo: resultList)
            System.out.println("\nO modelo é " + modelo + "\n");

        entityManager.close();
        JpaUtil.close();
    }
}
