package RunTest;


import model.PruebaData;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExcelReader {

    public static void main(String[] args) {


        try {
            File f = new File("src/main/resources/excel2003.xlsx");
            InputStream inp = new FileInputStream(f);
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            System.out.println("Fin");

            boolean flagFirRow = true;
            for (Row row : sheet) {
                //Bandera del primer renglon
                if (flagFirRow) {
                    flagFirRow = false;
                } else {
                    PruebaData pruebaData = PruebaData.getPruebaDataRowExcel(row);
                    System.out.println(pruebaData);
                    System.out.println(); // Nueva línea después de cada fila
                }
            }
        } catch (Exception e) {
            System.out.println("Erro");
            e.printStackTrace();
        }
    }
}
