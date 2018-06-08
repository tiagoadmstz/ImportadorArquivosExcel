package algoritimos.smartcardutil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import javax.smartcardio.*;

/**
 *
 * @author Tiago D. Teixeira
 */
public class SmartCardTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //"Fabrica" de Terminais PC/SC  
        TerminalFactory factory;
        //Lista de Leitores PC/SC  
        List terminals;
        //Terminal PC/SC  
        CardTerminal terminal;
        //Smart Card  
        Card card;
        //Smart Card ATR  
        ATR cardATR;
        //Canal de Comunicação com o Smart Card  
        CardChannel cardChannel;
        //APDU de Comando  
        CommandAPDU commandAPDU;
        //APDU de Resposta  
        ResponseAPDU responseAPDU;
        //Buffer de Auxilio  
        byte[] buffer;

        try {
            //Adquire Fabrica de Leitores  
            factory = TerminalFactory.getDefault();

            //Adquire Lista de Leitores PC/SC no Sistema  
            terminals = factory.terminals().list();
            System.out.println("Lista : " + terminals);

            //Adquire Primeiro Terminal da Lista  
            terminal = (CardTerminal) terminals.get(0);
            System.out.println("Terminal Selecionado: "
                    + terminal.getName());

            //Estabelece Conexão com o Cartão na Leitora  
            card = terminal.connect("*");
            System.out.println("card: " + card);

            //Adquire ATR do Cartão  
            cardATR = card.getATR();
            buffer = cardATR.getBytes();
            System.out.println("ATR : "
                    + formatBuffer(buffer, buffer.length));

            //Adquire Canal de Comunicação  
            cardChannel = card.getBasicChannel();

            //AID do HelloWorld  
            buffer = new byte[]{0x01, 0x02, 0x03, 0x04,
                0x05, 0x06, 0x07, 0x08,
                0x09, 0x00, 0x00};

            //Monta APDU de Envio  
            commandAPDU = new CommandAPDU(
                    0x00, //CLA  
                    0xA4, //INS - SELECT  
                    0x04, //P1  
                    0x00, //P2  
                    buffer);    //AID  

            //Imprime Comando  
            System.out.println("\n[SELECT COMMAND]");
            System.out.println("=> " + formatBuffer(
                    commandAPDU.getBytes(),
                    commandAPDU.getBytes().length));

            //Trasnmite e Recebe  
            responseAPDU = cardChannel.transmit(commandAPDU);

            //Verifica Resposta  
            if (responseAPDU.getSW() != 0x9000) {
                throw new Exception("Falha ao Selecionar : "
                        + String.format("0x%04X",
                                responseAPDU.getSW()));
            }

            //Imprime Resposta  
            System.out.println("<= " + formatBuffer(
                    responseAPDU.getBytes(),
                    responseAPDU.getBytes().length));

            //Bytes de Testes  
            buffer
                    = new byte[]{0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F};

            //Monta APDU de Envio  
            commandAPDU = new CommandAPDU(
                    0x00, //CLA  
                    0x00, //INS  
                    0x00, //P1  
                    0x00, //P2  
                    buffer); //Teste  

            //Imprime Comando  
            System.out.println("\n[TESTE BYTES]");
            System.out.println("=> " + formatBuffer(
                    commandAPDU.getBytes(),
                    commandAPDU.getBytes().length));

            //Trasnmite e Recebe  
            responseAPDU = cardChannel.transmit(commandAPDU);

            //Verifica Resposta  
            if (responseAPDU.getSW() != 0x9000) {
                throw new Exception("Falha ao Selecionar : "
                        + String.format("0x%04X",
                                responseAPDU.getSW()));
            }

            //Imprime Resposta  
            System.out.println("<= " + formatBuffer(
                    responseAPDU.getBytes(),
                    responseAPDU.getBytes().length));

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * Converte Buffer bytes para String
     *
     * @param buffer
     * @param length
     * @return String
     */
    public static String formatBuffer(byte[] buffer, int length) {
        StringBuilder strBuff = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            strBuff.append(String.format("%02X", buffer[i]));
        }
        return strBuff.toString();
    }
}
