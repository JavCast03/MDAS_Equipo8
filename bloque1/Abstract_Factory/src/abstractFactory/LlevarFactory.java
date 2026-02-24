package abstractfactory;

public class LlevarFactory implements PedidoFactory {
    @Override
    public PlatoMenu crearPlatoMenu(String entrante, String principal, String acompañamiento, String postre, double precioBase) {
        // Ignoramos el postre que nos pasen por parámetro porque para llevar no lo incluye [cite: 29]
        return new PlatoMenuLlevar(entrante, principal, acompañamiento, precioBase);
    }

    @Override
    public PlatoTemporada crearPlatoTemporada(String nombre, double precioBase) {
        return new PlatoTemporadaLlevar(nombre, precioBase);
    }
}