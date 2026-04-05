import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SistemaEmpresa {
    private List<CatalogoMobiliario> catalogos = new ArrayList<>();

    public void addCatalogo(CatalogoMobiliario catalogo) {
        catalogos.add(catalogo);
    }

    public List<Producto> buscarYOrdenarPorPrecioAsc() {
        List<Producto> todosLosProductos = new ArrayList<>();
        for (CatalogoMobiliario catalogo : catalogos) {
            todosLosProductos.addAll(catalogo.obtenerTodo());
        }

        return todosLosProductos.stream()
                .filter(p -> p.getUnidadesDisponibles() > 0)
                .sorted(Comparator.comparingDouble(Producto::getPrecio))
                .collect(Collectors.toList());
    }

    public List<Producto> buscarYOrdenarPorUnidadesDesc() {
        Map<String, Producto> productosAgrupados = new HashMap<>();

        for (CatalogoMobiliario catalogo : catalogos) {
            for (Producto p : catalogo.obtenerTodo()) {
                if (p.getUnidadesDisponibles() > 0) {
                    if (productosAgrupados.containsKey(p.getNombre())) {
                        productosAgrupados.get(p.getNombre()).sumarUnidades(p.getUnidadesDisponibles());
                    } else {
                        productosAgrupados.put(p.getNombre(), new Producto(
                                p.getNombre(), p.getPrecio(), p.getUnidadesDisponibles(),
                                p.getMaterial(), p.getColor(), p.getPlazas(), p.getDimensiones()));
                    }
                }
            }
        }

        return productosAgrupados.values().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getUnidadesDisponibles(), p1.getUnidadesDisponibles()))
                .collect(Collectors.toList());
    }
}