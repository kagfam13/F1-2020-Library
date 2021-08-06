/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;


/**
 *
 * @author kager
 */
public class PacketHeader implements Serializable
{
  
  private final int packetFormat, gameMajorVersion, gameMinorVersion, packetVersion, packetId, playerCarIndex, secondaryPlayerCarIndex;
  private final BigInteger sessionUid;
  private final float sessionTime;
  private final long frameIdentifier;
  
  public PacketHeader(List<Byte> data) {
    this.packetFormat = DataConverter.convertUint16(data, 0);
    this.gameMajorVersion = DataConverter.convertUint8(data.get(2));
    this.gameMinorVersion = DataConverter.convertUint8(data.get(3));
    this.packetVersion = DataConverter.convertUint8(data.get(4));
    this.packetId = DataConverter.convertUint8(data.get(5)); 
    this.sessionUid = DataConverter.convertUint64(data, 6);
    this.sessionTime = DataConverter.convertFloat(data, 14);
    this.frameIdentifier = DataConverter.convertUint(data, 18);
    this.playerCarIndex = DataConverter.convertUint8(data.get(22));
    this.secondaryPlayerCarIndex = DataConverter.convertUint8(data.get(23));
  }

  public PacketHeader(byte[] dataBytes) {
    this(DataConverter.getListOfBytes(dataBytes).subList(0, 24));
  }

  public int getPacketFormat ()
  {
    return packetFormat;
  }

  public int getGameMajorVersion ()
  {
    return gameMajorVersion;
  }

  public int getGameMinorVersion ()
  {
    return gameMinorVersion;
  }

  public int getPacketVersion ()
  {
    return packetVersion;
  }

  public int getPacketId ()
  {
    return packetId;
  }

  public BigInteger getSessionUid ()
  {
    return sessionUid;
  }

  public float getSessionTime ()
  {
    return sessionTime;
  }

  public int getPlayerCarIndex ()
  {
    return playerCarIndex;
  }

  public long getFrameIdentifier ()
  {
    return frameIdentifier;
  }

  public int getSecondaryPlayerCarIndex() {return secondaryPlayerCarIndex;}

}
