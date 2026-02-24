package abstractfactory;

public class PlatoTemporadaLlevar implements PlatoTemporada {
    private String nombre;
    private double precioBase;

    public PlatoTemporadaLlevar(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Plato de Temporada (Para Llevar): " + nombre);
    }

    @Override
    public double calcularPrecio() {
        // Los platos tienen un incremento del 2% si el pedido es para llevar [cite: 28]
        return precioBase * 1.02; 
    }
}