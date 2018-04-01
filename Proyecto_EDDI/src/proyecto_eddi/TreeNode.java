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

    public void CalificarNodo(TreeNode node) {
        if (!node.isLeaf(node)) {
            for (int i = 0; i < this.children.length(); i++) {
                this.children.get(i).CalificarNodo(this.children.get(i));
            }
            node.getData().setCalificacion(node.CalificarHijos(node, 0) / node.getChildren().length());
        }

    }

    public boolean isLeaf(TreeNode node) {
        return (node.getChildren().length() == 0);
    }

    public float CalificarHijos(TreeNode node, float num) {
        if (node.isLeaf(node)) {
            return node.getData().getCalificacion();
        } else {
            for (int i = 0; i < node.getChildren().length(); i++) {
                num += node.getChildren().get(i).CalificarHijos(node.getChildren().get(i), 0);
                node.getData().setCalificacion(num);
            }
        }
        return node.getData().getCalificacion();
    }
}
