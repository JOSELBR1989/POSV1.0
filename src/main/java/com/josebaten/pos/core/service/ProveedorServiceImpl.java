package com.josebaten.pos.core.service;

import com.josebaten.pos.core.dao.ProveedorDao;
import com.josebaten.pos.core.dao.ProveedorDaoImpl;
import com.josebaten.pos.core.model.Proveedor;
import java.util.List;

/**
 *
 * @author programacion
 */
public class ProveedorServiceImpl implements ProveedorService{
    
    private final ProveedorDao proveedorDao = new ProveedorDaoImpl();
    

    @Override
    public List<Proveedor> findAllProveedor() {
        return proveedorDao.findAllProveedor();
    }

    @Override
    public Proveedor findById(Long codigoProveedor) {
        return proveedorDao.findById(codigoProveedor);
    }

    @Override
    public void saveProveedor(Proveedor elemento) {
        proveedorDao.saveProveedor(elemento);
    }

    @Override
    public void deleteProveedor(Proveedor elemento) {
        proveedorDao.deleteProveedor(elemento);
    }

    @Override
    public void updateProveedor(Proveedor elemento) {
        proveedorDao.updateProveedor(elemento);
    }
    
}
