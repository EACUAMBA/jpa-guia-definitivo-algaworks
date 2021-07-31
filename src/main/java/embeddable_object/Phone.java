package embeddable_object;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
public class Phone {
    @Column(name= "country_code")
    private String countryCode;

    @Column(name = "operator_code")
    private String operatorCode;

    @Column(name = "phone")
    private String phone;

    public Phone() {
    }

    public Phone(String countryCode, String operatorCode, String phone) {
        this.countryCode = countryCode;
        this.operatorCode = operatorCode;
        this.phone = phone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
