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
public class Floyd extends Grafo {

    double[][] camino;
    public double[][] distancias;

    public Floyd() {

    }

    public void startFloyd() {
        if (graph.getNodeCount() > 0) {
            prepareFloyd();
            for (int k = 0; k < graph.getNodeCount(); k++) {
                for (int i = 0; i < graph.getNodeCount(); i++) {
                    for (int j = 0; j < graph.getNodeCount(); j++) {
                        /*if (i != j) {
                            if (distancias[i][j] == 0) {
                                distancias[i][j] = min(Double.POSITIVE_INFINITY, distancias[i][k] + distancias[k][j]);
                            } else {
                                distancias[i][j] = min(distancias[i][j], distancias[i][k] + distancias[k][j]);
                            }
                        }*/
                        double holi = distancias[i][k] + distancias[k][j];
                        if (holi < distancias[i][j]) {
                            distancias[i][j] = holi;
                            camino[i][j] = k;
                        }
                    }
                }
            }
            //System.out.println("");
            //System.out.println("");
            //printMatrix(camino);

        }

    }

    public double min(double a, double b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    public void prepareFloyd() {
        this.distancias = super.adyacente.clone();
        camino = new double[distancias.length][distancias.length];
        for (int i = 0; i < distancias.length; i++) {
            for (int j = 0; j < distancias.length; j++) {
                if (j != i) {
                    if (distancias[i][j] == 0) {
                        distancias[i][j] = Double.POSITIVE_INFINITY;
                    }
                    camino[i][j] = j;
                } else {
                    camino[i][j] = 0;
                }
            }
        }
        //System.out.println("Matriz distancias: ");
        //printMatrix(distancias);
        //System.out.println("Matriz caminos: ");
        //printMatrix(camino);

    }
    
    public void printMatrix(double[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print("["+matrix[i][j]+"]");
            }
            System.out.println();
        }
    }
}
