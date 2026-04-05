import java.util.ArrayList;
import java.util.List;

public abstract class CatalogoMobiliario {
    protected List<IProveedor> proveedores = new ArrayList<>();

    public void addProveedor(IProveedor proveedor) {
        this.proveedores.add(proveedor);
    }

    public List<Producto> obtenerTodo() {
        List<Producto> todos = new ArrayList<>();
        for (IProveedor proveedor : proveedores) {
            todos.addAll(proveedor.obtenerInventario());
        }
        return todos;
    }
}