package composite;

import java.util.ArrayList;
import java.util.List;

public class Espacio implements IComponenteEnergia {
    
    private String nombre;
    private List<IComponenteEnergia> componentes;

    public Espacio(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    public void agregar(IComponenteEnergia componente) {
        if (componente == null) {
            throw new IllegalArgumentException("No se puede añadir un componente nulo.");
        }
        componentes.add(componente);
    }

    public void eliminar(IComponenteEnergia componente) {
        componentes.remove(componente);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double estimarConsumoGlobal() {
        double consumoTotal = 0;
        for (IComponenteEnergia comp : componentes) {
            consumoTotal += comp.estimarConsumoGlobal();
        }
        return consumoTotal;
    }

    @Override
    public double calcularCosteTotal(double precioKWh) {
        double costeTotal = 0;
        for (IComponenteEnergia comp : componentes) {
            costeTotal += comp.calcularCosteTotal(precioKWh);
        }
        return costeTotal;
    }
}