package abstractfactory;

public interface PedidoFactory {
    PlatoMenu crearPlatoMenu(String entrante, String principal, String acompañamiento, String postre,
            double precioBase);

    PlatoTemporada crearPlatoTemporada(String nombre, double precioBase);
}