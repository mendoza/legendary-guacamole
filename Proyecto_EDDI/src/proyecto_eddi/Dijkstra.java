/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class Dijkstra extends Grafo{

    private final int infinito = (int) Double.POSITIVE_INFINITY;
    //public int vertices;
    //public int[][] grafo;

    public Dijkstra() {
        //readGraph(path);
        //super.adyacente = getVicinity();
        
    }

    public int minDistance(int[] dist, boolean[] visitados) {
        int min = infinito;
        int min_index = 0;
        for (int i = 0; i < graph.getNodeCount(); i++) {
            if (visitados[i] == false && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public int[] startDijkstra(int origen) {
        origen = origen - 1;
        int[] distancias = new int[graph.getNodeCount()];
        boolean[] visitados = new boolean[graph.getNodeCount()];
        for (int i = 0; i < graph.getNodeCount(); i++) {
            distancias[i] = infinito;
            visitados[i] = false;
        }
        if (inBounds(origen)) {
            distancias[origen] = 0;
            for (int i = 0; i < graph.getNodeCount() - 1; i++) {
                int indice_menor = minDistance(distancias, visitados);
                visitados[indice_menor] = true;
                for (int j = 0; j < graph.getNodeCount(); j++) {
                    if (!visitados[j] && adyacente[indice_menor][j] > 0 && distancias[indice_menor] != infinito
                            && distancias[indice_menor] + adyacente[indice_menor][j] < distancias[j]) {
                        distancias[j] = distancias[indice_menor] + (int) adyacente[indice_menor][j];
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

    //Metodos de utileria
    public String printDijkstra(int[] distancias) {
        String retorno = "";
        if (distancias != null) {
            for (int i = 0; i < distancias.length; i++) {
                retorno += "[" + distancias[i] + "]";
            }
        }
        return retorno;
    }
    
    /*public void readGraph(String path) throws FileNotFoundException, IOException {
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

    }*/
}
