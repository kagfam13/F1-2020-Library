package data.motion;

import data.DataConverter;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class MotionData {
    private final double worldpositionX, worldpositionY, worldpositionZ,worldVelocityX, worldVelocityY, worldVelocityZ;

    public MotionData(List<Byte> data) {
        this.worldpositionX = DataConverter.convertFloat(data, 0);
        this.worldpositionY = DataConverter.convertFloat(data, 4);
        this.worldpositionZ = DataConverter.convertFloat(data, 8);
        this.worldVelocityX = DataConverter.convertFloat(data, 12);
        this.worldVelocityY = DataConverter.convertFloat(data, 16);
        this.worldVelocityZ = DataConverter.convertFloat(data, 20);
    }

    public double getWorldpositionX() {
        return worldpositionX;
    }

    public double getWorldpositionY() {
        return worldpositionY;
    }

    public double getWorldpositionZ() {
        return worldpositionZ;
    }

    public double getWorldVelocityX() {
        return worldVelocityX;
    }

    public double getWorldVelocityY() {
        return worldVelocityY;
    }

    public double getWorldVelocityZ() {
        return worldVelocityZ;
    }

}
