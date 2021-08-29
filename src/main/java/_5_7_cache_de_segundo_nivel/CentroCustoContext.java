package _5_7_cache_de_segundo_nivel;

import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CentroCustoContext {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction entityTransaction = manager.getTransaction();

        System.out.println("Buscando o centro no banco de dados, foi gerado um SQL.");
        CentroCusto centroCusto = manager.find(CentroCusto.class, 1L);
        System.out.println("Nome do centro 1L, nome: " + centroCusto.getDesignacao());

        System.out.println("\n Fechando o Manager...");
        manager.close();
        System.out.println("Manager fechado\n");

        System.out.println("\n Abrindo novo manager...");
        EntityManager novo_manager = JpaUtil.getEntityManager();
        System.out.println("Apos abrir...");

        System.out.println("\nBuscando novamente o centro 1L agora no CACHE de segundo nivel...");
        CentroCusto centroCusto1 = novo_manager.find(CentroCusto.class, 1L);

        System.out.println("Nome do centro que encontrei no cache: " + centroCusto1.getDesignacao());

        novo_manager.close();
        JpaUtil.close();
    }
}
