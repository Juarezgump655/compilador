package util;

public class Parametros {

    private final  String name;
    private final String tipo;

    public Parametros(String name, String tipo) {
        this.name = name;
        this.tipo = tipo;
    }

    public String getName() {
        return name;
    }

    public String getTipo() {
        return tipo;
    }
}
