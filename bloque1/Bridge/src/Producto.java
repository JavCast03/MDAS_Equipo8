public class Producto {
    private String nombre;
    private double precio;
    private int unidadesDisponibles;
    private String material;
    private String color;
    private int plazas; 
    private String dimensiones;

    public Producto(String nombre, double precio, int unidadesDisponibles, String material, String color, int plazas, String dimensiones) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidadesDisponibles = unidadesDisponibles;
        this.material = material;
        this.color = color;
        this.plazas = plazas;
        this.dimensiones = dimensiones;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getUnidadesDisponibles() { return unidadesDisponibles; }
    public String getMaterial() { return material; }
    public String getColor() { return color; }
    public int getPlazas() { return plazas; }
    public String getDimensiones() { return dimensiones; }

    public void sumarUnidades(int cantidad) {
        this.unidadesDisponibles += cantidad;
    }

    @Override
    public String toString() {
        return nombre + " | Precio: " + precio + "€ | Stock: " + unidadesDisponibles;
    }
}