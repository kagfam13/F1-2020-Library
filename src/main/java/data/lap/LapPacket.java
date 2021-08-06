/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.lap;

import data.DataConverter;
import data.PacketHeader;
import data.lap.LapData;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author kager
 */
public class LapPacket
{
  
  private final PacketHeader packetHeader;
  private final List<LapData> lapData;
  
  public LapPacket(byte[] dataBytes) {
    List<Byte> data = DataConverter.getListOfBytes(dataBytes);
    this.packetHeader = new PacketHeader(data.subList(0, 24));
    this.lapData = new ArrayList<>();
    for(int i = 1; i < 23; i++){
      int from = 24 + ((i-1)*53);
      int to = 24 + (i * 53);
      this.lapData.add(new LapData(data.subList(from, to)));
    }
    
  }


  public PacketHeader getPacketHeader()
  {
    return packetHeader;
  }


  public List<LapData> getLapData ()
  {
    return lapData;
  }
  
}
