package modelo;

/**
 * Created by sandra on 11/10/2017.
 */

import java.util.Date;

public class Contacto {


    private long  id;

    public Contacto(long id, String nombre, String correo_electronico) {
        this.id = id;
        this.nombre = nombre;
        this.correo_electronico = correo_electronico;
    }

    public Contacto(String nombre, String correo_electronico, String twitter, String telefono, String fecha_nacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.correo_electronico = correo_electronico;
        this.twitter = twitter;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Contacto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    String nombre;
    String correo_electronico;
    String twitter;
    String telefono;
    String fecha_nacimiento;

    @Override
    public String toString() {
        return this.nombre + "\n" + this.correo_electronico;
    }
}

