package util;

public class Condicion {

    Variables variable = new Variables();

    public Condicion() {
    }

    public Boolean evaluar(String operador, String valor1, String valor2){
        Boolean resultado = false;
        switch(operador){
            case "==":
                if(variable.isNumeric(valor1) && variable.isNumeric(valor2)){
                    resultado = Double.parseDouble(valor1) == Double.parseDouble(valor2);
                }else{
                    resultado = valor1.equals(valor2);
                }
                break;
            case "!=":
                if(variable.isNumeric(valor1) && variable.isNumeric(valor2)){
                    resultado = Double.parseDouble(valor1) != Double.parseDouble(valor2);
                }else{
                    resultado = !valor1.equals(valor2);
                }
                break;
            case ">":
                resultado = variable.parseNumber(valor1) > variable.parseNumber(valor2);
                break;
            case "<":
                resultado = variable.parseNumber(valor1) < variable.parseNumber(valor2);
                break;
            case ">=":
                resultado = variable.parseNumber(valor1) >= variable.parseNumber(valor2);
                break;
            case "<=":
                resultado =variable.parseNumber(valor1) <= variable.parseNumber(valor2);
                break;
        }
        return resultado;
    }
}
