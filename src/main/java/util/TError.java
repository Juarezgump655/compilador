package util;

public class TError {
    String lexema,tipo,descripcion;
    int linea,columna;

    public TError(String le, int li, int co, String t,String de){
        lexema = le;
        linea = li;
        columna = co;
        tipo = t;
        descripcion = de;
    }

    @Override
    public String toString() {
        return "Error: "+tipo+" en la linea "+linea+" y columna "+columna+" en el simbolo "+lexema+", "+descripcion;
    }
}
