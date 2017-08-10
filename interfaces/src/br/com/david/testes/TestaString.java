package br.com.david.testes;

public class TestaString {

	public static void main(String[] args) {
		String nomeCompleto = " David Frasson Junior ";
		String sobreNome = "Frasson";
		String familia = "";

		if (nomeCompleto.contains(sobreNome)) {
			System.out.println("A String sobreNome encontra-se na String nomeCompleto!");
		}

		System.out.println("Tamanho com espaços em branco nas pontas: " + nomeCompleto.length());
		System.out.println("Tamanho sem os espaços em branco nas pontas: " + nomeCompleto.trim().length());
		if (familia.isEmpty()) {
			System.out.println("A String família está vazia!");
		}
		
		System.out.println("--------------------");
		imprimeLetra("Alura");
		ordemInvertida("Socorram-me, subi no ônibus em Marrocos");
		//imprimeLetra("anotaram a data da maratona");	
		
		convertStringToInt("762");
	}
	
	public static void imprimeLetra(String texto) {
		for (int i = texto.length() - 1; i >= 0; i--) {
			System.out.println(texto.charAt(i));			
		}		
	}
	
	public static void ordemInvertida(String texto) {
		String[] palavras = texto.split(" ");
		StringBuilder novoTexto = new StringBuilder();
		for (int i = palavras.length - 1; i >= 0; i--) {
			novoTexto.append(palavras[i]).append(" "); 			
		}
		
		System.out.println(novoTexto.toString());
	}
	
	public static void convertStringToInt(String text) {
	       int resultado = 0;
	        while (text.length() > 0){
	            char algarismo = text.charAt(0);
	            resultado = resultado * 10 + (algarismo - '0');
	            text = text.substring(1);
	        }
	        
	        System.out.println(resultado);
	}
}
