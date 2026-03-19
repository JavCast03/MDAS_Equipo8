package facade;

import java.util.ArrayList;
import java.util.List;

public class OficinaTurismoCordoba {
    public List<String> buscarActividadesPorTipo(String tipoEvento, String fechaAproximada) {
        System.out.println("[Sub-Sistema Turismo Córdoba] Consultando actividades de tipo: " + tipoEvento + "...");
        List<String> actividades = new ArrayList<>();
        if (tipoEvento.equalsIgnoreCase("Cultura")) {
            actividades.add("Visita Guiada a la Mezquita-Catedral");
            actividades.add("Ruta de los Patios Cordobeses");
        }
        return actividades;
    }
}