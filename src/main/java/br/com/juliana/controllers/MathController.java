package br.com.juliana.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.juliana.converters.NumberConverter;
import br.com.juliana.exceptions.ResourceNotFoundException;
import br.com.juliana.math.SimpleMath;

@RestController //IDENTIFICA QUE ESSE CONTROLLER É UMA REST API
public class MathController {

    private SimpleMath math = new SimpleMath();

    //CALCULO SOMA
	 @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Por favor, insira um valor numerico");
        
        }
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
    }

    //CALCULO SUBTRAÇÃO
    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Por favor, insira um valor numerico");
        
        }
        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
    }

    //CALCULO MULTIPLICAÇÃO
    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Por favor, insira um valor numerico");
        
        }
        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
    }

    //CALCULO DIVISÃO
    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Por favor, insira um valor numerico");
        
        }
        return math.division(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    //CALCULO MÉDIA
    @GetMapping("/medium/{numberOne}/{numberTwo}")
    public Double medium(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("Por favor, insira um valor numerico");
        
        }
        return math.medium(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    //CALCULO RAIZ QUADRADA
    @GetMapping("/squareroot/{numberOne}")
    public Double SquareRoot(
        @PathVariable(value = "numberOne") String numberOne
    ) {
        if(!NumberConverter.isNumeric(numberOne)) {
            throw new ResourceNotFoundException("Por favor, insira um valor numerico");
        
        }
        //math.sqrt => faz o calculo da raiz quadrada do numero que esta recebendo
        return math.SquareRoot(NumberConverter.convertToDouble(numberOne));
    }

    

    
}
