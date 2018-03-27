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

/**
 *
 * @author josue
 */
public class Dijkstra {

    private final int infinito = (int) Double.POSITIVE_INFINITY;
    public int vertices;
    /*public int[][] grafo = {
    {0, 4, 0, 0, 0, 0, 0, 8, 0},
    {4, 0, 8, 0, 0, 0, 0, 11, 0},
    {0, 8, 0, 7, 0, 4, 0, 0, 2},
    {0, 0, 7, 0, 9, 14, 0, 0, 0},
    {0, 0, 0, 9, 0, 10, 0, 0, 0},
    {0, 0, 4, 0, 10, 0, 2, 0, 0},
    {0, 0, 0, 14, 0, 2, 0, 1, 6},
    {8, 11, 0, 0, 0, 0, 1, 0, 7},
    {0, 0, 2, 0, 0, 0, 6, 7, 0}
    };*/
    public int[][] grafo;

    public Dijkstra(){
        
    }

    public int minDistance(int[] dist, boolean[] visitados) {
        //int min = Integer.MAX_VALUE;
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
        //System.out.println("Distancia minima del vertice seleccionado(vertice " + n + "): ");
        for (int i = 0; i < distancias.length; i++) {
            retorno+="["+distancias[i]+"]";
        }
        return retorno;
    }

    public int[] startDijkstra(int origen) {
        int[] distancias = new int[vertices];
        boolean[] visitados = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            distancias[i] = infinito;
            visitados[i] = false;
        }
        //if (origen - 1 >= vertices || origen - 1 < 0) {
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
            //printDijkstra(distancias,origen);
            //System.out.println(GraphtoString());
            //System.out.println("∞");

        //} else {
          /*  System.out.println("Ese origen no es valido");
            System.out.println(origen - 1);
            System.out.println(grafo.length);
            System.out.println(vertices);
        }*/
          return distancias;

    }
    
    public boolean inBounds(int posicion){
        return posicion-1>=grafo.length||posicion-1<0;
    }
    
    //Metodos de utileria
    
    public String GraphtoString(){
        String retorno = "";
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if(i==0&&j==0){
                    retorno+="[V]";
                }else if(i==0){
                    retorno+="["+j+"]";
                }else if(j==0){
                    retorno+="["+i+"]";
                }else{
                    retorno+="["+grafo[i-1][j-1]+"]";
                }
            }
            retorno+='\n';
            
        }
        return retorno;
    }
    
    public void readGraph(String path) throws FileNotFoundException, IOException{
        String line;
        int fila = 0;
        boolean creado = false;
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null) {
            String[]temporal = line.split(",");
            if(creado==false){
                grafo = new int[temporal.length][temporal.length];
                creado = true;
            }
            for (int i = 0; i < temporal.length; i++) {
                grafo[fila][i] = Integer.parseInt(temporal[i]);
            }
            fila++;
        }
        vertices = grafo.length;
        //System.out.println(GraphtoString());
        
    }

}
