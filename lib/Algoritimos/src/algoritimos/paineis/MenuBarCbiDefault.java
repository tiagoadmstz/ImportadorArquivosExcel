package algoritimos.paineis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 *
 * @author tiago.teixeira
 */
public class MenuBarCbiDefault extends JMenuBar {

    private JMenu menuArquivo;
    private JMenuItem itemNovo;
    private JMenuItem itemEditar;
    private JMenuItem itemAlterar;
    private JMenuItem itemCancelar;
    private JMenuItem itemFechar;
    private JMenuItem itemImprimir;
    private JMenuItem itemDeletar;
    private JMenuItem itemPesquisar;

    public MenuBarCbiDefault() {
        super();
        construirMenus();
    }

    private void construirMenus() {
        this.removeAll();

        menuArquivo = new JMenu("Arquivo");
        itemNovo = new JMenuItem("Novo");
        itemNovo.setActionCommand("novo");
        itemEditar = new JMenuItem("Editar");
        itemEditar.setActionCommand("editar");
        itemEditar.setEnabled(false);
        itemAlterar = new JMenuItem("Alterar");
        itemAlterar.setActionCommand("alterar");
        itemAlterar.setEnabled(false);
        itemCancelar = new JMenuItem("Cancelar");
        itemCancelar.setActionCommand("cancelar");
        itemCancelar.setEnabled(false);
        itemFechar = new JMenuItem("Fechar");
        itemFechar.setActionCommand("fechar");
        itemImprimir = new JMenuItem("Imprimir");
        itemImprimir.setActionCommand("imprimir");
        itemDeletar = new JMenuItem("Deletar");
        itemDeletar.setActionCommand("imprimir");
        itemDeletar.setEnabled(false);
        itemPesquisar = new JMenuItem("Pesquisar");
        itemPesquisar.setActionCommand("pesquisar");

        menuArquivo.add(itemNovo);
        menuArquivo.add(itemEditar);
        menuArquivo.add(itemAlterar);
        menuArquivo.add(itemCancelar);
        menuArquivo.add(itemImprimir);
        menuArquivo.add(itemDeletar);
        menuArquivo.add(itemPesquisar);
        menuArquivo.add(new JSeparator());
        menuArquivo.add(itemFechar);

        this.add(menuArquivo);
    }

    public List<JMenuItem> getListMenuItens() {
        JMenuItem[] itens = new JMenuItem[]{
            itemNovo, itemCancelar, itemAlterar, itemEditar, itemFechar, itemImprimir, itemDeletar};
        return Arrays.asList(itens);
    }

    public JMenu getMenuArquivo() {
        return menuArquivo;
    }

    public void setMenuArquivo(JMenu menuArquivo) {
        this.menuArquivo = menuArquivo;
    }

    public JMenuItem getItemNovo() {
        return itemNovo;
    }

    public void setItemNovo(JMenuItem itemNovo) {
        this.itemNovo = itemNovo;
    }

    public JMenuItem getItemEditar() {
        return itemEditar;
    }

    public void setItemEditar(JMenuItem itemEditar) {
        this.itemEditar = itemEditar;
    }

    public JMenuItem getItemAlterar() {
        return itemAlterar;
    }

    public void setItemAlterar(JMenuItem itemAlterar) {
        this.itemAlterar = itemAlterar;
    }

    public JMenuItem getItemCancelar() {
        return itemCancelar;
    }

    public void setItemCancelar(JMenuItem itemCancelar) {
        this.itemCancelar = itemCancelar;
    }

    public JMenuItem getItemFechar() {
        return itemFechar;
    }

    public void setItemFechar(JMenuItem itemFechar) {
        this.itemFechar = itemFechar;
    }

    public JMenuItem getItemImprimir() {
        return itemImprimir;
    }

    public void setItemImprimir(JMenuItem itemImprimir) {
        this.itemImprimir = itemImprimir;
    }

    public JMenuItem getItemDeletar() {
        return itemDeletar;
    }

    public void setItemDeletar(JMenuItem itemDeletar) {
        this.itemDeletar = itemDeletar;
    }

    public JMenuItem getItemPesquisar() {
        return itemPesquisar;
    }

    public void setItemPesquisar(JMenuItem itemPesquisar) {
        this.itemPesquisar = itemPesquisar;
    }

}
