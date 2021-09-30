package context._7_5_resultados_complexos_tuplas_e_construtores.lista_de_object;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListaDeObjectContext {
    private final EntityManager entityManager;

    public ListaDeObjectContext(){
        this.entityManager = JpaUtil.getEntityManager();

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);

        Root<Veiculo> veiculoRoot = criteriaQuery.from(Veiculo.class);

        criteriaQuery.multiselect(veiculoRoot.get("modelo"), veiculoRoot.<BigDecimal>get("valor"));

        TypedQuery<Object[]> typedQuery = this.entityManager.createQuery(criteriaQuery);

        List<Object[]> objectList = typedQuery.getResultList();

        for(Object[] objects : objectList){
            System.out.println(
                    "modelo " + objects[0]+
                    "\nvalor " + NumberFormat.getInstance(new Locale("PT", "MZ")).format(((BigDecimal)objects[1]).doubleValue())
            );
        }
    }

    public static void main(String[] args) {
        new ListaDeObjectContext();
    }
}
