/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josebaten.pos.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author josebaten
 */
@Entity
@Table(name="compras")
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numero_factura")
    private Long numeroFactura; 
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nit")
    private Cliente cliente; 
    
    @Column(name="fecha")
    private Date fecha; 
    
    @Column(name="total")
    private Double total;

    public Factura() {
    }

    public Factura(Long numeroFactura, Cliente cliente, Date fecha, Double total) {
        this.numeroFactura = numeroFactura;
        this.cliente = cliente;
        this.fecha = fecha;
        this.total = total;
    }

    public Long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
 
    
    
}
