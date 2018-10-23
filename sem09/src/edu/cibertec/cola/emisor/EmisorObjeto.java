package edu.cibertec.cola.emisor;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import edu.cibertec.entidades.Clientes;

public class EmisorObjeto {

	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static String cola = "Cibertec";
	public EmisorObjeto() {
		
	}
	
	public static void sendMessage() {
		
		try {
			ConnectionFactory factory = new ActiveMQConnectionFactory(url);
			Connection connection = factory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(cola);
			MessageProducer producer = session.createProducer(destination);
			Clientes miCliente = new Clientes(149,"Panchito",new String[] {"Sistemas","Operaciones"});
			ObjectMessage message = session.createObjectMessage(miCliente);
			producer.send(message);
			System.out.println(String.format("Cliente enviado : %s", miCliente));
			producer.close();
			session.close();
			connection.close();
		}
		catch(JMSException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		sendMessage();
	}

}