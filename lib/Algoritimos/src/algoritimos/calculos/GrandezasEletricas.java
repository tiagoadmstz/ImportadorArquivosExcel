/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimos.calculos;

import static algoritimos.util.Utilidades.arredondar;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author tiago.teixeira
 */
public class GrandezasEletricas {

    public static void calcularRST(String r, String s, String t) {
        calcularRST((r + s + t));
    }

    public static String calcularRST(String rst) {

        double[] vars = new double[3];
        double vMaior, media, resultado;
        String[] temp, temp2;

        try {
            if (!rst.equals(null)) {
                rst = rst.toUpperCase();
                temp = rst.split("A");
                temp2 = temp[0].split("/");

                for (int i = 0; i < 3; i++) {
                    vars[i] = Double.parseDouble(temp2[i].replace(",", ".").trim());
                }

                vMaior = Math.max(vars[0], vars[1]);
                vMaior = Math.max(vMaior, vars[2]);

                //porcentagem = (Valor maior - media) / media * 100
                media = (vars[0] + vars[1] + vars[2]) / 3;
                resultado = ((vMaior - media) / media) * 100;
                resultado = arredondar(resultado, 2, 1);
                return resultado > 0 ? String.valueOf(resultado) + "%" : "0%";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O Valor informado está incorreto ou fora do formato padrão ('1,2/1,3/1,4 A')", "Valor inválido", JOptionPane.ERROR_MESSAGE);
            return "0%";
        }
        return "0%";
    }

    public void calcularResistencia(String A, String B, String C, String D, String E, String F) {
        calcularResistencia((A + B + C + D + E + F));
    }

    public static String calcularResistencia(String resistencia) {

        double[] vars = new double[6];
        double vMaior = 0, vMenor = 0, resultado = 0;
        String[] temp = null, temp2 = null;

        try {
            if (!resistencia.equals(null) && !"".equals(resistencia)) {
                resistencia = resistencia.toUpperCase();

                if (resistencia.contains("G")) {
                    temp = resistencia.split("G");
                } else if (resistencia.contains("M")) {
                    temp = resistencia.split("M");
                } else if (resistencia.contains("O") && resistencia.indexOf("O") == (resistencia.length() - 4)) {
                    temp = resistencia.split("O");
                } else {
                    temp2 = resistencia.split("/");
                }

                if (temp2 == null) {
                    temp2 = temp[0].split("/");
                }

                for (int i = 0; i < 6; i++) {
                    vars[i] = i < temp2.length ? Double.parseDouble(temp2[i].replace(",", ".").trim()) : 0;
                }

                vMenor = vars[0];

                for (int i = 0; i < temp2.length; i++) {
                    vMaior = Math.max(vMaior, vars[i]);
                    vMenor = Math.min(vMenor, vars[i]);
                }

                BigDecimal vMax = new BigDecimal(vMaior);
                BigDecimal vMin = new BigDecimal(vMenor);

                // valor maior / valor menor -1 * 100
                BigDecimal div = vMax.divide(vMin);
                resultado = (div.doubleValue() - 1) * 100;
                return resultado > 0 ? String.valueOf(arredondar(resultado, 2, 1)) + "%" : "0%";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O Valor informado está incorreto ou fora do formato padrão ('1,2/1,3/1,4 Gohms')", "Valor inválido", JOptionPane.ERROR_MESSAGE);
            return "0%";
        }
        return "0%";
    }

}
