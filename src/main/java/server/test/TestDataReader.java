package server.test;

import TestData.TestMessages;
import data.maps.TelemetryDataMap;
import data.telemetry.CarTelemetryPacket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.net.*;

public class TestDataReader {

    public static void sendData(byte[] byteBuffer) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        int port = 1234;
        //printData(byteBuffer);
        System.out.println("Trying to send: " + byteBuffer + " - " + 2048 + " - " + address + " - " + port);
        DatagramPacket packet = new DatagramPacket(byteBuffer, 2048, address, port);
        socket.send(packet);
    }

    private static void printData(byte[] byteBuffer) {
        for (byte b: byteBuffer) {
            System.out.print(b + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        String path;
        System.out.println(System.getProperty("os.name"));
        if(System.getProperty("os.name").startsWith("Windows")){
            path = System.getProperty("user.home") + "\\OneDrive - SSI-SCHAEFER\\Documents\\priv\\f1Data";
        } else {
            path = System.getProperty("user.dir") + "/f1Data";
        }
        System.out.println(path);

        String fileName = "test.ser";
        FileInputStream fis = new FileInputStream(path + fileName);
        ObjectInputStream ois = new ObjectInputStream (fis);
        final TelemetryDataMap map = (TelemetryDataMap) ois.readObject ();

        System.out.println("----- " + map.size());
        map.keySet().stream().sorted().forEach(x -> {
            CarTelemetryPacket packet = map.get(x);
            int gear =  packet.getCarTelemetryData().get(packet.getPacketHeader().getPlayerCarIndex()).getGear();
            System.out.println(x + " - " + packet.getCarTelemetryData().get(packet.getPacketHeader().getPlayerCarIndex()).getSpeed() + " - " + gear);

            try {
                sendData(packet.getDataBy());
                Thread.sleep(34);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
