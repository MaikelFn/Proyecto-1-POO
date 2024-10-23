package Clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cajero {
    
    // URLs base para la consulta
    private static final String URL_VENTA = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicosXML?Indicador=317&FechaInicio=%s&FechaFinal=%s&Nombre=Profit&SubNiveles=N&CorreoElectronico=bancoprofit@gmail.com&Token=7OORAALCP0";
    private static final String URL_COMPRA = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicosXML?Indicador=318&FechaInicio=%s&FechaFinal=%s&Nombre=Profit&SubNiveles=N&CorreoElectronico=bancoprofit@gmail.com&Token=7OORAALCP0";
    
    public static void consultarTipoCambio(String tipo) {
        try {

            LocalDate fechaInicio = LocalDate.now();
            LocalDate fechaFinal = fechaInicio.plusDays(7);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            String fechaInicioStr = fechaInicio.format(formatter);
            String fechaFinalStr = fechaFinal.format(formatter);
            
            String url = tipo.equalsIgnoreCase("compra") ? 
                         String.format(URL_COMPRA, fechaInicioStr, fechaFinalStr) :
                         String.format(URL_VENTA, fechaInicioStr, fechaFinalStr);

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            StringBuilder content;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
            }
            connection.disconnect();

            System.out.println("Respuesta del BCCR (" + tipo + "): " + content.toString());

        } catch (IOException e) {
            System.err.println("Error al consultar el tipo de cambio: " + e.getMessage());
        }
    }
}
