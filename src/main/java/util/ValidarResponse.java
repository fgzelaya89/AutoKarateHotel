package util;


import model.responseRest.AvailabilitiesItem;
import model.responseRest.Combination;
import model.responseRest.ResponseRest;

import model.responseRest.RoomsItem;
import model.responseSOAP.HabitacionesValCombinacionesDto;
import model.responseSOAP.ListaAvail;
import model.responseSOAP.ReadResponseSOAP;
import model.responseSOAP.ValorarCombinacionesRbDto;


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

        validarResponseSoapRest(listaAvail, rest);
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

        System.out.println("[responseJSON]\n\t" + "getClass:\n\t" + responseJSON.getClass() + "\n\t" + responseJSON.toString());

        ResponseRest responseRest = ReadResponseRest.getResponseRest(responseJSON.toString());
        System.out.println(responseRest.toString());
        return responseRest;
    }

    public static boolean validarResponseSoapRest(ListaAvail soap, ResponseRest rest) {

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


        tablaComparacion.append("|Num Comp|Campo Comparacion|SOAP|REST|Resultado|\n");
        boolean comparacion = true;
        int contValorarCombinacionesRbDto = 1;
        //Inciamos compracion
        for (ValorarCombinacionesRbDto vc : soap.getListaAvail()) {
            String codigoDivisa = vc.getCodigoDivisa();
            String precio = vc.getPrecio();
            String precioAnterior = vc.getPrecioAnterior();
            System.out.println("[Combinacion - (" + contValorarCombinacionesRbDto + ")]:\n\t" + vc.toString());

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


                            //En caso de que las habitaciones sean iguales iniciamos la compracion entre repuesta Soap y Rest
                            //SOAP vs Rest
                            //ValorarCombinacionesRbDto.codigoDivisa = prices.price_with_tax.currency
                            boolean flagCodigoDivisa = codigoDivisa.equalsIgnoreCase(auxPricesPriceWithTaxCurrency);
                            addFilatablaComparacion("Codigo Divisa", codigoDivisa, auxPricesPriceWithTaxCurrency, flagCodigoDivisa);

                            //ValorarCombinacionesRbDto.precio = prices.price_with_tax.amount
                            boolean flagPrecio = precio.equalsIgnoreCase(auxPricesPriceWithTaxgetAmount);
                            addFilatablaComparacion("Precio", precio, auxPricesPriceWithTaxgetAmount, flagPrecio);

                            //ValorarCombinacionesRbDto.precioAnterior = prices.previous_price_with_tax.amount
                            boolean flagPrecioAnterior = precioAnterior.equalsIgnoreCase(auxPricesPreviousPriceWithTaxAmount);
                            addFilatablaComparacion("Precio Anterior", precioAnterior, auxPricesPreviousPriceWithTaxAmount, flagPrecioAnterior);

                            //Comparamos precio por habitacion
                            boolean flaghbPrecio = hbPrecio.equalsIgnoreCase(auxPrecioHabitacion);
                            addFilatablaComparacion("Precio Habitacion", hbPrecio, auxPrecioHabitacion, flaghbPrecio);

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

    public static void addFilatablaComparacion(String campo, String valorSoap, String valorRest, boolean resultado) {
        tablaComparacion.append("|").append(numComparacion).append("|").append(campo).append("|").append(valorSoap).append("|").append(valorRest).append("|").append(resultado).append("|\n");
        numComparacion++;
    }

    public static String getTablaComparacion() {
        return tablaComparacion.toString();
    }


}
