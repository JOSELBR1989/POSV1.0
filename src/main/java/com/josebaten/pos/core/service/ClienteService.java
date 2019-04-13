/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josebaten.pos.core.service;

import com.josebaten.pos.core.model.Cliente;
import java.util.List;

/**
 *
 * @author josebaten
 */
public interface ClienteService {
    
    public List<Cliente> findAllCliente();

    public Cliente findById(String nit);

    public void saveCliente(Cliente elemento);

    public void deleteCliente(Cliente elemento);

    public void updateCliente(Cliente elemento);   
}
