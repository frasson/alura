package br.com.david.testes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TestaPerformance {
	private static final int TOTAL = 30000;

    public static void main(String[] args) {
    	arrayList();
    	hashSet();
    }
    
    public static void arrayList() {
        System.out.println("Iniciando arrayList...");
        Collection<Integer> teste = new ArrayList<>();        

        long inicio = System.currentTimeMillis();        
        for (int i = 0; i < TOTAL; i++) {
            teste.add(i);
        }
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto add: " + (fim - inicio));

        inicio = System.currentTimeMillis();
        for (int i = 0; i < TOTAL; i++) {
            teste.contains(i);
        }
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto contains: " + (fim - inicio));
    }
    
    public static void hashSet() {
        System.out.println("Iniciando HashSet...");
        Collection<Integer> teste = new HashSet<>();        

        long inicio = System.currentTimeMillis();        
        for (int i = 0; i < TOTAL; i++) {
            teste.add(i);
        }
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto add: " + (fim - inicio));

        inicio = System.currentTimeMillis();
        for (int i = 0; i < TOTAL; i++) {
            teste.contains(i);
        }
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto contains: " + (fim - inicio));   	
    }
}