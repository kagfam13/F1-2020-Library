package server;

import data.lap.LapData;
import data.lap.LapPacket;
import data.maps.TelemetryDataMap;
import data.motion.MotionPacket;
import data.participants.ParticipantsPacket;
import data.session.SessionPacket;
import data.telemetry.CarTelemetryPacket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DataCollectionServer extends TelemetryServer {

    Map<Long, SessionPacket> sessionPackets = new HashMap<>();
    TelemetryDataMap carTelemetryPackets = new TelemetryDataMap();
    int counter = 0;


    public DataCollectionServer(int port) {
        super(port);
    }

    @Override
    public void receivedSessionPacket(SessionPacket sessionData) {
        sessionPackets.put(sessionData.getPacketHeader().getFrameIdentifier(), sessionData);

    }

    @Override
    public void receivedLapDataPacket(LapPacket lapData) {
        LapData data = lapData.getLapData().get(lapData.getPacketHeader().getPlayerCarIndex());
        if(data.getCurrentLapNum() > 3 && !saved) {
            save();
        }
    }

    private boolean saved = false;
    private long time = System.currentTimeMillis();
    @Override
    public void receivedCarTelDataPacket(CarTelemetryPacket carTelemetryPacket) {
        long currentTime = System.currentTimeMillis();
        System.out.println(carTelemetryPacket.getPacketHeader().getSessionTime() + " ---- " + (currentTime - time));
        time = currentTime;
        carTelemetryPackets.put(carTelemetryPacket.getPacketHeader().getSessionTime(), carTelemetryPacket);
    }

    @Override
    public void receivedParticipantsDataPacket(ParticipantsPacket participantsPacket) {

    }

    @Override
    public void receivedMotionPacket(MotionPacket motionPacket) {

    }

    public void save() {
        System.out.println("Trying to save. lines: " + carTelemetryPackets.size());

        try {
            String path;
            //System.out.println(System.getProperty("os.name"));
            if(System.getProperty("os.name").startsWith("Windows")){
                path = System.getProperty("user.home") + "\\OneDrive - SSI-SCHAEFER\\Documents\\priv\\f1Data";
            } else {
                path = System.getProperty("user.dir") + "/f1Data";
            }
            //System.out.println(path);

            String fileName = "test.ser";
            FileOutputStream fileOut = new FileOutputStream(path + fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(carTelemetryPackets);
            objectOut.close();
            //System.out.println("The Object was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        DataCollectionServer server = new DataCollectionServer(4321);
        server.start();
    }
}
