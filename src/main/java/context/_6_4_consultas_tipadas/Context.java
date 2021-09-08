package context._6_4_consultas_tipadas;

import domain.model.Proprietario;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class Context {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        //usamos as consultas tipadas para não precisarmos fazer cast na hora de pegar os dados.
        TypedQuery<Proprietario> proprietarioTypedQuery = entityManager.createQuery("select p from Proprietario p",Proprietario.class);

        List<Proprietario> proprietarioList = proprietarioTypedQuery.getResultList();
        for(Proprietario proprietario: proprietarioList){
            System.out.println("ID: " + proprietario.getId());
            System.out.println("Nome: " + proprietario.getNome());
            System.out.println("Telefones: \n" + proprietario.getTelefones() + "\n");
        }

        entityManager.close();
        JpaUtil.close();

    }
}
