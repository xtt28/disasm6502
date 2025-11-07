package io.github.xtt28.disasm6502.decoder;

import java.util.List;

import io.github.xtt28.disasm6502.insn.Insn;
import io.github.xtt28.disasm6502.insn.Opcode;

public class InsnDecoder {

    private InsnDecoder() {
    }

    public static Insn decode(final List<Byte> insn) {
        if (insn.isEmpty())
            throw new IllegalArgumentException("Cannot decode empty instruction");

        final var opcode = Opcode.fromRaw(insn.getFirst());
        return decode(opcode, insn.subList(1, insn.size()));
    }

    public static Insn decode(final Opcode opcode, final List<Byte> args) {
        final var argLen = opcode.getAddressingMode().length();
        if (args.size() != argLen)
            throw new RuntimeException(String.format("Invalid insn argument size: expected %d bytes, got %d bytes for opcode %s",
                    argLen, args.size(), opcode.name()));
        
        switch (argLen) {
            case 0: return new Insn(opcode);
            case 1: return new Insn(opcode, args.getFirst());
            case 2: return new Insn(opcode, (short) (((args.getLast() & 0xFF) << 8) | (args.getFirst() & 0xFF)));
        }
        
        return null;
    }
}
