package context._6_7_resultados_complexos_e_o_operador_new;

import domain.dto.PrecoVeiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class UsandoUmObjectoDTOContext {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        TypedQuery<PrecoVeiculo> query = em.createQuery("select new  domain.dto.PrecoVeiculo(v.id, v.modelo, v.valor) from Veiculo v", PrecoVeiculo.class);

        List<PrecoVeiculo> idModeloValor = query.getResultList();

        for(PrecoVeiculo obj: idModeloValor){

            System.out.println("Usando a classe " + obj.getClass() + " como dto.");
            Long id = obj.getId();
            String modelo = obj.getModelo();
            BigDecimal preco = obj.getValor();

            System.out.println("\n Oseu carro te o id " + id + " e é modelo " + modelo + " e preco de " + preco + "\n");
        }

        em.close();
        JpaUtil.close();
    }
}
