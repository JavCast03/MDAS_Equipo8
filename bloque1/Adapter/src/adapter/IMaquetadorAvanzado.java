import java.util.List;

public interface IMaquetadorAvanzado {
    void unirFicheros(String archivo1, String archivo2, String archivoSalida);

    void combinarIntercalando(String archivo1, String archivo2,
            List<int[]> parrafos1, List<int[]> parrafos2,
            String archivoSalida);

    void separarFicheroMultiple(String archivoOrigen, List<Integer> puntosDeCorte,
            List<String> archivosSalida);
}