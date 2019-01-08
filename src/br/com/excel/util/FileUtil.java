/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.util;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tiago.teixeira
 */
public class FileUtil {
    
    public static File selecionarArquivo(JFrame form) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
            fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo do Excel", "xls", "xlsx"));
            fileChooser.setMultiSelectionEnabled(false);
            fileChooser.setSize(200, 150);
            File arquivoDados = null;
            if (fileChooser.showDialog(form, "Selecionar") == JFileChooser.APPROVE_OPTION) {
                arquivoDados = fileChooser.getSelectedFile();
            }
            return arquivoDados;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
