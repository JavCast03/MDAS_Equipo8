import java.util.ArrayList;
import java.util.List;

public class EmpresaB implements IProveedor {
    private List<Producto> inventario;

    public EmpresaB() {
        inventario = new ArrayList<>();
        inventario.add(new Producto("Mesa Comedor", 150.0, 10, "Madera", "Roble", 0, "120x80"));
        // Mesa sin stock para comprobar que el filtro funciona
        inventario.add(new Producto("Mesa Oficina", 80.0, 0, "Metal", "Blanco", 0, "100x60"));
    }

    @Override
    public List<Producto> obtenerInventario() {
        return inventario;
    }
}