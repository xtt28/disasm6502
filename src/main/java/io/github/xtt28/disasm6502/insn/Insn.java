package io.github.xtt28.disasm6502.insn;

import io.github.xtt28.disasm6502.address.Address;
import io.github.xtt28.disasm6502.address.AddressingMode;

public final class Insn {
    
    private final Mnemonic mnemonic;
    private Address address;

    public Insn(final Opcode opcode) {
        this.mnemonic = opcode.getMnemonic();
        this.address = new Address(opcode.getAddressingMode());
    }

    public Insn(final Opcode opcode, final Address address) {
        this(opcode);
        this.address = address;
    }

    public Insn(final Opcode opcode, final short addrValue) {
        this(opcode, new Address(opcode.getAddressingMode(), addrValue));
    }

    public final Mnemonic getMnemonic() {
        return this.mnemonic;
    }

    public final Address getAddress() {
        return this.address;
    }

    @Override
    public final String toString() {
        if (this.address.getAddressingMode() == AddressingMode.IMPLIED)
            return this.mnemonic.name();

        return this.mnemonic.name() + " " + this.address.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Insn))
            return false;

        final var other = (Insn) obj;
        return this.address.equals(other.address)
            && this.mnemonic == other.mnemonic;
    }
}
