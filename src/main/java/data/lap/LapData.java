/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.lap;

import data.DataConverter;

import java.util.List;


/**
 *
 * @author kager
 */
public class LapData
{

  private final float lastLapTime, currentLapTime, bestLapTime, sector1Time, sector2Time, lapDistance, totalDistance, safetyCarDelta, bestLapSector1Time, bestLapSector2Time, bestLapSector3Time, bestOverallSector1Time, bestOverallSector2Time, bestOverallSector3Time;
  private final int carPosition, currentLapNum, pitStatus, sector, currentLapInvalid, penalties, gridPosition, driverStatus, resultStatus, bestLapNum, bestOverallSector1LapNum, bestOverallSector2LapNum, bestOverallSector3LapNum;
  
  public LapData(List<Byte> data) {

    this.lastLapTime = DataConverter.convertFloat(data, 0);
    this.currentLapTime = DataConverter.convertFloat(data, 4);

    this.sector1Time = (float) DataConverter.convertUint16(data, 8) / 1000;
    this.sector2Time = (float) DataConverter.convertUint16(data, 10) / 1000;
    this.bestLapTime = DataConverter.convertFloat(data, 12);

    this.bestLapNum = DataConverter.convertUint8(data.get(16));
    this.bestLapSector1Time = (float) DataConverter.convertUint16(data, 17) / 1000;
    this.bestLapSector2Time = (float) DataConverter.convertUint16(data, 19) / 1000;
    this.bestLapSector3Time = (float) DataConverter.convertUint16(data, 21) / 1000;

    this.bestOverallSector1Time = (float) DataConverter.convertUint16(data, 23) / 1000;
    this.bestOverallSector1LapNum = DataConverter.convertUint8(data.get(25));
    this.bestOverallSector2Time = (float) DataConverter.convertUint16(data, 26) / 1000;
    this.bestOverallSector2LapNum = DataConverter.convertUint8(data.get(28));
    this.bestOverallSector3Time = (float) DataConverter.convertUint16(data, 29) / 1000;
    this.bestOverallSector3LapNum = DataConverter.convertUint8(data.get(31));



    this.lapDistance = DataConverter.convertFloat(data, 32);
    this.totalDistance = DataConverter.convertFloat(data, 36);
    this.safetyCarDelta = DataConverter.convertFloat(data, 40);
    
    this.carPosition = DataConverter.convertUint8(data.get(44));
    this.currentLapNum = DataConverter.convertUint8(data.get(45));
    this.pitStatus = DataConverter.convertUint8(data.get(46));
    this.sector = DataConverter.convertUint8(data.get(47));
    this.currentLapInvalid = DataConverter.convertUint8(data.get(48));
    this.penalties = DataConverter.convertUint8(data.get(49));
    this.gridPosition = DataConverter.convertUint8(data.get(50));
    this.driverStatus = DataConverter.convertUint8(data.get(51));
    this.resultStatus = DataConverter.convertUint8(data.get(52));
  }


  public float getLastLapTime ()
  {
    return lastLapTime;
  }


  public float getCurrentLapTime ()
  {
    return currentLapTime;
  }


  public float getBestLapTime ()
  {
    return bestLapTime;
  }


  public float getSector1Time ()
  {
    return sector1Time;
  }


  public float getSector2Time ()
  {
    return sector2Time;
  }


  public float getLapDistance ()
  {
    return lapDistance;
  }


  public float getTotalDistance ()
  {
    return totalDistance;
  }


  public float getSafetyCarDelta ()
  {
    return safetyCarDelta;
  }


  public int getCarPosition ()
  {
    return carPosition;
  }


  public int getCurrentLapNum ()
  {
    return currentLapNum;
  }


  public int getPitStatus ()
  {
    return pitStatus;
  }


  public int getSector ()
  {
    return sector;
  }


  public int getCurrentLapInvalid ()
  {
    return currentLapInvalid;
  }


  public int getPenalties ()
  {
    return penalties;
  }


  public int getGridPosition ()
  {
    return gridPosition;
  }


  public int getDriverStatus ()
  {
    return driverStatus;
  }


  public int getResultStatus ()
  {
    return resultStatus;
  }

  public float getBestLapSector2Time() {
    return bestLapSector2Time;
  }

  public float getBestLapSector1Time() {
    return bestLapSector1Time;
  }

  public float getBestLapSector3Time() {
    return bestLapSector3Time;
  }

  public float getBestOverallSector1Time() {
    return bestOverallSector1Time;
  }

  public float getBestOverallSector2Time() {
    return bestOverallSector2Time;
  }

  public float getBestOverallSector3Time() {
    return bestOverallSector3Time;
  }

  public int getBestLapNum() {
    return bestLapNum;
  }

  public int getBestOverallSector1LapNum() {
    return bestOverallSector1LapNum;
  }

  public int getBestOverallSector2LapNum() {
    return bestOverallSector2LapNum;
  }

  public int getBestOverallSector3LapNum() {
    return bestOverallSector3LapNum;
  }
}
