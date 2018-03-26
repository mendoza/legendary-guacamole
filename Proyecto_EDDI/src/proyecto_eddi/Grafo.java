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
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author josue
 */
public class Grafo {

    private final double INFINITO = Double.POSITIVE_INFINITY;
    public Map<String, Vertex> vertexMap = new HashMap<String, Vertex>();

    public Grafo() {

    }

    public void addEdge(String source, String label, double cost) {
        Vertex v = getVertex(source);
        Vertex w = getVertex(label);
        v.adj.add(new Edge(w, cost));

    }

    public Vertex getVertex(String label) {
        //si el vertice que se busca no esta, lo agrega
        Vertex temp = vertexMap.get(label);
        if (temp == null) {
            temp = new Vertex(label);
            vertexMap.put(label, temp);
        }
        return temp;
    }

    public void printDijkstra(Vertex dest) {
        if (dest.previo != null) {
            printDijkstra(dest.previo);
            System.out.println(" -> ");
        }
        System.out.println("{" + dest.label + "," + dest.costo + "}");
    }

    public void clearAll() {
        for (Vertex v : vertexMap.values()) {
            v.reset();
        }
    }
    
    public void crearGrafo(String path) throws FileNotFoundException, IOException{
        String cadena;
        FileReader fr = new FileReader(path);
        BufferedReader bf = new BufferedReader(fr);
        while((cadena=bf.readLine())!=null){
            String[] temporal = cadena.split(",");
            String ori = temporal[0];
            String desti = temporal[1];
            double cos = Double.parseDouble(temporal[2]);
            addEdge(ori,desti,cos);
        }
        System.out.println("¡Grafo Creado!");
        
    }

    public void Dijkstra(String origen) {
        PriorityQueue<DPath> cola = new PriorityQueue<DPath>();
        Vertex inicio = vertexMap.get(origen);
        if (inicio != null) {
            clearAll();
            cola.add(new DPath(inicio, 0));
            inicio.setCosto(0);
            int nodosVisitados = 0;
            while (!cola.isEmpty() && nodosVisitados < vertexMap.size()) {
                DPath recorrido = cola.remove();
                Vertex v = recorrido.getDestino();
                if (!v.isProcesado()) {
                    continue;
                }
                v.setProcesado(true);
                nodosVisitados++;
                for (int i = 0; i < v.adj.length(); i++) {
                    Edge e = (Edge) v.adj.get(i);
                    Vertex w = e.getDestino();
                    double cvw = e.getCosto();
                    if (w.getCosto() > v.getCosto() + cvw) {
                        w.setCosto(v.getCosto() + cvw);
                        w.setPrevio(v);
                        cola.add(new DPath(w, w.getCosto()));

                    }
                }

            }
        }

    }

}
