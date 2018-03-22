/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

import java.io.Serializable;

/**
 *
 * @author david
 */
public class Compresion implements Serializable{
    private final long serializableUID = 666l;
    private String mensaje;
    private BinaryTree arbol;

    public Compresion(String mensaje, BinaryTree arbol) {
        this.mensaje = mensaje;
        this.arbol = arbol;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public BinaryTree getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree arbol) {
        this.arbol = arbol;
    }
}
