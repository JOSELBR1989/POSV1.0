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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class ProveedorController implements Initializable {
    private ProveedorService proveedorService = new ProveedorServiceImpl();
    private ObservableList<Proveedor> lista;    
    private Principal principal;
    
    private enum tipo {
        NUEVO,CANCELAR,GUARDAR,NINGUNO,MODIFICAR, GUARDAR_ACTUALIZACION
    }
    
    private tipo tipoOperacion = tipo.NINGUNO;
    
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
    
    
    @FXML private Button btnNuevo; 
    @FXML private Button btnGuardar; 
    @FXML private Button btnEliminar; 
    @FXML private Button btnModificar;
    @FXML private Button btnReporte; 
    @FXML private Button btnSalir;
            
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
        if(this.tblProveedor.getSelectionModel().getSelectedItem() != null){
            txtNit.setText(this.tblProveedor.getSelectionModel().getSelectedItem().getNit());
            txtDireccion.setText(this.tblProveedor.getSelectionModel().getSelectedItem().getDireccion());
            txtContactoPrincipal.setText(this.tblProveedor.getSelectionModel().getSelectedItem().getContactoPrincipal());
            txtRazonSocial.setText(this.tblProveedor.getSelectionModel().getSelectedItem().getRazonSocial());
            txtPaginaWeb.setText(this.tblProveedor.getSelectionModel().getSelectedItem().getPaginaWeb());        
        }
    }
    
    public void setVentanaPrincipalController(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
    
    void limpiar(){
        txtNit.setText("");
        txtDireccion.setText("");
        txtContactoPrincipal.setText("");
        txtRazonSocial.setText("");
        txtPaginaWeb.setText("");
    }
    
    public void activarDesactivarControles(Boolean tipo)
    {
        this.txtNit.setEditable(tipo);
        this.txtDireccion.setEditable(tipo);
        this.txtContactoPrincipal.setEditable(tipo);
        this.txtRazonSocial.setEditable(tipo);
        this.txtPaginaWeb.setEditable(tipo);
    }
    
    public void modificar()
    {
        if(this.tblProveedor.getSelectionModel().getSelectedItem()!= null)
        {
            this.activarDesactivarControles(Boolean.TRUE);
            this.tipoOperacion = tipoOperacion.MODIFICAR;
            this.btnNuevo.setText("Cancelar");
            this.btnGuardar.setDisable(false);
            this.btnEliminar.setDisable(true);
            this.btnModificar.setDisable(true);
            this.btnReporte.setDisable(true);
            this.btnSalir.setDisable(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"debe seleccionar un registro" );             
        }
    }
    
    public void nuevo(){
        
        switch(tipoOperacion){
            case NINGUNO:
                this.activarDesactivarControles(true);
                this.limpiar();
                this.btnNuevo.setText("Cancelar");
                this.btnGuardar.setDisable(false);
                this.btnEliminar.setDisable(true);
                this.btnModificar.setDisable(true);
                this.btnReporte.setDisable(true);
                this.btnSalir.setDisable(true);
                this.tipoOperacion = tipo.NUEVO;
                break;
            case NUEVO:
                this.activarDesactivarControles(true);
                this.limpiar();
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnSalir.setDisable(false);
                this.tipoOperacion = tipo.NINGUNO;
                break;
            case MODIFICAR:
                this.activarDesactivarControles(Boolean.FALSE);
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnSalir.setDisable(false);
                this.tipoOperacion = tipo.NINGUNO;
                break;
        }
    }
    
    public void Eliminar(){
        if(this.tblProveedor.getSelectionModel().getSelectedItem()!= null)
        {
            if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿desea continuar?",
            "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){

                Proveedor elemento = tblProveedor.getSelectionModel().getSelectedItem();
                this.proveedorService.deleteProveedor(elemento);
                this.tblProveedor.getItems().remove(elemento);
                JOptionPane.showMessageDialog(null,"Registro eliminado!" );             
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null,"Seleccione un registro para elimiar" );             

        }
        
    }
    
    public void Guardar()
    {
            switch(tipoOperacion){
                case NUEVO:
                        Proveedor nuevo = new Proveedor();
                        nuevo.setNit(txtNit.getText());
                        nuevo.setDireccion(txtDireccion.getText());
                        nuevo.setContactoPrincipal(txtContactoPrincipal.getText());
                        nuevo.setRazonSocial(txtRazonSocial.getText());
                        nuevo.setPaginaWeb(txtPaginaWeb.getText());
                        this.proveedorService.saveProveedor(nuevo);
                        this.lista.add(nuevo);
                        JOptionPane.showMessageDialog(null,"Registro almacenado correctamente" );             
                        this.btnNuevo.setText("Nuevo");
                        this.btnGuardar.setDisable(true);
                        this.btnEliminar.setDisable(false);
                        this.btnModificar.setDisable(false);
                        this.btnReporte.setDisable(false);
                        this.btnSalir.setDisable(false);
                        this.activarDesactivarControles(false);
                        
                    break;
                case MODIFICAR:
                    Proveedor proveedor = tblProveedor.getSelectionModel().getSelectedItem();
                    proveedor.setNit(txtNit.getText());
                    proveedor.setDireccion(txtDireccion.getText());
                    proveedor.setContactoPrincipal(txtContactoPrincipal.getText());
                    proveedor.setRazonSocial(txtRazonSocial.getText());
                    proveedor.setPaginaWeb(txtPaginaWeb.getText());
                    this.proveedorService.updateProveedor(proveedor);
                    lista.set(tblProveedor.getSelectionModel().getSelectedIndex(),proveedor);
                    JOptionPane.showMessageDialog(null,"Registro almacenado correctamente" );             
                    this.tipoOperacion = tipo.MODIFICAR;
                    nuevo();


                    break;
            }
            this.tipoOperacion = tipo.NINGUNO;
    }
    
    
    
}
