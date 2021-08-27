package eager_and_lazy_loading.context;

import eager_and_lazy_loading.model.Categoria;
import eager_and_lazy_loading.model.Produto;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CarregamentoBurroCarregamentoAstutoContext {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        //LazyLoading(em);
        //quando fazemos um carregamento eager (ansioso) ele vai trazer todos os dados mesmo se essses dados nao forem necessarios para frente
        //LazyLoading_ComObjectoDetached(em);

        EagerLoading(em);
        em.close();
        JpaUtil.close();
    }

    public static void EagerLoading(EntityManager em){
        Categoria categoria = em.find(Categoria.class, 30L);

        System.out.println("Nome da categoria: " + categoria.getNome());

        for (Produto produto : categoria.getProdutos())
            System.out.println("Produto: " + produto.getNome());
    }

    private static void LazyLoading_ComObjectoDetached(EntityManager em){
        EntityTransaction et = em.getTransaction();

        Produto produto = em.find(Produto.class, Long.valueOf(3));

        System.out.println("Desamarando o objecto!");
        em.detach(produto); // poderia ser o em.Close mesmo
        em.close();

        //Com lazy loading o jpa so carrega o que for necessario, sem o relacionamento que usa lazy loading. mas se tentarmos usar a categoria vamos ver que ele vai gerar uma nova consulta.

        if (produto != null) {
            System.out.println("Nome do produto: " + produto.getNome());



            System.out.println("Categoria: " + produto.getCategoria().getNome());
        }else
            System.out.println("Produto nao foi achado!");


    }

    private static void LazyLoading(EntityManager em){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Produto produto = em.find(Produto.class, Long.valueOf(3));

        //Com lazy loading o jpa so carrega o que for necessario, sem o relacionamento que usa lazy loading. mas se tentarmos usar a categoria vamos ver que ele vai gerar uma nova consulta.

        if (produto != null) {
            System.out.println("Nome do produto: " + produto.getNome());
            System.out.println("Categoria: " + produto.getCategoria().getNome());
        }else
            System.out.println("Produto nao foi achado!");

        et.commit();
    }

}
