package adapter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
        public static void main(String[] args) {

                String carpeta = "bloque1" + File.separator + "Adapter" + File.separator + "src" + File.separator
                                + "adapter" + File.separator + "ficheros"
                                + File.separator;

                new File(carpeta).mkdirs();

                IMaquetadorAvanzado maquetador = new MaquetadorAdapter();

                System.out.println("1. Probando Unión de Ficheros...");
                maquetador.unirFicheros(carpeta + "fichero1.txt", carpeta + "fichero2.txt",
                                carpeta + "union_salida.txt");
                System.out.println("Ficheros unidos en '" + carpeta + "union_salida.txt'");

                System.out.println("2. Probando Combinación Intercalada...");
                List<int[]> p1 = new ArrayList<>(Arrays.asList(new int[] { 1, 2 }, new int[] { 5, 6 }));
                List<int[]> p2 = new ArrayList<>(Arrays.asList(new int[] { 1, 3 }));
                maquetador.combinarIntercalando(carpeta + "fichero1.txt", carpeta + "fichero2.txt", p1, p2,
                                carpeta + "combinado_salida.txt");
                System.out.println("Ficheros combinados en '" + carpeta + "combinado_salida.txt'");

                System.out.println("3. Probando Separación Múltiple...");
                List<Integer> cortes = new ArrayList<>(Arrays.asList(3, 6)); // Cortar en línea 3 y 6
                List<String> salidas = new ArrayList<>(
                                Arrays.asList(carpeta + "parte1.txt", carpeta + "parte2.txt", carpeta + "parte3.txt"));
                maquetador.separarFicheroMultiple(carpeta + "union_salida.txt", cortes, salidas);
                System.out.println("Fichero separado en las 3 partes correspondientes dentro de la carpeta.");
        }
}