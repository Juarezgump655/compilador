package util;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
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


    public String buscarYActualizarVariable(ArrayList<Variables> variables , String id, String nuevoValor) {
        for (Variables variable : variables) {
            if (variable.getNombre().equals(id)) { // Suponiendo que getId() devuelve el id de la variable
                variable.setValor(nuevoValor); // Suponiendo que setValor() permite actualizar el valor de la variable
                System.out.println("Se actualizó la variable con el id " + id + " con el valor " + nuevoValor );
                return variable.getValor(); // Salir del método después de encontrar y actualizar la variable
            }
        }
        throw new IllegalArgumentException("La variable con el id " + id + " no existe en la lista");
    }

    @Override
    public String toString() {
        return "Variables{" +
                "tipo='" + tipo + '\'' +
                ", valor='" + valor + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public String operar(String operacion) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object resultado = engine.eval(operacion);
        System.out.println("Resultado: "+resultado);
        return resultado.toString();
    }

}
