package context._6_10_associacoes_e_joins.inner_join;

import domain.model.Proprietario;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class Context {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        TypedQuery<Proprietario> proprietarioTypedQuery = entityManager.createQuery("select distinct p from Proprietario p inner join p.veiculos v", Proprietario.class);

        List<Proprietario> proprietarioList = proprietarioTypedQuery.getResultList();

        for (Proprietario proprietario: proprietarioList){
            System.out.printf(
                    "Proprietarios com carro, pelo menos um carro%nNome: %s%n",
                    proprietario.getNome()
            );
        }

        entityManager.close();
        JpaUtil.close();
    }
}
