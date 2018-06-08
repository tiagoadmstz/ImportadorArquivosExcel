package algoritimos.frames;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import algoritimos.controle.ControleInstancias;
import algoritimos.listener.ListenerCBI;
import algoritimos.tabelas.TableModelCBI;
import java.awt.Frame;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Tiago D. Teixeira
 */
public class ConsultaForm extends javax.swing.JFrame {

    /**
     * Creates new form PesquisaProdutoOSFrom
     */
    private final ConsultaListener listener;
    public final static int PRODUTOS = 0;
    public final static int ENTIDADES = 1;
    public final static int SERVICOS = 2;

    public ConsultaForm() {
        this.setImageIcon();
        initComponents();
        listener = new ConsultaListener(this);
    }

    public void setParametros(String legenda, String campoDescricao, int columnDescricao,
            int tipoListaPesquisa, String nomeFormRequisicao, TableModelCBI model,
            TableModelCBI modelSolicitante, List<?> lista) {
        this.setLegenda(legenda);
        this.setCampoDescricao(campoDescricao, columnDescricao);
        this.setListaPesquisa(tipoListaPesquisa);
        this.setNomeFormRequisicao(nomeFormRequisicao);
        this.setTableModel(model, lista);
        this.setTableModelSolicitante(modelSolicitante);
    }

    private void setImageIcon() {
        setIconImage(new ImageIcon(getClass().getResource("/br/com/cbi/images/iconeCBI.gif")).getImage());
    }

    @Override
    public void requestFocus() {
        super.requestFocus();
        this.setState(Frame.NORMAL);
    }

    public void setTableModel(TableModelCBI tableModel, List<?> lista) {
        listener.addModel(tableModel, lista);
    }

    public void setTableModelSolicitante(TableModelCBI tableModelSolicitante) {
        listener.setModelSolicitante(tableModelSolicitante);
    }

    public void setColumnSize(int... tamanho) {
        listener.setColumnSize(tamanho);
    }

    public void setListenerSolicitante(ListenerCBI listenerSolicitante) {
        listener.setListenerSolicitante(listenerSolicitante);
    }

    public void setLegenda(String legenda) {
        this.setTitle(legenda);
    }

    public void setCampoDescricao(String campoDescricao, int column) {
        listener.setCampoDescricao(campoDescricao, column);
    }

    public void setNomeFormRequisicao(String nomeForm) {
        listener.setNomeFormRequisicao(nomeForm);
    }

    public void setListaPesquisa(int tipoLista) {
        listener.setListaPesquisa(tipoLista);

    }

    public JPanel getPainelBotoes() {
        return painelBotoes;
    }

    public void setPainelBotoes(JPanel painelBotoes) {
        this.painelBotoes = painelBotoes;
    }

    public JButton getBt0() {
        return bt0;
    }

    public void setBt0(JButton bt0) {
        this.bt0 = bt0;
    }

    public JButton getBt1() {
        return bt1;
    }

    public void setBt1(JButton bt1) {
        this.bt1 = bt1;
    }

    public JButton getBt2() {
        return bt2;
    }

    public void setBt2(JButton bt2) {
        this.bt2 = bt2;
    }

    public JButton getBt3() {
        return bt3;
    }

    public void setBt3(JButton bt3) {
        this.bt3 = bt3;
    }

    public JButton getBt4() {
        return bt4;
    }

    public void setBt4(JButton bt4) {
        this.bt4 = bt4;
    }

    public JButton getBt5() {
        return bt5;
    }

    public void setBt5(JButton bt5) {
        this.bt5 = bt5;
    }

    public JButton getBt6() {
        return bt6;
    }

    public void setBt6(JButton bt6) {
        this.bt6 = bt6;
    }

    public JButton getBt7() {
        return bt7;
    }

    public void setBt7(JButton bt7) {
        this.bt7 = bt7;
    }

    public JButton getBt8() {
        return bt8;
    }

    public void setBt8(JButton bt8) {
        this.bt8 = bt8;
    }

    public JButton getBt9() {
        return bt9;
    }

    public void setBt9(JButton bt9) {
        this.bt9 = bt9;
    }

    public JButton getBtA() {
        return btA;
    }

    public void setBtA(JButton btA) {
        this.btA = btA;
    }

    public JButton getBtB() {
        return btB;
    }

    public void setBtB(JButton btB) {
        this.btB = btB;
    }

    public JButton getBtC() {
        return btC;
    }

    public void setBtC(JButton btC) {
        this.btC = btC;
    }

    public JButton getBtCadastro() {
        return btCadastro;
    }

    public void setBtCadastro(JButton btCadastro) {
        this.btCadastro = btCadastro;
    }

    public JButton getBtD() {
        return btD;
    }

    public void setBtD(JButton btD) {
        this.btD = btD;
    }

    public JButton getBtE() {
        return btE;
    }

    public void setBtE(JButton btE) {
        this.btE = btE;
    }

    public JButton getBtF() {
        return btF;
    }

    public void setBtF(JButton btF) {
        this.btF = btF;
    }

    public JButton getBtG() {
        return btG;
    }

    public void setBtG(JButton btG) {
        this.btG = btG;
    }

    public JButton getBtH() {
        return btH;
    }

    public void setBtH(JButton btH) {
        this.btH = btH;
    }

    public JButton getBtI() {
        return btI;
    }

    public void setBtI(JButton btI) {
        this.btI = btI;
    }

    public JButton getBtJ() {
        return btJ;
    }

    public void setBtJ(JButton btJ) {
        this.btJ = btJ;
    }

    public JButton getBtK() {
        return btK;
    }

    public void setBtK(JButton btK) {
        this.btK = btK;
    }

    public JButton getBtL() {
        return btL;
    }

    public void setBtL(JButton btL) {
        this.btL = btL;
    }

    public JButton getBtM() {
        return btM;
    }

    public void setBtM(JButton btM) {
        this.btM = btM;
    }

    public JButton getBtN() {
        return btN;
    }

    public void setBtN(JButton btN) {
        this.btN = btN;
    }

    public JButton getBtO() {
        return btO;
    }

    public void setBtO(JButton btO) {
        this.btO = btO;
    }

    public JButton getBtP() {
        return btP;
    }

    public void setBtP(JButton btP) {
        this.btP = btP;
    }

    public JButton getBtPesquisa() {
        return btPesquisa;
    }

    public void setBtPesquisa(JButton btPesquisa) {
        this.btPesquisa = btPesquisa;
    }

    public JButton getBtQ() {
        return btQ;
    }

    public void setBtQ(JButton btQ) {
        this.btQ = btQ;
    }

    public JButton getBtR() {
        return btR;
    }

    public void setBtR(JButton btR) {
        this.btR = btR;
    }

    public JButton getBtReset() {
        return btReset;
    }

    public void setBtReset(JButton btReset) {
        this.btReset = btReset;
    }

    public JButton getBtS() {
        return btS;
    }

    public void setBtS(JButton btS) {
        this.btS = btS;
    }

    public JButton getBtT() {
        return btT;
    }

    public void setBtT(JButton btT) {
        this.btT = btT;
    }

    public JButton getBtU() {
        return btU;
    }

    public void setBtU(JButton btU) {
        this.btU = btU;
    }

    public JButton getBtV() {
        return btV;
    }

    public void setBtV(JButton btV) {
        this.btV = btV;
    }

    public JButton getBtW() {
        return btW;
    }

    public void setBtW(JButton btW) {
        this.btW = btW;
    }

    public JButton getBtX() {
        return btX;
    }

    public void setBtX(JButton btX) {
        this.btX = btX;
    }

    public JButton getBtY() {
        return btY;
    }

    public void setBtY(JButton btY) {
        this.btY = btY;
    }

    public JButton getBtZ() {
        return btZ;
    }

    public void setBtZ(JButton btZ) {
        this.btZ = btZ;
    }

    public JComboBox getCbPesquisa() {
        return cbPesquisa;
    }

    public void setCbPesquisa(JComboBox cbPesquisa) {
        this.cbPesquisa = cbPesquisa;
    }

    public JMenuItem getItemFechar() {
        return itemFechar;
    }

    public void setItemFechar(JMenuItem itemFechar) {
        this.itemFechar = itemFechar;
    }

    public JPanel getPainelCabecalho() {
        return painelCabecalho;
    }

    public void setPainelCabecalho(JPanel painelCabecalho) {
        this.painelCabecalho = painelCabecalho;
    }

    public JPanel getPainelPesquisa() {
        return painelPesquisa;
    }

    public void setPainelPesquisa(JPanel painelPesquisa) {
        this.painelPesquisa = painelPesquisa;
    }

    public JScrollPane getScPesquisa() {
        return scPesquisa;
    }

    public void setScPesquisa(JScrollPane scPesquisa) {
        this.scPesquisa = scPesquisa;
    }

    public JTable getTbPesquisa() {
        return tbPesquisa;
    }

    public void setTbPesquisa(JTable tbPesquisa) {
        this.tbPesquisa = tbPesquisa;
    }

    public JTextField getTxtPesquisa() {
        return txtPesquisa;
    }

    public void setTxtPesquisa(JTextField txtPesquisa) {
        this.txtPesquisa = txtPesquisa;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCabecalho = new javax.swing.JPanel();
        btCadastro = new javax.swing.JButton();
        painelPesquisa = new javax.swing.JPanel();
        cbPesquisa = new javax.swing.JComboBox();
        txtPesquisa = new javax.swing.JTextField();
        btPesquisa = new javax.swing.JButton();
        painelBotoes = new javax.swing.JPanel();
        bt0 = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        bt7 = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        bt9 = new javax.swing.JButton();
        btA = new javax.swing.JButton();
        btB = new javax.swing.JButton();
        btC = new javax.swing.JButton();
        btD = new javax.swing.JButton();
        btE = new javax.swing.JButton();
        btF = new javax.swing.JButton();
        btG = new javax.swing.JButton();
        btH = new javax.swing.JButton();
        btI = new javax.swing.JButton();
        btJ = new javax.swing.JButton();
        btL = new javax.swing.JButton();
        btM = new javax.swing.JButton();
        btN = new javax.swing.JButton();
        btO = new javax.swing.JButton();
        btP = new javax.swing.JButton();
        btQ = new javax.swing.JButton();
        btR = new javax.swing.JButton();
        btS = new javax.swing.JButton();
        btT = new javax.swing.JButton();
        btU = new javax.swing.JButton();
        btV = new javax.swing.JButton();
        btX = new javax.swing.JButton();
        btZ = new javax.swing.JButton();
        btW = new javax.swing.JButton();
        btY = new javax.swing.JButton();
        btK = new javax.swing.JButton();
        btReset = new javax.swing.JButton();
        scPesquisa = new javax.swing.JScrollPane();
        tbPesquisa = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        itemFechar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultas");
        setMinimumSize(new java.awt.Dimension(720, 453));
        setName("PesquisaProdutoOSForm"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        painelCabecalho.setBackground(new java.awt.Color(63, 63, 63));
        painelCabecalho.setPreferredSize(new java.awt.Dimension(800, 94));

        btCadastro.setBackground(new java.awt.Color(243, 243, 243));
        btCadastro.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btCadastro.setForeground(new java.awt.Color(255, 194, 14));
        btCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cbi/images/pesquisaIcon.png"))); // NOI18N
        btCadastro.setActionCommand("cadastro");
        btCadastro.setBorder(null);
        btCadastro.setBorderPainted(false);
        btCadastro.setContentAreaFilled(false);
        btCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout painelCabecalhoLayout = new javax.swing.GroupLayout(painelCabecalho);
        painelCabecalho.setLayout(painelCabecalhoLayout);
        painelCabecalhoLayout.setHorizontalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelCabecalhoLayout.setVerticalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        painelPesquisa.setPreferredSize(new java.awt.Dimension(800, 87));

        cbPesquisa.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        cbPesquisa.setToolTipText("");
        cbPesquisa.setActionCommand("campoPesquisa");

        txtPesquisa.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtPesquisa.setToolTipText("");
        txtPesquisa.setName("descricao"); // NOI18N

        btPesquisa.setBackground(new java.awt.Color(243, 243, 243));
        btPesquisa.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btPesquisa.setForeground(new java.awt.Color(255, 194, 14));
        btPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cbi/images/buscaSemanticaIcon.png"))); // NOI18N
        btPesquisa.setActionCommand("pesquisar");
        btPesquisa.setBorder(null);
        btPesquisa.setBorderPainted(false);
        btPesquisa.setContentAreaFilled(false);
        btPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        bt0.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt0.setForeground(new java.awt.Color(255, 0, 0));
        bt0.setText("0");
        bt0.setActionCommand("letra");
        bt0.setBorder(null);
        bt0.setBorderPainted(false);
        bt0.setContentAreaFilled(false);

        bt1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt1.setForeground(new java.awt.Color(255, 0, 0));
        bt1.setText("1");
        bt1.setActionCommand("letra");
        bt1.setBorder(null);
        bt1.setBorderPainted(false);
        bt1.setContentAreaFilled(false);

        bt2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt2.setForeground(new java.awt.Color(255, 0, 0));
        bt2.setText("2");
        bt2.setActionCommand("letra");
        bt2.setBorder(null);
        bt2.setBorderPainted(false);
        bt2.setContentAreaFilled(false);

        bt3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt3.setForeground(new java.awt.Color(255, 0, 0));
        bt3.setText("3");
        bt3.setActionCommand("letra");
        bt3.setBorder(null);
        bt3.setBorderPainted(false);
        bt3.setContentAreaFilled(false);

        bt4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt4.setForeground(new java.awt.Color(255, 0, 0));
        bt4.setText("4");
        bt4.setActionCommand("letra");
        bt4.setBorder(null);
        bt4.setBorderPainted(false);
        bt4.setContentAreaFilled(false);

        bt5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt5.setForeground(new java.awt.Color(255, 0, 0));
        bt5.setText("5");
        bt5.setActionCommand("letra");
        bt5.setBorder(null);
        bt5.setBorderPainted(false);
        bt5.setContentAreaFilled(false);

        bt6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt6.setForeground(new java.awt.Color(255, 0, 0));
        bt6.setText("6");
        bt6.setActionCommand("letra");
        bt6.setBorder(null);
        bt6.setBorderPainted(false);
        bt6.setContentAreaFilled(false);

        bt7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt7.setForeground(new java.awt.Color(255, 0, 0));
        bt7.setText("7");
        bt7.setActionCommand("letra");
        bt7.setBorder(null);
        bt7.setBorderPainted(false);
        bt7.setContentAreaFilled(false);

        bt8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt8.setForeground(new java.awt.Color(255, 0, 0));
        bt8.setText("8");
        bt8.setActionCommand("letra");
        bt8.setBorder(null);
        bt8.setBorderPainted(false);
        bt8.setContentAreaFilled(false);

        bt9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bt9.setForeground(new java.awt.Color(255, 0, 0));
        bt9.setText("9");
        bt9.setActionCommand("letra");
        bt9.setBorder(null);
        bt9.setBorderPainted(false);
        bt9.setContentAreaFilled(false);

        btA.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btA.setForeground(new java.awt.Color(255, 0, 0));
        btA.setText("A");
        btA.setActionCommand("letra");
        btA.setBorder(null);
        btA.setBorderPainted(false);
        btA.setContentAreaFilled(false);

        btB.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btB.setForeground(new java.awt.Color(255, 0, 0));
        btB.setText("B");
        btB.setActionCommand("letra");
        btB.setBorder(null);
        btB.setBorderPainted(false);
        btB.setContentAreaFilled(false);

        btC.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btC.setForeground(new java.awt.Color(255, 0, 0));
        btC.setText("C");
        btC.setActionCommand("letra");
        btC.setBorder(null);
        btC.setBorderPainted(false);
        btC.setContentAreaFilled(false);

        btD.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btD.setForeground(new java.awt.Color(255, 0, 0));
        btD.setText("D");
        btD.setActionCommand("letra");
        btD.setBorder(null);
        btD.setBorderPainted(false);
        btD.setContentAreaFilled(false);

        btE.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btE.setForeground(new java.awt.Color(255, 0, 0));
        btE.setText("E");
        btE.setActionCommand("letra");
        btE.setBorder(null);
        btE.setBorderPainted(false);
        btE.setContentAreaFilled(false);

        btF.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btF.setForeground(new java.awt.Color(255, 0, 0));
        btF.setText("F");
        btF.setActionCommand("letra");
        btF.setBorder(null);
        btF.setBorderPainted(false);
        btF.setContentAreaFilled(false);

        btG.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btG.setForeground(new java.awt.Color(255, 0, 0));
        btG.setText("G");
        btG.setActionCommand("letra");
        btG.setBorder(null);
        btG.setBorderPainted(false);
        btG.setContentAreaFilled(false);

        btH.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btH.setForeground(new java.awt.Color(255, 0, 0));
        btH.setText("H");
        btH.setActionCommand("letra");
        btH.setBorder(null);
        btH.setBorderPainted(false);
        btH.setContentAreaFilled(false);

        btI.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btI.setForeground(new java.awt.Color(255, 0, 0));
        btI.setText("I");
        btI.setActionCommand("letra");
        btI.setBorder(null);
        btI.setBorderPainted(false);
        btI.setContentAreaFilled(false);

        btJ.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btJ.setForeground(new java.awt.Color(255, 0, 0));
        btJ.setText("J");
        btJ.setActionCommand("letra");
        btJ.setBorder(null);
        btJ.setBorderPainted(false);
        btJ.setContentAreaFilled(false);

        btL.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btL.setForeground(new java.awt.Color(255, 0, 0));
        btL.setText("L");
        btL.setActionCommand("letra");
        btL.setBorder(null);
        btL.setBorderPainted(false);
        btL.setContentAreaFilled(false);

        btM.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btM.setForeground(new java.awt.Color(255, 0, 0));
        btM.setText("M");
        btM.setActionCommand("letra");
        btM.setBorder(null);
        btM.setBorderPainted(false);
        btM.setContentAreaFilled(false);

        btN.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btN.setForeground(new java.awt.Color(255, 0, 0));
        btN.setText("N");
        btN.setActionCommand("letra");
        btN.setBorder(null);
        btN.setBorderPainted(false);
        btN.setContentAreaFilled(false);

        btO.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btO.setForeground(new java.awt.Color(255, 0, 0));
        btO.setText("O");
        btO.setActionCommand("letra");
        btO.setBorder(null);
        btO.setBorderPainted(false);
        btO.setContentAreaFilled(false);

        btP.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btP.setForeground(new java.awt.Color(255, 0, 0));
        btP.setText("P");
        btP.setActionCommand("letra");
        btP.setBorder(null);
        btP.setBorderPainted(false);
        btP.setContentAreaFilled(false);

        btQ.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btQ.setForeground(new java.awt.Color(255, 0, 0));
        btQ.setText("Q");
        btQ.setActionCommand("letra");
        btQ.setBorder(null);
        btQ.setBorderPainted(false);
        btQ.setContentAreaFilled(false);

        btR.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btR.setForeground(new java.awt.Color(255, 0, 0));
        btR.setText("R");
        btR.setActionCommand("letra");
        btR.setBorder(null);
        btR.setBorderPainted(false);
        btR.setContentAreaFilled(false);

        btS.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btS.setForeground(new java.awt.Color(255, 0, 0));
        btS.setText("S");
        btS.setActionCommand("letra");
        btS.setBorder(null);
        btS.setBorderPainted(false);
        btS.setContentAreaFilled(false);

        btT.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btT.setForeground(new java.awt.Color(255, 0, 0));
        btT.setText("T");
        btT.setActionCommand("letra");
        btT.setBorder(null);
        btT.setBorderPainted(false);
        btT.setContentAreaFilled(false);

        btU.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btU.setForeground(new java.awt.Color(255, 0, 0));
        btU.setText("U");
        btU.setActionCommand("letra");
        btU.setBorder(null);
        btU.setBorderPainted(false);
        btU.setContentAreaFilled(false);

        btV.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btV.setForeground(new java.awt.Color(255, 0, 0));
        btV.setText("V");
        btV.setActionCommand("letra");
        btV.setBorder(null);
        btV.setBorderPainted(false);
        btV.setContentAreaFilled(false);

        btX.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btX.setForeground(new java.awt.Color(255, 0, 0));
        btX.setText("X");
        btX.setActionCommand("letra");
        btX.setBorder(null);
        btX.setBorderPainted(false);
        btX.setContentAreaFilled(false);

        btZ.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btZ.setForeground(new java.awt.Color(255, 0, 0));
        btZ.setText("Z");
        btZ.setActionCommand("letra");
        btZ.setBorder(null);
        btZ.setBorderPainted(false);
        btZ.setContentAreaFilled(false);

        btW.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btW.setForeground(new java.awt.Color(255, 0, 0));
        btW.setText("W");
        btW.setActionCommand("letra");
        btW.setBorder(null);
        btW.setBorderPainted(false);
        btW.setContentAreaFilled(false);

        btY.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btY.setForeground(new java.awt.Color(255, 0, 0));
        btY.setText("Y");
        btY.setActionCommand("letra");
        btY.setBorder(null);
        btY.setBorderPainted(false);
        btY.setContentAreaFilled(false);

        btK.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btK.setForeground(new java.awt.Color(255, 0, 0));
        btK.setText("K");
        btK.setActionCommand("letra");
        btK.setBorder(null);
        btK.setBorderPainted(false);
        btK.setContentAreaFilled(false);

        btReset.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btReset.setForeground(new java.awt.Color(255, 0, 0));
        btReset.setText("...");
        btReset.setActionCommand("letra");
        btReset.setBorder(null);
        btReset.setBorderPainted(false);
        btReset.setContentAreaFilled(false);

        javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
        painelBotoes.setLayout(painelBotoesLayout);
        painelBotoesLayout.setHorizontalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painelBotoesLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btM, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btN, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btO, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btP, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btQ, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btR, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btS, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btT, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btU, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btV, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btX, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btZ, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btW, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btY, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btK, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btReset, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelBotoesLayout.createSequentialGroup()
                        .addComponent(bt0, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btA, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btB, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btC, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btD, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btE, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btF, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btG, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btH, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(btI, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btJ, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btL, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelBotoesLayout.setVerticalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt0)
                    .addComponent(bt1)
                    .addComponent(bt2)
                    .addComponent(bt3)
                    .addComponent(bt4)
                    .addComponent(bt5)
                    .addComponent(bt6)
                    .addComponent(bt7)
                    .addComponent(bt8)
                    .addComponent(bt9)
                    .addComponent(btA)
                    .addComponent(btB)
                    .addComponent(btC)
                    .addComponent(btD)
                    .addComponent(btE)
                    .addComponent(btF)
                    .addComponent(btG)
                    .addComponent(btH)
                    .addComponent(btI)
                    .addComponent(btJ)
                    .addComponent(btL))
                .addGap(6, 6, 6)
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btM)
                    .addComponent(btN)
                    .addComponent(btO)
                    .addComponent(btP)
                    .addComponent(btQ)
                    .addComponent(btR)
                    .addComponent(btS)
                    .addComponent(btT)
                    .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btX)
                        .addComponent(btV)
                        .addComponent(btU))
                    .addComponent(btZ)
                    .addComponent(btW)
                    .addComponent(btY)
                    .addComponent(btK)
                    .addComponent(btReset))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout painelPesquisaLayout = new javax.swing.GroupLayout(painelPesquisa);
        painelPesquisa.setLayout(painelPesquisaLayout);
        painelPesquisaLayout.setHorizontalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisaLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelPesquisaLayout.createSequentialGroup()
                        .addComponent(cbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        painelPesquisaLayout.setVerticalGroup(
            painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btPesquisa))
                .addGap(10, 10, 10)
                .addComponent(painelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbPesquisa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        scPesquisa.setViewportView(tbPesquisa);

        menuBar.setPreferredSize(new java.awt.Dimension(0, 0));

        menuArquivo.setText("File");

        itemFechar.setText("fechar");
        itemFechar.setToolTipText("");
        menuArquivo.add(itemFechar);

        menuBar.add(menuArquivo);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addComponent(painelPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(scPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ControleInstancias.removeInstance(ConsultaForm.class.getName());
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt0;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JButton bt7;
    private javax.swing.JButton bt8;
    private javax.swing.JButton bt9;
    private javax.swing.JButton btA;
    private javax.swing.JButton btB;
    private javax.swing.JButton btC;
    private javax.swing.JButton btCadastro;
    private javax.swing.JButton btD;
    private javax.swing.JButton btE;
    private javax.swing.JButton btF;
    private javax.swing.JButton btG;
    private javax.swing.JButton btH;
    private javax.swing.JButton btI;
    private javax.swing.JButton btJ;
    private javax.swing.JButton btK;
    private javax.swing.JButton btL;
    private javax.swing.JButton btM;
    private javax.swing.JButton btN;
    private javax.swing.JButton btO;
    private javax.swing.JButton btP;
    private javax.swing.JButton btPesquisa;
    private javax.swing.JButton btQ;
    private javax.swing.JButton btR;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btS;
    private javax.swing.JButton btT;
    private javax.swing.JButton btU;
    private javax.swing.JButton btV;
    private javax.swing.JButton btW;
    private javax.swing.JButton btX;
    private javax.swing.JButton btY;
    private javax.swing.JButton btZ;
    private javax.swing.JComboBox cbPesquisa;
    private javax.swing.JMenuItem itemFechar;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JPanel painelPesquisa;
    private javax.swing.JScrollPane scPesquisa;
    private javax.swing.JTable tbPesquisa;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
