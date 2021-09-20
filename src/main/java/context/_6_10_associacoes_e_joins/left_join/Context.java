package context._6_10_associacoes_e_joins.left_join;

import util.JpaUtil;

import domain.model.Proprietario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class Context {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        TypedQuery<Object[]> estatisticaTypedQuery = entityManager.createQuery("select p.nome, count(v) from Proprietario p left join p.veiculos v group by p.nome", Object[].class);

        List<Object[]> estatisticaList = estatisticaTypedQuery.getResultList();

        for(Object[] obj: estatisticaList){
            System.out.println("O proprietario " + obj[0] + " tem cerca de " + obj[1] + " carros.");
        }


    }
}
