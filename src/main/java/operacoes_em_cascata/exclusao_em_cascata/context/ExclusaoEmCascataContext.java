package operacoes_em_cascata.exclusao_em_cascata.context;

import operacoes_em_cascata.exclusao_em_cascata.model.Categoria;
import operacoes_em_cascata.exclusao_em_cascata.model.Produto;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Arrays;

public class ExclusaoEmCascataContext {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

//        excluindoCategorias_SeusProdutos(em);
        excluindoObjectosOrfaos(em);

        em.close();
        JpaUtil.close();
    }

    public static void excluindoCategorias_SeusProdutos(EntityManager entityManager){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Categoria categoria = entityManager.find(Categoria.class, 10L);

        System.out.println("Nome da categoria: " + categoria.getNome());
        System.out.println("Apagando ela.");
        entityManager.remove(categoria);


        entityTransaction.commit();

    }

    public static void excluindoObjectosOrfaos(EntityManager entityManager){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Produto produto = entityManager.find(Produto.class, 4L);
        Categoria categoria = entityManager.find(Categoria.class, 20L);

        System.out.println("produto: " + produto.getNome() + " id: " + produto.getId());
        System.out.println("categoria: " +categoria.getNome() + " id: " + categoria.getId());

        System.out.println("removeu? " +categoria.getProdutos().remove(produto));

        entityTransaction.commit();

    }


}
