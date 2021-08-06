package data.telemetry;

import data.DataConverter;
import data.PacketHeader;
import data.telemetry.CarTelemetryData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CarTelemetryPacket implements Serializable {

    private static final long serialVersionUID = 1L;
    private final PacketHeader packetHeader;
    private final List<CarTelemetryData> carTelemetryData;
    private final byte[] dataBy;


    public CarTelemetryPacket(byte[] dataBy) {
        this.dataBy = dataBy.clone();
        List<Byte> data = DataConverter.getListOfBytes(dataBy);
        this.packetHeader = new PacketHeader(data.subList(0, 24));
        this.carTelemetryData = new ArrayList<>();

        for(int i = 1; i < 21; i++){
            int from = 24 + ((i-1)*58);
            int to = 24 + (i * 58);
            this.carTelemetryData.add(new CarTelemetryData(data.subList(from, to)));
        }
    }


    public PacketHeader getPacketHeader()
    {
        return packetHeader;
    }


    public List<CarTelemetryData> getCarTelemetryData()
    {
        return carTelemetryData;
    }

    public byte[] getDataBy() {
        return dataBy;
    }
}
