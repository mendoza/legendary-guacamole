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
public class TreeNode {

    private Empleado empleado;
    private ArrayList<TreeNode> hijos;

    public TreeNode(Empleado empleado) {
        this.empleado = empleado;
        this.hijos = new ArrayList();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public ArrayList<TreeNode> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<TreeNode> hijos) {
        this.hijos = hijos;
    }

}
