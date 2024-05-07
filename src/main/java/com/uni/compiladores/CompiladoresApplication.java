package com.uni.compiladores;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import mi.primer.scanner.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@SpringBootApplication
public class CompiladoresApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(CompiladoresApplication.class, args);

		/*String operacion = "((2+3*8+7)*4)/26+45";

		try {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			Object resultado = engine.eval(operacion);
			System.out.println("Resultado: " + resultado);
		} catch (ScriptException e) {
			e.printStackTrace();
		}*/

	}

	public static void pruebaCompi() throws IOException {

		CompiladoresApplication compiladoresApplication = new CompiladoresApplication();
		compiladoresApplication.compilarCup();

		/*MySecondScanner scanner = new MySecondScanner(new  FileReader("prueba.txt"));
		scanner.yylex();*/
	}

	public ArrayList<String> compilarCup() {
		try {
			Reader reader = new FileReader("prueba.txt");
			parser p = new parser(new Scanner(reader));
			p.parse();

			ArrayList<String> consola = new ArrayList<String>(p.consola);
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
