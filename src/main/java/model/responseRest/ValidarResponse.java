package model.responseRest;


import com.fasterxml.jackson.databind.ObjectMapper;
import model.responseSOAP.*;
import util.ReadResponseRest;

import java.io.IOException;

public class ValidarResponse {
    private static StringBuilder tablaComparacion = new StringBuilder();
    private static int numComparacion = 1;

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


        tablaComparacion.append("idTestCase|Num Comp|Campo Comparacion|SOAP|REST|Resultado|\n");
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
                acumlmotivoSOAP += "#" + m.getMotdisp() + "#";
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

                            String auxPricesPriceWithTaxCurrency = comparacionAvailabilitiesItem.getPrices().getPriceWithTax().getCurrency();
                            String auxPricesPriceWithTaxgetAmount = comparacionAvailabilitiesItem.getPrices().getPriceWithTax().getAmount().toString();

                            String auxPricesPreviousPriceWithTaxAmount = comparacionAvailabilitiesItem.getPrices().getPreviousPriceWithTax().getAmount().toString();
                            String auxPrecioHabitacion = comparacionRoomsItem.getPriceWithTax().get(0).getAmount().toString();

                            String outInfoHabitacionRestAmount = "> outInfoHabitacionRest: " + contValorarCombinacionesRbDto + "\n\t" +
                                    ">> Codigo Habitacion: " + comparacionRoomsItem.getRoomTypeCode() + "\n\t" +
                                    ">> Codigo Divisa: " + auxPricesPriceWithTaxCurrency + "\n\t" +
                                    ">> Precio: " + auxPricesPriceWithTaxgetAmount + "\n\t" +
                                    ">> Precio Anterior: " + auxPricesPreviousPriceWithTaxAmount + "\n\t" +
                                    ">> Precio Habitacion: " + auxPrecioHabitacion + "\n\t";
                            System.out.println("");
                            System.out.println(outInfoHabitacionRestAmount);

                            addFilatablaComparacion(idTestCase, "Tipo Habitacion", codtha, codtha, true);
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

                            //Comparamos precio por habitacion
                            //boolean flaghbPrecio = hbPrecio.equalsIgnoreCase(auxPrecioHabitacion);
                            addFilatablaComparacion(idTestCase, "Codigo lmotivo", acumlmotivoSOAP, acumlmotivoSOAP, "SinValidar");

                            if (!flagCodigoDivisa || !flagPrecio || !flagPrecioAnterior || !flaghbPrecio) {
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


}
