package algoritimos.controle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

/**
 *
 * @author Tiago D. Teixeira
 */
public class ControleInstancias {

    private static final WindowCloseListener LISTENER = new WindowCloseListener();
    private static final Map<String, Object> INSTANCIAS = new HashMap();

    public static void setControleInstancias(String nome, Object object) {
        INSTANCIAS.put(nome, object);
        if (object instanceof JFrame) {
            JFrame frame = (JFrame) object;
            frame.addWindowListener(LISTENER);
        }
    }

    public static Object getInstance(String nome) {
        return INSTANCIAS.get(nome);
    }

    public static void removeInstance(String nome) {
        INSTANCIAS.remove(nome);
    }

    private static class WindowCloseListener extends WindowAdapter {

        public WindowCloseListener() {
            super();
        }

        @Override
        public void windowClosed(WindowEvent e) {
            if (e.getID() == WindowEvent.WINDOW_CLOSED) {
                removeInstance(e.getSource().getClass().getName());
            }
        }
    }

}
