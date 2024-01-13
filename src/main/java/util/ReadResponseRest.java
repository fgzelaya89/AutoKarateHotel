package util;


import com.fasterxml.jackson.databind.ObjectMapper;
import model.responseRest.ResponseRest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadResponseRest {
    public static void main(String[] args) {

        //System.out.println("requestREST(): \n\t" + requestREST());
        String response = responseRest();
        System.out.println();
        System.out.println("--------------getResponseRest(jsonString)-------------------");
        System.out.println(getResponseRest(response.toString()));
    }

    public static String responseRest() {
        String SOURCE_PATH = "src/main/resources/responseRest.json";
        try {
            File file = new File(SOURCE_PATH);
            // Crear un FileReader para leer el archivo
            FileReader fileReader = new FileReader(file);
            // Usar un BufferedReader para leer el archivo de manera eficiente
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Variable para almacenar el contenido del archivo
            StringBuilder content = new StringBuilder();

            // Leer cada línea del archivo y agregarla al StringBuilder
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // Cerrar recursos
            bufferedReader.close();
            fileReader.close();

            // Imprimir el contenido del archivo como String
            System.out.println("Contenido del archivo:\n" + content.toString());

            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("------ERROR--------");
        }
        return "{}";
    }

    // mapeamos los datos obtenidos del response json a un objeto de la clase ResponseRest
    public static ResponseRest getResponseRest(String jsonString) {
        ResponseRest responseRest =null;
        try {
            // Crear un objeto ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Convertir el JSON a la clase Persona
             responseRest = objectMapper.readValue(jsonString, ResponseRest.class);

            // Imprimir la instancia de la clase Persona
           // System.out.println(responseRest);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] Fallo Metodo getResponseRest de la clase LeectorRequestRest");
        }
        return responseRest;
    }
}
