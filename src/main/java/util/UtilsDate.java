package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.NumeroTexto;
import model.PruebaData;
import model.TestCase;
import model.request.RequestRest.Destination;
import model.request.RequestRest.GuestDistributionsItem;
import model.request.RequestRest.RequestRest;
import model.request.RequestSOAP;
import model.request.testBorrar.RequestMyStoreApi;
import model.responseSOAP.ReadResponseSOAP;
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
        String request = "";
//        for (PruebaData e : readExcelTest()) {
//            System.out.println("<---------TEST_" + e.getIdPrueba() + "---------------->");
//            System.out.println("OBJETO");
//            System.out.println("");
//            System.out.println(e);
//            System.out.println("");
//            System.out.println("REST");
//            System.out.println("");
//            System.out.println("JSON: \n\t" + jsonRequestRest(e));
//            System.out.println("");
//            System.out.println("SOAP");
//            System.out.println("");
//            System.out.println("XML: \n\t" + requestSOAP(e));
//            System.out.println("");
//        }

//        System.out.println("");
//        System.out.println("");
        PruebaData test = getPruebaData("test_28");
        System.out.println(test);
//        System.out.println("<---------getRequestUnaHabitacionSinNino---------------->");
//        String request = getRequestUnaHabitacionSinNino(test);
//        //System.out.println("request:\n\t"+request);
//        System.out.println();
//
//        System.out.println("<---------getRequestUnaHabitacionConNino---------------->");
//        System.out.println();
//        request = getRequestUnaHabitacionConNino(test);
//        //System.out.println("request:\n\t"+request);
//
//        System.out.println();
        System.out.println("<---------requestSOAP---------------->");
        System.out.println();
        request = requestSOAP(test);
        System.out.println("requestSOAP:\n\t" + request);
//
//        System.out.println();
//        System.out.println("<---------requestRest---------------->");
//        System.out.println();
//        RequestRest auxRequest = requestRest(test);
//        System.out.println("request:\n\t" + auxRequest.toString());
//        System.out.println();



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

    public static String responseSOAP(String responseSOAP){
        System.out.println("responseSOAP:\n\t"+responseSOAP);
        String aux = ReadResponseSOAP.getListValorarCombinacionesRbDto(responseSOAP).get(0).toString();
        System.out.println("getListValorarCombinacionesRbDto:\n\t"+aux);
        return "OK";
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

    ///BORRAR
    public static String request(int numero) {
        String request = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:web=\"http://www.dataaccess.com/webservicesserver/\">\n" +
                "        <soap:Header/>\n" +
                "        <soap:Body>\n" +
                "          <web:NumberToDollars>\n" +
                "            <web:dNum>%s</web:dNum>\n" +
                "          </web:NumberToDollars>\n" +
                "        </soap:Body>\n" +
                "      </soap:Envelope>";
        String result = String.format(request, numero);
        return result;
    }

    public static String getRequestUnaHabitacionSinNino(PruebaData testCase) {
        return RequestSOAP.getRequestUnaHabitacionSinNino(testCase);
    }

    public static String getRequestUnaHabitacionConNino(PruebaData testCase) {
        return RequestSOAP.getRequestUnaHabitacionConNino(testCase);
    }

    public static String requestSOAP(PruebaData testCase) {
        return RequestSOAP.request(testCase);
    }

    public static RequestRest requestRest(PruebaData testCase) {
        RequestRest requestRest = new RequestRest();

        //Fecha
        String auxFch = testCase.newFormatFecLle().split("T")[0];
        requestRest.setGuestCheckinDate(auxFch);
        auxFch = testCase.newFormatSal().split("T")[0];
        requestRest.setGuestCheckoutDate(auxFch);

        //destination
        Destination destination = new Destination();
        destination.setCountry(testCase.getCodPai());
        destination.setDestination("");
        destination.addHotels(Integer.parseInt(testCase.getIdeHot()));
        requestRest.setDestination(destination);

        //guest_distributions
        if (Integer.parseInt(testCase.getNumAdu1()) > 0) {
            GuestDistributionsItem dp1 = new GuestDistributionsItem(Integer.parseInt(testCase.getNumAdu1()), Integer.parseInt(testCase.getNumNin1()), 0);
            if (testCase.getNumNin1() != "0") {
                for (int i = 0; i < dp1.getChildren(); i++) {
                    dp1.addChildrenAges(6);
                }
            }
            requestRest.addGuestDistributions(dp1);
        }
        if (Integer.parseInt(testCase.getNumAdu2()) > 0) {
            GuestDistributionsItem dp2 = new GuestDistributionsItem(Integer.parseInt(testCase.getNumAdu2()), Integer.parseInt(testCase.getNumNin2()), 0);
            if (testCase.getNumNin2() != "0") {
                for (int i = 0; i < dp2.getChildren(); i++) {
                    dp2.addChildrenAges(6);
                }
            }
            requestRest.addGuestDistributions(dp2);
        }

        if (Integer.parseInt(testCase.getNumAdu3()) > 0) {
            GuestDistributionsItem dp3 = new GuestDistributionsItem(Integer.parseInt(testCase.getNumAdu3()), Integer.parseInt(testCase.getNumNin3()), 0);
            if (testCase.getNumNin3() != "0") {
                for (int i = 0; i < dp3.getChildren(); i++) {
                    dp3.addChildrenAges(6);
                }
            }
            requestRest.addGuestDistributions(dp3);
        }


        //room_types
        requestRest.addRoomTypes(testCase.getCodTha1());
        if (testCase.getCodTha2() != "") requestRest.addRoomTypes(testCase.getCodTha2());
        if (testCase.getCodTha3() != "") requestRest.addRoomTypes(testCase.getCodTha3());

        //boards
        requestRest.addBoards(testCase.Boards());

        requestRest.setCountryOrigin(testCase.getCodPai());
        requestRest.setChannel("WEB");
        requestRest.setVendor(testCase.AmbitoRest());

        return requestRest;
    }

    public static String jsonRequestRest(PruebaData testCase) {
        RequestRest requestRest = requestRest(testCase);
        // Convertir objeto a formato JSON
        String json = "{ERROR}";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(requestRest);
            System.out.println("JSON generado: " + json);
        } catch (Exception e) {
            System.out.println("[FALLO] El metodo jsonRequestRest de la clase UtilsDate");
            e.printStackTrace();
        }
        return json;
    }


    public static RequestMyStoreApi requestMyStoreApi() {
        return new RequestMyStoreApi(12999, "Nano8", "Diario de informatico", "Libros", "Cordoba", "Interes");
    }

    public static String requestMyStoreApiDos() {
        String r = " {\n" +
                "      \"name\": \"Nano89\",\n" +
                "      \"price\": 12999,\n" +
                "      \"manufacturer\": \"Cordoba\",\n" +
                "      \"category\": \"Libros\",\n" +
                "      \"description\": \"Diario de informatico\",\n" +
                "      \"tags\": \"Interes\"\n" +
                "    }";
        return r;
    }

    public static String requestMyStoreApiTres() throws JsonProcessingException {
        RequestMyStoreApi producto = new RequestMyStoreApi(12999, "Nano8", "Diario de informatico", "Libros", "Cordoba", "Interes");
        // Convertir objeto a formato JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(producto);
        System.out.println("JSON generado: " + json);
        return json;
    }
}
