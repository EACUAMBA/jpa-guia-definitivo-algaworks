package inheritance.a_table_for_each_hierarchically_class;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "seller_a_table_for_each_hierarchically_class")
@PrimaryKeyJoinColumn(name = "person_id", referencedColumnName = "id")
public class Seller extends Person {
    @Column(name = "profit_rate")
    private Integer profitRate;

    @Column(name = "sell_sone")
    private String sellZone;

    public Integer getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(Integer profitRate) {
        this.profitRate = profitRate;
    }

    public String getSellZone() {
        return sellZone;
    }

    public void setSellZone(String sellZone) {
        this.sellZone = sellZone;
    }
}
