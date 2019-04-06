package com.josebaten.pos.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author josebaten
 */
@Entity
@Table(name="cliente")
public class Cliente implements Serializable   {
    @Id
    @Column(name="nit")
    private String nit;
    
    @Column(name="dpi")
    private String dpi; 
    
    @Column(name="nombre")
    private String nombre; 
    
    @Column(name="direccion")
    private String direccion;

    public Cliente() {
    }

    public Cliente(String nit, String dpi, String nombre, String direccion) {
        this.nit = nit;
        this.dpi = dpi;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
