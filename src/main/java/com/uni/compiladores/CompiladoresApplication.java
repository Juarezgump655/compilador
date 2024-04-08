package com.uni.compiladores;

import com.sun.tools.javac.parser.Lexer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
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
	/*parser p = new parser(new Scanner(new  FileReader("prueba.txt")));
		Object result = p.parse().value;
		System.out.println("Resultado: " + result);*/
		Scanner scanner = new Scanner(new FileReader("prueba.txt"));
		scanner.yylex();

	}

}
