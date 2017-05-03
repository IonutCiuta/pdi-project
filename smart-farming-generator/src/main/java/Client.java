/**
 * Created by Cristian on 4/29/2017.
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

    public void startClient()
            throws IOException, InterruptedException {

        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8091);
        SocketChannel client = SocketChannel.open(hostAddress);

        String threadName = Thread.currentThread().getName();

        System.out.println("Client planta: " + threadName + "... a pornit");



        // Send messages to server
        String [] messages = new String []
                {threadName + ": Indice umiditate",threadName + ": Indice lumina",threadName + ": Indice temperatura"};

        for (int i = 0; i < messages.length; i++) {
            byte [] message = new String(messages [i]).getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
            client.write(buffer);
            System.out.println(messages [i]);
            buffer.clear();
            Thread.sleep(5000);
        }
        client.close();
    }
}