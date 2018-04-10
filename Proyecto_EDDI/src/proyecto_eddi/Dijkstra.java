/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

import javax.swing.JOptionPane;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author josue
 */
public class Dijkstra extends Grafo{

    private final int infinito = (int) Double.POSITIVE_INFINITY;
    
    public Dijkstra() {        
        
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
                if(distancias[i]==(int)Double.POSITIVE_INFINITY){
                    retorno += "[+∞]";
                }else{
                    retorno += "[" + distancias[i] + "]";
                }
            }
        }
        return retorno;
    }
    
    @Override
    public Viewer showGraph() {
        if (graph.hasAttribute("ui.quality")) {
            graph.clearAttributes();
        }
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");
        graph.addAttribute("ui.stylesheet",
                "edge { fill-color: grey;}"+"node{size:32px; text-background-mode: plain; text-background-color: yellow; fill-mode: image-scaled; fill-image: url('./src/Images/electric-tower.png');}");
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
            node.addAttribute("ui.size", 10);
        }
        for (Edge edge : graph.getEachEdge()) {
            edge.setAttribute("ui.label", edge.getNumber("Weight"));
        }
        return graph.display();

    }
}
