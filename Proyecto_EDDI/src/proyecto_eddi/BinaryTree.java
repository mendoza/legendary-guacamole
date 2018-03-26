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

<<<<<<< Updated upstream
    public void setRoot(BinaryNode Root) {
        this.Root = Root;
    }
//<<<<<<< Updated upstream
    
//=======

    //FALTAN TODOS LOS METODOS ADMINISTRATIVOS, PARA PODER HACER LA COMPRESION DE HUFFMAN
    /*public boolean Insert(Object data){
        boolean out;
        if (isEmpty(Root)) {
            
        } else if((int)data){
            
        }
    }*/
 /*public boolean isEmpty(BinaryNode bn){
        return (bn.getData() == null);
    }*/
    
    public void Create(Object data) {
        this.Root = new BinaryNode(data);

    }

///>>>>>>> Stashed changes
    public void Erase() {
        this.Root = null;
=======
    public void setRoot(BinaryNode raiz) {
        this.Root = raiz;
>>>>>>> Stashed changes
    }

    public void insertar(char letra, Integer d) {
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
