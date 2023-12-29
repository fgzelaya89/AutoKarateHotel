package RunTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class test {
    public static void main(String[] args) {
        String fechaHoraEntrada = "11/30/2023 2:52 p. m.";

        // Crear un DateTimeFormatter para el formato de entrada
        DateTimeFormatter formatterEntrada = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a");

        // Parsear la fecha y hora de la cadena de entrada
        LocalDateTime dateTime = LocalDateTime.parse(fechaHoraEntrada, formatterEntrada);

        // Crear un DateTimeFormatter para el formato de salida
        DateTimeFormatter formatterSalida = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        // Formatear la fecha y hora al nuevo formato
        String fechaHoraSalida = dateTime.format(formatterSalida);

        System.out.println("Fecha y hora convertidas: " + fechaHoraSalida);

    }
}
