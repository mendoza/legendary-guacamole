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
        //A partir de aqui comienza la creacion de las listas
        for (int i = 0; i < operacion.length(); i++) {
            char aux = operacion.charAt(i);
            if(aux=='*'||aux=='/'||aux=='+'||aux=='-'){
                size++;
            }
        }
        System.out.println("El tamaño calculado de operaciones es: "+size);
        //Me estaba agarrando el size x2
        numeros = new ArrayList((size)+1);
        operandos = new ArrayList(size);
        int centinela = 1;
        String[] separador = operacion.split("\\+|\\-|\\*|\\/");
        for (int i = 0; i < separador.length; i++) {
            numeros.insert(Integer.parseInt(separador[i]), i+1);
            System.out.println("numeros "+separador[i]+" vuelta: "+ i);
            
        }
        for (int i = 0; i < operacion.length(); i++) {
            char aux = operacion.charAt(i);
            if(aux=='*'||aux=='/'||aux=='+'||aux=='-'){
                operandos.insert(aux, centinela);
                centinela++;
                System.out.println("operandos "+aux+" vuelta: "+ i);
            
            }
        }
        System.out.println("Size de numeros: "+numeros.getSize());
        System.out.println("Size de Operandos: "+operandos.getSize());
        operandos.printList();
        //fin de la creacion de las listas
        //A partir de aqui comienza la resolucion de problemas
        centinela = 1;
        int vuelta = 1;
        char searcher = '*';
        while(!operandos.isEmpty()){
            System.out.println("Centinela: " + centinela);
            char helper = (char)operandos.get(centinela);
            System.out.println("Helper: "+helper);
            if(helper == searcher){
                System.out.println("entro al if helper == searcher");
                int izquierda = (int)numeros.get(centinela);
                int derecha = (int)numeros.get(centinela+1);
                switch (searcher) {
                    case '*':
                        numeros.insert((izquierda*derecha), centinela);
                        numeros.erase(centinela+1);
                        break;
                    case '/':
                        numeros.insert((izquierda/derecha), centinela);
                        numeros.erase(centinela+1);
                        break;
                    case '+':
                        if((char)operandos.get(centinela-1)=='-'){
                            izquierda*=-1;
                        }
                        numeros.insert((izquierda+derecha), centinela);
                        numeros.erase(centinela+1);
                        break;
                    case '-':
                        if((char)operandos.get(centinela-1)=='-'){
                            izquierda*=-1;
                        }
                        numeros.insert((izquierda-derecha), centinela);
                        numeros.erase(centinela+1);
                        break;    
                    default:
                        throw new AssertionError();
                }
                operandos.erase(centinela);
                centinela--;
            }
            centinela++;
            if(centinela == operandos.getSize() || centinela<=0){
                System.out.println("Cumplio una vuelta");
                centinela = 1;
                if(vuelta == 1){
                    searcher = '/';
                }else if(vuelta == 2){
                    searcher = '+';
                }else if(vuelta == 3){
                    searcher = '-';
                }
                vuelta++;
            }
        }
        //fin de la resolucion de problemas
        System.out.println("El resultado es: "+numeros.get(0));
    }
    
}
