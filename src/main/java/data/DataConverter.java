/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author kager
 */
public class DataConverter
{
  public static List<Byte> getListOfBytes(byte[] data) {
    List<Byte> arrays = new ArrayList<Byte>();
    for(int i = 0; i < data.length; i++) {
      arrays.add(data[i]);
    }
    return arrays;
  }
  
  public static int convertUint16(List<Byte> data, int offset) {
    byte[] array = new byte[2];
    array[1] = data.get(offset);
    array[0] = data.get(offset + 1);
    return convertToInt(array);
  }
  
  private static int convertToInt(byte[] array) {
    ByteBuffer buffer = ByteBuffer.wrap(array);
    return Short.toUnsignedInt(buffer.getShort());
  }
  
  public static int convertUint8(Byte b) {
    return (int) Integer.toUnsignedLong(b);
  }
  
  public static int convertInt8(Byte b) {
    return (int) b;
  }
  
  public static BigInteger convertUint64(List<Byte> data, int offset) {
    byte[] array = new byte[8];
    array[7] = data.get(offset);
    array[6] = data.get(offset + 1);
    array[5] = data.get(offset + 2);
    array[4] = data.get(offset + 3);
    array[3] = data.get(offset + 4);
    array[2] = data.get(offset + 5);
    array[1] = data.get(offset + 6);
    array[0] = data.get(offset + 7);
    return new BigInteger(array);
  }
  
  public static float convertFloat(List<Byte> data, int offset) {
    byte[] array = new byte[4];
    array[0] = data.get(offset);
    array[1] = data.get(offset + 1);
    array[2] = data.get(offset + 2);
    array[3] = data.get(offset + 3);
    return convertByteArrayToFloat(array);
  }
  
  private static float convertByteArrayToFloat(byte[] b) {
    return ByteBuffer.wrap(b, 0, 4).order(ByteOrder.LITTLE_ENDIAN).getFloat();
  }
  
  public static long convertUint(List<Byte> data, int offset) {
    byte[] array = new byte[4];
    array[3] = data.get(offset);
    array[2] = data.get(offset + 1);
    array[1] = data.get(offset + 2);
    array[0] = data.get(offset + 3);
    return bytesToLong(array);
  } 
  
  private static long bytesToLong(byte[] bytes) {
    ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
    buffer.put(bytes);
    buffer.flip();//need flip 
    return 0; // TODO fix
  }


  public float convertByteArrayToFloat(byte[] b, int offset) {
    return ByteBuffer.wrap(b, offset, 4).order(ByteOrder.LITTLE_ENDIAN).getFloat();
  }


  public static int byteArrayToInt(byte[] b, int offset)
  {
    int value = 0;
    for (int i = offset; i < offset + 4; i++) {
      int shift = (4 - 1 - i) * 8;
      value += (b[i] & 0x000000FF) << shift;
    }
    return value;
  }

  public static short byteArrayToShort(byte[] b, int offset)
  {
    short value = 0;
    for (int i = offset; i < offset + 2; i++) {
      int shift = (4 - 1 - i) * 8;
      value += (b[i] & 0x000000FF) << shift;
    }
    return value;
  }

  public static int convertToShort(byte[] array) {
    ByteBuffer buffer = ByteBuffer.wrap(array);
    return Short.toUnsignedInt(buffer.getShort());
  }

}
