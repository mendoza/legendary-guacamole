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
public class BinaryNode {

    private BinaryNode L;
    private Object Data;
    private BinaryNode R;
    
    public BinaryNode(){
    
    }

    public BinaryNode(Object Data) {
        this.Data = Data;
    }

    public BinaryNode getL() {
        return L;
    }

    public void setL(BinaryNode L) {
        this.L = L;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object Data) {
        this.Data = Data;
    }

    public BinaryNode getR() {
        return R;
    }

    public void setR(BinaryNode R) {
        this.R = R;
    }

    @Override
    public String toString() {
        return ((String) Data);
    }
    
    
    
    

}
