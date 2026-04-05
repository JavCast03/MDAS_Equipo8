import java.util.ArrayList;
import java.util.List;

public class EmpresaA implements IProveedor {
    private List<Producto> inventario;

    public EmpresaA() {
        inventario = new ArrayList<>();
        inventario.add(new Producto("Sofá Chaise Longue", 450.0, 5, "Tela", "Gris", 3, null));
        inventario.add(new Producto("Sofá Cama", 300.0, 2, "Cuero", "Negro", 2, null));
    }

    @Override
    public List<Producto> obtenerInventario() {
        return inventario;
    }
}