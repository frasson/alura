package br.com.david.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class ImprimeNumero {
	public static void main(String args[]) {
		//tree();
		array();
	}
	
	public static void tree() {
		TreeSet<Integer> numeros = new TreeSet<>();
		
		for (int i = 1; i < 1001; i++) {
			numeros.add(i);			
		}
		
		for (Integer i : numeros.descendingSet()) {
			System.out.println(i);
		}		
	}
	
	public static void array() {
        List<Integer> lista = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) { 
            lista.add(i);
        }

        Collections.reverse(lista);

        for (Integer i : lista) {
            System.out.print(i + " ");
        }	
	}	
}