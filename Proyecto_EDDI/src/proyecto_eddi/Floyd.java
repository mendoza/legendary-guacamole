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

    double[][] floyd;

    public Floyd() {

    }
    
    public void startFloyd() {
        if (graph.getNodeCount() > 0) {
            for (int k = 0; k < graph.getNodeCount(); k++) {
                for (int i = 0; i < graph.getNodeCount(); i++) {
                    for (int j = 0; j < graph.getNodeCount(); j++) {
                        if (i != j) {
                            if (adyacentefloyd[i][j] == 0) {
                                adyacentefloyd[i][j] = min(Double.POSITIVE_INFINITY, adyacentefloyd[i][k] + adyacentefloyd[k][j]);
                            } else {
                                adyacentefloyd[i][j] = min(adyacentefloyd[i][j], adyacentefloyd[i][k] + adyacentefloyd[k][j]);
                            }
                        }

                        //System.out.println("ij: " + adyacentefloyd[i][j]);
                        //System.out.println("ik: " + adyacentefloyd[i][k]);
                        //System.out.println("kj: " + adyacentefloyd[k][j]);
                        
                        //System.out.println("ij: " + adyacentefloyd[i][j]);
                    }
                }
            }

        }

    }

    public double min(double a, double b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }
}
