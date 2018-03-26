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
public class Vertex {
    //representa los vertices
    public String label;
    public ArrayList adj;//Lista de adyacentes
    public double costo;
    public Vertex previo;//Vertice anterior en el camino mas corto :v
    public boolean procesado;

    public Vertex(String label) {
        this.label = label;
        this.adj = new ArrayList();
        this.costo = Double.POSITIVE_INFINITY;
        this.previo = null;
        this.procesado=false;
        
    }
    
    public void reset(){
        this.costo = Double.POSITIVE_INFINITY;
        this.previo = null;
        this.procesado=false;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ArrayList getAdj() {
        return adj;
    }

    public void setAdj(ArrayList adj) {
        this.adj = adj;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Vertex getPrevio() {
        return previo;
    }

    public void setPrevio(Vertex previo) {
        this.previo = previo;
    }

    public boolean isProcesado() {
        return procesado;
    }

    public void setProcesado(boolean procesado) {
        this.procesado = procesado;
    }
    
    
    
    
    
}
