package context._7_4_funcoes_agregacao;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.sql.SQLOutput;

public class FuncoesAgregacaoContext {

    private final EntityManager entityManager;

    public FuncoesAgregacaoContext(){
        this.entityManager = JpaUtil.getEntityManager();
    }

    private void UsandoFuncoesDeAgregacao(){
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<BigDecimal> veiculoCriteriaQuery = criteriaBuilder.createQuery(BigDecimal.class); //Definindo o resultado

        Root<Veiculo> veiculoRoot = veiculoCriteriaQuery.from(Veiculo.class); //Definindo a entidade que sera usada na pesuisa, a entidade pivo

        veiculoCriteriaQuery.select(criteriaBuilder.sum(veiculoRoot.<BigDecimal>get("valor")));

        TypedQuery<BigDecimal> bigDecimalTypedQuery = this.entityManager.createQuery(veiculoCriteriaQuery);

        BigDecimal total= bigDecimalTypedQuery.getSingleResult();

        System.out.println("A soma do precos dos carros é " + total);

    }

    @Override
    protected void finalize() throws Throwable {
        this.entityManager.close();
        JpaUtil.close();
        System.out.println("Objecto Destruido");
        super.finalize();
    }

    public static void main(String[] args) {
        FuncoesAgregacaoContext funcoesAgregacaoContext = new FuncoesAgregacaoContext();
        funcoesAgregacaoContext.UsandoFuncoesDeAgregacao();

    }
}
