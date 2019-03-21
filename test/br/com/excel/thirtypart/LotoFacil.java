/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.thirtypart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author tiago.teixeira
 */
public class LotoFacil {

    /**
     * @param args
     */
    public static void main(String[] args) {
        LotoFacil lf = new LotoFacil();
        String[] status = new String[]{"01", "02", "03"};
        lf.calculoPossibilidades(status).forEach(item -> System.out.println(item));
    }

    /**
     * Este método faz todas as combinações possíveis com um array de números
     *
     * @param status
     * @return Lista contendo uma lista de possiblidades
     */
    public List<List<Object>> calculoPossibilidades(Object[] status) {
        List<Object> lista = Arrays.asList(status);
        List<List<Object>> resultado = new ArrayList();
        resultado.add(lista);
        int possibilidades = lista.size() * (lista.size() - 1);
        System.out.println(String.format("Este array pode ter até %d combinações", possibilidades));

        for (int b = 0; b < lista.size(); b++) {
            List<Object> l = new ArrayList();
            Object alvo = lista.get(b);
            int quant = b == lista.size() - 1 ? lista.size() - 2 : lista.size() - 1;
            l.addAll(resultado.get(resultado.size() - 1));
            for (int p = 0; p < quant; p++) {
                int position = l.indexOf(alvo);
                if (l.get(p).equals(alvo)) {
                    l.remove(alvo);
                    l.add(position + 1, alvo);
                }
                resultado.add(new ArrayList(l));
            }
        }
        System.out.println(String.format("Consegui realizar %d combinações", resultado.size()));
        return resultado;
    }

}
