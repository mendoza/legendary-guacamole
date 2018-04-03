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

    private Empleado data = null;
    private final ArrayList<TreeNode> children = new ArrayList<>();
    private TreeNode parent = null;

    public TreeNode(Empleado data) {
        this.data = data;
    }

    TreeNode() {

    }

    public TreeNode addChild(TreeNode child) {
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    public void addChildren(ArrayList<TreeNode> children) {
        for (int i = 0; i < children.length(); i++) {
            this.children.get(i).setParent(this);
        }

        for (int i = 0; i < children.length(); i++) {
            this.children.add(children.get(i));
        }
    }

    public ArrayList<TreeNode> getChildren() {
        return children;
    }

    public Empleado getData() {
        return data;
    }

    public void setData(Empleado data) {
        this.data = data;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void printTree(TreeNode node, String appender) {
        System.out.println(appender + node.getData());
        for (int i = 0; i < this.children.length(); i++) {
            this.children.get(i).printTree(this.children.get(i), appender + appender);
        }
    }

    public void CalificarNodo() {
        if (!this.isLeaf()) {
            for (int i = 0; i < this.children.length(); i++) {
                this.children.get(i).CalificarNodo();
            }
            this.getData().setCalificacion(this.CalificarHijos(0) / this.getChildren().length());
        }

    }

    public boolean isLeaf() {
        return (this.getChildren().length() == 0);
    }

    public float CalificarHijos(float num) {
        if (this.isLeaf()) {
            return this.getData().getCalificacion();
        } else {
            for (int i = 0; i < this.getChildren().length(); i++) {
                num += this.getChildren().get(i).CalificarHijos(0);
                this.getData().setCalificacion(num);
            }
        }
        return this.getData().getCalificacion();
    }
}
