/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimos.util;

import java.util.prefs.Preferences;

/**
 *
 * @author tiago.teixeira
 */
public class RegistroWindows {

    /**
     * Grava dados em um registro do S.O. do usuário
     *
     * @param chave String contendo o nome da chave que contém o valor
     * @param valor valor a ser armazenado na chave do registro
     */
    public void grava_registro(String chave, String valor) {
        Preferences p = Preferences.userRoot();
        p.put(chave, valor);
    }

    /**
     * Lê os dados gravados em um registro do S.O. do usuário
     *
     * @param chave String contendo o nome da chave que contém o valor
     * @return String com o valor da chave
     */
    public String le_registro(String chave) {
        String dado = null;
        Preferences p = Preferences.userRoot();
        dado = p.get(chave, null);
        return dado;

    }

}
