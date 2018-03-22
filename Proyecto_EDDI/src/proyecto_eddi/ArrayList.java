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

    private Object[] list;
    private int availpos;

    ArrayList() {
        this.availpos = 0;
        this.list = new Object[1483400];
    }
    
    public int length(){
        return availpos;
    }

    public Object[] getList() {
        return list;
    }

    public void setList(Object[] list) {
        this.list = list;
    }
    
    public int indexOf(Object obj) {
        int pos = 0;
        for (int i = 0; i < availpos; i++) {
            if (obj == list[i]) {
                pos = i;
                return pos;
            } else {
                pos = -1;
            }
        }
        return pos;
    }

    public boolean set(int pos, Object obj) {
        if (pos >= 0 && pos <= availpos) {
            list[pos] = obj;
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(Object obj) {
        for (int i = 0; i < availpos; i++) {
            if (obj == list[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean insert(Object obj, int pos) {
        if (pos >= 0 && pos <= availpos) {
            if (pos == availpos) {
                list[pos] = obj;
                availpos += 1;
            } else {
                for (int i = availpos; i > pos; i--) {
                    list[i] = list[i - 1];
                    list[pos] = obj;
                    availpos += 1;
                }
            }
            return true;
        }
        return false;
    }

    public boolean add(Object obj) {
        list[availpos] = obj;
        availpos++;
        return true;
    }

    public Object get(int pos) {
        if (pos >= 0 && pos < availpos) {
            return list[pos];
        } else {
            return null;
        }
    }

    public void remove(int pos) {
        if (pos >= 0 && pos < availpos) {
            for (int i = pos; i < availpos - 1; i++) {
                list[i] = list[i + 1];
            }
            list[availpos - 1] = null;
            availpos--;
        }
    }

    public void clear() {
        list = new Object[1483400];
        this.availpos = 0;
    }

    public boolean isEmpty() {
        if (availpos == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printList() {
        System.out.print("[");
        for (int i = 0; i < availpos; i++) {
            if (i == 0) {
                System.out.print(""+list[i]);
            } else {
                System.out.print("," + list[i]);
            }
        }
        System.out.print("]");
    }
}
