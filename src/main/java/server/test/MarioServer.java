package server.test;

import data.lap.LapPacket;
import data.motion.MotionPacket;
import data.participants.ParticipantsPacket;
import data.session.SessionPacket;
import data.telemetry.CarTelemetryData;
import data.telemetry.CarTelemetryPacket;
import server.TelemetryServer;
import java.io.IOException;

public class MarioServer extends TelemetryServer {
    SiebenSegmentAnzeige anzeige;
    public MarioServer(int port) {
        super(port);
        anzeige = new SiebenSegmentAnzeige();
    }

    @Override
    public void receivedSessionPacket(SessionPacket sessionData) {

    }

    @Override
    public void receivedLapDataPacket(LapPacket lapData) {
        //System.out.println(lapData.getLapData().get(lapData.getPacketHeader().getPlayerCarIndex()).getCurrentLapTime());
    }

    @Override
    public void receivedCarTelDataPacket(CarTelemetryPacket carTelemetryPacket) {
        CarTelemetryData data = carTelemetryPacket.getCarTelemetryData().get(carTelemetryPacket.getPacketHeader().getPlayerCarIndex());
        System.out.println(data.getGear());
        anzeige.setNumber(data.getGear());

        System.out.println("-------------------------------------------------------");
        carTelemetryPacket.getCarTelemetryData().forEach(d -> System.out.println(d.getSpeed() + " - " + d.getGear()));
    }

    @Override
    public void receivedParticipantsDataPacket(ParticipantsPacket participantsPacket) {

    }

    @Override
    public void receivedMotionPacket(MotionPacket motionPacket) {

    }

    public static void main(String[] args) throws IOException {
        MarioServer server = new MarioServer(4321);
        server.start();
    }
}
