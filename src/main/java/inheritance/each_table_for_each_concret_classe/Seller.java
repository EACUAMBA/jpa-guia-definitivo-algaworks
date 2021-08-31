package inheritance.each_table_for_each_concret_classe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "seller_each_table_for_each_concret_classe")
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
