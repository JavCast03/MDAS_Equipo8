package facade;

import java.util.ArrayList;
import java.util.List;

public class AgenciaViajesFacade {
    private SistemaAlojamiento sistemaAlojamiento;
    private SistemaTransporte sistemaTransporte;
    private OficinaTurismoMadrid turismoMadrid;
    private OficinaTurismoCordoba turismoCordoba;

    public AgenciaViajesFacade() {
        this.sistemaAlojamiento = new SistemaAlojamiento();
        this.sistemaTransporte = new SistemaTransporte();
        this.turismoMadrid = new OficinaTurismoMadrid();
        this.turismoCordoba = new OficinaTurismoCordoba();
    }

    public void organizarViajeGrupal(String ciudadOrigen, String ciudadDestino, String fechaInicio, String fechaFin) {

        System.out.println("\n--- INICIANDO GESTIÓN DE VIAJE: " + ciudadOrigen + " -> " + ciudadDestino + " ---");

        List<String> transportes = sistemaTransporte.buscarTransporte(ciudadOrigen, ciudadDestino, fechaInicio,
                fechaFin);

        List<String> alojamientos = sistemaAlojamiento.buscarAlojamiento(ciudadDestino, fechaInicio, fechaFin);

        List<String> actividades = new ArrayList<>();
        if (ciudadDestino.equalsIgnoreCase("Madrid")) {
            actividades = turismoMadrid.eventosPorRangoFechas(fechaInicio, fechaFin);
        } else if (ciudadDestino.equalsIgnoreCase("Córdoba")) {
            actividades = turismoCordoba.buscarActividadesPorTipo("Cultura", fechaInicio);
        } else {
            actividades.add("No hay oficina de turismo registrada para este destino.");
        }

        imprimirItinerario(transportes, alojamientos, actividades);
    }

    private void imprimirItinerario(List<String> transportes, List<String> alojamientos, List<String> actividades) {
        System.out.println("\n--- ITINERARIO PROPUESTO ---");
        System.out.println(">> TRANSPORTES DISPONIBLES:");
        transportes.forEach(t -> System.out.println("  - " + t));

        System.out.println(">> ALOJAMIENTOS DISPONIBLES:");
        alojamientos.forEach(a -> System.out.println("  - " + a));

        System.out.println(">> ACTIVIDADES CULTURALES RECOMENDADAS:");
        actividades.forEach(act -> System.out.println("  - " + act));
        System.out.println("----------------------------------------------------\n");
    }
}