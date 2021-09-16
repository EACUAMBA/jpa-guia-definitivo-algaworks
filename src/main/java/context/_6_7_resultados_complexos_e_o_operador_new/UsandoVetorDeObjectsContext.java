package context._6_7_resultados_complexos_e_o_operador_new;

import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class UsandoVetorDeObjectsContext {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        Query query = em.createQuery("select v.id, v.modelo, v.valor from Veiculo v");

        List<Object[]> idModeloValor = query.getResultList();

        for(Object[] obj: idModeloValor){
            Long id = (Long) obj[0];
            String modelo = (String) obj[1];
            BigDecimal preco = (BigDecimal) obj[2];

            System.out.println("\n Oseu carro te o id " + id + " e é modelo " + modelo + " e preco de " + preco + "\n");
        }

        em.close();
        JpaUtil.close();

    }
}
