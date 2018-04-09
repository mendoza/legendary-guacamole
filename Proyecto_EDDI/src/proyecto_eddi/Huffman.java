/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

import javax.swing.ProgressMonitor;

/**
 *
 * @author david
 */
public class Huffman {

    private String mensaje;
    private String resultado;
    private LinkedList Listacamino;

    public Huffman(String msg) {
        mensaje = msg;
        Listacamino = new LinkedList();
        resultado = "";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LinkedList toNodes() {
        LinkedList l = new LinkedList();
        for (int i = 0; i < mensaje.length(); i++) {
            l.add((mensaje.charAt(i)));
        }
        return l;

    }

    public ListofTrees cuentaLetras(LinkedList l) {
        ListofTrees la = new ListofTrees();
        LinkedNode aux = l.getInicio();
        while (aux != null) {
            Integer x = l.removechar(aux.getData());
            BinaryNode nuevo = new BinaryNode(aux.getData(), x);
            BinaryTree a = new BinaryTree(nuevo);
            la.minormax(a);
            aux = l.getInicio();
        }
        return la;
    }

    public BinaryNode unir(NodeofTree a, NodeofTree b) {
        BinaryNode c = new BinaryNode('\u0000', ((a.getData().getRoot().getFrecuencia()) + (b.getData().getRoot().getFrecuencia())));
        c.setL(a.getData().getRoot());
        c.setR(b.getData().getRoot());
        return c;
    }

    public ListofTrees juntaNodo(ListofTrees l) {
        NodeofTree temp = l.getInicio();
        NodeofTree temp2;
        while ((temp != null) && (temp.getSiguiente() != null)) {
            l.setInicio(temp.getSiguiente());
            temp.setSiguiente(null);
            temp2 = l.getInicio();
            l.setInicio(temp2.getSiguiente());
            temp2.setSiguiente(null);
            BinaryNode nuevo = unir(temp, temp2);
            BinaryTree a = new BinaryTree(nuevo);
            l.minormax(a);
            temp = l.getInicio();
        }
        return l;
    }

    public String deletelast(String re) {
        String cadena = "";
        for (int i = 0; i < re.length() - 1; i++) {
            cadena += re.charAt(i);
        }
        return cadena;
    }

    public void pathfinder(BinaryNode r, String c) {
        resultado += c;
        if (r != null) {
            if (r.getLetra() != '\u0000') {
                Listacamino.add(r.getLetra(), resultado);
            }
            pathfinder(r.getL(), "0");
            if (r.getL() != null) {
                resultado = deletelast(resultado);
            }
            pathfinder(r.getR(), "1");
            if (r.getR() != null) {
                resultado = deletelast(resultado);
            }
        } else {
            resultado = deletelast(resultado);
        }
    }

    public LinkedList getPaths() {
        return Listacamino;
    }

    public String busca(char s, LinkedList l) {
        String camino = "";
        LinkedNode aux = l.getInicio();
        while (aux != null) {
            if (aux.getData() == s) {
                camino = aux.getPath();
            }
            aux = aux.getSiguiente();
        }
        return camino;
        //revisar esto al momento de descomprimir con la suficiente fumada puede servir :v
    }

    public String comprimir() {
        LinkedList listofchars = this.toNodes();
        ListofTrees listoftrees = this.cuentaLetras(listofchars);
        ListofTrees listoftrees2 = this.juntaNodo(listoftrees);
        this.pathfinder(listoftrees2.getInicio().getData().getRoot(), "");
        LinkedList camino = this.getPaths();
        String c = "";
        for (int i = 0; i < mensaje.length(); i++) {
            c += busca(mensaje.charAt(i), camino);
        }
        return c;
    }
}
