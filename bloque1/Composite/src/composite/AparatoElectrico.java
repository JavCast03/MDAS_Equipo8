package composite;

public class AparatoElectrico implements IComponenteEnergia {
    
    private String nombre;
    private double consumoPorHora;
    private double horasUso;

    public AparatoElectrico(String nombre, double consumoPorHora, double horasUso) {
        if (consumoPorHora < 0 || horasUso < 0) {
            throw new IllegalArgumentException("El consumo y las horas no pueden ser valores negativos.");
        }
        this.nombre = nombre;
        this.consumoPorHora = consumoPorHora;
        this.horasUso = horasUso;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double estimarConsumoGlobal() {
        return consumoPorHora * horasUso;
    }

    @Override
    public double calcularCosteTotal(double precioKWh) {
        return estimarConsumoGlobal() * precioKWh;
    }
}