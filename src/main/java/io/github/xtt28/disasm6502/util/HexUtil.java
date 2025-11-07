package io.github.xtt28.disasm6502.util;

public final class HexUtil {
    
    private HexUtil() {}

    public static String shortToHex(final short s) {
        final int unsigned = s & 0xFFFF;
        return String.format("$%04X", unsigned);
    }

    public static String shortToHexImm(final short s) {
        return "#" + shortToHex(s);
    }

    public static String byteToHex(final byte s) {
        return String.format("$%02X", s);
    }

    public static String byteToHexImm(final byte s) {
        return "#" + byteToHex(s);
    }
}
