package facade;

import java.util.ArrayList;
import java.util.List;

public class OficinaTurismoMadrid {
    public List<String> eventosPorRangoFechas(String fechaInicio, String fechaFin) {
        System.out.println("[Sub-Sistema Turismo Madrid] Consultando agenda cultural...");
        List<String> eventos = new ArrayList<>();
        eventos.add("Musical El Rey León");
        eventos.add("Exposición Museo del Prado");
        return eventos;
    }
}