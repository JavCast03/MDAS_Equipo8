import java.util.List;
import java.util.stream.Collectors;

public class CatalogoMesas extends CatalogoMobiliario {
    public List<Producto> buscarPorDimensiones(String dimensiones) {
        return obtenerTodo().stream()
                .filter(p -> p.getDimensiones() != null && p.getDimensiones().equalsIgnoreCase(dimensiones))
                .collect(Collectors.toList());
    }
}