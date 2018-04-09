/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author josue
 */
public class Floyd extends Grafo {

    public double[][] camino;
    public double[][] distancias;

    public Floyd() {

    }

    public void startFloyd() {
        if (graph.getNodeCount() > 0) {
            //prepareFloyd();
            for (int k = 0; k < graph.getNodeCount(); k++) {
                for (int i = 0; i < graph.getNodeCount(); i++) {
                    for (int j = 0; j < graph.getNodeCount(); j++) {
                        double aux = distancias[i][k] + distancias[k][j];
                        if (aux < distancias[i][j]) {
                            distancias[i][j] = aux;
                            camino[i][j] = k;
                        }
                    }
                }
            }
        }

    }

    public void prepareFloyd() {
        this.distancias = super.adyacente.clone();
        camino = new double[distancias.length][distancias.length];
        for (int i = 0; i < distancias.length; i++) {
            for (int j = 0; j < distancias.length; j++) {
                if (j != i) {
                    if (distancias[i][j] <= 0) {
                        distancias[i][j] = Double.POSITIVE_INFINITY;
                    }
                    camino[i][j] = j;
                } else {
                    camino[i][j] = 0;
                }
            }
        }
    }
    
    public void printMatrix(double[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print("["+matrix[i][j]+"]");
            }
            System.out.println();
        }
    }
    
    @Override
    public Viewer showGraph() {
        if (graph.hasAttribute("ui.quality")) {
            graph.clearAttributes();
        }
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");
        graph.addAttribute("ui.stylesheet",
                "edge { fill-color: grey;}"+"node{size:32px; text-background-mode: plain; text-background-color: yellow; fill-mode: image-scaled; fill-image: url('./Images/electric-tower.png');}");
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
