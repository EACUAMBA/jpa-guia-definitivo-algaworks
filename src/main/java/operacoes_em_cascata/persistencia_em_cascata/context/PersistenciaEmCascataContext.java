package operacoes_em_cascata.persistencia_em_cascata.context;

import operacoes_em_cascata.persistencia_em_cascata.model.Categoria;
import operacoes_em_cascata.persistencia_em_cascata.model.Produto;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Arrays;

public class PersistenciaEmCascataContext {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

//        adicionarProdutoComCategoriaNova(em);
        adicionarCategoriaComProdutoNovo(em);

        em.close();
        JpaUtil.close();
    }

    public static void adicionarProdutoComCategoriaNova(EntityManager entityManager){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Produto produto = new Produto();
        produto.setNome("Óleo de Amendoa");

        Categoria categoria = new Categoria();
        categoria.setNome("Cosmeticos");

        produto.setCategoria(categoria);

        entityManager.persist(produto);

        entityTransaction.commit();

    }

    public static void adicionarCategoriaComProdutoNovo(EntityManager entityManager){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Produto produto = new Produto();
        produto.setNome("Bacalhau");

        Categoria categoria = new Categoria();
        categoria.setNome("Alimenticios");

        produto.setCategoria(categoria);

        categoria.setProdutos(Arrays.asList(produto));

        entityManager.persist(categoria);

        entityTransaction.commit();

    }


}
