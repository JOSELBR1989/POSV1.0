package com.josebaten.pos.core.service;

import com.josebaten.pos.core.model.Proveedor;
import java.util.List;


public interface ProveedorService {
    
    public List<Proveedor> findAllProveedor();

    public Proveedor findById(Long codigoProveedor);

    public void saveProveedor(Proveedor elemento);

    public void deleteProveedor(Proveedor elemento);

    public void updateProveedor(Proveedor elemento);

}
