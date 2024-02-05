package model;

import java.util.Collections;
import java.util.List;

public class borrarTest {
    public static void main(String[] args) {
        List<Integer> lista = List.of(1, 3, 9);
        int valorMasChicoEntreIntervalos = encontrarValorMasChicoEntreIntervalos(lista);
        System.out.println("El valor más chico entre los intervalos es: " + valorMasChicoEntreIntervalos);
    }

    public static int encontrarValorMasChicoEntreIntervalos(List<Integer> lista) {
        if (lista == null || lista.size() < 2) {
            throw new IllegalArgumentException("La lista debe contener al menos dos elementos.");
        }

        // Ordenar la lista
        Collections.sort(lista);

        int minDiff = Integer.MAX_VALUE;

        // Iterar sobre los elementos y calcular la diferencia entre pares consecutivos
        for (int i = 1; i < lista.size(); i++) {
            int diff = lista.get(i) - lista.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        // Restar 1 al valor más pequeño encontrado
        int valorMasChicoEntreIntervalos = minDiff - 1;

        return valorMasChicoEntreIntervalos;
    }
}
