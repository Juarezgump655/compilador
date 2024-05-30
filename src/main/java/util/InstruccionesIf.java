package util;

import java.util.ArrayList;
import java.util.List;

public class InstruccionesIf {

    private List<Variables> variables = new ArrayList<>();
    private List<String> agregarConsola = new ArrayList<>();

    private List<Variables> variablesElse = new ArrayList<>();

    private List<String> agregarConsolaElse = new ArrayList<>();

    public InstruccionesIf(List<Variables> variables, List<String> agregarConsola) {
        this.variables = variables;
        this.agregarConsola = agregarConsola;
    }

    public InstruccionesIf(List<Variables> variables, List<String> agregarConsola, List<Variables> variablesElse, List<String> agregarConsolaElse) {
        this.variables = variables;
        this.agregarConsola = agregarConsola;
        this.variablesElse = variablesElse;
        this.agregarConsolaElse = agregarConsolaElse;
    }

    public InstruccionesIf() {

    }

    public List<Variables> getVariables() {
        return variables;
    }

    public void agregarVariable(Variables variable){
        this.variables.add(variable);
    }

    public List<String> getAgregarConsola() {
        return agregarConsola;
    }

    public void agregarConsola(String consola){
        this.agregarConsola.add(consola);
    }

    public List<Variables> getVariablesElse() {
        return variablesElse;
    }

    public List<String> getAgregarConsolaElse() {
        return agregarConsolaElse;
    }

    public void agregarVariableElse(Variables variable){
        this.variablesElse.add(variable);
    }

   public void setAgregarConsolaElse(String agregarConsolaElse) {
        this.agregarConsolaElse.add(agregarConsolaElse);
    }



    public void limpiarLista(){
        this.variables.clear();
        this.agregarConsola.clear();
        this.variablesElse.clear();
        this.agregarConsolaElse.clear();

    }
    public void limpiarListaElse(){
        this.variablesElse.clear();
        this.agregarConsolaElse.clear();
    }

    public void limpiarListaIf(){
        this.variables.clear();
        this.agregarConsola.clear();
    }




   public Boolean esVariable(Object variable){
        if(variable instanceof Variables){
            return true;
        }
        return false;
   }

}
