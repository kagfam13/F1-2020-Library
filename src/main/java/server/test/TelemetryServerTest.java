package server.test;

import data.lap.LapPacket;
import data.motion.MotionPacket;
import data.participants.ParticipantsPacket;
import data.session.SessionPacket;
import data.telemetry.CarTelemetryData;
import data.telemetry.CarTelemetryPacket;
import server.TelemetryServer;

import java.io.IOException;


public class TelemetryServerTest extends TelemetryServer {

    public TelemetryServerTest() {
        super(4321);
    }

    @Override
    public void receivedSessionPacket(SessionPacket sessionData) {

    }

    @Override
    public void receivedLapDataPacket(LapPacket lapData) {

    }

    @Override
    public void receivedCarTelDataPacket(CarTelemetryPacket carTelemetryPacket) {
        CarTelemetryData carTelemetryData = carTelemetryPacket.getCarTelemetryData().get(carTelemetryPacket.getPacketHeader().getPlayerCarIndex());
        System.out.println("SPEED: " + carTelemetryData.getSpeed());
        System.out.println("GEAR: " + carTelemetryData.getGear());
        System.out.println("RevLight%: " + carTelemetryData.getRevLightPercantage());
        System.out.println("STEER: " + carTelemetryData.getSteer());
        System.out.println("BRAKE: " + carTelemetryData.getBrake());
        System.out.println("THROTTLE: " + carTelemetryData.getThrottle());

    }

    @Override
    public void receivedParticipantsDataPacket(ParticipantsPacket participantsPacket) {

    }

    @Override
    public void receivedMotionPacket(MotionPacket motionPacket) {

    }

    public static void main(String[] args) {
        try {
            TelemetryServerTest testServer = new TelemetryServerTest();
            testServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
