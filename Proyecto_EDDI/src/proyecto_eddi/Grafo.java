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
import java.util.Iterator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
//import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.stream.GraphParseException;
import org.graphstream.ui.view.Viewer;


/**
 *
 * @author josue
 */
public class Grafo {

    public Graph graph = new SingleGraph("Grafo");
    public double[][] adyacente;
    public double[][] adyacentefloyd;

    public Grafo() {

    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public double[][] getAdyacente() {
        return adyacente;
    }

    public void setAdyacente(double[][] adyacente) {
        this.adyacente = adyacente;
    }

    //Metodo para sacar la matriz de adyacencia del graph
    public double[][] getVicinity() {
        double[][] retorno = new double[graph.getNodeCount()][graph.getNodeCount()];
        java.util.ArrayList<String> labels = new java.util.ArrayList();
        for (int i = 0; i < retorno.length; i++) {
            for (int j = 0; j < retorno.length; j++) {
                retorno[i][j] = 0;
            }
        }
        for (int i = 0; i < graph.getNodeCount(); i++) {
            labels.add(graph.getNode(i).getId());
        }
        /*for (int i = 0; i < labels.size(); i++) {
            System.out.print("[" + labels.get(i) + "]");
        }*/
        int i = 0, j = 0;
        for (Node n : graph) {
            Iterator<? extends Edge> edges = n.getLeavingEdgeIterator();
            while (edges.hasNext()) {
                Edge arista = edges.next();
                Node origin = arista.getSourceNode();
                Node destiny = arista.getTargetNode();
                if (n.getId().equals(origin.getId())) {
                    j = labels.indexOf(destiny.getId());
                    retorno[i][j] = arista.getNumber("Weight");
                } else if (n.getId().equals(destiny.getId())) {
                    j = labels.indexOf(origin.getId());
                    retorno[i][j] = arista.getNumber("Weight");
                }

            }
            i++;
        }
        /*for (int k = 0; k < retorno.length; k++) {
            for (int l = 0; l < retorno.length; l++) {
                System.out.print("[" + retorno[k][l] + "]");
            }
            System.out.println();
        }
        System.out.println("");*/
        return retorno;
    }

    //Metodo para leer Grafo de un archivo
    public void readGraph(String path) throws FileNotFoundException, IOException {
        graph.clear();
        String line, tag, origin, destiny;
        double weight;
        String[] auxiliar;
        BufferedReader br = new BufferedReader(new FileReader(path));
        line = br.readLine();
        auxiliar = line.split(",");
        for (int i = 0; i < auxiliar.length; i++) {
            graph.addNode(auxiliar[i]);
        }
        while ((line = br.readLine()) != null) {
            auxiliar = line.split(",");
            tag = auxiliar[0] + auxiliar[1];
            origin = auxiliar[0];
            destiny = auxiliar[1];
            weight = Double.parseDouble(auxiliar[2]);
            graph.addEdge(tag, origin, destiny);
            Edge e = graph.getEdge(tag);
            e.addAttribute("Weight", weight);
        }
        br.close();
        adyacente = getVicinity();
        adyacentefloyd = getVicinity();
    }
    
    public Viewer showGraph(){
        if(graph.hasAttribute("ui.quality")){
            graph.clearAttributes();
        }
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");
        graph.addAttribute("ui.stylesheet",
                "edge { fill-color: grey;}");
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
            node.addAttribute("ui.size", 10);
        }
        for (Edge edge : graph.getEachEdge()) {
            edge.setAttribute("ui.label", edge.getNumber("Weight"));
        }
        return graph.display();
        
    }
    
    public boolean inBounds(int posicion) {
        return posicion < adyacente.length && posicion >= 0;
    }
    
    public String GraphtoString() {
        String retorno = "";
        for (int i = 0; i < graph.getNodeCount() + 1; i++) {
            for (int j = 0; j < graph.getNodeCount() + 1; j++) {
                if (i == 0 && j == 0) {
                    retorno += "[V]";
                } else if (i == 0) {
                    retorno += "[-" + j + "-]";
                } else if (j == 0) {
                    retorno += "[" + i + "]";
                } else {
                    retorno += "[" + (int)adyacente[i - 1][j - 1] + "]";
                }
            }
            retorno += '\n';

        }
        return retorno;
    }
    
    public String GraphtoString(double[][] matriz) {
        String retorno = "";
        for (int i = 0; i < graph.getNodeCount() + 1; i++) {
            for (int j = 0; j < graph.getNodeCount() + 1; j++) {
                if (i == 0 && j == 0) {
                    retorno += "[V]";
                } else if (i == 0) {
                    retorno += "[-" + j + "-]";
                } else if (j == 0) {
                    retorno += "[" + i + "]";
                } else {
                    retorno += "[" + matriz[i - 1][j - 1] + "]";
                }
            }
            retorno += '\n';

        }
        return retorno;
    }

}
