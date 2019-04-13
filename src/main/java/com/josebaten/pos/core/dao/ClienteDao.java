package com.josebaten.pos.core.dao;

import com.josebaten.pos.core.model.Cliente;
import java.util.List;

/**
 * @author JOSE BATEN
 */
public interface ClienteDao {
    
    public List<Cliente> findAllCliente();

    public Cliente findById(String nit);

    public void saveCliente(Cliente elemento);

    public void deleteCliente(Cliente elemento);

    public void updateCliente(Cliente elemento);
}
