package io.github.xtt28.disasm6502.address;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {
    @Test
    void testImmediate() {
        assertEquals("#$F3", new Address(AddressingMode.IMMEDIATE, (short) 0xF3).toString());
    }

    @Test
    void testAbsolute() {
        assertEquals("$063F", new Address(AddressingMode.ABSOLUTE, (short) 0x063F).toString());
    }

    @Test
    void testAbsoluteIndexedX() {
        assertEquals("$063F,X", new Address(AddressingMode.ABSOLUTE_INDEXED_X, (short) 0x063F).toString());
    }

    @Test
    void testAbsoluteIndexedY() {
        assertEquals("$063F,Y", new Address(AddressingMode.ABSOLUTE_INDEXED_Y, (short) 0x063F).toString());
    }

    @Test
    void testZeroPage() {
        assertEquals("$3F", new Address(AddressingMode.ZERO_PAGE, (short) 0x3F).toString());
    }

    @Test
    void testZeroPageX() {
        assertEquals("$3F,X", new Address(AddressingMode.ZERO_PAGE_INDEXED_X, (short) 0x3F).toString());
    }

    @Test
    void testZeroPageY() {
        assertEquals("$3F,Y", new Address(AddressingMode.ZERO_PAGE_INDEXED_Y, (short) 0x3F).toString());
    }

    @Test
    void testAccumulator() {
        assertEquals("A", new Address(AddressingMode.ACCUMULATOR).toString());
    }

    @Test
    void testImplied() {
        assertEquals("", new Address(AddressingMode.IMPLIED).toString());
    }

    @Test
    void testRelative() {
        assertEquals("$03", new Address(AddressingMode.RELATIVE, (short) 3).toString());
        assertEquals("$EC", new Address(AddressingMode.RELATIVE, (short) -20).toString());
    }

    @Test
    void testIndirectAbsolute() {
        assertEquals("($063F)", new Address(AddressingMode.INDIRECT_ABSOLUTE, (short) 0x063F).toString());
    }

    @Test
    void testIndexedIndirect() {
        assertEquals("($3F,X)", new Address(AddressingMode.INDEXED_INDIRECT, (short) 0x3F).toString());
    }

    @Test
    void testIndirectIndexed() {
        assertEquals("($3F),Y", new Address(AddressingMode.INDIRECT_INDEXED, (short) 0x3F).toString());
    }
}
