package io.github.xtt28.disasm6502.decoder;

import java.util.ArrayList;
import java.util.List;

import io.github.xtt28.disasm6502.insn.Insn;
import io.github.xtt28.disasm6502.insn.Opcode;

public final class ProgramDecoder {

    private final byte[] programBytes;
    private int readIndex = 0;

    public ProgramDecoder(final byte[] programBytes) {
        this.programBytes = programBytes;
    }

    public Insn getNextInsn() {
        final List<Byte> insnArgBytes = new ArrayList<>(2);
        final var opcodeNum = programBytes[readIndex++];
        final var opcode = Opcode.fromRaw(opcodeNum);

        for (var i = 0; i < opcode.getAddressingMode().length(); i++)
            insnArgBytes.add(programBytes[readIndex++]);

        final var insn = InsnDecoder.decode(opcode, insnArgBytes);
        return insn;
    }

    public boolean hasNextInsn() {
        return this.readIndex < this.programBytes.length;
    }
}
