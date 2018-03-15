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
public class CalculadoraMat {
    private ArrayList numeros;
    private ArrayList operandos;
    
    CalculadoraMat(String operacion){
        int size = 0;
        for (int i = 0; i < operacion.length(); i++) {
            char aux = operacion.charAt(i);
            if(aux=='*'||aux=='/'||aux=='+'||aux=='-'){
                size++;
            }
        }
        numeros = new ArrayList(size+1);
        operandos = new ArrayList(size);
        int centinela = 0;
        String[] separador = operacion.split("\\+|\\-|\\*|\\/");
        for (int i = 0; i < separador.length; i++) {
            numeros.insert(Integer.parseInt(separador[i]), i);
        }
        for (int i = 0; i < operacion.length(); i++) {
            char aux = operacion.charAt(i);
            if(aux=='*'||aux=='/'||aux=='+'||aux=='-'){
                operandos.insert(aux, centinela);
                centinela++;
            }
        }
        centinela = 0;
        int vuelta = 1;
        char searcher = '*';
        while(!operandos.isEmpty()&& numeros.getSize()>1){
            if((char)operandos.get(centinela) == searcher){
                int izquierda = (int)numeros.get(centinela);
                int derecha = (int)numeros.get(centinela+1);
                switch (searcher) {
                    case '*':
                        numeros.insert((izquierda*derecha), centinela);
                        numeros.erase(centinela+1);
                        break;
                    case '/':
                        numeros.insert((izquierda*derecha), centinela);
                        numeros.erase(centinela+1);
                        break;
                    case '+':
                        numeros.insert((izquierda*derecha), centinela);
                        numeros.erase(centinela+1);
                        break;
                    case '-':
                        numeros.insert((izquierda*derecha), centinela);
                        numeros.erase(centinela+1);
                        break;    
                    default:
                        throw new AssertionError();
                }
            }
        }
    }
    
}
