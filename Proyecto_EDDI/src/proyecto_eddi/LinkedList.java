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
public class LinkedList {

    private LinkedNode inicio;

    public LinkedList() {
        this.setInicio(null);
    }

    public LinkedNode getInicio() {
        return inicio;
    }

    public void setInicio(LinkedNode inicio) {
        this.inicio = inicio;
    }

    public void pushfront(char d) {
        LinkedNode nuevo = new LinkedNode(d);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }

    public void add(char d) {
        LinkedNode nuevo = new LinkedNode(d);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            LinkedNode aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }

    public int removechar(char valor) {
        int contador = 0;
        if (inicio != null) {
            LinkedNode aux = inicio;
            LinkedNode ant = null;
            while (aux != null) {
                if (aux.getData() == valor) {
                    if (ant == null) {
                        inicio = inicio.getSiguiente();
                        aux.setSiguiente(null);
                        aux = inicio;
                    } else {
                        ant.setSiguiente(aux.getSiguiente());
                        aux.setSiguiente(null);
                        aux = ant.getSiguiente();
                    }
                    contador++;
                } else {
                    ant = aux;
                    aux = aux.getSiguiente();
                }
            }
        }
        return contador;
    }

    public void pushfront(char letra, String camino) {
        LinkedNode nuevo = new LinkedNode(letra, camino);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }

    public void add(char letra, String camino) {
        LinkedNode nuevo = new LinkedNode(letra, camino);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            LinkedNode aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }

}
