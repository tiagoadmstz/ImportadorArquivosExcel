/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.excel.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.logging.Logger;

/**
 *
 * @author tiago.teixeira
 */
//@Log4j2
public class ConvertStringDate {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final long offset = ZonedDateTime.now().getOffset().getLong(ChronoField.OFFSET_SECONDS);

    //@Test
    public void test() {
        ConvertStringDate csd = new ConvertStringDate();
        csd.converteStringDataTimeZoneServer("141600", "100119");
    }

    public ConvertStringDate() {
        super();
    }

    public LocalDateTime converteStringDataTimeZoneServer(String horaOriginal, String dataATratar) {
        LocalDateTime ldt = this.obterDataFormatadaGPS(horaOriginal, dataATratar);
        String dataHoraFormatada = "";
        String dataServidor = "";
        try {
            dataHoraFormatada = ldt.format(dtf);
            dataServidor = ldt.plusSeconds(offset).format(dtf);
            log.info(String.format("> Data Hora GPS -> %s | %s <- Data Hora Servidor.", dataHoraFormatada, dataServidor));
        } catch (Exception e) {
            //log.error(String.format("Erro ao realizar o parse da data/hora [GPS | Servidor] (%s / %s): %s.", dataHoraFormata, dataServidor, e.toString()));
            log.info(String.format("Erro ao realizar o parse da data/hora [GPS | Servidor] (%s / %s): %s.", dataHoraFormatada, dataServidor, e.toString()));
        }
        return ldt;
    }

    private LocalDateTime obterDataFormatadaGPS(String horaOriginal, String dataATratar) {
        //obter horario
        LocalTime time = LocalTime.parse(horaOriginal, DateTimeFormatter.ofPattern("HHmmss"));
        //obter data
        // tratamento para nao perder a compatibilidade com o rastreador anterior
        if (dataATratar.indexOf(",") > 0) {
            dataATratar = dataATratar.substring(dataATratar.indexOf(",") + 1, dataATratar.length());
            dataATratar = dataATratar.substring(dataATratar.indexOf(",") + 1, dataATratar.length());
        }

        LocalDate date = dataATratar.length() == 8
                ? LocalDate.parse(dataATratar, DateTimeFormatter.ofPattern("yyyyMMdd"))
                : LocalDate.parse(dataATratar, DateTimeFormatter.ofPattern("ddMMyy"));

        //formado da data - dd/MM/yyyy HH:mm:ss
        return LocalDateTime.of(date, time);
    }
}
