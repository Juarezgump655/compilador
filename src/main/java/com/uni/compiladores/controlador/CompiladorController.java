package com.uni.compiladores.controlador;

import com.uni.compiladores.CompiladoresApplication;
import mi.primer.scanner.Scanner;
import mi.primer.scanner.parser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/compilador")
public class CompiladorController {

    ArrayList<String> consola = new ArrayList<String>();

    @PostMapping(value = "/traducir")
    public ArrayList<String> traducir(@RequestParam("txtMini") String txtMini) {
        try {
            if(txtMini == null || txtMini.isEmpty()){
                consola.add("No se ha ingresado texto");
                return consola;
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("prueba.txt"));
            writer.write(txtMini);
            writer.close();
            return compilarCup();
        } catch (IOException e) {
            e.printStackTrace();
            consola.add("Error al escribir el archivo");
            return consola;
        }
    }

    public ArrayList<String> compilarCup() {
        consola.clear();
        try {
            Reader reader = new FileReader("prueba.txt");
            Scanner scanner = new Scanner(reader);
            parser p = new parser(scanner);
            p.limpiarConsola();
            scanner.limpiarTablaEL();
            p.parse();

             consola = new ArrayList<String>(p.consola);
            ArrayList<String> consolaLexica = new ArrayList<String>(scanner.getTablaEL());
            System.out.println("RESULTADO CONSOLA");
            Collections.reverse(consola);
           if(!consolaLexica.isEmpty()){
                for (String s : consolaLexica) {
                    System.out.println(s);
                }
                return consolaLexica;
            }
            for (String s : consola) {
                System.out.println(s);
            }
            return consola;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CompiladoresApplication.class.getName()).log(Level.SEVERE, "Error al generar en cup ", ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}
