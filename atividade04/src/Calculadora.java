
public class Calculadora {

    public static double calcularDesconto(Funcionario funcionario) {
        double salario = funcionario.getSalarioBase();
        switch (funcionario.getCargo()) {
            case GERENTE:
                /**
                 * Caso o cargo seja GERENTE, o funcionário terá desconto de 30%
                 * caso o salário seja maior ou igual que 5.000,00, ou apenas
                 * 20% caso o salário seja menor que isso.
                 */
                if (salario >= 5000) {
                    return salario * 0.3;
                } else {
                    return salario * 0.2;
                }
            case DESENVOLVEDOR:
                /**
                 * Caso o cargo seja DESENVOLVEDOR, o funcionário terá desconto
                 * de 20% caso o salário seja maior ou igual que 3.000,00, ou
                 * apenas 10% caso o salário seja menor que isso.
                 */
                if (salario >= 3000) {
                    return salario * 0.2;
                } else {
                    return salario * 0.1;
                }
            case DBA:
            case TESTADOR:
                /**
                 * Caso o cargo seja DBA, o funcionário terá desconto de 25%
                 * caso o salário seja maior ou igual que 2.000,00, ou apenas
                 * 15% caso o salário seja menor que isso.
                 */

                /**
                 * Caso o cargo seja TESTADOR, o funcionário terá desconto de
                 * 25% caso o salário seja maior ou igual que 2.000,00, ou
                 * apenas 15% caso o salário seja menor que isso.
                 */
                if (salario >= 2000) {
                    return salario * 0.25;
                } else {
                    return salario * 0.15;
                }
            default:
                return 0;
        }
    }
}
