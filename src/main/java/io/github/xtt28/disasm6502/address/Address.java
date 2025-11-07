package io.github.xtt28.disasm6502.address;

import io.github.xtt28.disasm6502.util.HexUtil;

public final class Address {

    private final AddressingMode addressingMode;
    private short addrValue;

    public Address(final AddressingMode addressingMode) {
        this.addressingMode = addressingMode;
    }

    public Address(final AddressingMode addressingMode, final short addrValue) {
        this(addressingMode);
        this.addrValue = addrValue;
    }

    public final AddressingMode getAddressingMode() {
        return this.addressingMode;
    }

    public final short getAddrValue() {
        return this.addrValue;
    }

    @Override
    public final String toString() {
        switch (this.addressingMode) {
            case ACCUMULATOR:
                return "A";
            case IMPLIED:
                return "";
            case IMMEDIATE:
                return HexUtil.byteToHexImm((byte) this.addrValue);
            case ZERO_PAGE:
                return HexUtil.byteToHex((byte) this.addrValue);
            case ZERO_PAGE_INDEXED_X:
                return HexUtil.byteToHex((byte) this.addrValue) + ",X";
            case ZERO_PAGE_INDEXED_Y:
                return HexUtil.byteToHex((byte) this.addrValue) + ",Y";
            case ABSOLUTE:
                return HexUtil.shortToHex(this.addrValue);
            case ABSOLUTE_INDEXED_X:
                return HexUtil.shortToHex(this.addrValue) + ",X";
            case ABSOLUTE_INDEXED_Y:
                return HexUtil.shortToHex(this.addrValue) + ",Y";
            case INDIRECT_ABSOLUTE:
                return "(" + HexUtil.shortToHex(this.addrValue) + ")";
            case INDEXED_INDIRECT:
                return "(" + HexUtil.byteToHex((byte) this.addrValue) + ",X)";
            case INDIRECT_INDEXED:
                return "(" + HexUtil.byteToHex((byte) this.addrValue) + "),Y";
            case RELATIVE:
                return HexUtil.byteToHex((byte) this.addrValue);
            default:
                return "";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Address))
            return false;
            
        final var other = (Address) obj;
        return this.addrValue == other.addrValue
                && this.addressingMode == other.addressingMode;
    }
}
