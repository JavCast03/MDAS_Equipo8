package abstractfactory;

public class PlatoMenuRestaurante implements PlatoMenu {
    private String entrante;
    private String principal;
    private String acompañamiento;
    private String postre;
    private double precioBase;

    public PlatoMenuRestaurante(String entrante, String principal, String acompañamiento, String postre,
            double precioBase) {
        this.entrante = entrante;
        this.principal = principal;
        this.acompañamiento = acompañamiento; // ensalada o patatas [cite: 30]
        this.postre = postre; // El menú en restaurante incluye postre [cite: 29]
        this.precioBase = precioBase;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println(
                "Menú (En Restaurante): " + entrante + " + " + principal + " con " + acompañamiento + " + " + postre);
    }

    @Override
    public double calcularPrecio() {
        return precioBase;
    }
}