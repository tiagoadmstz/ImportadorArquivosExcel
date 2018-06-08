/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimos.util;

import algoritimos.tabelas.TableModelCBI;
import java.awt.Component;
import java.awt.Container;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author tiago.teixeira
 */
public class ManipulaFrames {

    public static void setFildsEnableDisable(JFrame form, boolean enable) {

        for (Component comp : form.getComponents()) {
            comp.setEnabled(enable);
        }

    }

    public static void buttonsForm(Enum Operacao, Object[] Components) {

        for (Object ob : Components) {
            if (ob instanceof JTextField) {
                JTextField txt = (JTextField) ob;
                switch (Operacao.ordinal()) {
                    case 0: //new
                        txt.setText("");
                        txt.setEnabled(true);
                        break;
                    case 1: //cancel
                        //txt.setText("");
                        txt.setEnabled(false);
                        break;
                    case 2: //alter
                        txt.setEnabled(false);
                        break;
                    case 3: //save
                        txt.setEnabled(false);
                        break;
                    case 4: //edit
                        txt.setEnabled(true);
                        break;
                }
            } else if (ob instanceof JComboBox) {
                JComboBox cb = (JComboBox) ob;
                switch (Operacao.ordinal()) {
                    case 0: //new
                        if (cb.getItemCount() > 0) {
                            cb.setSelectedIndex(0);
                        }
                        cb.setEnabled(true);
                        break;
                    case 1: //cancel
                        /*if (cb.getItemCount() > 0) {
                        cb.setSelectedIndex(0);
                        }*/
                        cb.setEnabled(false);
                        break;
                    case 2: //alter
                        cb.setEnabled(false);
                        break;
                    case 3: //save
                        cb.setEnabled(false);
                        break;
                    case 4: //edit
                        cb.setEnabled(true);
                        break;
                }
            } else if (ob instanceof JScrollPane) {
                JScrollPane sp = (JScrollPane) ob;
                if (sp.getViewport().getComponent(0) instanceof JTextArea) {
                    JTextArea ta = (JTextArea) sp.getViewport().getComponent(0);
                    switch (Operacao.ordinal()) {
                        case 0: //new
                            ta.setText("");
                            ta.setEnabled(true);
                            break;
                        case 1: //cancel
                            //ta.setText("");
                            ta.setEnabled(false);
                            break;
                        case 2: //alter
                            ta.setEnabled(false);
                            break;
                        case 3: //save
                            ta.setEnabled(false);
                            break;
                        case 4: //edit
                            ta.setEnabled(true);
                            break;
                    }

                } else if (sp.getViewport().getComponent(0) instanceof JTable) {
                    JTable tb = (JTable) sp.getViewport().getComponent(0);
                    TableModelCBI model = (TableModelCBI) tb.getModel();
                    switch (Operacao.ordinal()) {
                        case 0: //new
                            model.deletarLista();
                            tb.setEnabled(true);
                            break;
                        case 1: //cancel
                            //model.deletarLista();
                            tb.setEnabled(false);
                            break;
                        case 2: //alter
                            tb.setEnabled(false);
                            break;
                        case 3: //save
                            tb.setEnabled(false);
                            break;
                        case 4: //edit
                            tb.setEnabled(true);
                            break;
                    }
                }
            } else if (ob instanceof JButton) {
                JButton bt = (JButton) ob;
                switch (Operacao.ordinal()) {
                    case 0: //new
                        bt.setEnabled(true);
                        break;
                    case 1: //cancel
                        bt.setEnabled(false);
                        break;
                    case 2: //alter
                        bt.setEnabled(false);
                        break;
                    case 3: //save
                        bt.setEnabled(false);
                        break;
                    case 4: //edit
                        bt.setEnabled(true);
                        break;
                }
            } else if (ob instanceof JCheckBox) {
                JCheckBox ck = (JCheckBox) ob;
                switch (Operacao.ordinal()) {
                    case 0: //new
                        ck.setEnabled(true);
                        break;
                    case 1: //cancel
                        ck.setEnabled(false);
                        break;
                    case 2: //alter
                        ck.setEnabled(false);
                        break;
                    case 3: //save
                        ck.setEnabled(false);
                        break;
                    case 4: //edit
                        ck.setEnabled(true);
                        break;
                }
            } else if (ob instanceof JRadioButton) {
                JRadioButton rb = (JRadioButton) ob;
                switch (Operacao.ordinal()) {
                    case 0: //new
                        rb.setEnabled(true);
                        break;
                    case 1: //cancel
                        rb.setEnabled(false);
                        break;
                    case 2: //alter
                        rb.setEnabled(false);
                        break;
                    case 3: //save
                        rb.setEnabled(false);
                        break;
                    case 4: //edit
                        rb.setEnabled(true);
                        break;
                }
            }
        }
    }

    /**
     * Os botões do formulário devem ser adicionados na seguinte ordem 1-novo;
     * 2-cancelar; 3-salvar; 4-editar; 5-fechar; 6-imprimir; 7-deletar
     *
     * @param cdFunction É o código da operação de 0 a 4 (novo, cancelar,
     * alterar, salvar, editar)
     * @param button Lista de botões do formulário
     */
    public static void buttonsEnableOrder(int cdFunction, JButton... button) {

        switch (cdFunction) {
            case 0: //new
                button[0].setEnabled(false); //new
                button[1].setEnabled(true); //cancel
                button[2].setEnabled(true); //alter e save
                button[3].setEnabled(false); //editar
                if ("Alterar".equals(button[2].getText())) {
                    button[2].setText("Salvar");
                    button[2].setActionCommand("salvar");
                }
                button[4].setEnabled(false); //quit
                if (button.length >= 6) {
                    button[5].setEnabled(false); //print
                }
                if (button.length >= 7) {
                    button[6].setEnabled(false); //delete
                }
                break;
            case 1: //cancel and delete
                button[0].setEnabled(true); //new
                button[1].setEnabled(false); //cancel
                button[2].setEnabled(false); //alter e save
                button[3].setEnabled(false); //editar
                button[4].setEnabled(true); //quit
                if (button.length >= 6) {
                    button[5].setEnabled(false); //print
                }
                if (button.length >= 7) {
                    button[6].setEnabled(false); //delete
                }
                break;
            case 2: //alter
                button[0].setEnabled(true); //new
                button[1].setEnabled(false); //cancel
                button[2].setEnabled(false); //alter e save
                button[3].setEnabled(true); //editar
                if ("Alterar".equals(button[2].getText())) {
                    button[2].setText("Salvar");
                    button[2].setActionCommand("salvar");
                }
                button[4].setEnabled(true); //quit
                if (button.length >= 6) {
                    button[5].setEnabled(true); //print
                }
                if (button.length >= 7) {
                    button[6].setEnabled(true); //delete
                }
                break;
            case 3: //save
                button[0].setEnabled(true); //new
                button[1].setEnabled(false); //cancel
                button[2].setEnabled(false); //alter e save
                button[3].setEnabled(true); //editar
                if ("Salvar".equals(button[2].getText())) {
                    button[2].setText("Alterar");
                    button[2].setActionCommand("alterar");
                }
                button[4].setEnabled(true); //quit
                if (button.length >= 6) {
                    button[5].setEnabled(true); //print
                }
                if (button.length >= 7) {
                    button[6].setEnabled(true); //delete
                }
                break;
            case 4: //edit
                button[0].setEnabled(false); //new
                button[1].setEnabled(true); //cancel
                button[2].setEnabled(true); //alter e save
                button[3].setEnabled(false); //editar
                if ("Salvar".equals(button[2].getText())) {
                    button[2].setText("Alterar");
                    button[2].setActionCommand("alterar");
                }
                button[4].setEnabled(false); //quit
                if (button.length >= 6) {
                    button[5].setEnabled(false); //print
                }
                if (button.length >= 7) {
                    button[6].setEnabled(false); //delete
                }
                break;
        }
    }

    /**
     * Os itens do menu devem ser adicionados na seguinte ordem 1-novo;
     * 2-cancelar; 3-salvar; 4-editar; 5-fechar; 6-imprimir; 7-deletar
     *
     * @param cdFunction É o código da operação de 0 a 4 (novo, cancelar,
     * alterar, salvar, editar)
     * @param itemMenu Lista de itens do menu
     */
    public static void itensMenuEnableOrder(int cdFunction, JMenuItem... itemMenu) {
        switch (cdFunction) {
            case 0: //new
                itemMenu[0].setEnabled(false); //new
                itemMenu[1].setEnabled(true); //cancel
                itemMenu[2].setEnabled(true); //alter e save
                itemMenu[3].setEnabled(false); //editar
                if ("Alterar".equals(itemMenu[2].getText())) {
                    itemMenu[2].setText("Salvar");
                    itemMenu[2].setActionCommand("salvar");
                }
                itemMenu[4].setEnabled(false); //quit
                if (itemMenu.length >= 6) {
                    itemMenu[5].setEnabled(false); //print
                }
                if (itemMenu.length >= 7) {
                    itemMenu[6].setEnabled(false); //delete
                }
                break;
            case 1: //cancel and delete
                itemMenu[0].setEnabled(true); //new
                itemMenu[1].setEnabled(false); //cancel
                itemMenu[2].setEnabled(false); //alter e save
                itemMenu[3].setEnabled(false); //editar
                itemMenu[4].setEnabled(true); //quit
                if (itemMenu.length >= 6) {
                    itemMenu[5].setEnabled(false); //print
                }
                if (itemMenu.length >= 7) {
                    itemMenu[6].setEnabled(false); //delete
                }
                break;
            case 2: //alter
                itemMenu[0].setEnabled(true); //new
                itemMenu[1].setEnabled(false); //cancel
                itemMenu[2].setEnabled(false); //alter e save
                itemMenu[3].setEnabled(true); //editar
                if ("Alterar".equals(itemMenu[2].getText())) {
                    itemMenu[2].setText("Salvar");
                    itemMenu[2].setActionCommand("salvar");
                }
                itemMenu[4].setEnabled(true); //quit
                if (itemMenu.length >= 6) {
                    itemMenu[5].setEnabled(true); //print
                }
                if (itemMenu.length >= 7) {
                    itemMenu[6].setEnabled(true); //delete
                }
                break;
            case 3: //save
                itemMenu[0].setEnabled(true); //new
                itemMenu[1].setEnabled(false); //cancel
                itemMenu[2].setEnabled(false); //alter e save
                itemMenu[3].setEnabled(true); //editar
                if ("Salvar".equals(itemMenu[2].getText())) {
                    itemMenu[2].setText("Alterar");
                    itemMenu[2].setActionCommand("alterar");
                }
                itemMenu[4].setEnabled(true); //quit
                if (itemMenu.length >= 6) {
                    itemMenu[5].setEnabled(true); //print
                }
                if (itemMenu.length >= 7) {
                    itemMenu[6].setEnabled(true); //delete
                }
                break;
            case 4: //edit
                itemMenu[0].setEnabled(false); //new
                itemMenu[1].setEnabled(true); //cancel
                itemMenu[2].setEnabled(true); //alter e save
                itemMenu[3].setEnabled(false); //editar
                if ("Salvar".equals(itemMenu[2].getText())) {
                    itemMenu[2].setText("Alterar");
                    itemMenu[2].setActionCommand("alterar");
                }
                itemMenu[4].setEnabled(false); //quit
                if (itemMenu.length >= 6) {
                    itemMenu[5].setEnabled(false); //print
                }
                if (itemMenu.length >= 7) {
                    itemMenu[6].setEnabled(false); //delete
                }
                break;
        }
    }

    /**
     * Os botões do formulário devem ser adicionados na seguinte ordem 1-novo;
     * 2-cancelar; 3-salvar; 4-editar; 5-fechar; 6-imprimir; 7-deletar
     *
     * @param cdFunction É o código da operação de 0 a 4 (novo, cancelar,
     * alterar, salvar, editar)
     * @param jButtons lista de botoes
     */
    public static void buttonsEnableOrder(int cdFunction, List<JButton> jButtons) {
        buttonsEnableOrder(cdFunction, jButtons.toArray(new JButton[jButtons.size()]));
    }

    /**
     * Os itens do menu devem ser adicionados na seguinte ordem 1-novo;
     * 2-cancelar; 3-salvar; 4-editar; 5-fechar; 6-imprimir; 7-deletar
     *
     * @param cdFunction É o código da operação de 0 a 4 (novo, cancelar,
     * alterar, salvar, editar)
     * @param itensMenu Lista de itens do menu
     */
    public static void itensMenuEnableOrder(int cdFunction, List<JMenuItem> itensMenu) {
        itensMenuEnableOrder(cdFunction, itensMenu.toArray(new JMenuItem[itensMenu.size()]));
    }

    public static void enable(Container container, String... exclusoes) {

        for (Component comp : container.getComponents()) {
            if (comp instanceof JTextField) {
                comp.setEnabled(!comp.isEnabled());
            } else if (comp instanceof JComboBox) {
                comp.setEnabled(!comp.isEnabled());
            } else if (comp instanceof JButton) {
                comp.setEnabled(!comp.isEnabled());
            } else if (comp instanceof JScrollPane) {
                JScrollPane scroll = (JScrollPane) comp;
                for (Component comp2 : scroll.getViewport().getComponents()) {
                    if (comp2 instanceof JTextArea) {
                        JTextArea textArea = (JTextArea) comp2;
                        textArea.setEditable(!textArea.isEditable());
                        textArea.setEnabled(!textArea.isEnabled());
                    }
                }
            }
        }
    }

    public static void limparCampos(Container container) {

        Component components[] = container.getComponents();

        for (Component component : components) {
            if (component instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) component;
                field.setText("");
            } else if (component instanceof JTextField) {
                JTextField field = (JTextField) component;
                field.setText("");
            } else if (component instanceof JTextArea) {
                JTextArea area = (JTextArea) component;
                area.setText("");
            } else if (component instanceof JScrollPane) {
                JScrollPane scroll = (JScrollPane) component;
                for (Component comp : scroll.getViewport().getComponents()) {
                    if (comp instanceof JTextArea) {
                        JTextArea areaTemp = (JTextArea) comp;
                        areaTemp.setText("");
                    }
                }
            } else if (component instanceof JComboBox) {
                JComboBox combo = (JComboBox) component;
                combo.setSelectedIndex(0);
            }
        }
    }

    public void setDinamicFormFields(JPanel panel, Object name, Object valor) {
        for (Component comp : panel.getComponents()) {
            if (name.equals(comp.getName())) {
                if (comp instanceof JTextField) {
                    JTextField txtField = (JTextField) comp;
                    txtField.setText((String) valor);
                } else if (comp instanceof JFormattedTextField) {
                    JFormattedTextField formatTextField = (JFormattedTextField) comp;
                    formatTextField.setText((String) valor);
                } else if (comp instanceof JComboBox) {
                    JComboBox comboBox = (JComboBox) comp;
                    comboBox.setSelectedItem(valor);
                } else if (comp instanceof JScrollPane) {
                    JScrollPane scrollPane = (JScrollPane) comp;
                    for (Component comp2 : scrollPane.getViewport().getComponents()) {
                        if (comp2 instanceof JTextArea) {
                            JTextArea textArea = (JTextArea) comp2;
                            textArea.setText((String) valor);
                        }
                    }
                }
            }
        }
    }

    public Object getDinamicFormFields(JPanel panel, Object name) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JTextField) {
                if (comp.getName().equals(name)) {
                    JTextField txtField = (JTextField) comp;
                    return txtField.getText();
                }
            } else if (comp instanceof JFormattedTextField) {
                if (comp.getName().equals(name)) {
                    JFormattedTextField formattedTextField = (JFormattedTextField) comp;
                    return formattedTextField.getText();
                }
            } else if (comp instanceof JComboBox) {
                if (comp.getName().equals(name)) {
                    JComboBox comboBox = (JComboBox) comp;
                    return comboBox.getSelectedItem();
                }
            } else if (comp instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) comp;
                for (Component comp2 : scrollPane.getViewport().getComponents()) {
                    if (comp2 instanceof JTextArea) {
                        if (comp.getName().equals(name)) {
                            JTextArea textArea = (JTextArea) comp2;
                            return textArea.getText();
                        }
                    }
                }
            }
        }
        return null;
    }

    public static enum Operacao {
        NEW, CANCEL, ALTER, SAVE, EDIT
    }
}
