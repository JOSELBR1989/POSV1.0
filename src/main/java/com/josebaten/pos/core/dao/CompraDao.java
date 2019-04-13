package com.josebaten.pos.core.dao;

import com.josebaten.pos.core.model.Compra;
import java.util.List;

/**
 * @author JOSE BATEN
 */
public interface CompraDao {

    public List<Compra> findAllCompra();
    public Compra findById(Long idCompra);
    public void saveCompra(Compra elemento);
    public void deleteCompra(Compra elemento);
    public void updateCompra(Compra elemento);
}
