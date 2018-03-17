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

    private ArrayList numeros = new ArrayList();
    private ArrayList operandos = new ArrayList();

    CalculadoraMat() {

    }

    public int Resolver(String formula) {
        String[] nums = formula.split("\\+|\\-|\\/|\\*");
        int[] num = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            num[i] = Integer.parseInt(nums[i]);
        }

        for (int i = 0; i < num.length; i++) {
            numeros.add(num[i]);
        }
        for (int i = 0; i < formula.length(); i++) {
            switch (formula.charAt(i)) {
                case '+':
                    operandos.add(formula.charAt(i));
                    break;
                case '-':
                    operandos.add(formula.charAt(i));

                    break;
                case '/':
                    operandos.add(formula.charAt(i));
                    break;
                case '*':
                    operandos.add(formula.charAt(i));
                    break;
                default:
                    break;
            }
        }
        while (operandos.contains('*')) {
            numeros.set(operandos.indexOf('*'), ((int) numeros.get(operandos.indexOf('*'))) * ((int) numeros.get(operandos.indexOf('*') + 1)));
            numeros.remove(operandos.indexOf('*') + 1);
            operandos.remove(operandos.indexOf('*'));
        }
        while (operandos.contains('/')) {
            numeros.set(operandos.indexOf('/'), ((int) numeros.get(operandos.indexOf('/'))) / ((int) numeros.get(operandos.indexOf('/') + 1)));
            numeros.remove(operandos.indexOf('/') + 1);
            operandos.remove(operandos.indexOf('/'));
        }
        while (operandos.contains('-')) {
            numeros.set(operandos.indexOf('-'), ((int) numeros.get(operandos.indexOf('-'))) - ((int) numeros.get(operandos.indexOf('-') + 1)));
            numeros.remove(operandos.indexOf('-') + 1);
            operandos.remove(operandos.indexOf('-'));
        }
        while (operandos.contains('+')) {
            numeros.set(operandos.indexOf('+'), ((int) numeros.get(operandos.indexOf('+'))) + ((int) numeros.get(operandos.indexOf('+') + 1)));
            numeros.remove(operandos.indexOf('+') + 1);
            operandos.remove(operandos.indexOf('+'));
        }
        return (int) (numeros.get(0));
    }

}
