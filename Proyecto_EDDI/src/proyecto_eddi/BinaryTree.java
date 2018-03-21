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

    public void Erase() {
        this.Root = null;
    }

    public void Insert(Object data) {
        BinaryNode newnode = new BinaryNode(data);
        if (Root == null) {
            Root = newnode;
        } else {
            BinaryNode focus = Root;
            BinaryNode parent;
            while (true) {
                parent = focus;
                if ((int) data < (int) focus.getData()) {
                    focus = focus.getL();
                    if (focus == null) {
                        parent.setL(newnode);
                        return;
                    }
                } else {
                    focus = focus.getR();
                    if (focus == null) {
                        parent.setR(newnode);
                        return;
                    }
                }
            }
        }
    }

    public void print(BinaryNode node) {
        if (node != null) {
            print(node.getL());
            System.out.print(","+node.getData());
            print(node.getR());

        }
    }
}
