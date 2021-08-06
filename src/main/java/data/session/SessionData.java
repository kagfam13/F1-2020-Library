package data.session;

import data.DataConverter;

import java.util.List;

public class SessionData {
    private final int weather, trackTemperature, airTemperture, totalLaps, trackLenght, sessionType, trackId, formula, sessionatimeLeft, sessionDuration, pitSpeedLimit, gamePaused, isSpectating, spectatorCarIndex; // TODO sliProNativeSupport, numMarshalZones, MarshalZones, safetyCarStatus, networkGame

    public SessionData(List<Byte> data) {
        this.weather = DataConverter.convertUint8(data.get(0));
        this.trackTemperature = DataConverter.convertInt8(data.get(1));
        this.airTemperture = DataConverter.convertInt8(data.get(2));
        this.totalLaps = DataConverter.convertUint8(data.get(3));
        this.trackLenght = DataConverter.convertUint16(data, 4);
        this.sessionType = DataConverter.convertUint8(data.get(6));
        this.trackId = DataConverter.convertInt8(data.get(7));
        this.formula = DataConverter.convertUint8(data.get(8));
        this.sessionatimeLeft = DataConverter.convertUint16(data, 9);
        this.sessionDuration = DataConverter.convertUint16(data, 11);
        this.pitSpeedLimit = DataConverter.convertUint8(data.get(13));
        this.gamePaused = DataConverter.convertUint8(data.get(14));
        this.isSpectating = DataConverter.convertUint8(data.get(15));
        this.spectatorCarIndex = DataConverter.convertUint8(data.get(16));
    }

    public int getWeather() {
        return weather;
    }

    public int getTrackTemperature() {
        return trackTemperature;
    }

    public int getAirTemperture() {
        return airTemperture;
    }

    public int getTotalLaps() {
        return totalLaps;
    }

    public int getTrackLenght() {
        return trackLenght;
    }

    public int getSessionType() {
        return sessionType;
    }

    public int getTrackId() {
        return trackId;
    }

    public int getFormula() {
        return formula;
    }

    public int getSessionatimeLeft() {
        return sessionatimeLeft;
    }

    public int getSessionDuration() {
        return sessionDuration;
    }

    public int getPitSpeedLimit() {
        return pitSpeedLimit;
    }

    public int getGamePaused() {
        return gamePaused;
    }

    public int getIsSpectating() {
        return isSpectating;
    }

    public int getSpectatorCarIndex() {
        return spectatorCarIndex;
    }
}
