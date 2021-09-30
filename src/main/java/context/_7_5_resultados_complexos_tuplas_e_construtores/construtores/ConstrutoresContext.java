package context._7_5_resultados_complexos_tuplas_e_construtores.construtores;

import domain.dto.PrecoVeiculo;
import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public class ConstrutoresContext {
    private EntityManager entityManager;

    public ConstrutoresContext(){
        this.entityManager = JpaUtil.getEntityManager();

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<PrecoVeiculo> precoVeiculoCriteriaQuery = criteriaBuilder.createQuery(PrecoVeiculo.class);

        Root<Veiculo> veiculoRoot = precoVeiculoCriteriaQuery.from(Veiculo.class);

        precoVeiculoCriteriaQuery.select(criteriaBuilder.construct(PrecoVeiculo.class,veiculoRoot.<Long>get("id"), veiculoRoot.<String>get("modelo"), veiculoRoot.<BigDecimal>get("valor")));

        TypedQuery<PrecoVeiculo> precoVeiculoTypedQuery = this.entityManager.createQuery(precoVeiculoCriteriaQuery);

        List<PrecoVeiculo> precoVeiculoList = precoVeiculoTypedQuery.getResultList();

        for(PrecoVeiculo precoVeiculo: precoVeiculoList){
            System.out.println(
                    "\nID: " + precoVeiculo.getId() +
                    "\nModelo: " + precoVeiculo.getModelo()
                    + "\nValor: " + precoVeiculo.getValor()
            );
        }


    }

    public static void main(String[] args) {
        new ConstrutoresContext();
    }
}
