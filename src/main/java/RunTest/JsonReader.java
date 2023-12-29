package RunTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.NumeroTexto;
import model.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader{
    public static void main(String[] args) {
        int con =1;
        List<TestCase> listaTestCase = new ArrayList<TestCase>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Ruta al archivo JSON
            File jsonFile = new File("src/main/resources/numero.json");

            // Lee el JSON y conviértelo en una lista de objetos
            List<NumeroTexto> listaNumeros = objectMapper.readValue(jsonFile, new TypeReference<List<NumeroTexto>>() {});


            // Imprime la lista de objetos
            for (NumeroTexto numeroTexto : listaNumeros) {
                //System.out.println(numeroTexto.getNumero() + ": " + numeroTexto.getTextoNumero());
                listaTestCase.add( new TestCase(con,numeroTexto));
                con++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
