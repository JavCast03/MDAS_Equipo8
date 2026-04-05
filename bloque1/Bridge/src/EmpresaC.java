import java.util.ArrayList;
import java.util.List;

public class EmpresaC implements IProveedor {
    private List<Producto> inventario;

    public EmpresaC() {
        inventario = new ArrayList<>();
        inventario.add(new Producto("Sofá Chaise Longue", 430.0, 3, "Tela", "Gris", 3, null));
        inventario.add(new Producto("Mesa Cristal", 200.0, 4, "Cristal", "Transparente", 0, "90x90"));
    }

    @Override
    public List<Producto> obtenerInventario() {
        return inventario;
    }
}