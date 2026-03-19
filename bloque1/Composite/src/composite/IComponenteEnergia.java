package composite;

public interface IComponenteEnergia {
    String getNombre();
    double estimarConsumoGlobal(); 
    double calcularCosteTotal(double precioKWh); 
}
