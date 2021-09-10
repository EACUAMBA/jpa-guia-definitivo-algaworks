package context._6_2_consultas_simples_e_interacao_no_resultado;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Context {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        //Criamos uma query usando  o method da instancia do EntityManager .createQuery(query) e passamos como parametro a query JPQL, veja que é muito parecida com a qery do SQL
        Query query = entityManager.createQuery("select v from Veiculo v where v.anoModelo < 2011");

        System.out.println("Pedindo ao JPA para buscar os dados.");
        //Pedindo ao JPA para buscar os dados usando a minha query, criada manualmente, chamada de query dinamica. , temos aqui uma lista não tipada, sem um tipo especifico.
        List resultList = query.getResultList();

        for (Object object: resultList){
            //Verificando se as instancias que temos nessa lista são filhas de Veiculo e fazendo o cast se for.
            if (object instanceof  Veiculo){
                Veiculo veiculo = (Veiculo) object;
                System.out.println();
                System.out.println("Modelo " + veiculo.getModelo());
                System.out.println("Ano Modelo " + veiculo.getAnoModelo());
            }
        }
        entityManager.close();
        JpaUtil.close();
    }
}
