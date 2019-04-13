package com.josebaten.pos.core.sistema;

import com.josebaten.pos.core.controller.ProveedorController;
import com.josebaten.pos.core.controller.VentanaPrincipalController;


import static javafx.application.Application.launch;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Principal extends Application {
    
    private final String PAQUETE_VISTA = "/com/josebaten/pos/core/view/";
    private Stage escenarioPrincipal; 
    
    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        this.escenarioPrincipal = escenarioPrincipal; 
        mostrarVentanaPrincipal();
        //mostrarVentanaProveedores();
        this.escenarioPrincipal.setTitle("Sistema de control de Almacen V. 1.0");
        this.escenarioPrincipal.show();
    }

    public void mostrarVentanaPrincipal() throws IOException{
        VentanaPrincipalController main = (VentanaPrincipalController) cambiarEscena("VentanaPrincipalView.fxml",800,600);
//        main.setPrincipal(this);
    }
    
    public void mostrarVentanaProveedores()throws IOException{
        ProveedorController proveedorController = (ProveedorController)cambiarEscena("ProveedorView.fxml",776,449);
        proveedorController.setVentanaPrincipalController(this);
    }
    
    public Initializable cambiarEscena(String fxml, int ancho, int alto) throws IOException{
        Initializable resultado = null;
        
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource(PAQUETE_VISTA.concat(fxml) ));
        Scene escena = new Scene(root, ancho,alto);
        escena.getStylesheets().add("/styles/Styles.css");
        

        this.escenarioPrincipal.setScene(escena);
        this.escenarioPrincipal.sizeToScene();
        
        resultado= (Initializable)loader.getController();
        
        
        return resultado;
    }
    
    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
