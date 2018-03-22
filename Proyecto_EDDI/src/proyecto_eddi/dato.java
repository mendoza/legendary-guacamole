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
public class dato {

    private char letra;
    private int frecuencia;

    public dato(){
        
    }
    
    public dato(char letra, int frecuencia) {
        this.letra = letra;
        this.frecuencia = frecuencia;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    @Override
    public String toString() {
        return "dato{" + "letra=" + letra + ", frecuencia=" + frecuencia + '}';
    }
}
