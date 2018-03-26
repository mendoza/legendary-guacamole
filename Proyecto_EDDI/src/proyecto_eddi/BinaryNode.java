/*
 * To change this license heaR, choose License HeaRs in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

/**
 *
 * @author david
 */
public class BinaryNode {

    private int frecuencia;
    private char letra;
    private BinaryNode L;
    private BinaryNode R;

    public BinaryNode(char letra, int frecuencia) {
        this.letra = letra;
        this.frecuencia = frecuencia;
        L = null;
        R = null;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int dato) {
        this.frecuencia = dato;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public BinaryNode getL() {
        return L;
    }

    public void setL(BinaryNode L) {
        this.L = L;
    }

    public BinaryNode getR() {
        return R;
    }

    public void setR(BinaryNode R) {
        this.R = R;
    }

    @Override
    public String toString() {
        return letra + ":" + frecuencia;
    }

}
