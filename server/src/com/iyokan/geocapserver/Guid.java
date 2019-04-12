package com.iyokan.geocapserver;

import java.util.Arrays;

public abstract class Guid {
    byte[] bytes;

    /**
     * Creates an empty guid
     */
    public Guid() {
        this.bytes = new byte[16];
    }

    /***
     * Creates a guid with the specified bytes
     * @param bytes bytes to use
     */
    public Guid(byte[] bytes) {
        if (bytes.length != 16) {
            throw new RuntimeException();
        }
        this.bytes = bytes;
    }

    public Guid(String string) {
        String s = string.replace("-", "");
        bytes = new byte[16];

        int len = s.length();
        for (int i = 0; i < len; i += 2) {
            bytes[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
    }

    public byte[] getBytes() {
        return bytes;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bytes);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Guid) {
            return equals((Guid)obj);
        }
        return false;
    }

    public boolean equals(Guid obj) {
        return Arrays.equals(obj.getBytes(), bytes);
    }

    @Override
    public String toString() {
        char[] str = new char[36];

        int index = 0;
        for (int i = 0; i < 16; i++) {
            if (i == 4 || i == 6 || i == 8 || i == 10) {
                str[index++] = '-';
            }

            byte val = bytes[i];

            byte val1 = (byte)(val >> 4);
            byte val2 = (byte)(val & 0xF);

            str[index++] = (char)((val1 > 9) ? ('A' + val1 - 10) : ('0' + val1));
            str[index++] = (char)((val2 > 9) ? ('A' + val2 - 10) : ('0' + val2));
        }

        return new String(str);
    }
}
