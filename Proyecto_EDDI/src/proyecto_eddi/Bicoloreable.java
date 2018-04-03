/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author josue
 */
public class Bicoloreable extends Grafo {

    int color = 1;
    
    public Bicoloreable() {
        
    }

    public ArrayList<Node> findNeighbours(Node origen) {
        int k = -1;
        ArrayList<Node> neighbours = new ArrayList<>();
        for (int i = 0; i < graph.getNodeCount(); i++) {
            if (graph.getNode(i).equals(origen)) {
                k = i;
            }
        }
        if (k != -1) {
            for (int j = 0; j < adyacente[k].length; j++) {
                if (adyacente[k][j] != 0 && adyacente[k][j] != Double.POSITIVE_INFINITY) {
                    neighbours.add(graph.getNode(j));
                }
            }
        }
        return neighbours;
    }

    public String getNeighbours() {
        ArrayList<Node> temporal;
        String retorno = "";
        for (int i = 0; i < graph.getNodeCount(); i++) {
            Node n = graph.getNode(i);
            temporal = findNeighbours(n);
            int pos = i + 1;
            retorno += pos + ") " + n.getId() + ":" + temporal.toString() + "\n";
        }
        return retorno;
    }

    public void prepareDFS() {
        for (Node node : graph) {
            node.addAttribute("Visited", false);
            graph.addAttribute("ui.quality");
            graph.addAttribute("ui.antialias");
            graph.addAttribute("ui.stylesheet",
                    "node { fill-color: grey;}");
        }
        
    }

    public int startDFS(int origen) {
        if (origen >= 0 && origen < graph.getNodeCount()) {
            DFS(graph.getNode(origen));
            boolean es = Coloreable();
            if (es) {
                JOptionPane.showMessageDialog(null, "Es coloreable", "¿Es coloreable?", JOptionPane.INFORMATION_MESSAGE);
                Viewer viewer = showGraph();
                viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "No es coloreable", "¿Es coloreable?", JOptionPane.INFORMATION_MESSAGE);
                Viewer viewer = showGraph();
                viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
                return 2;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Origen no valido", "Error", JOptionPane.ERROR_MESSAGE);
            return 3;
        }
    }

    public void DFS(Node nodoOrigen) {
        if (color == 1) {
            nodoOrigen.setAttribute("ui.style", "fill-color: rgb(50,205,50);");
            color = 2;
        } else {
            nodoOrigen.setAttribute("ui.style", "fill-color: rgb(75,0,130);");
            color = 1;
        }
        ArrayList<Node> neighbours = findNeighbours(nodoOrigen);
        nodoOrigen.setAttribute("Visited", true);
        for (Node m : neighbours) {
            boolean vis = (boolean) m.getAttribute("Visited");
            //System.out.println(vis);
            if (m != null && vis == false) {
                DFS(m);
            }
        }

    }

    public boolean Coloreable() {
        boolean coloreable = true;
        for (Node node : graph) {
            ArrayList<Node> neighbours = findNeighbours(node);
            for (Node m : neighbours) {
                if (node.getAttribute("ui.style") == m.getAttribute("ui.style")) {
                    coloreable = false;
                }
            }
        }
        return coloreable;
    }

    public Viewer showOriginal() {
        reset();
        return graph.display();
    }
    
    public void reset(){
        color = 1;
        for (Node node : graph) {
            node.setAttribute("Visited",false);
            node.setAttribute("ui.style", "fill-color: grey;");
        }
        
    }

}
