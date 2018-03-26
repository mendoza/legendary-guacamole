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
public class NodeofTree {

    private BinaryTree data;
    private NodeofTree siguiente;

    public NodeofTree(BinaryTree d) {
        this.data = d;
        this.siguiente = null;
    }

    public BinaryTree getData() {
        return data;
    }

    public void setData(BinaryTree dato) {
        this.data = dato;
    }

    public NodeofTree getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodeofTree siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
