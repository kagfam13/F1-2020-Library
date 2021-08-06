package data.session;

import data.DataConverter;
import data.PacketHeader;
import data.session.SessionData;

import java.util.List;

public class SessionPacket {
    private final PacketHeader packetHeader;
    private final SessionData sessionData;

    public SessionPacket(byte[] dataBytes) {
        List<Byte> data = DataConverter.getListOfBytes(dataBytes);
        this.packetHeader = new PacketHeader(data.subList(0, 24));
        this.sessionData = new SessionData(data.subList(24, data.size()));
    }

    public PacketHeader getPacketHeader() {
        return packetHeader;
    }

    public SessionData getSessionData() {
        return sessionData;
    }
}
