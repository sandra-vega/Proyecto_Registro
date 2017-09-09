package com.example.sandra.proyecto_registro;

import java.io.Serializable;

/**
 * Created by sandra on 07/09/2017.
 */

public class pojos implements Serializable {
    private String Usuario;
    private String Email;
    private String Twitter;
    private String Tel;
    private String FechaN;

    public pojos() {
    }

    @Override
    public String toString() {
        return Usuario + "\n" + Email;
    }

    public pojos(String usuario, String email, String twitter, String tel, String fechaN) {
        Usuario = usuario;
        Email = email;
        Twitter = twitter;
        Tel = tel;
        FechaN = fechaN;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String twitter) {
        Twitter = twitter;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getFechaN() {
        return FechaN;
    }

    public void setFechaN(String fechaN) {
        FechaN = fechaN;
    }
}
