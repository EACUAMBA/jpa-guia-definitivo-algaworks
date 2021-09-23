package context._7_1_introducao_a_estrutura_basica;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ConsultaSimplesContext {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        //Pegamos uma instancia do CriteriaBuilder e colocamos em uma interface CriteriaBuilder agora podemos usar essa interface para criar vários objectos queies para fazer varias consultas.
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        //Agora usamos o metodo createQuery(Classe de consulta) para criar uma query
        CriteriaQuery<Veiculo> veiculoCriteriaQuery = criteriaBuilder.createQuery(Veiculo.class);

        //Depois disso vamos chamar o metodo from da nossa query para obtermos um root, uma raiz.
        Root<Veiculo> veiculoRoot = veiculoCriteriaQuery.from(Veiculo.class);

        //Aqui infomamos com o metodo select(Root) o que queremos fazer
        veiculoCriteriaQuery.select(veiculoRoot);


        TypedQuery<Veiculo> veiculoTypedQuery = entityManager.createQuery(veiculoCriteriaQuery);

        List<Veiculo> veiculoList = veiculoTypedQuery.getResultList();

        for (Veiculo veiculo: veiculoList)
            System.out.println("Modelo: " + veiculo.getModelo() + " \nID: " + veiculo.getId());

        entityManager.close();
        JpaUtil.close();
    }
}
