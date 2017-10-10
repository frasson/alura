package br.com.david.jms.topico;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

public class Publisher {
	public static void main(String[] args) throws Exception {

		/* Inicio da inicialização */
		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		connection.start();

		// arg1 = transação
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination topico = (Destination) context.lookup("loja");		
		/* Fim da inicialização */

		MessageProducer producer = session.createProducer(topico);
		
		for (int i = 0; i < 10; i++) {
			Message message = session.createTextMessage("<topico><id>" + i + "</id></topico>");
			//message.setBooleanProperty("ebook", false);
			producer.send(message);
		}		

		session.close();
		connection.close();
		context.close();
	}
}