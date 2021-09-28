package context._7_2_filtros_e_queries_dinamicas.queries_dinamicas;

import domain.model.TipoCombustivel;
import domain.model.Veiculo;
import org.hibernate.Criteria;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class QueriesDinamicasContext {
    private static final EntityManager entityManager = JpaUtil.getEntityManager();
    public static void main(String[] args) {
        TipoCombustivel tipoCombustivel = TipoCombustivel.ALCOOL;
        BigDecimal valor = BigDecimal.valueOf(500_000D);

        List<Veiculo> veiculoList = pesquisarVeiculos(tipoCombustivel, valor);

        for (Veiculo veiculo: veiculoList){
            System.out.println("\n" +
                    " ID " + veiculo.getId()+
                    " Modelo: " + veiculo.getModelo()
                    + "\n");
        }

    }

    public static List<Veiculo> pesquisarVeiculos(TipoCombustivel tipoCombustivel, BigDecimal maiorValor){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Veiculo> veiculoCriteriaQuery = criteriaBuilder.createQuery(Veiculo.class);

        Root<Veiculo> veiculoRoot = veiculoCriteriaQuery.from(Veiculo.class);

        veiculoCriteriaQuery.select(veiculoRoot);

        List<Predicate> predicateList = new ArrayList<>();

        if(tipoCombustivel != null){
            ParameterExpression<TipoCombustivel> tipoCombustivelParameterExpression = criteriaBuilder.parameter(TipoCombustivel.class, "tipoCombustivel");
            predicateList.add(criteriaBuilder.equal(veiculoRoot.get("tipoCombustivel"), tipoCombustivelParameterExpression));
        }

        if(maiorValor != null){
            ParameterExpression<BigDecimal> bigDecimalParameterExpression = criteriaBuilder.parameter(BigDecimal.class, "valor");
            predicateList.add(criteriaBuilder.lessThanOrEqualTo(veiculoRoot.<BigDecimal>get("valor"), bigDecimalParameterExpression));
        }

        veiculoCriteriaQuery.where(predicateList.toArray(new Predicate[0]));

        TypedQuery<Veiculo> veiculoTypedQuery = entityManager.createQuery(veiculoCriteriaQuery);

        if(tipoCombustivel != null){
            veiculoTypedQuery.setParameter("tipoCombustivel", tipoCombustivel);
        }

        if(maiorValor != null){
            veiculoTypedQuery.setParameter("valor", maiorValor);
        }

        List<Veiculo> veiculoList = veiculoTypedQuery.getResultList();

        return veiculoList;
    }

}
