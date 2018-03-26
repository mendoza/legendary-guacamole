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
public class DPath {
    public Vertex destino;
    public double costo;

    public DPath(Vertex destino, double costo) {
        this.destino = destino;
        this.costo = costo;
    }
    
    public int compareTo(DPath comp){
        return (this.costo<comp.costo?-1:this.costo>comp.costo?1:0);
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
