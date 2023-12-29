package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.NumeroTexto;
import model.PruebaData;
import model.TestCase;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UtilsDate {
    public String getValida() {
        return "five hundred and one dollars";
    }

    
    public static void main(String[] args) {
        for (PruebaData e : readExcelTest()) {
            System.out.println("idPrueba: " + e.IdPrueba());
            System.out.println(e.toString());
        }
        System.out.println("");
        PruebaData r = getPruebaData("TEST_310");
        System.out.println(r.toString());
    }

    public static PruebaData getPruebaData(String idPrueba) {

        int auxIdPrueba = Integer.parseInt(idPrueba.split("_")[1]);

        // Utiliza el método filter para filtrar la lista
        PruebaData resultPruebaData = readExcelTest().stream()
                .filter(testCase -> auxIdPrueba == testCase.IdPrueba())
                .findFirst()
                .orElse(null); // Si no se encuentra ningún elemento, devuelve null

        return resultPruebaData;
    }

    public static TestCase getTestCase(String tstCase) {

        // Utiliza el método filter para filtrar la lista
        TestCase resultTestCase = readJsonTest().stream()
                .filter(testCase -> tstCase.equals(String.valueOf(testCase.getNumCaso())))
                .findFirst()
                .orElse(null); // Si no se encuentra ningún elemento, devuelve null

        return resultTestCase;
    }

    public static List<TestCase> readJsonTest() {
        int con = 1;
        List<TestCase> listaTestCase = new ArrayList<TestCase>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Ruta al archivo JSON
            File jsonFile = new File("src/main/resources/numero.json");

            // Lee el JSON y conviértelo en una lista de objetos
            List<NumeroTexto> listaNumeros = objectMapper.readValue(jsonFile, new TypeReference<List<NumeroTexto>>() {
            });


            // Imprime la lista de objetos
            for (NumeroTexto numeroTexto : listaNumeros) {
                //System.out.println(numeroTexto.getNumero() + ": " + numeroTexto.getTextoNumero());
                listaTestCase.add(new TestCase(con, numeroTexto));
                con++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaTestCase;
    }

    public static List<PruebaData> readExcelTest() {
        List<PruebaData> listaPruebaData = new ArrayList<PruebaData>();
        try {
            File f = new File("src/main/resources/excel2003.xlsx");
            InputStream inp = new FileInputStream(f);
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);

            boolean flagFirRow = true;
            for (Row row : sheet) {
                //Bandera del primer renglon
                if (flagFirRow) {
                    flagFirRow = false;
                } else {
                    PruebaData pruebaData = PruebaData.getPruebaDataRowExcel(row);
                    listaPruebaData.add(pruebaData);
                }
            }

        } catch (Exception e) {
            System.out.println("[ERROR] Fallo al ejecutar readExcelTest de la calse UtilsDate");
            e.printStackTrace();
        }
        return listaPruebaData;
    }
}
