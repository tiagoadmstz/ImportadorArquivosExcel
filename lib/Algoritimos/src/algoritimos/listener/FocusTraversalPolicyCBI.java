package algoritimos.listener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.List;
import javax.swing.JScrollPane;

/**
 *
 * @author Tiago D. Teixeira
 */
public class FocusTraversalPolicyCBI extends FocusTraversalPolicy{

    private final JScrollPane scroll;
    private final List<Component> componentes;
    
    public FocusTraversalPolicyCBI(JScrollPane scroll, List<Component> componentes){
        super();
        this.scroll = scroll;
        this.componentes = componentes;
    }

    @Override
    public Component getComponentAfter(Container aContainer, Component aComponent) {
        int index = componentes.indexOf(aComponent) + 1;
        int position = aComponent.getX() - 30;
        scroll.getVerticalScrollBar().setValue(position);
        
        return componentes.get(index);
    }

    @Override
    public Component getComponentBefore(Container aContainer, Component aComponent) {
        int index = componentes.indexOf(aComponent) - 1;
        return componentes.get(index);
    }

    @Override
    public Component getFirstComponent(Container aContainer) {
        return componentes.get(0);
    }

    @Override
    public Component getLastComponent(Container aContainer) {
        return componentes.get(componentes.size() - 1);
    }

    @Override
    public Component getDefaultComponent(Container aContainer) {
        return componentes.get(0);
    }

    
}
