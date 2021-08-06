/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.status;

import data.DataConverter;

import java.util.List;


/**
 *
 * @author kager
 */
public class CarStatusData
{
  
  private final int tractionControl, antiLockBrake, fuelMix, frontBreakBias, pitLimiterStatus, maxRPM, idleRPM, 
          maxGears, drsAllowed, actualTyreCombound, tyreVisualCompound, frontLeftWingDamage, frontRightWingDamage, 
          rearWingDamage, engineDamage, gearBoxDamage, vehicleFiaFlags, ersDeployMode;
  private final int[] tyresWear, tyresDamage;
  private final float fuelInTank, fuelCapacity, fuelRemainingLaps, ersStoreEnergy, ersHarvestedThisLapMGUK, ersHarvestedThisLapMGUH, ersDeployedThisLap;
  
  public CarStatusData(List<Byte> data) {
    this.tractionControl = DataConverter.convertUint8(data.get(0));
    this.antiLockBrake = DataConverter.convertUint8(data.get(1));
    this.fuelMix = DataConverter.convertUint8(data.get(2));
    this.frontBreakBias = DataConverter.convertUint8(data.get(3));
    this.pitLimiterStatus = DataConverter.convertUint8(data.get(4));  
    this.fuelInTank = DataConverter.convertFloat(data, 5);
    this.fuelCapacity = DataConverter.convertFloat(data, 9);
    this.fuelRemainingLaps = DataConverter.convertFloat(data, 13);
    this.maxRPM = DataConverter.convertUint16(data, 17);
    this.idleRPM = DataConverter.convertUint16(data, 19);
    this.maxGears = DataConverter.convertUint8(data.get(21));
    this.drsAllowed = DataConverter.convertUint8(data.get(22));
    this.tyresWear = new int[4];
    this.tyresWear[0] = DataConverter.convertUint8(data.get(23));
    this.tyresWear[1] = DataConverter.convertUint8(data.get(24));
    this.tyresWear[2] = DataConverter.convertUint8(data.get(25));
    this.tyresWear[3] = DataConverter.convertUint8(data.get(26));
    this.actualTyreCombound = DataConverter.convertUint8(data.get(27));
    this.tyreVisualCompound = DataConverter.convertUint8(data.get(28));
    this.tyresDamage = new int[4];
    this.tyresDamage[0] = DataConverter.convertUint8(data.get(29));
    this.tyresDamage[1] = DataConverter.convertUint8(data.get(30));
    this.tyresDamage[2] = DataConverter.convertUint8(data.get(31));
    this.tyresDamage[3] = DataConverter.convertUint8(data.get(32));
    this.frontLeftWingDamage = DataConverter.convertUint8(data.get(33));
    this.frontRightWingDamage = DataConverter.convertUint8(data.get(34));
    this.rearWingDamage = DataConverter.convertUint8(data.get(35));
    this.engineDamage = DataConverter.convertUint8(data.get(36));
    this.gearBoxDamage = DataConverter.convertUint8(data.get(37));
    this.vehicleFiaFlags = DataConverter.convertInt8(data.get(38));
    this.ersStoreEnergy = DataConverter.convertFloat(data, 39);
    this.ersDeployMode = DataConverter.convertUint8(data.get(43));
    this.ersHarvestedThisLapMGUK = DataConverter.convertFloat(data, 44);
    this.ersHarvestedThisLapMGUH = DataConverter.convertFloat(data, 48);
    this.ersDeployedThisLap = DataConverter.convertFloat(data, 52);
  }
}

