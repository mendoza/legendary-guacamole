/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

/**
 *
 * @author josue
 */
public class ArrayStack {

    int size, CAP;
    Object[] array;

    //David, hay que preguntar si ahuevos esta clase debe heredar o implementar de TDA
    ArrayStack() {
        size = -1;
        CAP = 1000;
        //no estoy seguro si debemos dejarlo en mil esto
        //Como podrás ver solo agarre el stack del ingeniero y lo implemente en java
        array = new Object[CAP];
        for (int i = 0; i < CAP; i++) {
            array[i] = null;
        }
    }

    boolean push(Object data) {
        if (size < CAP - 1) {
            size++;
            array[size] = data;
            return true;

        } else {
            return false;
        }
    }

    Object pop() {
        if (size >= 0) {
            Object data = array[size];
            array[size] = 0;
            size--;
            return data;
        } else {
            return null;
        }
    }

    Object top() {
        if (size >= 0) {
            return array[size];
        } else {
            return null;
        }
    }

    boolean isEmpty() {
        return size == -1;
    }

    void clear() {
        array = new Object[CAP];
        for (int i = 0; i < CAP; i++) {
            array[i] = null;
        }

    }

    void print() {
        for (int i = size; i >= 0; i--) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println();
    }

}
