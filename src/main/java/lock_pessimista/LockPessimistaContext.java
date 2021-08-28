package lock_pessimista;

import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;

public class LockPessimistaContext {

    public static void main(String[] args) {
        EntityManager manager_1 = JpaUtil.getEntityManager();
        EntityManager manager_2 = JpaUtil.getEntityManager();

        alterarMesmoProdutoEmSimultaneo(manager_1, manager_2);

        manager_1.close();
        manager_2.close();
        JpaUtil.close();
    }

    public static void alterarMesmoProdutoEmSimultaneo(EntityManager m1, EntityManager m2){
        EntityTransaction et1 = m1.getTransaction();
        EntityTransaction et2 = m2.getTransaction();
        et1.begin();
        et2.begin();

        System.out.println("Buscando os dados do m1");
        Produto produto_m1 = m1.find(Produto.class, 1L, LockModeType.PESSIMISTIC_READ);
        System.out.println("Encontrei: " + produto_m1.getNome());


        System.out.println("Buscando os dados do m2");
        Produto produto_m2 = m2.find(Produto.class, 1L, LockModeType.PESSIMISTIC_READ);
        System.out.println("Encontrei: " + produto_m2.getNome());

        System.out.println("Editando os dados...");
        produto_m1.setNome("Agua Vumba 1L");
        produto_m2.setNome("Agua Namacha 1L");

        et2.commit();
        et1.commit();

    }
}
