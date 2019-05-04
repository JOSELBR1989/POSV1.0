package com.josebaten.pos.core.model;


import javafx.beans.property.StringProperty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "select p from Proveedor p"),
    @NamedQuery(name = "Proveedor.findAllOrderByNit", query = "select p from Proveedor p order by p.nit"),
    @NamedQuery(name = "Proveedor.findByCodigoProveedor", query = "select p from Proveedor p where p.codigoProveedor = ?1")// metodo de prueba
})
public class Proveedor implements Serializable {

    
    private final LongProperty codigoProveedor;

    private final StringProperty nit;

    private final StringProperty razonSocial;

    private final StringProperty direccion;

    private final StringProperty paginaWeb;

    private final StringProperty contactoPrincipal;

    public Proveedor() {
        this.codigoProveedor = new SimpleLongProperty();
        this.nit = new SimpleStringProperty();
        this.razonSocial = new SimpleStringProperty();
        this.direccion = new SimpleStringProperty();
        this.paginaWeb = new SimpleStringProperty();
        this.contactoPrincipal = new SimpleStringProperty();
    }

    public Proveedor(Long codigoProveedor, String nit, String razonSocial, String direccion, String paginaWeb, String contactoPrincipal) {
        this.codigoProveedor = new SimpleLongProperty(codigoProveedor);
        this.nit = new SimpleStringProperty(nit);
        this.razonSocial = new SimpleStringProperty(razonSocial);
        this.direccion = new SimpleStringProperty(direccion);
        this.paginaWeb = new SimpleStringProperty(paginaWeb);
        this.contactoPrincipal = new SimpleStringProperty(contactoPrincipal);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_proveedor")
    public Long getCodigoProveedor() {
        return codigoProveedor.get();
    }
    public LongProperty codigoProveedor()
    {
        return this.codigoProveedor;
    }
    public void setCodigoProveedor(Long codigoProveedor) {
        this.codigoProveedor.set(codigoProveedor);
    }

    @Column(name = "nit")
    public String getNit() {
        return nit.get();
    }
    
    public StringProperty nit()
    {
        return this.nit;
    }
    

    public void setNit(String nit) {
        this.nit.set(nit);
    }

    @Column(name = "razon_social")
    public String getRazonSocial() {
        return razonSocial.get();
    }
    public StringProperty razonSocial()
    {
        return this.razonSocial;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial.set(razonSocial);
    }

    @Column(name = "direccion")
    public String getDireccion() {
        return direccion.get();
    }
    public StringProperty direccion(){
        return this.direccion;
    }
    
    
    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    @Column(name = "pagina_web")
    public String getPaginaWeb() {
        return paginaWeb.get();
    }
    public StringProperty paginaWeb()
    {
        return this.paginaWeb;
    }
    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb.set(paginaWeb);
    }

    @Column(name = "contacto_principal")
    public String getContactoPrincipal() {
        return contactoPrincipal.get();
    }
    
    public StringProperty contactoPrincipal()
    {
        return this.contactoPrincipal;
    }

    public void setContactoPrincipal(String contactoPrincipal) {
        this.contactoPrincipal.set( contactoPrincipal);
    }

}
