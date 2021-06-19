package model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CarId implements Serializable {
    private String provincia;
    private String matricula;

    public CarId(){

    }

    public CarId(String provincia, String matricula){
        this.matricula = matricula;
        this.provincia = provincia;
    }

    public void setProvincia(String provincia){
        this.provincia = provincia;
    }
    public String getProvincia(){
        return this.provincia;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public String getMatricula(){
        return this.matricula;
    }
}
