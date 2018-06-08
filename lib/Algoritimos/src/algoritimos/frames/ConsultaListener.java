package algoritimos.frames;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import algoritimos.controle.ControleInstancias;
import algoritimos.listener.ListenerCBIAdapter;
import algoritimos.listener.ListenerCBI;
import algoritimos.tabelas.TableModelCBI;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Tiago D. Teixeira
 */
public final class ConsultaListener extends ListenerCBIAdapter {

    private final ConsultaForm form;
    private TableModelCBI model = null;
    private TableModelCBI modelSolicitante = null;
    private ListenerCBI listenerSolicitante = null;
    private final PesquisaRenderer renderer;
    private String nomeFormRequisicao;
    private String campoDescricao;

    public ConsultaListener(ConsultaForm form) {
        this.form = form;
        renderer = new PesquisaRenderer();
        attachListener();
        form.getTxtPesquisa().requestFocus();
    }

    /**
     * Adiciona a identificação por nome do formulário que requisitou o
     * formulário de pesquisa.
     *
     * @param nomeForm nome do formulário que requisitou a pesquisa.
     */
    public void setNomeFormRequisicao(String nomeForm) {
        this.nomeFormRequisicao = nomeForm;
    }

    /**
     * Adiciona o tablemodel do formulário solicitante para fazer as adições da
     * lista
     *
     * @param modelSolicitante modelo da tabela solicitante
     */
    public void setModelSolicitante(TableModelCBI modelSolicitante) {
        this.modelSolicitante = modelSolicitante;
    }

    /**
     * Adiciona um listener do formulário solicitante para fazer adições de
     * objetos
     *
     * @param listenerSolicitante listener do formulário solicitante
     */
    public void setListenerSolicitante(ListenerCBI listenerSolicitante) {
        this.listenerSolicitante = listenerSolicitante;
    }

    /**
     * Campo utilizado para realizar a pesquisa de texto dinamico e ser
     * utilizado para fazer o link de dados ao receber um duplo clique
     *
     * @param campoDescricao nome do campo de descrição da tabela
     * @param column número da coluna onde fica o campo de descrição
     */
    public void setCampoDescricao(String campoDescricao, int column) {
        this.campoDescricao = campoDescricao;
        renderer.setColumnLink(column);
    }

    /**
     * Inseri a lista de campos que podem ser pesquisados neste formulário.
     *
     * @param tipoLista <br> 0 - lista para pesquisa de produtos;
     * <br> 1 - lista para pesquisa de clientes.
     */
    public void setListaPesquisa(int tipoLista) {
        switch (tipoLista) {
            case 0:
                form.getCbPesquisa().addItem("Código Interno");
                form.getCbPesquisa().addItem("Código do Fornecedor");
                form.getCbPesquisa().addItem("Descrição do Produto");
                break;
            case 1:
                form.getCbPesquisa().addItem("Código de Registro");
                form.getCbPesquisa().addItem("Razão Social/Nome");
                form.getCbPesquisa().addItem("Nome Fantasia/Apelido");
                form.getCbPesquisa().addItem("CNPJ/CPF");
                form.getCbPesquisa().addItem("IE/RG");
                break;
            case 2:
                form.getCbPesquisa().addItem("Descrição Serviço");
                break;
            case 3:
                form.getCbPesquisa().addItem("Ordem de Serviço");
                form.getCbPesquisa().addItem("Número de Série");
                form.getCbPesquisa().addItem("Categoria");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "cadastro":
                switch (nomeFormRequisicao) {
                    case "cadProdutosForm":
                        break;
                    case "cadEntidadesForm":
                        break;
                }
                break;
            case "pesquisar":
                //model.aplicarFiltro(form.getCbPesquisa().getSelectedIndex(), form.getTxtPesquisa().getText());
                form.getTxtPesquisa().requestFocus();
                break;
            case "fechar":
                fechar(form);
                break;
            case "letra":
                JButton bt = (JButton) e.getSource();
                if (!"...".equals(bt.getText())) {
                    //model.aplicarFiltroLetra(campoDescricao, bt.getText());
                } else if ("...".equals(bt.getText())) {
                    model.resetarLista();
                }
                form.getTxtPesquisa().requestFocus();
        }
    }

    @Override
    public void attachListener() {
        for (Component bt : form.getPainelBotoes().getComponents()) {
            JButton b = (JButton) bt;
            b.addActionListener(this);
        }
        form.getBtCadastro().addActionListener(this);
        form.getBtPesquisa().addActionListener(this);
        form.getCbPesquisa().addItemListener(this);
        form.getTbPesquisa().addMouseListener(this);
        form.getTxtPesquisa().addKeyListener(this);
        form.getItemFechar().addActionListener(this);
        fecharESC(form.getItemFechar());
    }

    public void setColumnSize(int... tamanho) {
        int column = 0;
        for (int t : tamanho) {
            form.getTbPesquisa().getColumnModel().getColumn(column++).setPreferredWidth(t);
        }
    }

    public void addModel(TableModelCBI tableModel, List<?> lista) {
        model = tableModel;
        model.addLista(lista);
        //form.getTbPesquisa().setModel(model);

        for (int i = 0; i < form.getTbPesquisa().getColumnCount(); i++) {
            if (form.getTbPesquisa().getColumnClass(i) != Boolean.class) {
                form.getTbPesquisa().getColumnModel().getColumn(i).setCellRenderer(renderer);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            if (modelSolicitante != null) {
                /*if (modelSolicitante instanceof ProdutosOSTableModel) {
                Estoque estoque = (Estoque) model.getObject(form.getTbPesquisa().getSelectedRow());
                ProdutosOS p = new ProdutosOS();
                p.setCodigoInterno(estoque.getId().toString());
                p.setDescricaoProduto(estoque.getDescricaoProduto());
                p.setLote(estoque.getLote());
                p.setQuantidade(1d);
                p.setRealizado(false);
                String quant = JOptionPane.showInputDialog(form, "Qual a quantidade a ser inserida?", "Inserir Produto", JOptionPane.OK_CANCEL_OPTION);
                quant = quant.replace(",", ".");
                p.setQuantidade(Double.parseDouble(quant));
                modelSolicitante.addObject(p);
                } else if (modelSolicitante instanceof ServicosOSTableModel) {
                CatalogoServicos catServico = (CatalogoServicos) model.getObject(form.getTbPesquisa().getSelectedRow());
                ServicosOS s = new ServicosOS();
                s.setDescricaoServico(catServico.getDescricaoServico());
                String quant = JOptionPane.showInputDialog(form, "Qual a quantidade a ser inserida?", "Inserir Servico", JOptionPane.OK_CANCEL_OPTION);
                s.setQuantidade(Double.parseDouble(quant));
                modelSolicitante.addObject(s);
                } else if (modelSolicitante instanceof ProdutosMovimentadosTableModel) {
                Estoque estoque = (Estoque) model.getObject(form.getTbPesquisa().getSelectedRow());
                ProdutosMovimentados pm = new ProdutosMovimentados();
                pm.setIdEstoque(estoque.getId());
                pm.setCodigoInterno(estoque.getCodigoInterno());
                pm.setDescricaoProduto(estoque.getDescricaoProduto());
                pm.setLote(estoque.getLote());
                pm.setValorUnitario(estoque.getValorCompra());
                pm.setRealizado(false);
                String quant = JOptionPane.showInputDialog(form, "Qual a quantidade a ser inserida?", "Inserir Produto", JOptionPane.OK_CANCEL_OPTION);
                quant = quant.replace(",", ".");
                pm.setQuantidade(Double.parseDouble(quant));
                if (!"".equals(pm.getValorUnitario()) && pm.getValorUnitario() == null) {
                Double total = (Double.parseDouble(pm.getValorUnitario()) * pm.getQuantidade());
                pm.setTotal(total.toString());
                }
                    modelSolicitante.addObject(pm);*/
            } else {
                modelSolicitante.addObject(model.getObject(form.getTbPesquisa().getSelectedRow()));
            }
        } else if (listenerSolicitante != null) {
            /*if (listenerSolicitante instanceof ExcecoesListener) {
            ExcecoesEx excecoesEx = (ExcecoesEx) listenerSolicitante.getJPAHelper().getObject("from ExcecoesEx as ex where ex.numeroSerie = :paramSerie",
            "paramSerie", String.valueOf(model.getValueAt(form.getTbPesquisa().getSelectedRow(), 2)));
            listenerSolicitante.setDados(excecoesEx);
            listenerSolicitante.getDados();
            listenerSolicitante.setEnableButtons(Algoritimos.SAVE);
            ControleInstancias.removeInstance(ConsultaForm.class.getName());
            form.dispose();
            } else if (listenerSolicitante instanceof ClienteOsListener) {
            ClienteOsListener clienteListener = (ClienteOsListener) listenerSolicitante;
            clienteListener.setCliente((Entidade) model.getObject(form.getTbPesquisa().getSelectedRow()));
            ControleInstancias.removeInstance(ConsultaForm.class.getName());
            form.dispose();
            } else if (listenerSolicitante instanceof InspecaoRecebimentoListener) {
            InspecaoRecebimentoListener inspecaoListener = (InspecaoRecebimentoListener) listenerSolicitante;
            inspecaoListener.setNomeFornecedor((Entidade) model.getObject(form.getTbPesquisa().getSelectedRow()));
            ControleInstancias.removeInstance(ConsultaForm.class.getName());
            form.dispose();
            }*/
        }
        //System.out.println(model.getObject(form.getTbPesquisa().getSelectedRow()));
        form.getTxtPesquisa().requestFocus();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        form.getTxtPesquisa().requestFocus();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            form.getBtPesquisa().doClick();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        ControleInstancias.removeInstance(ConsultaForm.class
                .getName());

    }

    private class PesquisaRenderer extends DefaultTableCellRenderer {

        private final Color gray = new Color(225, 225, 225);
        private final Color white = new Color(255, 255, 255);
        private int column = 0;

        public void setColumnLink(int column) {
            this.column = column;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (isSelected) {
                renderer.setBackground(Color.blue);
                renderer.setForeground(white);
            } else if (row % 2 != 0 && column != this.column) {
                renderer.setForeground(Color.black);
                renderer.setBackground(gray);
            } else if (row % 2 == 0 && column != this.column) {
                renderer.setForeground(Color.black);
                renderer.setBackground(white);
            } else if (row % 2 != 0 && column == this.column) {
                renderer.setForeground(Color.blue);
                renderer.setBackground(gray);
            } else if (row % 2 == 0 && column == this.column) {
                renderer.setForeground(Color.blue);
                renderer.setBackground(white);
            }

            return renderer;
        }

    }
}
