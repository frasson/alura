package br.com.david.testes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestaInteger {

	public static void main(String[] args) {
		Integer x1 = new Integer(10);
	    Integer x2 = new Integer(10);

	    if (x1.equals(x2)) {
	        System.out.println("igual");
	    } else {
	        System.out.println("diferente");
	    }
	    
	    Collection<Integer> collection = new ArrayList<Integer>();
	    List<Integer> list = new ArrayList<Integer>();
	    Set<Integer> set = new HashSet();
    
	    
	}
}
