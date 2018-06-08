/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimos.dao;

import java.net.InetAddress;
import javax.swing.JOptionPane;
import org.apache.derby.drda.NetworkServerControl;

/**
 *
 * @author Tiago D. Teixeira
 */
public class AlgoritimosDB {
    
    private static ThreadLocal<NetworkServerControl> servidordb = new ThreadLocal<NetworkServerControl>();
    private static NetworkServerControl servidor;
    
    public static void algoritimosDB(){
        try{
            //servidor = new NetworkServerControl(InetAddress.getLocalHost(),1527);
            servidor = new NetworkServerControl("localhost","1527");
            servidordb.set(servidor);
            JOptionPane.showMessageDialog(null, "Servidor Estabelecido em " + InetAddress.getLocalHost(), "Endereço do Servidor", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao criar instancia do servidor!", "ERRO!!!!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void iniciarServidor(){
        try{
            servidor.start(null);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Não foi poss�vel iniciar o servidor", "ERRO!!!!!!!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void desligarServidor(){
        try{
           servidor.shutdown();
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "O servidor não foi iniciado", "Serviço não encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
