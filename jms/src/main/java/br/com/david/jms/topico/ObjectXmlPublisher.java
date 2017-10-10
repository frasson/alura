package br.com.david.jms.topico;

import java.io.StringWriter;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import br.com.david.jms.modelo.Pedido;
import br.com.david.jms.modelo.PedidoFactory;

public class ObjectXmlPublisher {
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
		
		Pedido pedido = new PedidoFactory().geraPedidoComValores();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Pedido.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();		
		
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		StringWriter writer = new StringWriter();
		jaxbMarshaller.marshal(pedido, writer);
		String pedidoXml = writer.toString();
		
		System.out.println(pedidoXml);
		
		Message message = session.createTextMessage(pedidoXml);
		producer.send(message);		

		session.close();
		connection.close();
		context.close();
	}
}