package com.josebaten.pos.core.dao;

import com.josebaten.pos.core.db.Conexion;
import com.josebaten.pos.core.model.Cliente;
import java.util.List;

/**
 * @author JOSE BATÉN
 */
public class ClienteDaoImpl implements ClienteDao {

    @Override
    public List<Cliente> findAllCliente() {
        return (List<Cliente>)Conexion.getInstancia().findAll(Cliente.class);
    }

    @Override
    public Cliente findById(String nit) {
        return (Cliente)Conexion.getInstancia().findById(Cliente.class, nit);
    }

    @Override
    public void saveCliente(Cliente elemento) {
        Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteCliente(Cliente elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateCliente(Cliente elemento) {
        Conexion.getInstancia().update(elemento);
    }
    
}
