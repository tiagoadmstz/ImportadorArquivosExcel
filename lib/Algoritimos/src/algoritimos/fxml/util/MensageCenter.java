/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimos.fxml.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Tiago D. Teixeira
 */
public class MensageCenter {

    public static void getErrorMensage(String mensagemErro) {
        Alert da = new Alert(Alert.AlertType.ERROR);
        da.setTitle("Erro!");
        da.setHeaderText("Ocorreu um erro ao executar operação!");
        da.setContentText(mensagemErro);
        da.showAndWait();
    }

    public static boolean getCloseSystemMensage() {
        Alert da = new Alert(Alert.AlertType.CONFIRMATION,
                "Deseja realmente fechar o sistema?",
                ButtonType.YES, ButtonType.NO);
        da.setTitle("Fechar Sistema");
        da.showAndWait();
        return da.getResult() == ButtonType.YES;
    }

}
