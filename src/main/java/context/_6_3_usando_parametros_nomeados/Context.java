package context._6_3_usando_parametros_nomeados;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Context {
    public static void main(String[] args) {
        //Usar o sistema de paramentros do JPA nos ajuda a evitar o SQLInjection, pois o proprio JPA faz o tratamento, sanetização dos dados.

        Scanner scanner = new Scanner(System.in);
        System.out.println("insira o numero do carro que quer ver as especificacões: ");
        Long id = Long.parseLong(scanner.next());

        EntityManager entityManager = JpaUtil.getEntityManager();

        //Para criar uma parametro devemos adicionar : (dois pontos) antes do nome do parametros que queremos fazer o bind (vinculacao).
        Query query = entityManager.createQuery("select  v from Veiculo v where v.id = :id");

        //Para usar esse parametro devemos chamar o metodo .setParameter() da class Query e o primeiro parametro é uma String com o nome do paramentor que queremos utilizar.
        query.setParameter("id", id);

        Veiculo veiculo = (Veiculo) query.getSingleResult();
        System.out.println("id: " + veiculo.getId());
        System.out.println("Fabricante: " + veiculo.getFabricante());
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Preço: " + NumberFormat.getInstance(new Locale("pt", "mz")).format(veiculo.getValor()));
        System.out.println();

        entityManager.close();
        JpaUtil.close();
    }
}
