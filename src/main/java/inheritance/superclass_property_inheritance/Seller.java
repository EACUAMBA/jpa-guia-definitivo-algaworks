package inheritance.superclass_property_inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "seller_superclass_property_inheritance")
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
