package context._7_6_funcoes;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class Funcoes {
    private final EntityManager entityManager;

    public Funcoes(){
        entityManager = JpaUtil.getEntityManager();




    }

    public void exemplo1(){
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Veiculo> cq = cb.createQuery(Veiculo.class);

        Root<Veiculo> veiculoRoot = cq.from(Veiculo.class);

        //Criando um predicado, obtendo um predicado do CriteriBuilder com o method equal, passando no method como primeiro parametro o campo do Root que será usado na comparacao e o outro o valor variavel que será usado para comparar.
        Predicate predicate = cb.equal(cb.upper(veiculoRoot.get("modelo")), "Navara".toUpperCase());

        cq.select(veiculoRoot);
        cq.where(predicate);

        TypedQuery<Veiculo> veiculoTypedQuery = this.entityManager.createQuery(cq);

        List<Veiculo> veiculoList = veiculoTypedQuery.getResultList();

        for(Veiculo veiculo: veiculoList){
            System.out.printf(
                    "ID: %d%nModelo: %s%nNome Proprietario: %s",
                    veiculo.getId(), veiculo.getModelo(), veiculo.getProprietario().getNome()
            );
        }


    }

    public void exemplo2(){
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<String> cq = cb.createQuery(String.class);

        Root<Veiculo> veiculoRoot = cq.from(Veiculo.class);

        Expression<String> stringExpression = cb.concat(
                cb.concat(
                        veiculoRoot.<String>get("fabricante"),
                        "-"
                ),
                veiculoRoot.<String>get("modelo")
        );

        cq.select(stringExpression);

        TypedQuery<String> stringTypedQuery = this.entityManager.createQuery(cq);

        List<String> veiculoList = stringTypedQuery.getResultList();

        for(String veiculo: veiculoList){
            System.out.println(veiculo);
        }


    }
    public static void main(String[] args) {
        Funcoes funcoes = new Funcoes();
        funcoes.exemplo2();

        funcoes.entityManager.close();
        JpaUtil.close();
    }
}
