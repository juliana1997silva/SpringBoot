package br.com.juliana.converters;

public class NumberConverter {
//CONVERTE STRING EM NUMERICO
public static Double convertToDouble(String strNumber) {
    //verifica se o valor recebido esta nullo
    if(strNumber == null) return 0D;

    //se for recebido "," ser substituido por "."
    String number = strNumber.replaceAll(",", ".");
    
    //verifico se number é numerico
    if(isNumeric(number)) return Double.parseDouble(number);

    return 0D;
}

//VERIFICA SE É NUMERICO
public static boolean isNumeric(String strNumber) {
    //verifica se o valor recebido esta nullo
    if(strNumber == null) return false;
    //se for recebido "," ser substituido por "."
    String number = strNumber.replaceAll(",", ".");
    //regex para validar se é numero
    return number.matches("[-+]?[0-9]*\\.?[0-9]+");
}
}
