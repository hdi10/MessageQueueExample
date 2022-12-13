/**
 * Dastekin created on 13.12.2022 the Producer-Class inside the package - PACKAGE_NAME
 */
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Producer {
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] argv) throws Exception {
     ConnectionFactory factory = new ConnectionFactory();
     factory.setHost("localhost");
     try (Connection connection = factory.newConnection();
     Channel channel = connection.createChannel()) {

         channel.queueDeclare(QUEUE_NAME,false,false,false,null);
         String message = "Hellow Wolrd!";
         channel.basicPublish("", QUEUE_NAME, null, message.getBytes(UTF_8));
         System.out.println("[x] Send " + message + "");
     }
    }
}
