package model.responseSOAP;

public class ObservacionesSOAP {

    private static String obsInconsistencia = "[INFO] Observacion de Inconsistencia en la lectura del Response SOAP:\n\t";
    private static int contObsInconsistencia = 1;
    private static boolean flagInconObsSoap = false;

    private static String infoReadSOAP = "[INFO] Informacion en la lectura de la reserva en el response SOAP:\n\t";

    public static void addObsInconsistencia(String obsInconsistencia) {
        obsInconsistencia += contObsInconsistencia + " - " + obsInconsistencia + "\n\t";
        contObsInconsistencia++;
        flagInconObsSoap = true;
    }

    public static void addInfoReadSOAP(String infoReadSOAP) {
        infoReadSOAP += " - " + infoReadSOAP + "\n\t";
    }

    public static String getObsInconsistencia() {
        return obsInconsistencia;
    }

    public static int getContObsInconsistencia() {
        return contObsInconsistencia;
    }

    public static boolean isFlagInconObsSoap() {
        return flagInconObsSoap;
    }

    public static String getInfoReadSOAP() {
        return infoReadSOAP;
    }

    public static String getInfoObservacionesSOAP() {
        return "infoReadSOAP:\n\t" + infoReadSOAP +
                "flagInconObsSoap:\n\t" + flagInconObsSoap +
                "obsInconsistencia:\n\t" + obsInconsistencia;
    }
}
