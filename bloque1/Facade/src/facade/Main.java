package facade;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE AGENCIA DE VIAJES (PATRÓN FACADE) ===");

        AgenciaViajesFacade agencia = new AgenciaViajesFacade();

        agencia.organizarViajeGrupal("Sevilla", "Madrid", "15/10/2026", "20/10/2026");

        agencia.organizarViajeGrupal("Sevilla", "Córdoba", "01/11/2026", "05/11/2026");
    }
}