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
public class ListofTrees {

    private NodeofTree inicio;

    public NodeofTree getInicio() {
        return inicio;
    }

    public void setInicio(NodeofTree inicio) {
        this.inicio = inicio;
    }

    public void pushfront(BinaryTree d) {
        NodeofTree nuevo = new NodeofTree(d);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }

    public void add(BinaryTree d) {
        NodeofTree nuevo = new NodeofTree(d);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            NodeofTree aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }

    //ayuda a crear bosque con los chars indicados
    public void minormax(BinaryTree d) {
        NodeofTree nuevo = new NodeofTree(d);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            NodeofTree aux = inicio;
            NodeofTree ant = null;
            while (aux != (null) && (aux.getData().getRoot().getFrecuencia() <= nuevo.getData().getRoot().getFrecuencia())) {
                ant = aux;
                aux = aux.getSiguiente();
            }
            if (ant == null) {
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
            } else if (aux == null) {
                ant.setSiguiente(nuevo);
            } else {
                ant.setSiguiente(nuevo);
                nuevo.setSiguiente(aux);
            }
        }
    }

}
