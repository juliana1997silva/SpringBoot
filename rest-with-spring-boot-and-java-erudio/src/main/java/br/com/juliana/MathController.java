package br.com.juliana;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController //IDENTIFICA QUE ESSE CONTROLLER É UMA REST API
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    
    //AULA STEP 06
	 @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new IllegalArgumentException();
        
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    

    //CONVERTE STRING EM NUMERICO
    private Double convertToDouble(String strNumber) {
        //verifica se o valor recebido esta nullo
        if(strNumber == null) return 0D;

        //se for recebido "," ser substituido por "."
        String number = strNumber.replaceAll(",", ".");
        
        //verifico se number é numerico
        if(isNumeric(number)) return Double.parseDouble(number);

        return 0D;
    }

    //VERIFICA SE É NUMERICO
    private boolean isNumeric(String strNumber) {
        //verifica se o valor recebido esta nullo
        if(strNumber == null) return false;
        //se for recebido "," ser substituido por "."
        String number = strNumber.replaceAll(",", ".");
        //regex para validar se é numero
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
