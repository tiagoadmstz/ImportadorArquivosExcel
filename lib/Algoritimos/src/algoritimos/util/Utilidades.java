/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimos.util;

import java.awt.Component;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tiago.teixeira
 */
public class Utilidades {

    /**
     * Esta função arredonda valores para qualquer quantidade de casas decimais
     * após a vírgula
     *
     * @param valor valor a ser arredondado.
     * @param casas quantidade de casas que se quer após a vírgula.
     * @param ceilOrFloor se 0 o valor é aproximado para cima, se 1 o valor é
     * aproximado para baixo.
     * @return double arredondado.
     */
    public static double arredondar(double valor, int casas, int ceilOrFloor) {
        double arredondado = valor;
        arredondado *= (Math.pow(10, casas));
        if (ceilOrFloor == 0) {
            arredondado = Math.ceil(arredondado);
        } else if (ceilOrFloor == 1) {
            arredondado = Math.floor(arredondado);
        }
        arredondado /= (Math.pow(10, casas));
        return arredondado;
    }

    /**
     * Este método é utilizado para gerar chaves criptografadas em SHA de 512
     * bits com saída de chave hexadecimal de 160 bits utilizando SALT.
     *
     * @param password - texto a ser criptografado.
     * @return - chave hexadecimal de 160 bits.
     */
    public static String encriptyPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte messageCript[] = md.digest(password.getBytes("UTF-8")); //RFC3548

            //Técnica de SALT com HASH de senha
            byte messageSalt[] = md.digest(Arrays.toString(messageCript).concat(password).getBytes("UTF-8"));

            //geração do hash em hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageSalt) {
                hexString.append(String.format("%02X", 0xFF & b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException nse) {
            nse.printStackTrace();
        }
        return null;
    }

    /**
     * Exibe um selecionar de arquivos padrão
     *
     * @param legenda título do form
     * @param filtro tipo de arquivos que devem ser mostrados
     * @return
     */
    public static String selecionadorArquivos(String legenda, String filtro) {
        JFileChooser fileChooser = new JFileChooser();
        if (!"".equals(filtro) && filtro != null) {
            fileChooser.setFileFilter(new FileNameExtensionFilter(null, filtro));
        }
        fileChooser.setDialogTitle(legenda);
        int acao = fileChooser.showDialog(null, "Selecionar");
        if (acao == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }

    public static String tratarAcentuacao(String palavra) {
        String temp = "";
        StringBuilder strb = new StringBuilder(palavra);
        String[] quebrada;

        if (!"".equals(palavra)) {
            quebrada = palavra.split("['!@#$%¨&*`´^~:;.,?°ºª]");

            if (quebrada.length != 0) {
                int i = 1;
                for (String str : quebrada) {
                    if (quebrada.length > i) {
                        strb.insert(str.length(), "\\");
                    }
                    i++;
                }
            }
        }
        temp = strb.toString();
        return temp;
    }

    public static Object tratarAcentuacao(Object palavra, String acento, String acentoNovo) {

        if (!"".equals(palavra)) {

            Object novaPalavra;
            String temp = palavra.toString();
            Pattern p = Pattern.compile(".*" + acento + ".*", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(temp);

            if (m.matches() == true) {
                temp = temp.replace(acento, acentoNovo);
                novaPalavra = temp;
            } else {
                novaPalavra = temp;
            }

            return novaPalavra;
        }
        return palavra;
    }

    public static void toggleVisible(Component... comps) {
        Arrays.asList(comps).stream().forEach(c -> {
            c.setVisible(!c.isVisible());
        });
    }
}
