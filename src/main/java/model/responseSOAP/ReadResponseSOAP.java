package model.responseSOAP;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadResponseSOAP {

    private ObservacionesSOAP observacionesSOAP = new ObservacionesSOAP();

    public static void main(String[] args) {
        String response = responseSOAPXML();
        System.out.println("--------------getListValorarCombinacionesRbDto(response)------------------");
        int cont = 0;
        for (String i : getListValorarCombinacionesRbDto(response)) {
            System.out.println("Posicion[" + cont + "]\n\t" + i);
            cont++;
        }
        System.out.println("");
        System.out.println("--------------getlistaAvail(response)------------------");
        ListaAvail listaAvail = getlistaAvail(response);
        cont = 1;
        for (ValorarCombinacionesRbDto v : listaAvail.getListaAvail()) {
            System.out.println("ValorarCombinacionesRbDto[" + cont + "]: \n\t" + v.toString());
            cont++;
        }

//        System.out.println("");
//        System.out.println("--------------ObservacionesSOAP------------------");
//        System.out.println("ObservacionesSOAP: \n\t"+ObservacionesSOAP.getInfoObservacionesSOAP());

        System.out.println("");
        System.out.println("--------------getInfoResponseSOAP------------------");
        System.out.println(getInfoResponseSOAP(listaAvail));


    }

    //lEEMOS EL ARCHIVO JSON Q FUE FORMATIADO DE XML A JSON NO ES IMPORTANTE
    public static String responseSOAPJSON() {
        String SOURCE_PATH = "src/main/resources/responseSOAP.json";
        try {
            File file = new File(SOURCE_PATH);
            // Crear un FileReader para leer el archivo
            FileReader fileReader = new FileReader(file);
            // Usar un BufferedReader para leer el archivo de manera eficiente
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Variable para almacenar el contenido del archivo
            StringBuilder content = new StringBuilder();

            // Leer cada línea del archivo y agregarla al StringBuilder
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // Cerrar recursos
            bufferedReader.close();
            fileReader.close();

            // Imprimir el contenido del archivo como String
            System.out.println("Contenido del archivo:\n" + content.toString());

            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("------ERROR--------");
        }
        return "{}";
    }

    //lEEMOS EL ARCHIVO XML CONTINE LA REPUESTA, NO ES IMPORANTE
    public static String responseSOAPXML() {
        String SOURCE_PATH = "src/main/resources/responseSOAP.xml";
        try {
            File file = new File(SOURCE_PATH);
            // Crear un FileReader para leer el archivo
            FileReader fileReader = new FileReader(file);
            // Usar un BufferedReader para leer el archivo de manera eficiente
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Variable para almacenar el contenido del archivo
            StringBuilder content = new StringBuilder();

            // Leer cada línea del archivo y agregarla al StringBuilder
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // Cerrar recursos
            bufferedReader.close();
            fileReader.close();

            // Imprimir el contenido del archivo como String
            System.out.println("Contenido del archivo:\n" + content.toString());

            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("------ERROR--------");
        }
        return "{}";
    }




    ///Devuelve una lista de String con los datos que estend entro de tag ValorarCombinacionesRbDto
    /// puede devolver 0 o N
    public static List<String> getListValorarCombinacionesRbDto(String auxinput) {
        // Tu cadena de entrada con múltiples ocurrencias
        String input = auxinput;

        // Condiciones de búsqueda
        String startTag = "<ValorarCombinacionesRbDto>";
        String endTag = "</ValorarCombinacionesRbDto>";

        // Crear la expresión regular
        String regex = Pattern.quote(startTag) + "(.*?)" + Pattern.quote(endTag);

        // Compilar la expresión regular
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);

        // Obtener el matcher
        Matcher matcher = pattern.matcher(input);

        // Lista para almacenar todas las coincidencias
        List<String> matches = new ArrayList<>();

        // Iterar sobre las coincidencias
        while (matcher.find()) {
            // Obtener el valor entre las etiquetas y agregarlo a la lista
            String result = matcher.group(1).trim();
            matches.add(result);
        }

        // Imprimir todas las coincidencias
//        int cont = 1;
//        for (String match : matches) {
//            System.out.println("Valor extraído[" + cont + "]:\n" + match);
//            cont++;
//        }
        return matches;
    }

    //Enviamos el Tags y no devuelve una lista con lo que este dentro del tags
    public static List<String> readTagsSOAP(String auxinput, String tags) {
        // Tu cadena de entrada con múltiples ocurrencias
        String input = auxinput;

        // Condiciones de búsqueda
        String startTag = "<" + tags + ">";
        String endTag = "</" + tags + ">";

        // Crear la expresión regular
        String regex = Pattern.quote(startTag) + "(.*?)" + Pattern.quote(endTag);

        // Compilar la expresión regular
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);

        // Obtener el matcher
        Matcher matcher = pattern.matcher(input);

        // Lista para almacenar todas las coincidencias
        List<String> matches = new ArrayList<>();

        // Iterar sobre las coincidencias
        while (matcher.find()) {
            // Obtener el valor entre las etiquetas y agregarlo a la lista
            String result = matcher.group(1).trim();
            matches.add(result);
        }

        // Imprimir todas las coincidencias
//        int cont = 1;
//        for (String match : matches) {
//            System.out.println("Valor extraído[" + cont + "]:\n" + match);
//            cont++;
//        }
        return matches;
    }

    //Enviamos el XML y devuelve mapeado el dato de listaAvail
    public static ListaAvail getlistaAvail(String responseXML) {
        ListaAvail listaAvail = new ListaAvail();
        ValorarCombinacionesRbDto valorarCombinacionesRbDto = new ValorarCombinacionesRbDto();
        HabitacionesValCombinacionesDto habitacionesValCombinacionesDto = new HabitacionesValCombinacionesDto();

        //Recuperamos la lista de ValorarCombinacionesRbDto del response (lista de habitaciones disponible)
        List<String> listCombinacionesRbDto = getListValorarCombinacionesRbDto(responseXML);
        if (listCombinacionesRbDto.size() == 0) {
            ObservacionesSOAP.addObsInconsistencia(" No devuelve disponibilidad de habitacion ");
        }
        ObservacionesSOAP.addInfoReadSOAP("Total de habitaciones disponible: " + listCombinacionesRbDto.size());
        for (String auxCombinacionesRbDto : listCombinacionesRbDto) {
            valorarCombinacionesRbDto = getValorarCombinacionesRbDto(auxCombinacionesRbDto);
            listaAvail.addListaAvail(valorarCombinacionesRbDto);
        }

        return listaAvail;
    }

    public static ValorarCombinacionesRbDto getValorarCombinacionesRbDto(String CombinacionesRbDto) {
        ValorarCombinacionesRbDto valorarCombinacionesRbDto = new ValorarCombinacionesRbDto();


        List<String> auxreadTagsSOAP = new ArrayList<String>();

        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "ambito");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de ambito " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setAmbito(auxreadTagsSOAP.get(0));

        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "cadenaValidacionComb");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de cadenaValidacionComb " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setCadenaValidacionComb(auxreadTagsSOAP.get(0));

        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "codigoDivisa");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de codigoDivisa " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setCodigoDivisa(auxreadTagsSOAP.get(0));

        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "disponibilidad");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de disponibilidad " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setDisponibilidad(auxreadTagsSOAP.get(0));

        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "estmin");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de estmin " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setEstmin(auxreadTagsSOAP.get(0));


        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "hotel");
        //[OJO] Cuando busca dentro de los "ValorarCombinacionesRbDto" existen dos tags "hotel", una esta a la altura de la rais y otro dentro de una lista listTHabs
        // Pero en este caso solo esta tomando el correspondiente, que esta a la altura de la rais
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de hotel " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setHotel(auxreadTagsSOAP.get(0));

        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "hotel_tarifa");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de hotel_tarifa " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setHotel_tarifa(auxreadTagsSOAP.get(0));

        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "id");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de id " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setId(auxreadTagsSOAP.get(0));

        // lmotivo; <lmotivo/> Esta comentado por que este request no trae dato y no se si es lista o un dato
//        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "lmotivo");
//        if (auxreadTagsSOAP.size() > 1)
//            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de lmotivo " + auxreadTagsSOAP.size());
//        valorarCombinacionesRbDto.setLmotivo(auxreadTagsSOAP.get(0));

        // paradaventa; <paradaventa/> Esta comentado por que este request no trae dato y no se si es lista o un dato
//        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "paradaventa");
//        if (auxreadTagsSOAP.size() > 1)
//            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de paradaventa " + auxreadTagsSOAP.size());
//        valorarCombinacionesRbDto.setParadaventa(auxreadTagsSOAP.get(0));

        // precio;
        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "precio");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de precio " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setPrecio(auxreadTagsSOAP.get(0));

        // precioAnterior;
        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "precioAnterior");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de precioAnterior " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setPrecioAnterior(auxreadTagsSOAP.get(0));

        // precioAnteriorSinImpuestos;
        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "precioAnteriorSinImpuestos");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de precioAnteriorSinImpuestos " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setPrecioAnteriorSinImpuestos(auxreadTagsSOAP.get(0));

        // precioSinImpuestos;
        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "precioSinImpuestos");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de precioSinImpuestos " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setPrecioSinImpuestos(auxreadTagsSOAP.get(0));

        // precioSinPuntos;
        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "precioSinPuntos");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de precioSinPuntos " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setPrecioSinPuntos(auxreadTagsSOAP.get(0));

        // precioTransfer;
        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "precioTransfer");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de precioTransfer " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setPrecioTransfer(auxreadTagsSOAP.get(0));

        // precioTransferSinImpuestos;
        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "precioTransferSinImpuestos");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de precioTransferSinImpuestos " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setPrecioTransferSinImpuestos(auxreadTagsSOAP.get(0));

        // puntosHabitacion;
        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "puntosHabitacion");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de puntosHabitacion " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setPuntosHabitacion(auxreadTagsSOAP.get(0));

        // release;
        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "release");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de release " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setRelease(auxreadTagsSOAP.get(0));

        // switaxinl;
        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "switaxinl");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de switaxinl " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setSwitaxinl(auxreadTagsSOAP.get(0));

        // tipoCombinacion;
        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "tipoCombinacion");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de tipoCombinacion " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setTipoCombinacion(auxreadTagsSOAP.get(0));


//        // tipoTarifa; <tipoTarifa/> Esta comentado por que este request no trae dato y no se si es lista o un dato
//        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "tipoTarifa");
//        if (auxreadTagsSOAP.size() > 1)
//            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de tipoTarifa " + auxreadTagsSOAP.size());
//        valorarCombinacionesRbDto.setTipoTarifa(auxreadTagsSOAP.get(0));

        // version1;
        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "version1");
        if (auxreadTagsSOAP.size() > 1)
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de version1 " + auxreadTagsSOAP.size());
        valorarCombinacionesRbDto.setVersion1(auxreadTagsSOAP.get(0));


        //listaHabitaciones
        auxreadTagsSOAP = readTagsSOAP(CombinacionesRbDto, "listaHabitaciones");
        if (auxreadTagsSOAP.size() == 0) {
            ObservacionesSOAP.addObsInconsistencia("No se ecnontro listaHabitaciones ");
        } else if (auxreadTagsSOAP.size() > 1) {
            ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de listaHabitaciones " + auxreadTagsSOAP.size());
        }
        String tagslistaHabitaciones = auxreadTagsSOAP.get(0);

        List<String> listTagsHabitacionesValCombinacionesDto = readTagsSOAP(tagslistaHabitaciones, "HabitacionesValCombinacionesDto");
        for (String auxHabitacionesValCombinacionesDto : listTagsHabitacionesValCombinacionesDto) {
            //Armamos los objetos de HabitacionesValCombinacionesDto que se registran en la lista listaHabitaciones
            HabitacionesValCombinacionesDto habitacionesValCombinacionesDto = new HabitacionesValCombinacionesDto();

            auxreadTagsSOAP = readTagsSOAP(auxHabitacionesValCombinacionesDto, "codtha");
            if (auxreadTagsSOAP.size() > 1)
                ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de codtha " + auxreadTagsSOAP.size());
            habitacionesValCombinacionesDto.setCodtha(auxreadTagsSOAP.get(0));

            auxreadTagsSOAP = readTagsSOAP(auxHabitacionesValCombinacionesDto, "codtre");
            if (auxreadTagsSOAP.size() > 1)
                ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de codtre " + auxreadTagsSOAP.size());
            habitacionesValCombinacionesDto.setCodtre(auxreadTagsSOAP.get(0));

            auxreadTagsSOAP = readTagsSOAP(auxHabitacionesValCombinacionesDto, "flagCompararOcupacionEnEquals");
            if (auxreadTagsSOAP.size() > 1)
                ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de flagCompararOcupacionEnEquals " + auxreadTagsSOAP.size());
            habitacionesValCombinacionesDto.setFlagCompararOcupacionEnEquals(auxreadTagsSOAP.get(0));

            auxreadTagsSOAP = readTagsSOAP(auxHabitacionesValCombinacionesDto, "numHab");
            if (auxreadTagsSOAP.size() > 1)
                ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de numHab " + auxreadTagsSOAP.size());
            habitacionesValCombinacionesDto.setNumHab(auxreadTagsSOAP.get(0));

            auxreadTagsSOAP = readTagsSOAP(auxHabitacionesValCombinacionesDto, "numad");
            if (auxreadTagsSOAP.size() > 1)
                ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de numad " + auxreadTagsSOAP.size());
            habitacionesValCombinacionesDto.setNumad(auxreadTagsSOAP.get(0));

            auxreadTagsSOAP = readTagsSOAP(auxHabitacionesValCombinacionesDto, "numbb");
            if (auxreadTagsSOAP.size() > 1)
                ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de numbb " + auxreadTagsSOAP.size());
            habitacionesValCombinacionesDto.setNumbb(auxreadTagsSOAP.get(0));

            auxreadTagsSOAP = readTagsSOAP(auxHabitacionesValCombinacionesDto, "numni");
            if (auxreadTagsSOAP.size() > 1)
                ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de numni " + auxreadTagsSOAP.size());
            habitacionesValCombinacionesDto.setNumni(auxreadTagsSOAP.get(0));

            auxreadTagsSOAP = readTagsSOAP(auxHabitacionesValCombinacionesDto, "precio");
            if (auxreadTagsSOAP.size() > 1)
                ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de precio " + auxreadTagsSOAP.size());
            habitacionesValCombinacionesDto.setPrecio(auxreadTagsSOAP.get(0));

            auxreadTagsSOAP = readTagsSOAP(auxHabitacionesValCombinacionesDto, "precioSinImpuestos");
            if (auxreadTagsSOAP.size() > 1)
                ObservacionesSOAP.addObsInconsistencia("Se encontro mas de un tags de precioSinImpuestos " + auxreadTagsSOAP.size());
            habitacionesValCombinacionesDto.setPrecioSinImpuestos(auxreadTagsSOAP.get(0));

            //Agrego la habitacion
            valorarCombinacionesRbDto.addListaHabitaciones(habitacionesValCombinacionesDto);///Ejecutar el RUN TEST
        }

        return valorarCombinacionesRbDto;
    }


    public static String getInfoResponseSOAP(ListaAvail listaAvail) {
        String ValorarCombinacionesRbDto = "Total De ValorarCombinacionesRbDto: " + listaAvail.getListaAvail().size() + "\n\t";
        StringBuilder HabitacionesDisponibles = new StringBuilder();
        int cont = 1;
        for (ValorarCombinacionesRbDto aux : listaAvail.getListaAvail()) {
            HabitacionesDisponibles.append("> ValorarCombinacionesRbDto[").append(cont).append("]:\n\t");
            HabitacionesDisponibles.append("\t>> Ambito: " + aux.getAmbito() + "\n\t");
            HabitacionesDisponibles.append("\t>> cadenaValidacionComb: " + aux.getCadenaValidacionComb() + "\n\t");
            HabitacionesDisponibles.append("\t>> disponibilidad: " + aux.getDisponibilidad() + "\n\t");
            HabitacionesDisponibles.append("\t>> estmin: " + aux.getEstmin() + "\n\t");
            HabitacionesDisponibles.append("\t>> hotel: " + aux.getHotel() + "\n\t");
            HabitacionesDisponibles.append("\t>> hotel_tarifa: " + aux.getHotel_tarifa() + "\n\t");
            HabitacionesDisponibles.append("\t>> id: " + aux.getId() + "\n\t");

            HabitacionesDisponibles.append("\t>>> listaHabitaciones: " + aux.getListaHabitaciones().size() + "\n\t");
            int contHVCB = 1;
            for (HabitacionesValCombinacionesDto auxB : aux.getListaHabitaciones()) {
                HabitacionesDisponibles.append("\t\t>> HabitacionesValCombinacionesDto[").append(contHVCB).append("]:\n\t");
                HabitacionesDisponibles.append("\t\t\t>>> codtha: " + auxB.getCodtha() + "\n\t");
                HabitacionesDisponibles.append("\t\t\t>>> codtre: " + auxB.getCodtre() + "\n\t");
                HabitacionesDisponibles.append("\t\t\t>>> numHab: " + auxB.getNumHab() + "\n\t");
                HabitacionesDisponibles.append("\t\t\t>>> numad: " + auxB.getNumad() + "\n\t");
                HabitacionesDisponibles.append("\t\t\t>>> numbb: " + auxB.getNumbb() + "\n\t");
                HabitacionesDisponibles.append("\t\t\t>>> numni: " + auxB.getNumni() + "\n\t");
                HabitacionesDisponibles.append("\t\t\t>>> precio: " + auxB.getPrecio() + "\n\t");
                HabitacionesDisponibles.append("\t\t\t>>> precioSinImpuestos: " + auxB.getPrecioSinImpuestos() + "\n\t");
                contHVCB++;
            }
            cont++;
        }
        return ValorarCombinacionesRbDto + HabitacionesDisponibles;
    }

}
