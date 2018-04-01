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
class Empleado {

    private String Nombre;
    private String Posicion;
    private float Calificacion;

    public Empleado() {
    }

    public Empleado(float calificacion, String nombre, String posicion) {
        this.Calificacion = calificacion;
        this.Nombre = nombre;
        this.Posicion = posicion;
    }

    public float getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(float Calificacion) {
        this.Calificacion = Calificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPosicion() {
        return Posicion;
    }

    public void setPosicion(String Posicion) {
        this.Posicion = Posicion;
    }

    @Override
    public String toString() {
        return this.Nombre+" " +this.Posicion+" "+'('+this.Calificacion+')';
    }
    
}
