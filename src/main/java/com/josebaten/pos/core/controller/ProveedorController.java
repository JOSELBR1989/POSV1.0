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
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class ProveedorController implements Initializable {
    private ProveedorService proveedorService = new ProveedorServiceImpl();
    private ObservableList<Proveedor> lista;    
    private Principal principal;
    
    @FXML private TableView<Proveedor> tblProveedor;
    
    @FXML private TableColumn<Proveedor,String> colNit;
    @FXML private TableColumn<Proveedor,String>  colRazonSocial;
    @FXML private TableColumn<Proveedor,String>  colDireccion;
    @FXML private TableColumn<Proveedor,String>  colPaginaWeb;
    @FXML private TableColumn<Proveedor,String>  colContacto;
    
    
    @FXML private TextField txtNit;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtContactoPrincipal;
    @FXML private TextField txtRazonSocial;
    @FXML private TextField txtPaginaWeb;
            
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
        
        
        tblProveedor.getSelectionModel().selectedItemProperty().addListener(newSelection ->{seleccionar();});
    }
    
    public void seleccionar()
    {
        txtNit.setText(this.tblProveedor.getSelectionModel().getSelectedItem().getNit());
        txtDireccion.setText(this.tblProveedor.getSelectionModel().getSelectedItem().getDireccion());
        txtContactoPrincipal.setText(this.tblProveedor.getSelectionModel().getSelectedItem().getContactoPrincipal());
        txtRazonSocial.setText(this.tblProveedor.getSelectionModel().getSelectedItem().getRazonSocial());
        txtPaginaWeb.setText(this.tblProveedor.getSelectionModel().getSelectedItem().getPaginaWeb());        
    }
    
    public void setVentanaPrincipalController(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
    
    public void nuevo(){
        try
        {    
            Proveedor nuevo = new Proveedor();
            nuevo.setNit(txtNit.getText());
            nuevo.setDireccion(txtDireccion.getText());
            nuevo.setContactoPrincipal(txtContactoPrincipal.getText());
            nuevo.setRazonSocial(txtRazonSocial.getText());
            nuevo.setPaginaWeb(txtPaginaWeb.getText());
            this.proveedorService.saveProveedor(nuevo);
            this.lista.add(nuevo);
            JOptionPane.showMessageDialog(null,"Registro almacenado correctamente" );
            
            txtNit.setText("");
            txtDireccion.setText("");
            txtContactoPrincipal.setText("");
            txtRazonSocial.setText("");
            txtPaginaWeb.setText("");
            
            
            
            
            
            
            
            
            
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al registrar el dato" );
        
        }
    }
    
    
    
}
