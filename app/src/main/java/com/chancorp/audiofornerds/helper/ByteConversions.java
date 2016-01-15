package com.chancorp.audiofornerds.helper;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by Chan on 2015-12-10.
 */
public class ByteConversions {
    public static short[] bytesToShorts(byte[] b){
        short[] shorts = new short[b.length/2];
    // to turn bytes to shorts as either big endian or little endian.
        ByteBuffer.wrap(b).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(shorts);
        return shorts;
    }
}
