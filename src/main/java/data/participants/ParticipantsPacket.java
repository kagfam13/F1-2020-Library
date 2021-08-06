package data.participants;

import data.DataConverter;
import data.PacketHeader;
import data.participants.ParticipantData;

import java.util.ArrayList;
import java.util.List;

public class ParticipantsPacket {
    private final PacketHeader packetHeader;
    private final List<ParticipantData> participantData;
    private final int numActiveCars;

    public ParticipantsPacket(byte[] dataBytes) {
        List<Byte> data = DataConverter.getListOfBytes(dataBytes);
        this.packetHeader = new PacketHeader(data.subList(0, 24));
        this.participantData = new ArrayList<>();
        numActiveCars = DataConverter.convertUint8(data.get(24));
        for (int i = 1; i < 23; i++) {
            int from = 25 + ((i - 1) * 54);
            int to = 25 + (i * 54);
            this.participantData.add(new ParticipantData(data.subList(from, to)));
        }
    }

    public PacketHeader getPacketHeader() {
        return packetHeader;
    }

    public List<ParticipantData> getParticipantData() {
        return participantData;
    }
}
