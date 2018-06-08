package algoritimos.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tiago D. Teixeira
 */
public class PesquisaUtil {

    public static List<?> pesquisaDinamica(List<?> lista, String nomeCampo, String strEntrada) {

        List<Object> listaResultado = new ArrayList();
        String strPesquisa = geraStringPesquisaDinamica(strEntrada);
        boolean resultado;
        int i = 0;

        for (Object obj : lista) {
            if (!"".equals(nomeCampo)) {
                Pattern p = Pattern.compile(".*" + nomeCampo + ".*=.*" + strPesquisa, Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(obj.toString());
                resultado = m.matches();
            } else {
                Pattern p = Pattern.compile(strPesquisa, Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(obj.toString());
                resultado = m.matches();
            }

            if (resultado != false) {
                listaResultado.add(i++, obj);
            }
        }
        return listaResultado;
    }

    public static List<?> pesquisaDinamica(List<?> lista, String[] nomeCampo, String[] strEntrada) {
        List<Object> listaResultado = new ArrayList();
        String encadeamento = "";
        int cont = 0;
        for (String campo : nomeCampo) {
            if (strEntrada.length > 1 && cont < strEntrada.length) {
                encadeamento = encadeamento.concat(".*" + campo + "=" + strEntrada[cont++] + ".*,");
            } else {
                encadeamento = encadeamento.concat(".*" + campo + "=" + strEntrada[cont++] + ".*");
            }
        }

        for (Object obj : lista) {
            Pattern p = Pattern.compile(encadeamento, Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(obj.toString());
            if (m.matches() == true) {
                listaResultado.add(obj);
            }
        }

        return listaResultado;
    }

    public static boolean pesquisaDinamicaVF(List<?> lista, String nomeCampo, String strEntrada) {
        //List<Object> listaResultado = new ArrayList();
        String strPesquisa = geraStringPesquisaDinamica(strEntrada);
        boolean resultado = false;
        //int i = 0;

        for (Object obj : lista) {
            if (!"".equals(nomeCampo)) {
                Pattern p = Pattern.compile(".*" + nomeCampo + ".*=.*" + strPesquisa, Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(obj.toString());
                resultado = m.matches();
                if (resultado == true) {
                    break;
                }
            } else {
                Pattern p = Pattern.compile(strPesquisa, Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(obj.toString());
                resultado = m.matches();
                if (resultado == true) {
                    break;
                }
            }
        }

        return resultado;
    }

    public static String geraStringPesquisaDinamica(String strEntrada) {

        String[] palavras;
        String temp = "";
        String strSaida = "";

        palavras = strEntrada.split(" ");

        for (String p : palavras) {
            temp = p;
            if ("".equals(strSaida)) {
                strSaida = ".*" + temp;
            } else {
                strSaida = strSaida + ".*" + temp;
            }
            strSaida = strSaida + ".*";
        }

        return strSaida;
    }

    /**
     * Gera uma lista a partir de outra com itens filtrados pela letra inicial.
     *
     * @param lista - A lista que será filtrada
     * @param nomeCampo - Nome da coluna que será filtrada
     * @param letra - A letra inicial
     * @return List
     */
    public static List<?> pesquisaPorLetraInicial(List<?> lista, String nomeCampo, String letra) {
        List<Object> objects = new ArrayList();
        Pattern pattern = null;
        Matcher matcher = null;
        boolean vogal = false;
        long quant = 0;
        int i = -1;

        String[] vogais = new String[]{"AÁÀÂÃÄaáàâãä", "EÉÈÊËeéèêë", "IÍÌÎÏiíìîï", "OÓÒÔÕÖoóòôõö", "UÚÙÛÜuúùûü"};

        for (String str : vogais) {
            //verifica se é uma vogal prevista
            vogal = str.matches(".*" + letra + ".*");
            //guarda a quantidade de letras no vetor
            quant = vogal == true ? str.chars().count() : quant;

            i++;

            if (vogal == true) {
                break;
            }
        }

        //verifica qual dos vetores tem a letra escolhida
        if (vogal == true) {
            //faz uma verificação para cada letra do vetor
            for (int l = 0; l < quant; l++) {
                for (Object obj : lista) {
                    pattern = Pattern.compile(".*" + nomeCampo + "=" + vogais[i].substring(l, l + 1) + ".*", Pattern.CASE_INSENSITIVE);
                    matcher = pattern.matcher(obj.toString());
                    if (matcher.matches() == true) {
                        objects.add(obj);
                    }
                }
            }

        } else if (vogal == false) {
            for (Object obj : lista) {
                String str = ".*" + nomeCampo + "=" + letra + ".*";
                pattern = Pattern.compile(str, Pattern.CASE_INSENSITIVE);
                matcher = pattern.matcher(obj.toString());
                if (matcher.find()) {
                    objects.add(obj);
                }
            }

        }

        return objects;

    }
    
}
