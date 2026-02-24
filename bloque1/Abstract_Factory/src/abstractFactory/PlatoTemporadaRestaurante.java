package abstractfactory;

public class PlatoTemporadaRestaurante implements PlatoTemporada {
    private String nombre;
    private double precioBase;

    public PlatoTemporadaRestaurante(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Plato de Temporada (En Restaurante): " + nombre);
    }

    @Override
    public double calcularPrecio() {
        return precioBase;
    }
}