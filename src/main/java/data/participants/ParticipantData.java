package data.participants;

import data.DataConverter;

import java.util.List;

public class ParticipantData {
    private final int aiControlled, driverId, teamId, raceNumber, nationality;

    public ParticipantData(List<Byte> data) {
        this.aiControlled = DataConverter.convertUint8(data.get(0));
        this.driverId = DataConverter.convertUint8(data.get(1));
        this.teamId = DataConverter.convertUint8(data.get(2));
        this.raceNumber = DataConverter.convertUint8(data.get(3));
        this.nationality = DataConverter.convertUint8(data.get(4));
    }

    public int getAiControlled() {
        return aiControlled;
    }

    public int getDriverId() {
        return driverId;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getRaceNumber() {
        return raceNumber;
    }

    public int getNationality() {
        return nationality;
    }
}
