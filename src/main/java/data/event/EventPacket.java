package data.event;

import data.DataConverter;
import data.PacketHeader;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

public class EventPacket {
    private final PacketHeader packetHeader;
    //private final EventCode code;

    public EventPacket(byte[] dataBy) {
        List<Byte> data = DataConverter.getListOfBytes(dataBy);
        this.packetHeader = new PacketHeader(data.subList(0, 24));
        Byte[] b = new Byte[4];
        List<Byte> subList = data.subList(24, 28);
        Byte[] c = subList.toArray(b);
        //Base64.getEncoder().encodeToString(c.toString());
        //code = EventCode.valueOf(DataConverter.co)
        //switch ()

    }


    }
