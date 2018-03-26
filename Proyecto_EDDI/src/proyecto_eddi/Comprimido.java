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
public class Comprimido implements Serializable {

    public long SerializableUID = 666L;
    private byte[] array;
    private LinkedList paths;

    public Comprimido() {
    }

    public Comprimido(byte[] array, LinkedList paths) {
        this.array = array;
        this.paths = paths;
    }

    public long getSerializableUID() {
        return SerializableUID;
    }

    public void setSerializableUID(long SerializableUID) {
        this.SerializableUID = SerializableUID;
    }

    public byte[] getArray() {
        return array;
    }

    public void setArray(byte[] array) {
        this.array = array;
    }

    public LinkedList getPaths() {
        return paths;
    }

    public void setPaths(LinkedList paths) {
        this.paths = paths;
    }

    public String descomprimir() {
        String reto = "";
        for (int i = 0; i < array.length; i++) {
            String ac = Integer.toBinaryString(array[i] & 0xFF);
            reto += ac;
        }
        return reto;
    }
}
