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

    public void prepareFloyd() {
        if (graph.getNodeCount() > 0) {

            floyd = new double[graph.getNodeCount()][graph.getNodeCount()];
            for (int k = 0; k < graph.getNodeCount(); k++) {
                for (int i = 0; i < graph.getNodeCount(); i++) {
                    for (int j = 0; j < graph.getNodeCount(); j++) {
                        double dt = adyacentefloyd[i][k] + adyacentefloyd[k][j];
                        if (adyacentefloyd[i][j] > dt) {
                            adyacentefloyd[i][j] = dt;
                            floyd[i][j]=k;
                        }
                    }
                }
            }
            /*floyd = new double[graph.getNodeCount()][graph.getNodeCount()];
            for (int i = 0; i < floyd.length; i++) {
                for (int j = 0; j < floyd.length; j++) {
                    floyd[i][j] = 0;
                }

            }
            
            for (int k = 0; k < graph.getNodeCount(); k++) {
                for (int i = 0; i < graph.getNodeCount(); i++) {
                    for (int j = 0; j < graph.getNodeCount(); j++) {
                        if(adyacentefloyd[i][k]+adyacentefloyd[k][j] < adyacentefloyd[i][j]){
                            System.out.println("entro al if");
                            adyacentefloyd[i][j]= adyacentefloyd[i][k]+adyacentefloyd[k][j];
                            floyd[i][j] = k;
                        }
                    }
                }
            }*/

        }

    }
}
