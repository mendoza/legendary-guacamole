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
public class Huffman {

    private String Texto;
    private ArrayList Forest;
    private String Resultado;

    public Huffman() {

    }

    public Huffman(String Texto) {
        this.Texto = Texto;
        this.Forest = new ArrayList();
        this.Resultado = "";
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public ArrayList getForest() {
        return Forest;
    }

    public void setForest(ArrayList Forest) {
        this.Forest = Forest;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }

    public void PlantaryTalar() {
        ArrayList chars = new ArrayList();
        ArrayList ints = new ArrayList();
        for (int i = 0; i < Texto.length(); i++) {
            if (!(chars.contains(Texto.charAt(i)))) {
                chars.add(Texto.charAt(i));
                ints.add(1);
            } else {
                ints.set(chars.indexOf(Texto.charAt(i)), ((int) ints.get(chars.indexOf(Texto.charAt(i))) + 1));
            }
        }

        //pasar a valores de verdad
        Object[] frecuencias = new Object[ints.length()];
        Object[] letras = new Object[chars.length()];
        for (int i = 0; i < chars.length(); i++) {
            letras[i] = chars.get(i);
            frecuencias[i] = ints.get(i);
        }

        int tempi = 0;
        char tempc;
        for (int i = 0; i < frecuencias.length; i++) {
            for (int j = 1; j < (frecuencias.length - i); j++) {        
                if (((int) frecuencias[j - 1]) > ((int) frecuencias[j])) {
                    tempi = (int) frecuencias[j - 1];
                    frecuencias[j - 1] = frecuencias[j];
                    frecuencias[j] = tempi;

                    tempc = (char) letras[j - 1];
                    letras[j - 1] = letras[j];
                    letras[j] = tempc;
                }

            }
        }
        chars.setList(letras);
        ints.setList(frecuencias);
        
        for (int i = 0; i < chars.length(); i++) {
            Forest.add(new BinaryTree(new dato(((char)chars.get(i)),((int)ints.get(i)))));
        }
        Object[] forest = Forest.getList();
        while(Forest.length() != 1){
            
        }
    }
}
