/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josebaten.pos.core.service;

import com.josebaten.pos.core.dao.ClienteDao;
import com.josebaten.pos.core.dao.ClienteDaoImpl;
import com.josebaten.pos.core.model.Cliente;
import java.util.List;

/**
 *
 * @author josebaten
 */
public class ClienteServiceImpl implements ClienteService {
    private final ClienteDao clienteDao = new ClienteDaoImpl();

    @Override
    public List<Cliente> findAllCliente() {
        return clienteDao.findAllCliente();
    }

    @Override
    public Cliente findById(String nit) {
        return clienteDao.findById(nit);
    }

    @Override
    public void saveCliente(Cliente elemento) {
        clienteDao.saveCliente(elemento);
    }

    @Override
    public void deleteCliente(Cliente elemento) {
        clienteDao.deleteCliente(elemento);
    }

    @Override
    public void updateCliente(Cliente elemento) {
        clienteDao.updateCliente(elemento);
    }
    
}
