package model.request;

import model.PruebaData;


public class RequestSOAP {
    public static String getRequestUnaHabitacionSinNino(PruebaData testCase) {
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.booking.rumbonet.riu.com\" xmlns:dtos=\"http://dtos.booking.rumbonet.riu.com\" xmlns:ser1=\"http://services.common.rumbonet.riu.com\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <ser:recuperarTablaPreciosRB>\n" +
                "         <ser:in0>\n" +
                "            <dtos:codigoAccesoUsuario>" + testCase.Ambito() + "</dtos:codigoAccesoUsuario>\n" +
                "            <dtos:codigoAmbito>" + testCase.getAmbito() + "</dtos:codigoAmbito>\n" +
                "            <dtos:codigoPaisAmbito>" + testCase.getCodPai() + "</dtos:codigoPaisAmbito>\n" +
                "            <dtos:codigoRegimen>" + testCase.getCodTre() + "</dtos:codigoRegimen>\n" +
                "            <dtos:fechaEntrada>" + testCase.newFormatFecLle() + "</dtos:fechaEntrada>\n" +
                "            <dtos:fechaSalida>" + testCase.newFormatSal() + "</dtos:fechaSalida>\n" +
                "            <dtos:listaHabitaciones>\n" +
                "               <dtos:listaHabitaciones>\n" +
                "                  <dtos:DispHabitacionDto>\n" +
                "                     <dtos:listaedades>\n" +
                "                     </dtos:listaedades>\n" +
                "                     <dtos:numeroAdultos>" + testCase.getNumAdu1() + "</dtos:numeroAdultos>\n" +
                "                     <dtos:numeroBabies>0</dtos:numeroBabies>\n" +
                "                     <dtos:numeroInfants>" + testCase.getNumNin1() + "</dtos:numeroInfants>\n" +
                "                  </dtos:DispHabitacionDto>\n" +
                "               </dtos:listaHabitaciones>\n" +
                "            </dtos:listaHabitaciones>\n" +
                "            <dtos:listaTipoHabitaciones>\n" +
                "               <ser1:string>" + testCase.getCodTha1() + "</ser1:string>\n" +
                "            </dtos:listaTipoHabitaciones>\n" +
                "            <dtos:listaHoteles>\n" +
                "               <dtos:listaHoteles>\n" +
                "                  <ser1:int>" + testCase.getIdeHot() + "</ser1:int>\n" +
                "               </dtos:listaHoteles>\n" +
                "            </dtos:listaHoteles>\n" +
                "            <dtos:numeroAdultos>" + testCase.totalAdulto() + "</dtos:numeroAdultos>\n" +
                "            <dtos:numeroBabies>0</dtos:numeroBabies>\n" +
                "            <dtos:numeroHabitaciones>" + testCase.getNumHab() + "</dtos:numeroHabitaciones>\n" +
                "            <dtos:numeroInfants>" + testCase.totalNinos() + "</dtos:numeroInfants>\n" +
                "         </ser:in0>\n" +
                "      </ser:recuperarTablaPreciosRB>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        return request;
    }

    public static String getRequestUnaHabitacionConNino(PruebaData testCase) {
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.booking.rumbonet.riu.com\" xmlns:dtos=\"http://dtos.booking.rumbonet.riu.com\" xmlns:ser1=\"http://services.common.rumbonet.riu.com\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <ser:recuperarTablaPreciosRB>\n" +
                "         <ser:in0>\n" +
                "            <dtos:codigoAccesoUsuario>" + testCase.Ambito() + "</dtos:codigoAccesoUsuario>\n" +
                "            <dtos:codigoAmbito>" + testCase.getAmbito() + "</dtos:codigoAmbito>\n" +
                "            <dtos:codigoPaisAmbito>" + testCase.getCodPai() + "</dtos:codigoPaisAmbito>\n" +
                "            <dtos:codigoRegimen>" + testCase.getCodTre() + "</dtos:codigoRegimen>\n" +
                "            <dtos:fechaEntrada>" + testCase.newFormatFecLle() + "</dtos:fechaEntrada>\n" +
                "            <dtos:fechaSalida>" + testCase.newFormatSal() + "</dtos:fechaSalida>\n" +
                "            <dtos:listaHabitaciones>\n" +
                "               <dtos:listaHabitaciones>\n" +
                "                  <dtos:DispHabitacionDto>\n" +
                "                     <dtos:listaedades>\n";

        String lisEdades = "";
        int totalNino = Integer.parseInt(testCase.totalNinos());
        System.out.println("[INFO]Total Ninos: " + totalNino);
        for (int i = 0; i < totalNino; i++) {
            lisEdades += "<ser1:int>6</ser1:int>\n";
        }

        String requestDos = "         </dtos:listaedades>\n" +
                "                     <dtos:numeroAdultos>" + testCase.getNumAdu1() + "</dtos:numeroAdultos>\n" +
                "                     <dtos:numeroBabies>0</dtos:numeroBabies>\n" +
                "                     <dtos:numeroInfants>" + testCase.getNumNin1() + "</dtos:numeroInfants>\n" +
                "                  </dtos:DispHabitacionDto>\n" +
                "               </dtos:listaHabitaciones>\n" +
                "            </dtos:listaHabitaciones>\n" +
                "            <dtos:listaTipoHabitaciones>\n" +
                "               <ser1:string>" + testCase.getCodTha1() + "</ser1:string>\n" +
                "            </dtos:listaTipoHabitaciones>\n" +
                "            <dtos:listaHoteles>\n" +
                "               <dtos:listaHoteles>\n" +
                "                  <ser1:int>" + testCase.getIdeHot() + "</ser1:int>\n" +
                "               </dtos:listaHoteles>\n" +
                "            </dtos:listaHoteles>\n" +
                "            <dtos:numeroAdultos>" + testCase.totalAdulto() + "</dtos:numeroAdultos>\n" +
                "            <dtos:numeroBabies>0</dtos:numeroBabies>\n" +
                "            <dtos:numeroHabitaciones>" + testCase.getNumHab() + "</dtos:numeroHabitaciones>\n" +
                "            <dtos:numeroInfants>" + testCase.totalNinos() + "</dtos:numeroInfants>\n" +
                "         </ser:in0>\n" +
                "      </ser:recuperarTablaPreciosRB>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        return request + lisEdades + requestDos;
    }


    public static String request(PruebaData testCase) {
        String primeraParteRequest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.booking.rumbonet.riu.com\" xmlns:dtos=\"http://dtos.booking.rumbonet.riu.com\" xmlns:ser1=\"http://services.common.rumbonet.riu.com\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <ser:recuperarTablaPreciosRB>\n" +
                "         <ser:in0>\n" +
                "            <dtos:codigoAccesoUsuario>" + testCase.Ambito() + "</dtos:codigoAccesoUsuario>\n" +
                "            <dtos:codigoAmbito>" + testCase.getAmbito() + "</dtos:codigoAmbito>\n" +
                "            <dtos:codigoPaisAmbito>" + testCase.getCodPai() + "</dtos:codigoPaisAmbito>\n" +
                "            <dtos:codigoRegimen>" + testCase.getCodTre() + "</dtos:codigoRegimen>\n" +
                "            <dtos:fechaEntrada>" + testCase.newFormatFecLle() + "</dtos:fechaEntrada>\n" +
                "            <dtos:fechaSalida>" + testCase.newFormatSal() + "</dtos:fechaSalida>\n";

        if (testCase.getPromocode() != "") {
            primeraParteRequest += "<dtos:promocode>" + testCase.getPromocode() + "</dtos:promocode>\n";
        }

        if (testCase.getPuntosGastar() != "") {
            primeraParteRequest += "<dtos:puntosGastar>" + testCase.getPuntosGastar() + "</dtos:puntosGastar>\n";
        }

        if (testCase.getUsuario() != "") {
            primeraParteRequest += "<dtos:codigoRiuClass>" + testCase.getUsuario() + "</dtos:codigoRiuClass>\n";
        }

        primeraParteRequest += "            <dtos:listaHabitaciones>\n" +
                "               <dtos:listaHabitaciones>\n";

        /////////////////////Armamdo de Habitaciones////////////////////////////////
        String auxLisEdades = "";
        int totalNino = 0;
        //HABITACION UNO//
        String habitacionUno = "<dtos:DispHabitacionDto>\n" +
                "                            <dtos:listaedades>\n" +
                "                            %s \n" +//Ingresamo la lista de niños de habitacion uno
                "                            </dtos:listaedades>\n" +
                "                            <dtos:numeroAdultos>" + testCase.getNumAdu1() + "</dtos:numeroAdultos>\n" +
                "                            <dtos:numeroBabies>0</dtos:numeroBabies>\n" +
                "                            <dtos:numeroInfants>" + testCase.getNumNin1() + "</dtos:numeroInfants>\n" +
                "                        </dtos:DispHabitacionDto>\n";

        totalNino = Integer.parseInt(testCase.getNumNin1());
        for (int i = 0; i < totalNino; i++) {
            auxLisEdades += "<ser1:int>6</ser1:int>\n";
        }
        habitacionUno = String.format(habitacionUno, auxLisEdades);

        //HABITACION DOS//
        auxLisEdades = "";
        String habitacionDos = "<dtos:DispHabitacionDto>\n" +
                "                            <dtos:listaedades>\n" +
                "                            %s \n" +//Ingresamo la lista de niños de habitacion dos
                "                            </dtos:listaedades>\n" +
                "                            <dtos:numeroAdultos>" + testCase.getNumAdu2() + "</dtos:numeroAdultos>\n" +
                "                            <dtos:numeroBabies>0</dtos:numeroBabies>\n" +
                "                            <dtos:numeroInfants>" + testCase.getNumNin2() + "</dtos:numeroInfants>\n" +
                "                        </dtos:DispHabitacionDto>\n";

        totalNino = Integer.parseInt(testCase.getNumNin2());
        for (int i = 0; i < totalNino; i++) {
            auxLisEdades += "<ser1:int>6</ser1:int>\n";
        }
        habitacionDos = String.format(habitacionDos, auxLisEdades);
        //HABITACION TRES//
        auxLisEdades = "";
        String habitacionTres = "<dtos:DispHabitacionDto>\n" +
                "                            <dtos:listaedades>\n" +
                "                            %s \n" +//Ingresamo la lista de niños de habitacion dos
                "                            </dtos:listaedades>\n" +
                "                            <dtos:numeroAdultos>" + testCase.getNumAdu3() + "</dtos:numeroAdultos>\n" +
                "                            <dtos:numeroBabies>0</dtos:numeroBabies>\n" +
                "                            <dtos:numeroInfants>" + testCase.getNumNin3() + "</dtos:numeroInfants>\n" +
                "                        </dtos:DispHabitacionDto>\n";

        totalNino = Integer.parseInt(testCase.getNumNin3());
        for (int i = 0; i < totalNino; i++) {
            auxLisEdades += "<ser1:int>6</ser1:int>\n";
        }
        habitacionTres = String.format(habitacionTres, auxLisEdades);
        /////////////////////FIN DE Armamdo de Habitaciones ///////////////////////

        String ultimaParteRequest = " </dtos:listaHabitaciones>\n" +
                "            </dtos:listaHabitaciones>\n" +
                "            <dtos:listaTipoHabitaciones>\n" +
                "               <ser1:string>" + testCase.getCodTha1() + "</ser1:string>\n" +
                "            </dtos:listaTipoHabitaciones>\n" +
                "            <dtos:listaHoteles>\n" +
                "               <dtos:listaHoteles>\n" +
                "                  <ser1:int>" + testCase.getIdeHot() + "</ser1:int>\n" +
                "               </dtos:listaHoteles>\n" +
                "            </dtos:listaHoteles>\n" +
                "            <dtos:numeroAdultos>" + testCase.totalAdulto() + "</dtos:numeroAdultos>\n" +
                "            <dtos:numeroBabies>0</dtos:numeroBabies>\n" +
                "            <dtos:numeroHabitaciones>" + testCase.getNumHab() + "</dtos:numeroHabitaciones>\n" +
                "            <dtos:numeroInfants>" + testCase.totalNinos() + "</dtos:numeroInfants>\n" +
                "         </ser:in0>\n" +
                "      </ser:recuperarTablaPreciosRB>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        String request = "";

        if (testCase.totalHabitacion() == 1) {
            request = primeraParteRequest + habitacionUno + ultimaParteRequest;
        } else if (testCase.totalHabitacion() == 2) {
            request = primeraParteRequest + habitacionUno + habitacionDos + ultimaParteRequest;
        } else if (testCase.totalHabitacion() == 3) {
            request = primeraParteRequest + habitacionUno + habitacionDos + habitacionTres + ultimaParteRequest;
        }

        return request;

    }
}
