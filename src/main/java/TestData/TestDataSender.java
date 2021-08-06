package TestData;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestDataSender {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        int port = 4321;
        byte[] byteBuffer = TestMessages.TELEMETRY1;
        DatagramPacket packet = new DatagramPacket(byteBuffer, 2048, address, port);
        socket.send(packet);
    }
}