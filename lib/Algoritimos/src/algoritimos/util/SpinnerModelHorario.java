package algoritimos.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractSpinnerModel;

/**
 *
 * @author Tiago D. Teixeira
 */
public class SpinnerModelHorario extends AbstractSpinnerModel{

    private Integer horas = 0;
    private Integer minutos = 0;

    public SpinnerModelHorario() {
        super();
        getHoraAtual();
    }
    
    @Override
    public Object getValue() {
        String hora = getHorario(horas, minutos);
        return hora;
    }

    @Override
    public void setValue(Object value) {
        String horario = value.toString();
        String[] h = horario.split(":");
        horas = Integer.parseInt(h[0]);
        minutos = Integer.parseInt(h[1]);
        fireStateChanged();
    }

    @Override
    public Object getNextValue() {
            if(horas < 24 && horas != 0){
               if(minutos < 60 && minutos != 0){
                   minutos++;
               } else {
                   horas++;
                   minutos = 0;
               }
            } else if (horas == 0){
                if(minutos == 0){
                    minutos++;
                } else {
                    horas++;
                }
            }else{
                horas = 0;
                minutos = 0;
            }
        return getHorario(horas, minutos);
    }

    @Override
    public Object getPreviousValue() {
        if(horas < 24 && horas != 0){
               if(minutos < 60 && minutos != 0){
                   minutos--;
               } else {
                   horas--;
                   minutos = 0;
               }
        }else if(horas == 0 && minutos == 0){
            horas = 24;
            } else {
                horas = 0;
                minutos = 0;
            }
        return getHorario(horas, minutos);
    }
    
    private String getHorario(int hora, int minuto){
        String horario = "";

        if(hora < 10){
            horario = "0" + hora;
        } else {
            horario = Integer.toString(hora);
        }
        
        horario += ":";
        
        if(minuto < 10){
            horario += ("0" + minuto);
        }else{
            horario += Integer.toString(minuto);
        }
        
        return horario;
    }
    
    private String formateHora(String horario){
        return "";
    }
    
    private String getHoraAtual(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm"); 
	Date date = new Date();
        String hora = dateFormat.format(date);
        String[] h = hora.split(":");
        horas = Integer.parseInt(h[0]);
        minutos = Integer.parseInt(h[1]);
	return hora; 
    }
    
    private boolean verificaHorario(String horario){
        char[] hi = null;
        //verifica o tamanho da string
        if(horario.length() == 4 || horario.length() == 5){
           //faz verificação se todos os itens são números
              horario.getChars(0, (horario.length() -1), hi, 0);
              for(char s:hi){
                  try{
                    if(!":".equals(s)){
                        int i = Integer.parseInt(String.valueOf(s));
                    }
                  }catch(Exception ex){
                      return false;
                  }
              }
        }
        return true;
    }
}
