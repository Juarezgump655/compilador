package util;


import java.util.ArrayList;

public class Variables {
    public String tipo;
    public String valor;
    public String nombre;

    public Variables(String tipo, String valor, String nombre) {
        this.tipo = tipo;
        this.valor = valor;
        this.nombre = nombre;
    }

    public Variables() {
    }


    public Variables(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static Float parseNumber(String stringValue) {
        try {
            // Intenta convertir el String a un número entero
            return Float.parseFloat(stringValue);
        } catch (NumberFormatException e) {
            // Si no se puede convertir a entero, entonces es un número flotante
            return null;
        }
    }

    public Boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Float d = Float.parseFloat(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static String obtenerValorVaiable( String nombre, ArrayList<Variables> variables ){
        for (Variables variable : variables) {
            if (variable.getNombre().equals(nombre)){
                System.out.println("Variable encontrada: " + variable.getNombre() + " con valor: " + variable.getValor());
                return variable.getValor();
            }
        }
        return null;
    }
}
