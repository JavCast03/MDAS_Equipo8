package abstractfactory;

public class RestauranteFactory implements PedidoFactory {
    @Override
    public PlatoMenu crearPlatoMenu(String entrante, String principal, String acompañamiento, String postre, double precioBase) {
        return new PlatoMenuRestaurante(entrante, principal, acompañamiento, postre, precioBase);
    }

    @Override
    public PlatoTemporada crearPlatoTemporada(String nombre, double precioBase) {
        return new PlatoTemporadaRestaurante(nombre, precioBase);
    }
}