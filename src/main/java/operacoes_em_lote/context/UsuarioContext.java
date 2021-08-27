package operacoes_em_lote.context;

import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class UsuarioContext {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

//        actualizarEmLote(em);
        removerTodosFalsos(em);

        em.close();
        JpaUtil.close();

    }

    public static void actualizarEmLote(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query =em.createQuery("update operacoes_em_lote_usuario set estado = false where email like :email");
        query.setParameter("email", "%@gmail.com");

        int linhasafect = query.executeUpdate();

        System.out.println("foram afectadas: " + linhasafect + " linhas");

        et.commit();
    }
    public static void removerTodosFalsos(EntityManager em){
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query = em.createQuery("DELETE from operacoes_em_lote_usuario where estado = :estado");
        query.setParameter("estado", false);
int linhasafect = query.executeUpdate();

        System.out.println("foram afectadas: " + linhasafect + " linhas");

        et.commit();
    }
}
