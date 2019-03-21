/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tiago.teixeira
 */
public final class Lotofacil {

    private final String url;
    private final WebClient wc;

    public static void main(String[] args) {
        Lotofacil lotofacil = new Lotofacil();
        Map<String, List<Long>> resultados = lotofacil.getResultados();
        resultados.keySet().forEach(concurso -> System.out.println(concurso));
        resultados.forEach((k, v) -> System.out.println(v));
    }

    public Lotofacil() {
        this.url = "http://www.loterias.caixa.gov.br/wps/portal/loterias/landing/lotofacil";
        wc = new WebClient(BrowserVersion.CHROME);
    }

    private HtmlPage getIndexPage() {
        try {
            HtmlPage index = wc.getPage(url);
            System.out.println(index.getTitleText());
            System.out.println(index.getUrl().toString());
            return index;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Map<String, List<Long>> getResultados() {
        try {
            Map<String, List<Long>> map = new HashMap();
            List<Long> resultados = new ArrayList();
            HtmlPage index = getIndexPage();
            List<HtmlElement> lista = index.getBody().getElementsByAttribute("table", "class", "simple-table lotofacil");
            List<HtmlElement> spans = index.getBody().getElementsByAttribute("span", "class", "ng-binding");
            HtmlTable tabela = (HtmlTable) lista.get(0);
            HtmlSpan concurso = (HtmlSpan) spans.get(0);
            wc.waitForBackgroundJavaScript(10000L);
            String ccs = concurso.getTextContent().replaceAll("\\s+", " ").trim();
            List<HtmlTableCell> cells = tabela.getBodies().get(0).getElementsByAttribute("td", "ng-repeat", "dezena in resultadoLinha");
            cells.forEach(cell -> resultados.add(Long.parseLong(cell.getTextContent())));
            map.put(ccs, resultados);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
