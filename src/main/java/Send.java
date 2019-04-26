import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class Send {

    private final static String QUEUE_NAME = "APP_PRODUCER_QUEUE";
    private final static String EXCHANGE_NAME = "app.producer.direct";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try {
            factory.setUri("amqp://guest:guest@localhost");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        Channel channel = null;
        try {
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String message = "Hello World!";
        try {
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" [x] Sent '" + message + "'");

        try {
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
