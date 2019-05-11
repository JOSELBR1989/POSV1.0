package com.josebaten.pos.core.model;

import java.io.Serializable;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="telefono_proveedor")
public class TelefonoProveedor implements Serializable {
    
//    private final LongProperty codigoTelefono;
//    private final StringProperty numero;
//    private final StringProperty descripcion;
//    
//    private Proveedor proveedor;
//    
//
//    public TelefonoProveedor() {
//        this.codigoTelefono = new SimpleLongProperty();
//        this.numero = new SimpleStringProperty();
//        this.descripcion = new SimpleStringProperty();
//    }
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "codigo_telefono")
//    public Long getCodigoTelefono() {
//        return codigoTelefono.get();
//    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_telefono")
    private Long codigoTelefono;
    
    @Column(name="numero")
    private String numero;
    
    @Column(name="descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="codigo_proveedor")
    private Proveedor proveedor;

    
}
