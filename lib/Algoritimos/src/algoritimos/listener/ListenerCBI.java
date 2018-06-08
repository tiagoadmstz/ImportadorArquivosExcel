package algoritimos.listener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import algoritimos.util.ManipulaFrames;
import algoritimos.controle.ControleInstancias;
import algoritimos.beans.JTextFieldCBI;
import algoritimos.calculos.Datas;
import algoritimos.frames.ConsultaForm;
import algoritimos.tabelas.DefaultCBIHeaderRenderer;
import algoritimos.tabelas.TableModelCBI;
import algoritimos.dao.EntityManagerHelper;
import algoritimos.dao.JPAHelper;
import algoritimos.util.ManipulaFrames;
import algoritimos.util.ScrollPaneUtil;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Tiago D. Teixeira
 */
public abstract class ListenerCBI implements ActionListener, ListSelectionListener, KeyListener, MouseListener, FocusListener, ItemListener, WindowListener {

    public ListenerCBI() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "novo":
                break;
            case "cancelar":
                break;
            case "salvar":
                break;
            case "alterar":
                break;
            case "editar":
                break;
            case "fechar":
                break;
            case "imprimir":
                break;
            case "excluir":
                break;
            case "pesquisar":
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * @param textField campo de identificação separado em painel próprio
     * @param jPanel lista de paines que serão manipulados pelo método
     * @param buttons iista de botões que serão manipulados pelo método
     */
    public void novo(JTextField textField, List<JPanel> jPanel, List<JButton> buttons) {
        if (textField != null) {
            textField.setText("");
        }
        this.enableOrDisabelComponentsPanel(jPanel, ManipulaFrames.Operacao.NEW.ordinal());
        this.setEnableButtons(ManipulaFrames.Operacao.NEW.ordinal(), buttons);
    }

    public void novoItemMenu(JTextField textField, List<JPanel> jPanel, List<JMenuItem> itensMenu) {
        if (textField != null) {
            textField.setText("");
        }
        this.enableOrDisabelComponentsPanel(jPanel, ManipulaFrames.Operacao.NEW.ordinal());
        this.setEnableItensMenu(ManipulaFrames.Operacao.NEW.ordinal(), itensMenu);
    }

    public void enableOrDisabelComponentsPanel(List<JPanel> jPanel, int operation) {
        jPanel.stream().forEach((jp) -> {
            //ManipulaFrames.buttonsForm(operation, jp.getComponents());
        });
    }

    private void apagarDadosPaineis(List<JPanel> jPanel) {
        jPanel.stream().forEach((jp) -> {
            for (Component cpt : jp.getComponents()) {
                if (cpt instanceof JTextField) {
                    JTextField txt = (JTextField) cpt;
                    txt.setText("");
                } else if (cpt instanceof JScrollPane) {
                    JScrollPane scp = (JScrollPane) cpt;
                    for (Component s : scp.getViewport().getComponents()) {
                        if (s instanceof JTable) {
                            JTable tb = (JTable) s;
                            TableModelCBI model = (TableModelCBI) tb.getModel();
                            model.deletarLista();
                        }
                    }
                }
            }
        });
    }

    public void cancelar(List<JPanel> jPanel, List<JButton> buttons) {
        //this.apagarDadosPaineis(jPanel);
        this.enableOrDisabelComponentsPanel(jPanel, ManipulaFrames.Operacao.CANCEL.ordinal());
        this.setEnableButtons(ManipulaFrames.Operacao.CANCEL.ordinal(), buttons);
    }

    public void cancelarItemMenu(List<JPanel> jPanel, List<JMenuItem> itensMenu) {
        this.apagarDadosPaineis(jPanel);
        this.enableOrDisabelComponentsPanel(jPanel, ManipulaFrames.Operacao.CANCEL.ordinal());
        this.setEnableItensMenu(ManipulaFrames.Operacao.CANCEL.ordinal(), itensMenu);
    }

    public void editar(List<JPanel> jPanel, List<JButton> buttons) {
        this.enableOrDisabelComponentsPanel(jPanel, ManipulaFrames.Operacao.EDIT.ordinal());
        this.setEnableButtons(ManipulaFrames.Operacao.EDIT.ordinal(), buttons);
    }

    public void editarItensMenu(List<JPanel> jPanel, List<JMenuItem> itensMenu) {
        this.enableOrDisabelComponentsPanel(jPanel, ManipulaFrames.Operacao.EDIT.ordinal());
        this.setEnableItensMenu(ManipulaFrames.Operacao.EDIT.ordinal(), itensMenu);
    }

    public void fechar(JFrame jFrame) {
        if ((JOptionPane.showConfirmDialog(jFrame, "Deseja realmente fechar o formulário?", "Fechar Formulário", JOptionPane.YES_NO_OPTION)) == 0) {
            jFrame.dispose();
        }
    }

    public void fecharSistema(JFrame jFrame) {
        if ((JOptionPane.showConfirmDialog(jFrame, "Deseja realmente encerrar o sistema?", "Encerrar Sistema", JOptionPane.YES_NO_OPTION)) == 0) {
            System.exit(0);
        }
    }

    public void fecharESC(JMenuItem menuItem) {
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        menuItem.setAccelerator(escape);
    }

    public abstract void attachListener();

    public abstract JPAHelper getJPAHelper();

    public abstract void addModel();

    public abstract void carregarListeners();

    public abstract void carregarPaineis();

    /**
     * Pega um objeto enviado de outro formulário e inclui no objeto local
     *
     * @param object = Entidade controlada pelo painel
     */
    public abstract void setDados(Object object);

    /**
     * Pega os dados do formulário e coloca no modelo de objeto EX:
     * produto.setQuantidade(form.getTxtQuantidade.getText());
     */
    public abstract void setDados();

    /**
     * Pega os dados de um objeto e mostra nos campos do formulário EX:
     * form.getTxtQuantidade().setText(produto.getQuantidade());
     */
    public abstract void getDados();

    public abstract void setMaxLegthTextFields();

    public abstract void setEnableButtons(int codFunction);

    public abstract void salvar(int tipo);

    /**
     * Salva um registro e faz operações básicas de controle, atualizar o
     * formulário ou tabelas fica por conta do solicitante.
     *
     * @param tipo 0 = salvar, 1 = alterar
     * @param jpaHelper uma instância de JPAHelper
     * @param object o objeto a ser salvo na base de dados
     * @param form o formulário que solicitou a ação
     * @param paineis lista de paineis a serem manipulados
     * @param botoes lista de botoes a serem manipulados
     * @param itensMenu só funciona caso botoes for null
     * @return retorna se a transação foi bem sucedida
     */
    public boolean salvar(int tipo, JPAHelper jpaHelper, Object object, JFrame form, List<JPanel> paineis, List<JButton> botoes, List<JMenuItem> itensMenu) {
        switch (tipo) {
            case 0: //salvar
                if (JOptionPane.showConfirmDialog(form, "Deseja salvar o registro?", "Salvar Registro", JOptionPane.YES_NO_OPTION) == 0) {
                    this.setDados();
                    jpaHelper.getOperation(jpaHelper.INSERT, object);
                    this.enableOrDisabelComponentsPanel(paineis, ManipulaFrames.Operacao.SAVE.ordinal());
                    if (botoes != null) {
                        this.setEnableButtons(ManipulaFrames.Operacao.SAVE.ordinal(), botoes);
                    } else if (itensMenu != null) {
                        this.setEnableItensMenu(ManipulaFrames.Operacao.SAVE.ordinal(), itensMenu);
                    }
                    this.getDados();
                    return true;
                }
                return false;
            case 1: //alterar
                if (JOptionPane.showConfirmDialog(form, "Deseja salvar as alterações feitas no registro?", "Salvar Registro", JOptionPane.YES_NO_OPTION) == 0) {
                    this.setDados();
                    jpaHelper.getOperation(jpaHelper.UPDATE, object);
                    this.enableOrDisabelComponentsPanel(paineis, ManipulaFrames.Operacao.SAVE.ordinal());
                    if (botoes != null) {
                        this.setEnableButtons(ManipulaFrames.Operacao.SAVE.ordinal(), botoes);
                    } else if (itensMenu != null) {
                        this.setEnableItensMenu(ManipulaFrames.Operacao.SAVE.ordinal(), itensMenu);
                    }
                    return true;
                }
                return false;
            case 3: //save or update
                if (JOptionPane.showConfirmDialog(form, "Deseja salvar as alterações feitas no registro?", "Salvar Registro", JOptionPane.YES_NO_OPTION) == 0) {
                    this.setDados();
                    jpaHelper.getOperation(jpaHelper.SAVEORUPDATE, object);
                    this.enableOrDisabelComponentsPanel(paineis, ManipulaFrames.Operacao.SAVE.ordinal());
                    if (botoes != null) {
                        this.setEnableButtons(ManipulaFrames.Operacao.SAVE.ordinal(), botoes);
                    } else if (itensMenu != null) {
                        this.setEnableItensMenu(ManipulaFrames.Operacao.SAVE.ordinal(), itensMenu);
                    }
                    return true;
                }
                return false;
        }
        return false;
    }

    /**
     * Salva um registro e faz operações básicas de controle, atualizar o
     * formulário ou tabelas fica por conta do solicitante.
     *
     * @param tipo 0 = salvar, 1 = alterar
     * @param emh uma instância de EntityManangerHelper
     * @param object o objeto a ser salvo na base de dados
     * @param form o formulário que solicitou a ação
     * @param paineis lista de paineis a serem manipulados
     * @param botoes lista de botoes a serem manipulados
     * @param itensMenu só funciona caso botoes for null
     * @return retorna se a transação foi bem sucedida
     */
    public boolean salvar(int tipo, EntityManagerHelper emh, Object object, JFrame form, List<JPanel> paineis, List<JButton> botoes, List<JMenuItem> itensMenu) {
        switch (tipo) {
            case 0: //salvar
                if (JOptionPane.showConfirmDialog(form, "Deseja salvar o registro?", "Salvar Registro", JOptionPane.YES_NO_OPTION) == 0) {
                    this.setDados();
                    emh.getOperation(EntityManagerHelper.OPERATION_TYPE.SAVE, object, EntityManagerHelper.PERSISTENCE_UNIT.SERMED_PRONTUARIO_PU);
                    this.enableOrDisabelComponentsPanel(paineis, ManipulaFrames.Operacao.SAVE.ordinal());
                    if (botoes != null) {
                        this.setEnableButtons(ManipulaFrames.Operacao.SAVE.ordinal(), botoes);
                    } else if (itensMenu != null) {
                        this.setEnableItensMenu(ManipulaFrames.Operacao.SAVE.ordinal(), itensMenu);
                    }
                    this.getDados();
                    return true;
                }
                return false;
            case 1: //alterar
                if (JOptionPane.showConfirmDialog(form, "Deseja salvar as alterações feitas no registro?", "Salvar Registro", JOptionPane.YES_NO_OPTION) == 0) {
                    this.setDados();
                    emh.getOperation(EntityManagerHelper.OPERATION_TYPE.UPDATE, object, EntityManagerHelper.PERSISTENCE_UNIT.SERMED_PRONTUARIO_PU);
                    this.enableOrDisabelComponentsPanel(paineis, ManipulaFrames.Operacao.SAVE.ordinal());
                    if (botoes != null) {
                        this.setEnableButtons(ManipulaFrames.Operacao.SAVE.ordinal(), botoes);
                    } else if (itensMenu != null) {
                        this.setEnableItensMenu(ManipulaFrames.Operacao.SAVE.ordinal(), itensMenu);
                    }
                    return true;
                }
                return false;
        }
        return false;
    }

    public abstract void alterar();

    /**
     * Este método faz a manipulação do formulário e botões apenas, caso precise
     * fazer mais coisas sobreescreva o método alterar() e utilize este como
     * auxiliar com a chamada de super.
     *
     * @param paineis lista de painéis
     * @param botoes lista de botões
     */
    public void alterar(List<JPanel> paineis, List<JButton> botoes) {
        this.enableOrDisabelComponentsPanel(paineis, ManipulaFrames.Operacao.ALTER.ordinal());
        this.setEnableButtons(ManipulaFrames.Operacao.ALTER.ordinal(), botoes);
    }

    public void alterarItensMenu(List<JPanel> paineis, List<JMenuItem> itensMenu) {
        this.enableOrDisabelComponentsPanel(paineis, ManipulaFrames.Operacao.ALTER.ordinal());
        this.setEnableItensMenu(ManipulaFrames.Operacao.ALTER.ordinal(), itensMenu);
    }

    public abstract void editar();

    public abstract void imprimir();

    public abstract void pesquisar();

    public ConsultaForm pesquisar(ListenerCBI listenerSolicitante) {
        ConsultaForm consulta = (ConsultaForm) ControleInstancias.getInstance(ConsultaForm.class.getName());
        if (consulta == null) {
            consulta = new ConsultaForm();
            ControleInstancias.setControleInstancias(ConsultaForm.class.getName(), consulta);
        }
        consulta.setListenerSolicitante(listenerSolicitante);
        return consulta;
    }

    public abstract void deletar();

    /**
     * Está é um método básico para deletar registros simples e fazer a
     * manipulação do formulário e botões. Para itens complexos sobreescreva o
     * método deletar().
     *
     * @param object item a ser deletado
     * @param form formulário solicitante
     * @param jpaHelper instância de JPAHelper
     * @param paineis lista de paineis
     * @param botoes lista de botoes
     * @return
     */
    public boolean deletar(Object object, JFrame form, JPAHelper jpaHelper, List<JPanel> paineis, List<JButton> botoes) {
        if (JOptionPane.showConfirmDialog(form, "Deseja deletar o registro?", "Salvar Registro", JOptionPane.YES_NO_OPTION) == 0) {
            this.setDados();
            jpaHelper.getOperation(jpaHelper.DELETE, object);
            enableOrDisabelComponentsPanel(paineis, ManipulaFrames.Operacao.CANCEL.ordinal());
            setEnableButtons(ManipulaFrames.Operacao.CANCEL.ordinal(), botoes);
            return true;
        }
        return false;
    }

    public boolean deletarItensMenu(Object object, JFrame form, JPAHelper jpaHelper, List<JPanel> paineis, List<JMenuItem> itensMenu) {
        if (JOptionPane.showConfirmDialog(form, "Deseja deletar o registro?", "Salvar Registro", JOptionPane.YES_NO_OPTION) == 0) {
            this.setDados();
            jpaHelper.getOperation(jpaHelper.DELETE, object);
            enableOrDisabelComponentsPanel(paineis, ManipulaFrames.Operacao.CANCEL.ordinal());
            setEnableItensMenu(ManipulaFrames.Operacao.CANCEL.ordinal(), itensMenu);
            return true;
        }
        return false;
    }

    public void setEnableButtons(int codFunction, List<JButton> jButons) {
        ManipulaFrames.buttonsEnableOrder(codFunction, jButons);
    }

    public void setEnableItensMenu(int codFunction, List<JMenuItem> jButons) {
        ManipulaFrames.itensMenuEnableOrder(codFunction, jButons);
    }

    public void setScrollPanelConfig(JScrollPane scrollPane) {
        ScrollPaneUtil.scrollPanelConfigurator(scrollPane);
    }

    public void addItens(String tipo) {

    }

    public void removeItens(String tipo) {

    }

    public abstract void carregarListas();

    public void apagarTabelas() {

    }

    public void setColumnDesign(JTable table, DefaultTableCellRenderer tableRenderer) {
        //rederização das colunas
        for (int i = 0; i < table.getColumnCount(); i++) {
            if (table.getColumnClass(i) != Boolean.class) {
                table.getColumnModel().getColumn(i).setCellRenderer(tableRenderer);
            }
        }
    }

    public void setColumnFilter(JTable table, TableRowSorter rowSorter) {
        int columns = table.getModel().getColumnCount();
        for (int i = 0; i < columns; i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(new DefaultCBIHeaderRenderer(rowSorter));
        }
    }

    public void addColumnComboBox(JTable table, int colunmIndex, JComboBox comboBox) {
        table.getColumnModel().getColumn(colunmIndex).setCellEditor(new DefaultCellEditor(comboBox));
    }

    public void setColumnSize(JTable table, int... tamanho) {
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(tamanho[i]);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {
        OnChangeListener.EventListener(e);
    }

    /**
     * Este método é utilizado como padrão para campos de data e hora protegendo
     * o campo contra entradas inválidas e formatando a data e a hora informados
     * pelo usuário para um formato padrão, para utilizar este método basta
     * colocar o nome do campo de data ou hora e adicionar um FocusListener
     * passar super.focusLost(e) na sobreescrita do método se existir, caso
     * contrário será utilizado o método padrão.
     *
     * @param e FocusEvent passado pelo campo
     */
    @Override
    public void focusLost(FocusEvent e) {
        OnChangeListener.EventListener(e);
        if (OnChangeListener.getChangeEvent() == true) {
            if (e.getSource() instanceof JTextField || e.getSource() instanceof JTextFieldCBI) {
                JTextField textField = (JTextField) e.getComponent();
                if (!"".equals(textField.getText())) {
                    switch (textField.getName()) {
                        case "data":
                            textField.setText(Datas.getDate(textField.getText(), 1));
                            break;
                        case "hora":
                            textField.setText(Datas.getHour(textField.getText(), 1));
                            break;
                    }
                }
            }

            /*if (e.getSource() instanceof JComboBox){
             JComboBox comboBox = (JComboBox) e.getComponent();
             if(!"".equals(comboBox.getSelectedItem().toString())){
             //escrever a ação aqui
             }
             }*/
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        //ControleInstancias.removeInstance(null);
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public static enum Operacao{
        NOVO, SALVAR, CANCELAR, DELETAR, 
    }
    
}
