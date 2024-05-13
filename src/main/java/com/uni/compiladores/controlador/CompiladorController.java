package com.uni.compiladores.controlador;

import com.uni.compiladores.CompiladoresApplication;
import mi.primer.scanner.Scanner;
import mi.primer.scanner.parser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/compilador")
public class CompiladorController {

    ArrayList<String> consola = new ArrayList<String>();

    @PostMapping(value = "/traducir")
    public ArrayList<String> traducir(/*@RequestParam("txtMini") String txtMini,
                                      @RequestParam("fileJava") MultipartFile fileJava*/) {
        return compilarCup();
    }

    public ArrayList<String> compilarCup() {
        consola.clear();
        try {
            Reader reader = new FileReader("prueba.txt");
            parser p = new parser(new Scanner(reader));
            p.parse();

             consola = new ArrayList<String>(p.consola);
            Collections.reverse(consola);
            System.out.println("RESULTADO CONSOLA");
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
