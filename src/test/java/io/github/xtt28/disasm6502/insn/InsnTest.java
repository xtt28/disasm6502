package io.github.xtt28.disasm6502.insn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsnTest {
    
    @Test
    void testOraImmediate() {
        final var insn = new Insn(Opcode.ORA_IMMEDIATE, (short) 0x3F);
        assertEquals("ORA #$3F", insn.toString());
    }
}
