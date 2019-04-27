package com.josebaten.pos.core.controller;

import com.josebaten.pos.core.model.Proveedor;
import com.josebaten.pos.core.service.ProveedorService;
import com.josebaten.pos.core.service.ProveedorServiceImpl;
import com.josebaten.pos.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ProveedorController implements Initializable {
    private ProveedorService proveedorService = new ProveedorServiceImpl();
    private ObservableList<Proveedor> lista;    
    private Principal principal;
    @FXML private TableView tblProveedor;
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        proveedorService.findAllProveedor();
        
//        lista = FXCollections.observableArrayList(proveedorService.findAllProveedor());
//        this.tblProveedor.setItems(lista);
    }
    public void setVentanaPrincipalController(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
    
    
    
}
