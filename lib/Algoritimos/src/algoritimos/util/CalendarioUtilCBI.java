package algoritimos.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Tiago D. Teixeita
 */
public class CalendarioUtilCBI {
    
    private static final Calendar calendario = new GregorianCalendar();
    private static final Date dataAtual = new Date();
    
    private static int diaAtual(){
        Calendar c = Calendar.getInstance();
        c.setTime(dataAtual);
        Format format = new SimpleDateFormat("dd");
        return Integer.parseInt(format.format(c.getTime()));
    }
    
    private static int mesAtual(){
        Calendar c = Calendar.getInstance();
        c.setTime(dataAtual);
        Format format = new SimpleDateFormat("MM");
        return Integer.parseInt(format.format(c.getTime())) - 1;
    }
    
    private static int anoAtual(){
        Calendar c = Calendar.getInstance();
        c.setTime(dataAtual);
        Format format = new SimpleDateFormat("yyyy");
        return Integer.parseInt(format.format(c.getTime()));
    }
    
    public static int getDiaSemana(int dia){
        GregorianCalendar d = new GregorianCalendar(anoAtual(), mesAtual(), dia);
        return d.get(Calendar.DAY_OF_WEEK);
    }
    
    public static int getDiaSemana(){
        GregorianCalendar d = new GregorianCalendar(anoAtual(), mesAtual(), diaAtual());
        return d.get(Calendar.DAY_OF_WEEK);
    }
    
    public static String getDiaSemanaEstenco(int diaSemana){
        switch (diaSemana){
            case 1:
                return "Domingo";
            case 2:
                return "Segunda-feira";
            case 3:
                return "Terça-feira";
            case 4:
                return "Quarta-feira";
            case 5:
                return "Quinta-feira";
            case 6:
                return "Sexta-feira";
            case 7:
                return "Sabádo";
        }    
        return "";
    }
    
    public static String getMesEstenco(int mes){
        switch (mes){
            case 0: 
                return "Janeiro";
            case 1:
                return "Fevereiro";
            case 2:
                return "Março";
            case 3:
                return "Abril";
            case 4:
                return "Maio";
            case 5:
                return "Junho";
            case 6:
                return "Julho";
            case 7:
                return "Agosto";
            case 8:
                return "Setembro";
            case 9:
                return "Outubro";
            case 10:
                return "Novembro";
            case 11:
                return "Dezembro";
        }    
        return "";
    }
    
    public static String  getDataCompletaExtenso(){
        String data = "";
        data = data.concat(getDiaSemanaEstenco(getDiaSemana()));
        data = data.concat(", " + diaAtual() + " de " + getMesEstenco(mesAtual()).toLowerCase() + " de " + anoAtual());
        return data;
    }
}
