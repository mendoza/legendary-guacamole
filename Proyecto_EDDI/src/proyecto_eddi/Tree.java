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
public class Tree {

    private TreeNode Root;

    public Tree() {
        this.Root = null;
    }

    public Tree(TreeNode Root) {
        this.Root = Root;
    }

    public TreeNode getRoot() {
        return Root;
    }

    public void setRoot(TreeNode Root) {
        this.Root = Root;
    }

    public void clear() {
        this.Root = null;
    }

    public TreeNode addChild(TreeNode child) {
        child.setParent(this.Root);
        this.Root.getChildren().add(child);
        return child;
    }

    public void addChildren(ArrayList<TreeNode> children) {
        for (int i = 0; i < children.length(); i++) {
            this.Root.getChildren().get(i).setParent(this.Root);
        }

        for (int i = 0; i < children.length(); i++) {
            this.Root.getChildren().add(children.get(i));
        }
    }

    public boolean isLeaf(TreeNode node) {
        return (node.getChildren().length() == 0);
    }

    public void printTree(TreeNode node, String appender) {
        System.out.println(appender + node.getData());
        for (int i = 0; i < this.Root.getChildren().length(); i++) {
            this.Root.getChildren().get(i).printTree(this.Root.getChildren().get(i), appender + appender);
        }
    }
}
