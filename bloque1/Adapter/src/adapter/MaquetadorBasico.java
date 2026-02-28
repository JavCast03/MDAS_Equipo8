import java.io.*;

public class MaquetadorBasico {

    public void anadirTexto(String rutaArchivo, String texto) {
        try (FileWriter fw = new FileWriter(rutaArchivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.print(texto);
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
    }

    public String extraerParrafo(String rutaArchivo, int lineaInicio, int lineaFin) {
        StringBuilder parrafo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int lineaActual = 1;
            while ((linea = br.readLine()) != null) {
                if (lineaActual >= lineaInicio && lineaActual <= lineaFin) {
                    parrafo.append(linea).append(System.lineSeparator());
                }
                lineaActual++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
        return parrafo.toString();
    }

    public void dividirFichero(String rutaArchivo, int lineaCorte, String rutaDestino1, String rutaDestino2) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
                PrintWriter out1 = new PrintWriter(new FileWriter(rutaDestino1));
                PrintWriter out2 = new PrintWriter(new FileWriter(rutaDestino2))) {

            String linea;
            int lineaActual = 1;
            while ((linea = br.readLine()) != null) {
                if (lineaActual <= lineaCorte) {
                    out1.println(linea);
                } else {
                    out2.println(linea);
                }
                lineaActual++;
            }
        } catch (IOException e) {
            System.err.println("Error al dividir fichero: " + e.getMessage());
        }
    }
}