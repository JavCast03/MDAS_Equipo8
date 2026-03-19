package adapter;
import java.util.List;
import java.io.File;

public class MaquetadorAdapter implements IMaquetadorAvanzado {
    private MaquetadorBasico maquetadorBasico;

    public MaquetadorAdapter() {
        this.maquetadorBasico = new MaquetadorBasico();
    }

    @Override
    public void unirFicheros(String archivo1, String archivo2, String archivoSalida) {
        if (archivo1 == null || archivo2 == null || archivoSalida == null) {
            throw new IllegalArgumentException("Las rutas de los archivos no pueden ser nulas.");
        }
        String contenido1 = maquetadorBasico.extraerParrafo(archivo1, 1, Integer.MAX_VALUE);
        String contenido2 = maquetadorBasico.extraerParrafo(archivo2, 1, Integer.MAX_VALUE);

        crearArchivoVacio(archivoSalida);

        maquetadorBasico.anadirTexto(archivoSalida, contenido1);
        maquetadorBasico.anadirTexto(archivoSalida, contenido2);
    }

    @Override
    public void combinarIntercalando(String archivo1, String archivo2,
            List<int[]> parrafos1, List<int[]> parrafos2,
            String archivoSalida) {

        if (parrafos1 == null || parrafos2 == null) {
            throw new IllegalArgumentException("Las listas de párrafos no pueden ser nulas.");
        }

        crearArchivoVacio(archivoSalida);

        int maxIteraciones = Math.max(parrafos1.size(), parrafos2.size());

        for (int i = 0; i < maxIteraciones; i++) {
            if (i < parrafos1.size()) {
                int[] rango1 = parrafos1.get(i);
                String p1 = maquetadorBasico.extraerParrafo(archivo1, rango1[0], rango1[1]);
                if (!p1.isEmpty())
                    maquetadorBasico.anadirTexto(archivoSalida, p1);
            }

            if (i < parrafos2.size()) {
                int[] rango2 = parrafos2.get(i);
                String p2 = maquetadorBasico.extraerParrafo(archivo2, rango2[0], rango2[1]);
                if (!p2.isEmpty())
                    maquetadorBasico.anadirTexto(archivoSalida, p2);
            }
        }
    }

    @Override
    public void separarFicheroMultiple(String archivoOrigen, List<Integer> puntosDeCorte,
            List<String> archivosSalida) {

        if (puntosDeCorte == null || archivosSalida == null || puntosDeCorte.size() >= archivosSalida.size()) {
            throw new IllegalArgumentException(
                    "Datos inválidos: Debe haber al menos un archivo de salida más que puntos de corte.");
        }

        String archivoTemporal = archivoOrigen;
        int lineasExtraidas = 0;

        for (int i = 0; i < puntosDeCorte.size(); i++) {
            String archivoActual = archivosSalida.get(i);
            String restoTemporal = "temp_resto_" + i + ".txt";

            int corteRelativo = puntosDeCorte.get(i) - lineasExtraidas;

            maquetadorBasico.dividirFichero(archivoTemporal, corteRelativo, archivoActual, restoTemporal);

            if (!archivoTemporal.equals(archivoOrigen)) {
                new File(archivoTemporal).delete();
            }
            archivoTemporal = restoTemporal;
            lineasExtraidas = puntosDeCorte.get(i);
        }

        File fResto = new File(archivoTemporal);
        File fUltimo = new File(archivosSalida.get(archivosSalida.size() - 1));

        if (fUltimo.exists())
            fUltimo.delete();
        fResto.renameTo(fUltimo);
    }

    private void crearArchivoVacio(String rutaArchivo) {
        try {
            File f = new File(rutaArchivo);
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
        } catch (Exception e) {
            System.err.println("Error crítico inicializando archivo de salida: " + e.getMessage());
        }
    }
}