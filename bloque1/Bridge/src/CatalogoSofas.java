import java.util.List;
import java.util.stream.Collectors;

public class CatalogoSofas extends CatalogoMobiliario {
    public List<Producto> buscarPorPlazas(int plazas) {
        return obtenerTodo().stream()
                .filter(p -> p.getPlazas() == plazas)
                .collect(Collectors.toList());
    }
}