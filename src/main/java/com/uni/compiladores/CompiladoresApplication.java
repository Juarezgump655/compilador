package com.uni.compiladores;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import mi.primer.scanner.*;
@SpringBootApplication
public class CompiladoresApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(CompiladoresApplication.class, args);
		try{
			CompiladoresApplication compiladoresApplication = new CompiladoresApplication();
			CompiladoresApplication.pruebaCompi();
		}catch (IOException e){
			System.out.println("Error en la lectura del archivo");
		}

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

			ArrayList<String> inverso = new ArrayList<String>(p.resultados2);
			Collections.reverse(inverso);
			return inverso;
		} catch (FileNotFoundException ex) {
			Logger.getLogger(CompiladoresApplication.class.getName()).log(Level.SEVERE, "Error al generar en cup ", ex);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}

}
