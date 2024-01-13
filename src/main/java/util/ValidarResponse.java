package util;

import com.linecorp.armeria.internal.shaded.guava.base.Objects;
import model.responseRest.ResponseRest;
import model.responseSOAP.ListaAvail;
import model.responseSOAP.ReadResponseSOAP;
import model.responseSOAP.ValorarCombinacionesRbDto;
import com.intuit.karate.graal.JsMap;

public class ValidarResponse {
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

        System.out.println("[responseJSON]\n\t"+responseJSON.toString());
        ResponseRest responseRest = ReadResponseRest.getResponseRest(responseJSON.toString());
        System.out.println(responseRest.toString());
        return responseRest;
    }
}
