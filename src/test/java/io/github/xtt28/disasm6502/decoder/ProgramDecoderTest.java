package io.github.xtt28.disasm6502.decoder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProgramDecoderTest {

    @Test
    void testDecodeMultipleInsns() {
        // ASL $FA; PHA; ORA $04F3,X
        final var program = new byte[] { 0x06, (byte) 0xFA, 0x48, 0x1D, (byte) 0xF3, 0x04 };
        final var decoder = new ProgramDecoder(program);
        assertTrue(decoder.hasNextInsn());
        assertEquals("ASL $FA", decoder.getNextInsn().toString());
        assertTrue(decoder.hasNextInsn());
        assertEquals("PHA", decoder.getNextInsn().toString());
        assertTrue(decoder.hasNextInsn());
        assertEquals("ORA $04F3,X", decoder.getNextInsn().toString());
        assertFalse(decoder.hasNextInsn());
    }

    @Test
    void testDecodeEmptyProgram() {
        final var decoder = new ProgramDecoder(new byte[]{});
        assertFalse(decoder.hasNextInsn());
    }
}
