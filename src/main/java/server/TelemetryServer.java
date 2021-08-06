package server;

import data.*;
import data.lap.LapPacket;
import data.motion.MotionPacket;
import data.participants.ParticipantsPacket;
import data.session.SessionPacket;
import data.telemetry.CarTelemetryPacket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public abstract class TelemetryServer {

    private final int port;

    public TelemetryServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(port);
        byte[] receiveData = new byte[2048];
        while(true)
        {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            receivedData(receivePacket);
        }
    }

    private void receivedData(DatagramPacket receiveData) throws IOException {
        //printData(receiveData);
        PacketHeader header = new PacketHeader(receiveData.getData());
        switch(header.getPacketId()) {
            case 0: receivedMotionPacket(new MotionPacket(receiveData.getData())); break;
            case 1: receivedSessionPacket(new SessionPacket(receiveData.getData())); break;
            case 2: receivedLapDataPacket(new LapPacket(receiveData.getData())); break;
            case 4: receivedParticipantsDataPacket(new ParticipantsPacket(receiveData.getData())); break;
            case 6: receivedCarTelDataPacket(new CarTelemetryPacket(receiveData.getData())); break;
        }

    }

    protected void printData(DatagramPacket receiveData) {
        byte[] bA = receiveData.getData();
        for (byte b: bA) {
            System.out.print(b + ", ");
        }
        System.out.println();
    }

    public abstract void receivedSessionPacket(SessionPacket sessionData);

    public  abstract void receivedLapDataPacket(LapPacket lapData);

    public abstract void receivedCarTelDataPacket(CarTelemetryPacket carTelemetryPacket);

    public abstract void receivedParticipantsDataPacket(ParticipantsPacket participantsPacket);

    public abstract void receivedMotionPacket(MotionPacket motionPacket);
}
