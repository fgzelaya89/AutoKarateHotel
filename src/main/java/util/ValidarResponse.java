package util;


import com.fasterxml.jackson.databind.ObjectMapper;
import model.responseRest.*;

import model.responseSOAP.*;

import java.io.IOException;
import java.util.LinkedHashMap;

import net.minidev.json.JSONObject;

public class ValidarResponse {
    private static StringBuilder tablaComparacion = new StringBuilder();
    private static int numComparacion = 1;
    private static int statusSOAP = -1;
    private static int statusRest = -1;

    public static boolean setStatusSOAPRest(String idTestCase, int auxStatusSOAP, int auxStatusRest) {
        statusSOAP = auxStatusSOAP;
        statusRest = auxStatusRest;
        if (statusSOAP != 200 || statusRest != 200) {
            System.out.println("[INFO] La respuesta del servicio SOAP fue: " + statusSOAP);
            System.out.println("[INFO] La respuesta del servicio REST fue: " + statusRest);
            tablaComparacion.append("idTestCase|Num Comp|Campo Comparacion|SOAP|REST|Resultado|\n");
            addFilatablaComparacion(idTestCase, "StatusCode", String.valueOf(statusSOAP), String.valueOf(statusRest), "Uno de los Servicio no responde");
            ExcelWriter.writeToExcel(tablaComparacion.toString());
            resetTabla();
            return false;
        }
        return true;
    }


    public static String resetTabla() {
        numComparacion = 1;
        tablaComparacion = new StringBuilder();
        return "OK";

    }

    public static void main(String[] args) {
        String responseSoap = ReadResponseSOAP.responseSOAPXML();
        ListaAvail listaAvail = ReadResponseSOAP.getlistaAvail(responseSoap);

        String responseRest = ReadResponseRest.responseRest();
        ResponseRest rest = ReadResponseRest.getResponseRest(responseRest);

        validarResponseSoapRest("Test", listaAvail, rest);
        System.out.println();
        System.out.println(getTablaComparacion());

    }

    public static ListaAvail readResponseSOAP(String responseXML) {
        ListaAvail listaAvail = ReadResponseSOAP.getlistaAvail(responseXML);
        int cont = 1;
        for (ValorarCombinacionesRbDto v : listaAvail.getListaAvail()) {
            System.out.println("ValorarCombinacionesRbDto[" + cont + "]: \n\t" + v.toString());
            cont++;
        }
        return listaAvail;
    }

    public static ResponseRest readResponseRest(Object responseJSON) {

        ResponseRest responseRest = null;
        // Crear un ObjectMapper (parte de Jackson) para convertir objetos a JSON
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Convertir PolyglotMap a JSON
            String json = objectMapper.writeValueAsString(responseJSON);
            // Imprimir el JSON resultante
            System.out.println(json);
            //Convertimo
            responseRest = ReadResponseRest.getResponseRest(json);
            System.out.println(responseRest.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return responseRest;
    }

    public static boolean validarResponseSoapRest(String idTestCase, ListaAvail soap, ResponseRest rest) {


        if (statusSOAP != 200 || statusRest != 200) {
            System.out.println("[INFO] La respuesta del servicio SOAP fue: " + statusSOAP);
            System.out.println("[INFO] La respuesta del servicio REST fue: " + statusRest);
            tablaComparacion.append("idTestCase|Num Comp|Campo Comparacion|SOAP|REST|Resultado|\n");
            addFilatablaComparacion(idTestCase, "StatusCode", String.valueOf(statusSOAP), String.valueOf(statusRest), "SinValidar");
            return false;
        }


        if (soap.getListaAvail().size() == 0) {
            System.out.println("[INFO] El response del SOAP no devuelve disponibilidad");
            System.out.println("[INFO] Response SOAP:\n\t" + soap.toString());
            return false;
        }

        if (rest.getAvailabilities().size() == 0) {
            System.out.println("[INFO] El response del REST no devuelve disponibilidad");
            System.out.println("[INFO] Response rest:\n\t" + rest.toString());
            return false;
        }


        //NUEVO 1/2/24
        validarDisponibilidadHabitacion(idTestCase, soap, rest);
        codigoMensajeLmotivoMessagesCode(idTestCase, soap, rest);
        validarExistenTipoHabitacionDeSoap(idTestCase, soap, rest);

        boolean comparacion = true;
        int contValorarCombinacionesRbDto = 1;
        //Inciamos compracion

        for (ValorarCombinacionesRbDto vc : soap.getListaAvail()) {
            String codigoDivisa = vc.getCodigoDivisa();
            String precio = vc.getPrecio();
            String precioAnterior = vc.getPrecioAnterior();
            System.out.println("[Combinacion - (" + contValorarCombinacionesRbDto + ")]:\n\t" + vc.toString());

            //lmotivo
            String acumlmotivoSOAP = "";
            for (MotivoDispDto m : vc.getLmotivo()) {
                acumlmotivoSOAP += m.getMotdisp() + "-";
            }
            //ValorarCombinacionesRbDto

            //Bajo la condicion de que el servicio SOAP Devuelva el mismo tipo de habitacion
            //Se creara la siguiente bandera que es de una sola busqueda segun el tipo de habitacion
            int auxContHabitacionesValCombinacionesDtoSoap = 0;
            for (HabitacionesValCombinacionesDto hb : vc.getListaHabitaciones()) {
                //Buscamo el codigo de habitacion del soap, para buscarlo en el rest
                String codtha = hb.getCodtha();
                String hbPrecio = hb.getPrecio();


                RoomsItem comparacionRoomsItem = null;
                AvailabilitiesItem comparacionAvailabilitiesItem = null;
                if (auxContHabitacionesValCombinacionesDtoSoap == 0) {
                    //La bandera de primera vuelta
                    auxContHabitacionesValCombinacionesDtoSoap++;
                    String outInfoHabitacionSoap = "> outInfoHabitacionSoap: " + contValorarCombinacionesRbDto + "\n\t" +
                            ">> Codigo Habitacion: " + codtha + "\n\t" +
                            ">> Codigo Divisa: " + vc.getCodigoDivisa() + "\n\t" +
                            ">> Precio: " + vc.getPrecio() + "\n\t" +
                            ">> Precio Anterior: " + vc.getPrecioAnterior() + "\n\t" +
                            ">> Precio Habitacion: " + hbPrecio + "\n\t";
                    System.out.println("");
                    System.out.println(outInfoHabitacionSoap);
                    //Recorro el arreglo del rest Availabilities
                    for (AvailabilitiesItem ah : rest.getAvailabilities()) {
                        //Recorro las availabilities.combination.rooms para obtener el codigo y el objeto
                        //bandera True si tipo de roon son iguales, en caso contrario false
                        boolean tipoHabitacionesIguales = false;
                        boolean auxPrimeraVuelta = true;
                        int contIgualdadRooms = 0;
                        //messages.info.code
                        String acumInfoItemRest = "";
                        if (ah.getMessages() != null) {
                            InfoItem inf;
                            for (model.responseRest.InfoItem InfoItem : ah.getMessages().getInfo()) {
                                acumInfoItemRest += InfoItem.getCode() + "-";
                            }
                        }
                        //Recorro la rooms
                        for (RoomsItem auxRoomsItem : ah.getCombination().getRooms()) {
                            if (auxRoomsItem.getRoomTypeCode().equalsIgnoreCase(codtha)) {
                                contIgualdadRooms++;
                                comparacionRoomsItem = auxRoomsItem;
                                comparacionAvailabilitiesItem = ah;

                            }
                        }
                        //Condicion de control si las rooms del arreglos son iguales
                        if (ah.getCombination().getRooms().size() == contIgualdadRooms) {
                            System.out.println("comparacionAvailabilitiesItemRest:\n\t" + comparacionAvailabilitiesItem.toString());

                            String auxPricesPriceWithTaxCurrency = "null";
                            String auxPricesPriceWithTaxgetAmount = "null";
                            String auxPricesPreviousPriceWithTaxAmount = "null";
                            String auxPrecioHabitacion = "null";
                            if (comparacionAvailabilitiesItem.getPrices() != null) {
                                auxPricesPriceWithTaxCurrency = (!comparacionAvailabilitiesItem.getPrices().getPriceWithTax().getCurrency().isEmpty()) ? comparacionAvailabilitiesItem.getPrices().getPriceWithTax().getCurrency() : "null";
                                auxPricesPriceWithTaxgetAmount = (!comparacionAvailabilitiesItem.getPrices().getPriceWithTax().getAmount().toString().isEmpty()) ? comparacionAvailabilitiesItem.getPrices().getPriceWithTax().getAmount().toString() : "null";
                                auxPricesPreviousPriceWithTaxAmount = (!comparacionAvailabilitiesItem.getPrices().getPreviousPriceWithTax().getAmount().toString().isEmpty()) ? comparacionAvailabilitiesItem.getPrices().getPreviousPriceWithTax().getAmount().toString() : "null";
                                auxPrecioHabitacion = (!comparacionRoomsItem.getPriceWithTax().get(0).getAmount().toString().isEmpty()) ? comparacionRoomsItem.getPriceWithTax().get(0).getAmount().toString() : "null";
                            }
                            String outInfoHabitacionRestAmount = "> outInfoHabitacionRest: " + contValorarCombinacionesRbDto + "\n\t" +
                                    ">> Codigo Habitacion: " + comparacionRoomsItem.getRoomTypeCode() + "\n\t" +
                                    ">> Codigo Divisa: " + auxPricesPriceWithTaxCurrency + "\n\t" +
                                    ">> Precio: " + auxPricesPriceWithTaxgetAmount + "\n\t" +
                                    ">> Precio Anterior: " + auxPricesPreviousPriceWithTaxAmount + "\n\t" +
                                    ">> Precio Habitacion: " + auxPrecioHabitacion + "\n\t";
                            System.out.println("");
                            System.out.println(outInfoHabitacionRestAmount);
                            //NUEVO 1/2/24
                            tablaComparacion.append("idTestCase|Num Comp|Campo Comparacion|SOAP|REST|Resultado|\n");

                            addFilatablaComparacion(idTestCase, "Tipo Habitacion", codtha, comparacionRoomsItem.getRoomTypeCode(), codtha.equalsIgnoreCase(comparacionRoomsItem.getRoomTypeCode()));
                            //En caso de que las habitaciones sean iguales iniciamos la compracion entre repuesta Soap y Rest
                            //SOAP vs Rest
                            //ValorarCombinacionesRbDto.codigoDivisa = prices.price_with_tax.currency
                            boolean flagCodigoDivisa = codigoDivisa.equalsIgnoreCase(auxPricesPriceWithTaxCurrency);
                            addFilatablaComparacion(idTestCase, "Codigo Divisa", codigoDivisa, auxPricesPriceWithTaxCurrency, flagCodigoDivisa);

                            //ValorarCombinacionesRbDto.precio = prices.price_with_tax.amount
                            boolean flagPrecio = precio.equalsIgnoreCase(auxPricesPriceWithTaxgetAmount);
                            addFilatablaComparacion(idTestCase, "Precio", precio, auxPricesPriceWithTaxgetAmount, flagPrecio);

                            //ValorarCombinacionesRbDto.precioAnterior = prices.previous_price_with_tax.amount
                            boolean flagPrecioAnterior = precioAnterior.equalsIgnoreCase(auxPricesPreviousPriceWithTaxAmount);
                            addFilatablaComparacion(idTestCase, "Precio Anterior", precioAnterior, auxPricesPreviousPriceWithTaxAmount, flagPrecioAnterior);

                            //Comparamos precio por habitacion
                            boolean flaghbPrecio = hbPrecio.equalsIgnoreCase(auxPrecioHabitacion);
                            addFilatablaComparacion(idTestCase, "Precio Habitacion", hbPrecio, auxPrecioHabitacion, flaghbPrecio);

                            if (!acumlmotivoSOAP.equalsIgnoreCase("") || !acumInfoItemRest.equalsIgnoreCase("")) {
                                //boolean flaghbPrecio = hbPrecio.equalsIgnoreCase(auxPrecioHabitacion);
                                addFilatablaComparacion(idTestCase, "Codigo lmotivo", acumlmotivoSOAP, acumInfoItemRest, "SinValidar");
                            }

                            //Falta la validacion de los code
                            boolean flagStatusCode = (statusSOAP == statusRest);
                            addFilatablaComparacion(idTestCase, "StatusCode", String.valueOf(statusSOAP), String.valueOf(statusRest), flagStatusCode);

                            if (!flagCodigoDivisa || !flagPrecio || !flagPrecioAnterior || !flaghbPrecio || !flagStatusCode) {
                                comparacion = false;
                            }
                            contIgualdadRooms = 0;
                        }
                    }
                }

            }
            contValorarCombinacionesRbDto++;
        }

        //Si devuelve True= compracion OK, caso contario devolvera false.
        return comparacion;
    }

    public static void addFilatablaComparacion(String idTestCase, String campo, String valorSoap, String valorRest, boolean resultado) {
        tablaComparacion.append(idTestCase).append("|").append(numComparacion).append("|").append(campo).append("|").append(valorSoap).append("|").append(valorRest).append("|").append(resultado).append("|\n");
        numComparacion++;
    }

    public static void addFilatablaComparacion(String idTestCase, String campo, String valorSoap, String valorRest, String resultado) {
        tablaComparacion.append(idTestCase).append("|").append(numComparacion).append("|").append(campo).append("|").append(valorSoap).append("|").append(valorRest).append("|").append(resultado).append("|\n");
        numComparacion++;
    }

    public static String getTablaComparacion() {
        return tablaComparacion.toString();
    }


    //1/2/24
    public static void validarDisponibilidadHabitacion(String idTestCase, ListaAvail soap, ResponseRest rest) {
        int countCombHabitacionesSOAP = 0;
        int countCombHabitacionesREST = 0;

        // Contamos la cantidad de habitaciones disponible en el SOAP
        //  soap.listaAvail.().listahabilitacion = contar sea distinto a null!!
        for (ValorarCombinacionesRbDto vc : soap.getListaAvail()) {
            if (!vc.getListaHabitaciones().isEmpty()) {
                countCombHabitacionesSOAP++;
            }
        }
        // Contamos la cantidad de habitaciones disponible en el rest
        //  rest.availabilities.().combination.rooms = contar sea distinto a null!!
        for (AvailabilitiesItem av : rest.getAvailabilities()) {
            if (!av.getCombination().getRooms().isEmpty()) {
                countCombHabitacionesREST++;
            }
        }
        tablaComparacion.append("idTestCase|Num Comp|Campo Comparacion|SOAP|REST|Resultado|\n");
        if (countCombHabitacionesSOAP == countCombHabitacionesREST) {
            String resul = "EQUALS:La repuesta entre el SOAP y Rest son iguales, controlar el reporte de Karate ";
            addFilatablaComparacion(idTestCase, "Habitaciones Disponible", String.valueOf(countCombHabitacionesSOAP), String.valueOf(countCombHabitacionesREST), resul);
        } else if (countCombHabitacionesSOAP < countCombHabitacionesREST) {
            String resul = "True:El Servicio Rest tiene mas combinaciones de habitacion, es lo esperado ";
            addFilatablaComparacion(idTestCase, "Habitaciones Disponible", String.valueOf(countCombHabitacionesSOAP), String.valueOf(countCombHabitacionesREST), resul);
        } else {
            String resul = "False:Sevicio SOAP tiene mas habitaciones de lo esperado, controlar el reporte de Karate ";
            addFilatablaComparacion(idTestCase, "Habitaciones Disponible", String.valueOf(countCombHabitacionesSOAP), String.valueOf(countCombHabitacionesREST), resul);
        }
    }

    //1/2/24
    public static void codigoMensajeLmotivoMessagesCode(String idTestCase, ListaAvail soap, ResponseRest rest) {
        String acumMessagesCode = "";
        for (AvailabilitiesItem av : rest.getAvailabilities()) {
            //Si Messeges es distinto a null
            if (av.getMessages() != null) {
                for (InfoItem info : av.getMessages().getInfo()) {
                    acumMessagesCode += info.getCode() + "#";
                }
            }
        }

        String acumLmotivo = "";
        for (ValorarCombinacionesRbDto av : soap.getListaAvail()) {
            if (!av.getLmotivo().isEmpty()) {
                for (MotivoDispDto m : av.getLmotivo()) {
                    acumLmotivo = m.getMotdisp() + "#";
                }
            }
        }

        if (!acumLmotivo.equalsIgnoreCase("") || !acumMessagesCode.equalsIgnoreCase("")) {
            tablaComparacion.append("idTestCase|Num Comp|Campo Comparacion|SOAP|REST|Resultado|\n");
            addFilatablaComparacion(idTestCase, "Codigo Lmotivo y Messages ", acumLmotivo, acumMessagesCode, "LOG INFORMATIVO:Codigos encontrados en los response, no se esta validando coincidencias");
        }

    }

    //1/2/24
    public static void validarExistenTipoHabitacionDeSoap(String idTestCase, ListaAvail soap, ResponseRest rest) {
        String codiTipoHabitacionSOAP = "";
        for (ValorarCombinacionesRbDto av : soap.getListaAvail()) {
            //Validamos que no este vacio
            if (!av.getListaHabitaciones().isEmpty()) {
                String codTha = "";
                for (HabitacionesValCombinacionesDto hv : av.getListaHabitaciones()) {

                    if (codTha.equalsIgnoreCase("")) {
                        codTha += hv.getCodtha();
                    } else {
                        codTha += ":" + hv.getCodtha();
                    }
                }
                if (!codTha.equalsIgnoreCase(""))
                    codiTipoHabitacionSOAP += codTha + "#";
            }

        }
        System.out.println("Tipo de habitacion SOAP: " + codiTipoHabitacionSOAP);
        int totalSOAP = codiTipoHabitacionSOAP.split("#").length;
        System.out.println("Total de habitaciones SOAP: " + totalSOAP);

        String codiTipoHabitacionREST = "";
        for (AvailabilitiesItem av : rest.getAvailabilities()) {
            String codRoomsItem = "";
            if (!av.getCombination().getRooms().isEmpty()) {
                for (RoomsItem room : av.getCombination().getRooms()) {
                    if (codRoomsItem.equalsIgnoreCase("")) {
                        codRoomsItem += room.getRoomTypeCode();
                    } else {
                        codRoomsItem += ":" + room.getRoomTypeCode();
                    }
                }
                if (codiTipoHabitacionREST.equalsIgnoreCase("")) {
                    codiTipoHabitacionREST += codRoomsItem;
                } else {
                    codiTipoHabitacionREST += "#" + codRoomsItem;
                }
            }

        }

        System.out.println("Tipo de habitacion REST: " + codiTipoHabitacionREST);
        int totalREST = codiTipoHabitacionREST.split("#").length;
        System.out.println("Total de habitaciones REST: " + totalREST);

        tablaComparacion.append("idTestCase|Num Comp|Campo Comparacion|SOAP|REST|Resultado|\n");
        addFilatablaComparacion(idTestCase, "Combinacion de habitacion por tipo", "[" + codiTipoHabitacionSOAP + "] - Total: " + totalSOAP, "[" + codiTipoHabitacionREST + "] - Total: " + totalREST, "LOG INFORMATIVO:[#]:Combinacion Habitacion");

        //codiTipoHabitacionSOAP = "DDSB:DDSB#DGSB:DGSB#SJSB:SJSB#AAA:AAA#BB:BB#CC";
        String habitacionSoap[] = codiTipoHabitacionSOAP.split("#");
        boolean flagDiferenciaCombinacionHabitacion = false;
        String combinacionSOAPNoExistenteEnRest = "";
        for (String combinacionSoap : habitacionSoap) {
            //Si no lo contine lo almacenamos
            if (!(codiTipoHabitacionREST.contains(combinacionSoap))) {
                combinacionSOAPNoExistenteEnRest += combinacionSoap + "#";
                flagDiferenciaCombinacionHabitacion = true;
            }
        }

        if (flagDiferenciaCombinacionHabitacion) {
            tablaComparacion.append("idTestCase|Num Comp|Campo Comparacion|SOAP|REST|Resultado|\n");
            addFilatablaComparacion(idTestCase, "Combinacion de SOAP no encontradas en REST", combinacionSOAPNoExistenteEnRest, codiTipoHabitacionREST, "false:Esta combinacion no se encontro en Servicio Rest");
        }

    }

}
