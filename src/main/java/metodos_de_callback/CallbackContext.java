package metodos_de_callback;

import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;

public class CallbackContext {
    private static final EntityManager manager;

    static {
        manager = JpaUtil.getEntityManager();
    }


    public static void main(String[] args) {
        executando();

    }

    public static void executando(){
        EntityTransaction et = manager.getTransaction();
        et.begin();

        Animal animal = Animal.builder().designacao("Burro").dataNascimento(LocalDate.of(2000, 10, 27)).build();
        manager.persist(animal);

        System.out.println("A idade é " + animal.getIdade());
        System.out.println("Ultima modificacao: " + animal.getUltimaModificacao());

        et.commit();
        manager.close();
    }
}
