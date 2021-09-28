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

        //Criamos um Criteria Builder para consegurimos criar as queries com o CriteriaQuery
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        //Criamos um query com o tipo de resultado que esperamos, aqui esperamos, esperamos um Veiculo.
        CriteriaQuery<Veiculo> veiculoCriteriaQuery = criteriaBuilder.createQuery(Veiculo.class);

        //Criamos e adicionamos um raiz de pesquisa, que deve corresponder a entidade que vamosdar, damos como parametro a entidade que queremos fazer a pesuqisa.
        Root<Veiculo> veiculoRoot = veiculoCriteriaQuery.from(Veiculo.class);

        //Aqui estamos especificando o item que sera retornado pela queri, que procura que sera resornado< agora será um select.
        veiculoCriteriaQuery.select(veiculoRoot);

        //Criando query.
        TypedQuery<Veiculo> veiculoTypedQuery = entityManager.createQuery(veiculoCriteriaQuery);

        List<Veiculo> veiculoList = veiculoTypedQuery.getResultList();

        for (Veiculo veiculo: veiculoList)
            System.out.println("Modelo: " + veiculo.getModelo() + " \nID: " + veiculo.getId());

        entityManager.close();
        JpaUtil.close();
    }
}
