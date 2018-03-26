/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

/**
 *
 * @author Josue
 * @better author David :v
 * @param <T>
 */
public class ArrayList<T> {

    private Object[] list;
    private int availpos;

    ArrayList() {
        this.availpos = 0;
        this.list = new Object[1483400];
    }

    public int length() {
        return availpos;
    }

    public Object[] getList() {
        return list;
    }

    public void setList(Object[] list) {
        this.list = list;
    }

    public int indexOf(T obj) {
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

    public boolean set(int pos, T obj) {
        if (pos >= 0 && pos <= availpos) {
            list[pos] = obj;
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(T obj) {
        for (int i = 0; i < availpos; i++) {
            if (obj == list[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean insert(int pos,T obj) {
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

    public boolean add(T obj) {
        list[availpos] = obj;
        availpos++;
        return true;
    }

    public T get(int pos) {
        if (pos >= 0 && pos < availpos) {
            return ((T) list[pos]);
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
        return availpos == 0;
    }

    @Override
    public String toString() {
        String reto ="";
        reto+="[";
        for (int i = 0; i < availpos; i++) {
            if (i == 0) {
                reto+=("" + list[i]);
            } else {
                reto+=("," + list[i]);
            }
        }
        reto+="]";
        return reto;
    }
}
