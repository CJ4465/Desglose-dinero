
package com.mycompany.gastos_semana;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class GastosController implements Initializable {

    @FXML
    private TextField txtAlimentos;
    @FXML
    private TextField txtRefrigerios;
    @FXML
    private TextField txtTransporte;
    @FXML
    private TextField txtTelefonia;
    @FXML
    private TextField txtOtros;
    @FXML
    private TextField txtTotalSemanal;
    @FXML
    private TextField txtGastoAlto;
    @FXML
    private Button btnCalcular;
    @FXML
    private Button btnLimpiar;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void calcularEstadisticas(ActionEvent event) {
        try {
            double alimentacion = leerCampo(txtAlimentos);
            double refrigerios = leerCampo(txtRefrigerios);
            double transporte = leerCampo(txtTransporte);
            double telefonia = leerCampo(txtTelefonia);
            double otros = leerCampo(txtOtros);

            double total = alimentacion + refrigerios + transporte + telefonia + otros;
            txtTotalSemanal.setText(String.valueOf(total));

            double mayor = alimentacion;
            String nombreMayor = "Alimentación";

            if (refrigerios > mayor) {
                mayor = refrigerios;
                nombreMayor = "Refrigerios";
            }
            if (transporte > mayor) {
                mayor = transporte;
                nombreMayor = "Transporte";
            }
            if (telefonia > mayor) {
                mayor = telefonia;
                nombreMayor = "Telefonía";
            }
            if (otros > mayor) {
                mayor = otros;
                nombreMayor = "Otros";
            }

            txtGastoAlto.setText(nombreMayor);

        } catch (NumberFormatException e) {
            txtTotalSemanal.setText("Error");
            txtGastoAlto.setText("Revise datos");
        }
    }
    
    private double leerCampo(TextField txt) {
        String texto = txt.getText().trim();
        if (texto.isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(texto);
    }

    @FXML
    private void limpiarCampos(ActionEvent event) {
        txtAlimentos.setText("");
        txtRefrigerios.setText("");
        txtTransporte.setText("");
        txtTelefonia.setText("");
        txtOtros.setText("");
        txtTotalSemanal.setText("");
        txtGastoAlto.setText("");
        txtAlimentos.requestFocus();
    }
}
