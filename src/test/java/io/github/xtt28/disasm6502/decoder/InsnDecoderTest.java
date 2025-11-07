package io.github.xtt28.disasm6502.decoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class InsnDecoderTest {
    
    @Test
    void testDecodeAslZeroPage() {
        final var insn = InsnDecoder.decode(List.of((byte)0x06, (byte)0xFA));
        assertEquals("ASL $FA", insn.toString());
    }

    @Test
    void testDecodeOraAbsoluteX() {
        final var insn = InsnDecoder.decode(List.of((byte)0x1D, (byte)0xF3, (byte)0x04));
        assertEquals("ORA $04F3,X", insn.toString());
    }
}
