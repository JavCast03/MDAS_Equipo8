package facade;

import java.util.ArrayList;
import java.util.List;

public class SistemaAlojamiento {
    private List<String> catalogoHoteles;

    public SistemaAlojamiento() {
        catalogoHoteles = new ArrayList<>();
        catalogoHoteles.add("Hotel Palace (Madrid)");
        catalogoHoteles.add("Hostal Centro (Madrid)");
        catalogoHoteles.add("Hotel Mezquita (Córdoba)");
        catalogoHoteles.add("Apartamentos Judería (Córdoba)");
    }

    public List<String> buscarAlojamiento(String ciudadDestino, String fechaEntrada, String fechaSalida) {
        List<String> resultados = new ArrayList<>();
        System.out.println("[Sub-Sistema Alojamiento] Buscando hoteles en " + ciudadDestino + "...");
        
        for (String hotel : catalogoHoteles) {
            if (hotel.contains(ciudadDestino)) {
                resultados.add(hotel + " (Disponible del " + fechaEntrada + " al " + fechaSalida + ")");
            }
        }
        return resultados;
    }
}