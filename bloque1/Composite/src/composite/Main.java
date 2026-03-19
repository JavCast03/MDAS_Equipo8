package composite;

public class Main {
    public static void main(String[] args) {

        final double PRECIO_KWH = 0.15; 

        System.out.println("=== SISTEMA DE CONTROL ENERGÉTICO UNIVERSITARIO ===\n");

        AparatoElectrico proyector = new AparatoElectrico("Proyector", 0.3, 5);
        AparatoElectrico ordenadores = new AparatoElectrico("20 Ordenadores", 4.0, 6); 
        AparatoElectrico maquinaVending = new AparatoElectrico("Máquina de Vending (Pasillo)", 0.5, 24);
        AparatoElectrico lucesExteriores = new AparatoElectrico("Focos Jardín", 2.0, 10);

        Espacio aula1 = new Espacio("Aula 1 (Informática)");
        Espacio edificioA = new Espacio("Edificio A (Ciencias)");
        Espacio campus = new Espacio("Campus Central");


        aula1.agregar(proyector);
        aula1.agregar(ordenadores);

        edificioA.agregar(aula1);
        edificioA.agregar(maquinaVending);

        campus.agregar(edificioA);
        campus.agregar(lucesExteriores);

        System.out.println("Consumo de un espacio pequeño (Solo Aula 1)");
        mostrarGasto(aula1, PRECIO_KWH);

        System.out.println("\n Consumo de un edificio (Aula 1 + Máquina Vending)");
        mostrarGasto(edificioA, PRECIO_KWH);

        System.out.println("\nGASTO TOTAL DEL CAMPUS (Edificio A + Luces exteriores)");
        mostrarGasto(campus, PRECIO_KWH);
    }

    private static void mostrarGasto(IComponenteEnergia componente, double precioKWh) {
        System.out.printf(" %s | Consumo: %.2f kWh | Coste Estimado: %.2f euros\n", 
                          componente.getNombre(), 
                          componente.estimarConsumoGlobal(), 
                          componente.calcularCosteTotal(precioKWh));
    }
}