/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josebaten.pos.core.service;

import com.josebaten.pos.core.dao.CompraDao;
import com.josebaten.pos.core.dao.CompraDaoImpl;
import com.josebaten.pos.core.model.Compra;
import java.util.List;

/**
 *
 * @author josebaten
 */
public class CompraServiceImpl implements CompraService {
    private final CompraDao compraDao = new CompraDaoImpl();
    
    @Override
    public List<Compra> findAllCompra() {
        return compraDao.findAllCompra();
    }

    @Override
    public Compra findById(Long idCompra) {
        return compraDao.findById(idCompra); 
    }

    @Override
    public void saveCompra(Compra elemento) {
        compraDao.saveCompra(elemento);
    }

    @Override
    public void deleteCompra(Compra elemento) {
        compraDao.deleteCompra(elemento);
    }

    @Override
    public void updateCompra(Compra elemento) {
        compraDao.updateCompra(elemento);
    }
    
}
