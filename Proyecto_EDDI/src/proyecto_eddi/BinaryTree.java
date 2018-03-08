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

    public BinaryNode getRoot() {
        return Root;
    }

    public void setRoot(BinaryNode Root) {
        this.Root = Root;
    }
    
    //FALTAN TODOS LOS METODS ADMINISTRATIVOS, PARA PODER HACER LA COMPRECION DE HUFFMAN
}
