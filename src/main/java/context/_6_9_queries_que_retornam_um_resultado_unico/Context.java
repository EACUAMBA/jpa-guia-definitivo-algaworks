package context._6_9_queries_que_retornam_um_resultado_unico;

import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Context {
    public static void main(String[] args) {
        EntityManager entityManager  = JpaUtil.getEntityManager();

        TypedQuery<Long> longTypedQuery = entityManager.createQuery(
                "select count(v)from Veiculo v", Long.class
        );
        Long contagem = longTypedQuery.getSingleResult();
        System.out.println("A contagem foi de " + contagem);
    }
}
