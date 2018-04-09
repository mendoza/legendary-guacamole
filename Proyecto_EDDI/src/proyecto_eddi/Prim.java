/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author josue
 */
public class Prim extends Grafo {
    
    boolean[] visitados;
    int indicePadres[];
    int pesos[];
    Graph mst = new SingleGraph("MST");
    boolean creado = false;
    
    public Prim(){
        
    }
    
    boolean getCreado(){
        return creado;
    }
    
    public void preparePrim(){
        visitados = new boolean[adyacente.length];
        indicePadres = new int[adyacente.length];
        pesos = new int[adyacente.length];
        for (int i = 0; i < visitados.length; i++) {
            visitados[i]=false;
            pesos[i]=Integer.MAX_VALUE;
        }
        pesos[0]=0;
        indicePadres[0]=-1;   
        
    }
    
    public void startPrim(){
        for (int i = 0; i < adyacente.length - 1; i++) {
            int minIndex = minDistance(pesos, visitados);
            visitados[minIndex] = true;
            for (int j = 0; j < adyacente.length; j++) {
                if (adyacente[minIndex][j] != 0 && visitados[j] == false && adyacente[minIndex][j] < pesos[j]) {
                    indicePadres[j] = minIndex;
                    pesos[j] = (int)adyacente[minIndex][j];
                }
            }
        }
    }
    
    public void createGraph() {
        creado = true;
        for (int i = 0; i < adyacente.length; i++) {
            int alfa = i+1;
            mst.addNode(alfa + "");
        }
        for (int i = 1; i <adyacente.length ; i++) {
            String id = i+"";
            int o = indicePadres[i]+1;
            int d = i+1;
            mst.addEdge(id, o+"", d+"");
            mst.getEdge(id).addAttribute("Weight", pesos[i]);
        }
        mst.addAttribute("ui.quality");
        mst.addAttribute("ui.antialias");
        mst.addAttribute("ui.stylesheet",
                "edge { fill-color: grey;}"+"node{size:32px; text-background-mode: plain; text-background-color: yellow; fill-mode: image-scaled; fill-image: url('./src/electric-tower.png');}");
        for (Node node : mst) {
            node.setAttribute("ui.label", node.getId());
            node.addAttribute("ui.size", 10);
        }
        for (Edge edge : mst.getEachEdge()) {
            
            edge.setAttribute("ui.label", edge.getNumber("Weight"));
        }
    }
    
    public Viewer showPrim(){
        if(!creado){
            createGraph();
        }
        return mst.display();
    }
    
    public String PrimToString(){
        String retorno = "";
        for (int i = 1; i < adyacente.length; i++) {
            int o = indicePadres[i]+1;
            int d = i +1;
            retorno+= "Desde "+ o + " hasta " + d +" con costo "+ adyacente[i][indicePadres[i]]+"\n";                    
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
                "edge { fill-color: grey;}"+"node{size:32px; text-background-mode: plain; text-background-color: yellow; fill-mode: image-scaled; fill-image: url('./src/electric-tower.png');}");
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
