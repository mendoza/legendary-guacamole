/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class Dijkstra {

    private final int infinito = (int) Double.POSITIVE_INFINITY;
    public int vertices;
    public int[][] grafo;

    public Dijkstra() {

    }

    public int minDistance(int[] dist, boolean[] visitados) {
        int min = infinito;
        int min_index = 0;
        for (int i = 0; i < vertices; i++) {
            if (visitados[i] == false && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public String printDijkstra(int[] distancias) {
        String retorno = "";
        if (distancias != null) {
            for (int i = 0; i < distancias.length; i++) {
                retorno += "[" + distancias[i] + "]";
            }
        }
        return retorno;
    }

    public int[] startDijkstra(int origen) {
        origen = origen - 1;
        int[] distancias = new int[vertices];
        boolean[] visitados = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            distancias[i] = infinito;
            visitados[i] = false;
        }
        if (inBounds(origen)) {
            distancias[origen] = 0;
            for (int i = 0; i < vertices - 1; i++) {
                int indice_menor = minDistance(distancias, visitados);
                visitados[indice_menor] = true;
                for (int j = 0; j < vertices; j++) {
                    if (!visitados[j] && grafo[indice_menor][j] > 0 && distancias[indice_menor] != infinito
                            && distancias[indice_menor] + grafo[indice_menor][j] < distancias[j]) {
                        distancias[j] = distancias[indice_menor] + grafo[indice_menor][j];
                    }
                }
            }
            //System.out.println("∞");
            return distancias;

        } else {
            JOptionPane.showMessageDialog(null, "Origen no valido", "Error", JOptionPane.ERROR_MESSAGE);

        }
        return null;

    }

    public boolean inBounds(int posicion) {
        return posicion < grafo.length && posicion >= 0;
    }

    //Metodos de utileria
    public String GraphtoString() {
        String retorno = "";
        for (int i = 0; i < vertices + 1; i++) {
            for (int j = 0; j < vertices + 1; j++) {
                if (i == 0 && j == 0) {
                    retorno += "[V]";
                } else if (i == 0) {
                    retorno += "[" + j + "]";
                } else if (j == 0) {
                    retorno += "[" + i + "]";
                } else {
                    retorno += "[" + grafo[i - 1][j - 1] + "]";
                }
            }
            retorno += '\n';

        }
        return retorno;
    }

    public void readGraph(String path) throws FileNotFoundException, IOException {
        String line;
        int fila = 0;
        boolean creado = false;
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null) {
            String[] temporal = line.split(",");
            if (creado == false) {
                grafo = new int[temporal.length][temporal.length];
                creado = true;
            }
            for (int i = 0; i < temporal.length; i++) {
                grafo[fila][i] = Integer.parseInt(temporal[i]);
            }
            fila++;
        }
        vertices = grafo.length;

    }

}
