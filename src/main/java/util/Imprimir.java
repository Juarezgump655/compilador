package util;
import java.util.ArrayList;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("singleton")
public class Imprimir implements Instrucciones{


    private ArrayList<String> consola = new ArrayList<>();

    public static ArrayList<String>  listaImpri = new ArrayList<>();
    private static String mensaje;
    public  void imprimir() {

         for (String s : listaImpri) {
             System.out.println(s);
         }
    }

    @Override
    public void ejecutar() {
      imprimir();
      consola.clear();
      for (String s : listaImpri) {
          consola.add(s);
      }
    }

    public static String getMensaje() {
        return mensaje;
    }

    public static void setMensaje(String mensaje) {
        System.out.println("Mensaje: " + mensaje);
        Imprimir.mensaje = mensaje;
    }

    public ArrayList<String> getConsola() {
        return consola;
    }



}
