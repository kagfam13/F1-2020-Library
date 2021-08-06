package data.motion;

import data.DataConverter;
import data.PacketHeader;
import data.telemetry.CarTelemetryData;

import java.util.ArrayList;
import java.util.List;

public class MotionPacket {
    private final PacketHeader packetHeader;
    private final List<MotionData> motionData;

    public MotionPacket(byte[] dataBy) {
        List<Byte> data = DataConverter.getListOfBytes(dataBy);
        this.packetHeader = new PacketHeader(data.subList(0, 24));
        this.motionData = new ArrayList<>();

        for(int i = 1; i < 21; i++){
            int from = 24 + ((i-1)*60);
            int to = 24 + (i * 60);
            this.motionData.add(new MotionData(data.subList(from, to)));
        }

    }
}
