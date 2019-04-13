package com.josebaten.pos.core.service;

import com.josebaten.pos.core.model.Factura;
import java.util.List;

/**
 * @author JOSE BATEN
 */
public interface FacturaService {
    
    public List<Factura> findAllFactura();
    
    public Factura findById(Long numeroFactura);
    
    public void saveFactura(Factura elemento);
    
    public void deleteFactura(Factura elemento);
    
    public void updateFactura(Factura elemento);
    
}
