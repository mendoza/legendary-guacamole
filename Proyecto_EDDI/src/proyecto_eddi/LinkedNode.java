/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

/**
 *
 * @author david
 */
public class LinkedNode {

    private char Data;
    private LinkedNode siguiente;
    private String path;

    public LinkedNode(char d) {
        this.Data = d;
        this.siguiente = null;
    }

    public LinkedNode(char letra, String camino) {
        this.Data = letra;
        this.siguiente = null;
        this.path = camino;
    }

    public char getData() {
        return Data;
    }

    public void setData(char dato) {
        this.Data = dato;
    }

    public LinkedNode getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(LinkedNode siguiente) {
        this.siguiente = siguiente;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
