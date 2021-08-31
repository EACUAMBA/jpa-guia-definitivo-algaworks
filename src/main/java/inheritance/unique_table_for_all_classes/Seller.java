package inheritance.unique_table_for_all_classes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "seller_unique_table_for_all_classes")
@DiscriminatorValue(value = "Seller")
public class Seller extends Person{
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
