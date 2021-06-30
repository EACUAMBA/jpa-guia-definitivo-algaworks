/*
 * Copyright (c) 2021.
 * Feito por Edilson Alexandre Cuamba aos 23/6/2021 4:7:31
 * Desenvolvedor Java | Spring & ZKoss | React JS & Native | UX & UI
 * (+258) 84 24 73 772 & (+258) 82 25 65 148
 * edilsoncuamba@gmail.com
 */

package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Owner implements Serializable {

    @Column(name = "owner_name")
    private String name;

    @Column(name = "owner_phone")
    private String phone;

    @Column(name = "owner_email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String telefone) {
        this.phone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
