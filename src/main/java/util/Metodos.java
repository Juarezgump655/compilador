package util;

import java.util.LinkedList;

public class Metodos {

    private String nombre;
    private String retorno;

    private LinkedList<Parametros> parametros;


    public Metodos(String nombre, String retorno, LinkedList<Parametros> parametros) {
        this.nombre = nombre;
        this.retorno = retorno;
        this.parametros = parametros;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRetorno() {
        return retorno;
    }

    public LinkedList<Parametros> getParametros() {
        return parametros;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public void setParametros(LinkedList<Parametros> parametros) {
        this.parametros = parametros;
    }

}
