package com.josebaten.pos.core.service;

import com.josebaten.pos.core.model.Compra;
import java.util.List;

/**
 * @author JOSE BATÉN
 */
public interface CompraService {
    
    public List<Compra> findAllCompra();
    public Compra findById(Long idCompra);
    public void saveCompra(Compra elemento);
    public void deleteCompra(Compra elemento);
    public void updateCompra(Compra elemento);
}
