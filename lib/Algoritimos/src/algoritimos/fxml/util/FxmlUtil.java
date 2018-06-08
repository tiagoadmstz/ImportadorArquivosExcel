/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimos.fxml.util;

/**
 *
 * @author tiago.teixeira
 */
public class FxmlUtil {
    
    public static void fecharSistema() {
        if(MensageCenter.getCloseSystemMensage()){
            System.exit(0);
        }
    }
    
}
