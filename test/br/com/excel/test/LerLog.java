/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tiago.teixeira
 */
public class LerLog {

    private final Scanner scan = new Scanner(System.in);

    public LerLog() {
        selecionarJar();
    }

    public void selecionarJar() {
        File[] arquivos = null;
        JFileChooser fileChooser = new JFileChooser();
        //fileChooser.setCurrentDirectory(new File("\\\\10.10.11.3\\logpf\\Prod"));
        fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo de log", "LOG"));
        fileChooser.setDialogTitle("Selecionar Arquivo de Log");
        fileChooser.setMultiSelectionEnabled(true);
        int acao = fileChooser.showDialog(null, "Selecionar");
        if (acao == JFileChooser.APPROVE_OPTION) {
            arquivos = fileChooser.getSelectedFiles();
        }

        try {
            for (File file : arquivos) {
                String dados = new String(Files.readAllBytes(file.toPath()));
                System.out.print("O que devo procurar? (TEXTO) : ");
                String mt = scan.next();
                System.out.println("------EXECUTANDO VAREDURA DE BYTES------");
                if (dados.contains(mt)) {
                    System.out.println("Encontrei!!! seu log está no arquivo ".concat(file.getName()));
                    System.out.print("Posso procurar o registro? (S/N) : ");
                    String procurar = scan.next();
                    if (procurar.equals("S") || procurar.equals("s")) {
                        System.out.println("-------------LINHAS DE LOG ENCONTRADAS-----------------");
                        String[] split = dados.split("\n");
                        Pattern p = Pattern.compile("^(.*(" + mt + ").*)$");
                        for (String linha : split) {
                            Matcher m = p.matcher(linha);
                            if (m.matches()) {
                                System.out.println(linha);
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(fileChooser, e.getMessage());
        }
    }

}
