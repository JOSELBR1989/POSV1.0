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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ProveedorController implements Initializable {
    private ProveedorService proveedorService = new ProveedorServiceImpl();
    private ObservableList<Proveedor> lista;    
    private Principal principal;
    
    @FXML private TableView tblProveedor;
    
    @FXML private TableColumn<Proveedor,String> colNit;
    @FXML private TableColumn<Proveedor,String>  colRazonSocial;
    @FXML private TableColumn<Proveedor,String>  colDireccion;
    @FXML private TableColumn<Proveedor,String>  colPaginaWeb;
    @FXML private TableColumn<Proveedor,String>  colContacto;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        proveedorService.findAllProveedor();
        
        lista = FXCollections.observableArrayList(proveedorService.findAllProveedor());
        this.tblProveedor.setItems(lista);
        this.colNit.setCellValueFactory(cellValue->cellValue.getValue().nit());
        this.colRazonSocial.setCellValueFactory(cellValue->cellValue.getValue().razonSocial());
        this.colDireccion.setCellValueFactory(cellValue->cellValue.getValue().direccion());
        this.colPaginaWeb.setCellValueFactory(cellValue->cellValue.getValue().paginaWeb());
        this.colContacto.setCellValueFactory(cellValue->cellValue.getValue().contactoPrincipal());
        
    }
    
    
    public void setVentanaPrincipalController(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
    
    
    
}
