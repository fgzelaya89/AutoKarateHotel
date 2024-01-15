package util;

import com.linecorp.armeria.internal.shaded.guava.base.Objects;
import model.responseRest.ResponseRest;
import model.responseSOAP.ListaAvail;
import model.responseSOAP.ReadResponseSOAP;
import model.responseSOAP.ValorarCombinacionesRbDto;
import com.intuit.karate.graal.JsMap;
import org.json.simple.JSONObject;

import java.util.*;

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

        System.out.println("[responseJSON]\n\t"+"getClass:\n\t"+responseJSON.getClass()+"\n\t"+responseJSON.toString());

        ResponseRest responseRest = ReadResponseRest.getResponseRest(responseJSON.toString());
        System.out.println(responseRest.toString());
        return responseRest;
    }


    public static String convertObjectToList(Object obj) {

        System.out.println("obj: "+obj.getClass()+" "+obj.toString());

        LinkedHashMap objeto = (LinkedHashMap) obj;

        java.util.LinkedHashMap linkedHashMap = new LinkedHashMap();

        // Agregar elementos al LinkedHashMap
        linkedHashMap.put("key1", "value1");
        linkedHashMap.put("key2", 123);
        linkedHashMap.put("key3", true);

        // Imprimir el contenido del LinkedHashMap
        System.out.println("LinkedHashMap: " + linkedHashMap);

        String jsonString = new JSONObject(linkedHashMap).toString();

        System.out.println("jsonString: "+jsonString);
        return "OK";
    }
}
