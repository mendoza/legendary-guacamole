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
public class CasillaLaberinto {
    private int i, j;
    
    CasillaLaberinto(){
        
    }
    
    CasillaLaberinto(int a, int b){
        this.i=a;
        this.j=b;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
    
     public CasillaLaberinto Arriba() {
        return new CasillaLaberinto(i - 1, j);
    }

    public CasillaLaberinto Abajo() {
        return new CasillaLaberinto(i + 1, j);
    }

    public CasillaLaberinto Derecha() {
        return new CasillaLaberinto(i, j + 1);
    }

    public CasillaLaberinto Izquierda() {
        return new CasillaLaberinto(i, j - 1);
}
    
    
}
