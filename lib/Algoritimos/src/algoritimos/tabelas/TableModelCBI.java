package algoritimos.tabelas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;


/**
 *
 * @author Tiago D. Teixeira
 */
public abstract class TableModelCBI extends TableModel_CBI{
    
    public abstract void addObject(Object Object);
    public abstract void removeObject(int rowIndex);
    public abstract Object getObject(int rowIndex);
    public abstract void deletarLista();
    public abstract void addLista(List<?> lista);
    public abstract List<?> getLista();
    public abstract void resetarLista();
    public abstract void atualizarItem(Object object);
    public abstract void atualizarItem(Object object, int rowIndex);
    public abstract void setSelectedRow(int row);
    public abstract void aplicarFiltro(int column, String filtro);
    public abstract void aplicarFiltroLetra(String column, String filtro);
}
