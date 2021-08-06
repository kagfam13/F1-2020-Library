/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.status;

import data.DataConverter;
import data.PacketHeader;
import data.status.CarStatusData;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author kager
 */
public class CarStatusPacket
{
  
  private final PacketHeader packetHeader;
  private final List<CarStatusData> carStatusData;
  
  public CarStatusPacket(byte[] dataBy) {
    List<Byte> data = DataConverter.getListOfBytes(dataBy);
    this.packetHeader = new PacketHeader(data.subList(0, 24));
    this.carStatusData = new ArrayList<>();
    for(int i = 1; i < 21; i++){
      int from = 24 + ((i-1)*56);
      int to = 24 + (i * 56);
      this.carStatusData.add(new CarStatusData(data.subList(from, to)));
    }
  }


  public PacketHeader getPacketHeader()
  {
    return packetHeader;
  }


  public List<CarStatusData> getCarStatusData ()
  {
    return carStatusData;
  }
  
  
}
