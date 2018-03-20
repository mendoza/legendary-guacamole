
import proyecto_eddi.BinaryTree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author josue
 */
public class idk {

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        for (int i = 0; i < 100; i++) {
            t.Insert(i);
        }

        t.print(t.getRoot());
    }
}
