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
public class ArrayList {
    private int size;
    private Object[] list;
    
    ArrayList(){
        this.size = -1;
        this.list = new Object[1000];
    }
    
    ArrayList(int largo){
        this.size = largo;
        this.list = new Object[largo];
    }

    public boolean insert(Object ob, int p) {
        if (p - 1 < list.length && p - 1 >= 0) {
            list[p - 1] = ob;
            size++;
            return true;
        } else {
            return false;
        }
    }

    public Object get(int p) {
        if (p - 1 < list.length && p - 1 >= 0) {
            return list[p - 1];
        } else {
            return null;
        }
    }

    public void erase(int p) {
        if (p - 1 < list.length && p - 1 >= 0) {
            list[p - 1] = null;
            for (int i = p; i < size; i++) {
                if (i != size) {
                    list[i - 1] = list[i];
                    list[i] = null;
                }
            }
            size--;
        }
    }

    public int find(Object object) {
        for (int i = 0; i < size; i++) {
            if (object == list[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    public Object nextTo(int p) {
        if (p + 1 < size || p + 1 >= 0) {
            return null;
        } else {
            return list[p + 1];
        }
    }

    public Object backTo(int p) {
        if (p - 1 > size || p - 1 < 0) {
            return null;
        } else {
            return list[p - 1];
        }
    }

    public void clear() {
        list = new Object[1000];
        this.size = -1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getSize(){
        return this.size;
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + " " + list[i]);
        }
    }
}
