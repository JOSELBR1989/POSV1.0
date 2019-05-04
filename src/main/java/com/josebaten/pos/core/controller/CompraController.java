package com.josebaten.pos.core.controller;

import com.josebaten.pos.core.model.Compra;
import com.josebaten.pos.core.model.Proveedor;
import com.josebaten.pos.core.service.CompraService;
import com.josebaten.pos.core.service.CompraServiceImpl;
import com.josebaten.pos.core.service.ProveedorService;
import com.josebaten.pos.core.service.ProveedorServiceImpl;
import com.josebaten.pos.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * @author josebaten
 */
public class CompraController implements Initializable {
    private final CompraService compraService = new CompraServiceImpl();
    private ObservableList<Compra> lista;    
    private Principal principals;
//    @FXML private TableView tblCompra;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void setVentanaPrincipalController(Principal principal){
        this.principals = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principals.mostrarVentanaPrincipal();
    }

}
