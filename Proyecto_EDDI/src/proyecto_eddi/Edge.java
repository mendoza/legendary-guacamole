/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

/**
 *
 * @author josue
 */
public class Edge {
    //Representa una Arista del grafo :v no le quise poner arista pq edge es mas bonitp
    public Vertex destino;
    public double costo;

    public Edge(Vertex destino, double costo) {
        this.destino = destino;
        this.costo = costo;
    }

    public Vertex getDestino() {
        return destino;
    }

    public void setDestino(Vertex destino) {
        this.destino = destino;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
    
}
