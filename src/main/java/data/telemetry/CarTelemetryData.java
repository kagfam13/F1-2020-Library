package data.telemetry;

import data.DataConverter;

import java.io.Serializable;
import java.util.List;

public class CarTelemetryData implements Serializable {

    private final int speed, clutch, gear, rpm, drs, revLightPercantage;
    private final double throttle, steer, brake;

    public CarTelemetryData(List<Byte> data) {
        this.speed = DataConverter.convertUint16(data, 0);
        this.throttle = DataConverter.convertFloat(data, 2);
        this.steer = DataConverter.convertFloat(data, 6);
        this.brake = DataConverter.convertFloat(data, 10);
        this.clutch = DataConverter.convertUint8(data.get(14));
        this.gear = DataConverter.convertInt8(data.get(15));
        this.rpm = DataConverter.convertUint16(data, 16);
        this.drs = DataConverter.convertUint8(data.get(20));
        this.revLightPercantage = DataConverter.convertUint8(data.get(21));
        // TODO add remaining stuff
        //60 bytes

    }

    public int getSpeed() {
        return speed;
    }

    public int getClutch() {
        return clutch;
    }

    public int getGear() {
        return gear;
    }

    public int getRpm() {
        return rpm;
    }

    public int getDrs() {
        return drs;
    }

    public int getRevLightPercantage() {
        return revLightPercantage;
    }

    public double getThrottle() {
        return throttle;
    }

    public double getSteer() {
        return steer;
    }

    public double getBrake() {
        return brake;
    }
}
