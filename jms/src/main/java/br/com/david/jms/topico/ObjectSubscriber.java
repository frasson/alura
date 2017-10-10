package br.com.david.jms.topico;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;

import br.com.david.jms.modelo.Pedido;

public class ObjectSubscriber {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
    	System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");

        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

        Connection connection = factory.createConnection(); 
        connection.setClientID("estoque");

        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topico = (Topic) context.lookup("loja");

        MessageConsumer consumer = session.createDurableSubscriber(topico, "assinatura");

        consumer.setMessageListener(new MessageListener() {
            
            public void onMessage(Message message) {

                ObjectMessage objectMessage = (ObjectMessage)message;

                try {
                	Pedido pedido = (Pedido)objectMessage.getObject();
                    System.out.println(pedido.getCodigo());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

        });


       new Scanner(System.in).nextLine();

        session.close();
        connection.close();
        context.close();
    }
}