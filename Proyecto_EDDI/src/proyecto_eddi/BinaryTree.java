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
public class BinaryTree {

    private BinaryNode Root;

    public BinaryTree() {
        Root = null;
    }

    public BinaryTree(BinaryNode raizArbol) {
        Root = raizArbol;
    }

    public BinaryNode getRoot() {
        return Root;
    }

    public void setRoot(BinaryNode Root) {
        this.Root = Root;
    }

    public void Erase() {
        this.Root = null;
    }

    public void Insert(char letra, Integer d) {
        BinaryNode nuevo = new BinaryNode(letra, d);
        if (Root == null) {
            Root = nuevo;
        } else {
            BinaryNode aux = Root;
            BinaryNode ant = null;
            while (aux != null) {
                ant = aux;
                if (d <= aux.getFrecuencia()) {
                    aux = aux.getL();
                } else {
                    aux.getR();
                }
            }
            if (d <= ant.getFrecuencia()) {
                ant.setL(nuevo);
            } else {
                ant.setR(nuevo);
            }
        }
    }

    public String toString() {
        return Root.toString();
    }

}
