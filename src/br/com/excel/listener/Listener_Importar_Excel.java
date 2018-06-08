/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.listener;

import br.com.excel.dal.DAO_Util;
import br.com.excel.frames.Form_Importar_Excel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tiago.teixeira
 */
public class Listener_Importar_Excel implements ActionListener {

    private final Form_Importar_Excel form;
    private DAO_Util dao;

    public Listener_Importar_Excel(Form_Importar_Excel form) {
        this.form = form;
        initComponents();
    }

    private void initComponents() {
        attachListeners();
    }

    private void attachListeners() {
        form.getListaBotoes().forEach(bt -> ((AbstractButton) bt).addActionListener(this));
    }

    @Override
    public void actionPerformed(ActionEvent acEvent) {
        switch (acEvent.getActionCommand()) {
            case "testarConexao":
                testarConexao();
                break;
        }
    }

    private void testarConexao() {
        boolean result = false;
        try {
            dao = new DAO_Util(form.getCbDriver().getSelectedItem().toString(),
                    form.getTxtEnderecoBanco().getText(),
                    form.getTxtUsuarioBanco().getText(),
                    String.valueOf(form.getTxtPasswordBanco().getPassword()));
            result = dao.conectar();
            dao.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result) {
            form.getLbRespostaTesteConexao().setForeground(Color.blue);
            form.getLbRespostaTesteConexao().setText("Conexão realizada com sucesso!!!");
        } else {
            form.getLbRespostaTesteConexao().setForeground(Color.red);
            form.getLbRespostaTesteConexao().setText("Ocorreu um erro ao tentar conectar ao banco de dados!!!");
        }
    }

    private void selecionarJar() {
        File arquivoSelecionado = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo jar", "jar"));
        fileChooser.setDialogTitle("Selecionar Jar do Driver do Banco de Dados");
        int acao = fileChooser.showDialog(null, "Selecionar");
        if (acao == JFileChooser.APPROVE_OPTION) {
            arquivoSelecionado = fileChooser.getSelectedFile();
        }
        //form.getTxtDriver().setText(arquivoSelecionado.getAbsolutePath());
    }
}
