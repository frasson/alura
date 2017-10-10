package br.com.david.jms.fila;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

public class ProdutorFila {
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

		MessageProducer producer = session.createProducer(fila);
		
		for (int i = 0; i < 1000; i++) {
			Message message = session.createTextMessage("<pedido><id>" + i + "</id></pedido>");
			producer.send(message);
		}		

		session.close();
		connection.close();
		context.close();
	}
}