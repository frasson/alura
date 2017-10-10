package br.com.david.jms.fila;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.naming.InitialContext;

public class VerificarFila {
	public static void main(String[] args) throws Exception {

		/* Inicio da inicialização */
		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		connection.start();

		// arg1 = transação
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination fila = (Destination) context.lookup("financeiro");		
		/* Fim da inicialização */

		QueueBrowser browser = session.createBrowser((Queue) fila);
		
		Enumeration<?> msgs = browser.getEnumeration();
		if ( !msgs.hasMoreElements() ) { 
		    System.out.println("Sem mensagens na fila");
		} else { 
		    while (msgs.hasMoreElements()) { 
		        Message tempMsg = (Message)msgs.nextElement(); 
		        System.out.println("Mensagem: " + tempMsg); 
		    }
		}		

		session.close();
		connection.close();
		context.close();
	}
}