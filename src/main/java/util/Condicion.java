package util;

public class Condicion {

    Variables variable = new Variables();

    private String operador;

    private String iDvariable1;

    private String iDvariable2;
    private String valor1;

    private String valor2;

    public Condicion() {
    }

    public Condicion(String operador, String valor1, String valor2) {
        this.operador = operador;
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public Condicion(String operador, String valor1, String valor2, String iDvariable1, String iDvariable2) {
        this.operador = operador;
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.iDvariable1 = iDvariable1;
        this.iDvariable2 = iDvariable2;
    }

    public Condicion(String operador, String valor1, String valor2, String iDvariable1) {
        this.operador = operador;
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.iDvariable1 = iDvariable1;
    }

    public String getOperador() {
        return operador;
    }

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public String getiDvariable1() {
        return iDvariable1;
    }

    public String getValor2() {
        return valor2;
    }

    public Boolean evaluar(Condicion condicion){
        String operador = condicion.getOperador();
        String valor1 = condicion.getValor1();
        String valor2 = condicion.getValor2();

        System.out.println("Se evalua la condicion: "+valor1+" "+operador+" "+valor2);
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
