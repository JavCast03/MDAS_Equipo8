package facade;

import java.util.ArrayList;
import java.util.List;

public class SistemaTransporte {
    private List<String> catalogoTransportes;

    public SistemaTransporte() {
        catalogoTransportes = new ArrayList<>();
        catalogoTransportes.add("AVE Tren: Sevilla -> Madrid");
        catalogoTransportes.add("Vuelo Iberia: Sevilla -> Madrid");
        catalogoTransportes.add("Autobús ALSA: Sevilla -> Córdoba");
        catalogoTransportes.add("AVE Tren: Madrid -> Córdoba");
    }

    public List<String> buscarTransporte(String origen, String destino, String fechaIda, String fechaVuelta) {
        List<String> resultados = new ArrayList<>();
        System.out.println("[Sub-Sistema Transporte] Buscando rutas de " + origen + " a " + destino + "...");
        
        for (String transporte : catalogoTransportes) {
            if (transporte.contains(origen) && transporte.contains(destino)) {
                resultados.add(transporte + " (Ida: " + fechaIda + " - Vuelta: " + fechaVuelta + ")");
            }
        }
        return resultados;
    }
}