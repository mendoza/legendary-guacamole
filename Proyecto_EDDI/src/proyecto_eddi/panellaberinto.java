/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_eddi;

/**
 *
 * @author david
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class panellaberinto extends JPanel {

    public int[][] matriz;
    public int x;
    public int y;
    public int reso;
    public Random rando = new Random();

    public panellaberinto(int x, int y, int reso) {
        this.x = x;
        this.y = y;
        this.reso = reso;
        this.matriz = new int[x / reso][y / reso];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i==0 || i == matriz.length-1 || j == 0 || j == matriz[0].length-1) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = rando.nextInt(2);

                }
            }
            
        }
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                Color c;
                if (matriz[i][j] == 1) {
                    c = Color.white;
                } else {
                    c = Color.BLACK;
                }
                g.setColor(c);
                g.fillRect(i * reso, j * reso, reso - 1, reso - 1);
            }
        }
    }

}
