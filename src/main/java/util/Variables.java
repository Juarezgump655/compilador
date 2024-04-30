package util;


public class Variables {
    public String tipo;
    public String valor;
    public String nombre;

    public Variables(String tipo, String valor, String nombre) {
        this.tipo = tipo;
        this.valor = valor;
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
}
