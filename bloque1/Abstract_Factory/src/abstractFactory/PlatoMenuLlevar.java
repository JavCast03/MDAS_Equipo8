package abstractfactory;

public class PlatoMenuLlevar implements PlatoMenu {
    private String entrante;
    private String principal;
    private String acompañamiento;
    private double precioBase;

    public PlatoMenuLlevar(String entrante, String principal, String acompañamiento, double precioBase) {
        this.entrante = entrante;
        this.principal = principal;
        this.acompañamiento = acompañamiento; // ensalada o patatas [cite: 30]
        this.precioBase = precioBase;
        // El menú para llevar no incluye postre [cite: 29]
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Menú (Para Llevar): " + entrante + " + " + principal + " con " + acompañamiento + " (Sin postre)");
    }

    @Override
    public double calcularPrecio() {
        // Los platos tienen un incremento del 2% si el pedido es para llevar [cite: 28]
        return precioBase * 1.02; 
    }
}