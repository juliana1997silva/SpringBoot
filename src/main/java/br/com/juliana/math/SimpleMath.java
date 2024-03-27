package br.com.juliana.math;

public class SimpleMath {

    // CALCULO SOMA
    public Double sum(Double numberOne, Double numberTwo) {

        return numberOne + numberTwo;
    }

    // CALCULO SUBTRAÇÃO
    public Double subtraction(Double numberOne, Double numberTwo) {

        return numberOne - numberTwo;
    }

    // CALCULO MULTIPLICAÇÃO
    public Double multiplication(Double numberOne, Double numberTwo) {

        return numberOne * numberTwo;
    }

    // CALCULO DIVISÃO
    public Double division(Double numberOne, Double numberTwo) {

        return numberOne / numberTwo;
    }

    // CALCULO MÉDIA
    public Double medium(Double numberOne, Double numberTwo) {

        return (numberOne + numberTwo) / 2;
    }

    // CALCULO RAIZ QUADRADA
    public Double SquareRoot(Double numberOne) {
        // math.sqrt => faz o calculo da raiz quadrada do numero que esta recebendo
        return Math.sqrt((numberOne));
    }

}
