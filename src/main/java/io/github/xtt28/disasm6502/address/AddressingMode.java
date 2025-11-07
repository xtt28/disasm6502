package io.github.xtt28.disasm6502.address;

public enum AddressingMode {
    IMMEDIATE(1),
    ABSOLUTE(2),
    ZERO_PAGE(1),
    ZERO_PAGE_INDEXED_X(1),
    ZERO_PAGE_INDEXED_Y(1),
    IMPLIED(0),
    INDIRECT_ABSOLUTE(2),
    ABSOLUTE_INDEXED_X(2),
    ABSOLUTE_INDEXED_Y(2),
    INDEXED_INDIRECT(1),
    INDIRECT_INDEXED(1),
    RELATIVE(1),
    ACCUMULATOR(0);

    private final int length;

    public final int length() {
        return this.length;
    }

    AddressingMode(int length) {
        this.length = length;
    }
}
