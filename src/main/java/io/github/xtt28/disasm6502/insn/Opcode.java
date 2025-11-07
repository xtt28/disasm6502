package io.github.xtt28.disasm6502.insn;

import java.util.HashMap;
import java.util.Map;

import io.github.xtt28.disasm6502.address.AddressingMode;

public enum Opcode {

    // 0x00-0x1F
    BRK(Mnemonic.BRK, 0x00, AddressingMode.IMPLIED),
    ORA_INDIRECT_X(Mnemonic.ORA, 0x01, AddressingMode.INDEXED_INDIRECT),
    ORA_ZERO_PAGE(Mnemonic.ORA, 0x05, AddressingMode.ZERO_PAGE),
    ASL_ZERO_PAGE(Mnemonic.ASL, 0x06, AddressingMode.ZERO_PAGE),
    PHP(Mnemonic.PHP, 0x08, AddressingMode.IMPLIED),
    ORA_IMMEDIATE(Mnemonic.ORA, 0x09, AddressingMode.IMMEDIATE),
    ASL_ACCUMULATOR(Mnemonic.ASL, 0x0A, AddressingMode.ACCUMULATOR),
    ORA_ABSOLUTE(Mnemonic.ORA, 0x0D, AddressingMode.ABSOLUTE),
    ASL_ABSOLUTE(Mnemonic.ASL, 0x0E, AddressingMode.ABSOLUTE),
    BPL(Mnemonic.BPL, 0x10, AddressingMode.RELATIVE),
    ORA_INDIRECT_Y(Mnemonic.ORA, 0x11, AddressingMode.INDIRECT_INDEXED),
    ORA_ZERO_PAGE_X(Mnemonic.ORA, 0x15, AddressingMode.ZERO_PAGE_INDEXED_X),
    ASL_ZERO_PAGE_X(Mnemonic.ASL, 0x16, AddressingMode.ZERO_PAGE_INDEXED_X),
    CLC(Mnemonic.CLC, 0x18, AddressingMode.IMPLIED),
    ORA_ABSOLUTE_Y(Mnemonic.ORA, 0x19, AddressingMode.ABSOLUTE_INDEXED_Y),
    ORA_ABSOLUTE_X(Mnemonic.ORA, 0x1D, AddressingMode.ABSOLUTE_INDEXED_X),
    ASL_ABSOLUTE_X(Mnemonic.ASL, 0x1E, AddressingMode.ABSOLUTE_INDEXED_X),

    // 0x20-0x3F
    JSR(Mnemonic.JSR, 0x20, AddressingMode.ABSOLUTE),
    AND_INDIRECT_X(Mnemonic.AND, 0x21, AddressingMode.INDEXED_INDIRECT),
    BIT_ZERO_PAGE(Mnemonic.BIT, 0x24, AddressingMode.ZERO_PAGE),
    AND_ZERO_PAGE(Mnemonic.AND, 0x25, AddressingMode.ZERO_PAGE),
    ROL_ZERO_PAGE(Mnemonic.ROL, 0x26, AddressingMode.ZERO_PAGE),
    PLP(Mnemonic.PLP, 0x28, AddressingMode.IMPLIED),
    AND_IMMEDIATE(Mnemonic.AND, 0x29, AddressingMode.IMMEDIATE),
    ROL_ACCUMULATOR(Mnemonic.ROL, 0x2A, AddressingMode.ACCUMULATOR),
    BIT_ABSOLUTE(Mnemonic.BIT, 0x2C, AddressingMode.ABSOLUTE),
    AND_ABSOLUTE(Mnemonic.AND, 0x2D, AddressingMode.ABSOLUTE),
    ROL_ABSOLUTE(Mnemonic.ROL, 0x2E, AddressingMode.ABSOLUTE),
    BMI(Mnemonic.BMI, 0x30, AddressingMode.RELATIVE),
    AND_INDIRECT_Y(Mnemonic.AND, 0x31, AddressingMode.INDIRECT_INDEXED),
    AND_ZERO_PAGE_X(Mnemonic.AND, 0x35, AddressingMode.ZERO_PAGE_INDEXED_X),
    ROL_ZERO_PAGE_X(Mnemonic.ROL, 0x36, AddressingMode.ZERO_PAGE_INDEXED_X),
    SEC(Mnemonic.SEC, 0x38, AddressingMode.IMPLIED),
    AND_ABSOLUTE_Y(Mnemonic.AND, 0x39, AddressingMode.ABSOLUTE_INDEXED_Y),
    AND_ABSOLUTE_X(Mnemonic.AND, 0x3D, AddressingMode.ABSOLUTE_INDEXED_X),
    ROL_ABSOLUTE_X(Mnemonic.ROL, 0x3E, AddressingMode.ABSOLUTE_INDEXED_X),

    // 0x40-0x5F
    RTI(Mnemonic.RTI, 0x40, AddressingMode.IMPLIED),
    EOR_INDIRECT_X(Mnemonic.EOR, 0x41, AddressingMode.INDEXED_INDIRECT),
    EOR_ZERO_PAGE(Mnemonic.EOR, 0x45, AddressingMode.ZERO_PAGE),
    LSR_ZERO_PAGE(Mnemonic.LSR, 0x46, AddressingMode.ZERO_PAGE),
    PHA(Mnemonic.PHA, 0x48, AddressingMode.IMPLIED),
    EOR_IMMEDIATE(Mnemonic.EOR, 0x49, AddressingMode.IMMEDIATE),
    LSR_ACCUMULATOR(Mnemonic.LSR, 0x4A, AddressingMode.ACCUMULATOR),
    JMP_ABSOLUTE(Mnemonic.JMP, 0x4C, AddressingMode.ABSOLUTE),
    EOR_ABSOLUTE(Mnemonic.EOR, 0x4D, AddressingMode.ABSOLUTE),
    LSR_ABSOLUTE(Mnemonic.LSR, 0x4E, AddressingMode.ABSOLUTE),
    BVC(Mnemonic.BVC, 0x50, AddressingMode.RELATIVE),
    EOR_INDIRECT_Y(Mnemonic.EOR, 0x51, AddressingMode.INDIRECT_INDEXED),
    EOR_ZERO_PAGE_X(Mnemonic.EOR, 0x55, AddressingMode.ZERO_PAGE_INDEXED_X),
    LSR_ZERO_PAGE_X(Mnemonic.LSR, 0x56, AddressingMode.ZERO_PAGE_INDEXED_X),
    CLI(Mnemonic.CLI, 0x58, AddressingMode.IMPLIED),
    EOR_ABSOLUTE_Y(Mnemonic.EOR, 0x59, AddressingMode.ABSOLUTE_INDEXED_Y),
    EOR_ABSOLUTE_X(Mnemonic.EOR, 0x5D, AddressingMode.ABSOLUTE_INDEXED_X),
    LSR_ABSOLUTE_X(Mnemonic.LSR, 0x5E, AddressingMode.ABSOLUTE_INDEXED_X),

    // 0x60-0x7F
    RTS(Mnemonic.RTS, 0x60, AddressingMode.IMPLIED),
    ADC_INDIRECT_X(Mnemonic.ADC, 0x61, AddressingMode.INDEXED_INDIRECT),
    ADC_ZERO_PAGE(Mnemonic.ADC, 0x65, AddressingMode.ZERO_PAGE),
    ROR_ZERO_PAGE(Mnemonic.ROR, 0x66, AddressingMode.ZERO_PAGE),
    PLA(Mnemonic.PLA, 0x68, AddressingMode.IMPLIED),
    ADC_IMMEDIATE(Mnemonic.ADC, 0x69, AddressingMode.IMMEDIATE),
    ROR_ACCUMULATOR(Mnemonic.ROR, 0x6A, AddressingMode.ACCUMULATOR),
    JMP_INDIRECT(Mnemonic.JMP, 0x6C, AddressingMode.INDIRECT_ABSOLUTE),
    ADC_ABSOLUTE(Mnemonic.ADC, 0x6D, AddressingMode.ABSOLUTE),
    ROR_ABSOLUTE(Mnemonic.ROR, 0x6E, AddressingMode.ABSOLUTE),
    BVS(Mnemonic.BVS, 0x70, AddressingMode.RELATIVE),
    ADC_INDIRECT_Y(Mnemonic.ADC, 0x71, AddressingMode.INDIRECT_INDEXED),
    ADC_ZERO_PAGE_X(Mnemonic.ADC, 0x75, AddressingMode.ZERO_PAGE_INDEXED_X),
    ROR_ZERO_PAGE_X(Mnemonic.ROR, 0x76, AddressingMode.ZERO_PAGE_INDEXED_X),
    SEI(Mnemonic.SEI, 0x78, AddressingMode.IMPLIED),
    ADC_ABSOLUTE_Y(Mnemonic.ADC, 0x79, AddressingMode.ABSOLUTE_INDEXED_Y),
    ADC_ABSOLUTE_X(Mnemonic.ADC, 0x7D, AddressingMode.ABSOLUTE_INDEXED_X),
    ROR_ABSOLUTE_X(Mnemonic.ROR, 0x7E, AddressingMode.ABSOLUTE_INDEXED_X),

    // 0x80-0x9F
    STA_INDIRECT_X(Mnemonic.STA, 0x81, AddressingMode.INDEXED_INDIRECT),
    STY_ZERO_PAGE(Mnemonic.STY, 0x84, AddressingMode.ZERO_PAGE),
    STA_ZERO_PAGE(Mnemonic.STA, 0x85, AddressingMode.ZERO_PAGE),
    STX_ZERO_PAGE(Mnemonic.STX, 0x86, AddressingMode.ZERO_PAGE),
    DEY(Mnemonic.DEY, 0x88, AddressingMode.IMPLIED),
    TXA(Mnemonic.TXA, 0x8A, AddressingMode.IMPLIED),
    STY_ABSOLUTE(Mnemonic.STY, 0x8C, AddressingMode.ABSOLUTE),
    STA_ABSOLUTE(Mnemonic.STA, 0x8D, AddressingMode.ABSOLUTE),
    STX_ABSOLUTE(Mnemonic.STX, 0x8E, AddressingMode.ABSOLUTE),
    BCC(Mnemonic.BCC, 0x90, AddressingMode.RELATIVE),
    STA_INDIRECT_Y(Mnemonic.STA, 0x91, AddressingMode.INDIRECT_INDEXED),
    STY_ZERO_PAGE_X(Mnemonic.STY, 0x94, AddressingMode.ZERO_PAGE_INDEXED_X),
    STA_ZERO_PAGE_X(Mnemonic.STA, 0x95, AddressingMode.ZERO_PAGE_INDEXED_X),
    STX_ZERO_PAGE_Y(Mnemonic.STX, 0x96, AddressingMode.ZERO_PAGE_INDEXED_Y),
    TYA(Mnemonic.TYA, 0x98, AddressingMode.IMPLIED),
    STA_ABSOLUTE_Y(Mnemonic.STA, 0x99, AddressingMode.ABSOLUTE_INDEXED_Y),
    TXS(Mnemonic.TXS, 0x9A, AddressingMode.IMPLIED),
    STA_ABSOLUTE_X(Mnemonic.STA, 0x9D, AddressingMode.ABSOLUTE_INDEXED_X),

    // OxA0-0xBF
    LDY_IMMEDIATE(Mnemonic.LDY, 0xA0, AddressingMode.IMMEDIATE),
    LDA_INDIRECT_X(Mnemonic.LDA, 0xA1, AddressingMode.INDEXED_INDIRECT),
    LDX_IMMEDIATE(Mnemonic.LDX, 0xA2, AddressingMode.IMMEDIATE),
    LDY_ZERO_PAGE(Mnemonic.LDY, 0xA4, AddressingMode.ZERO_PAGE),
    LDA_ZERO_PAGE(Mnemonic.LDA, 0xA5, AddressingMode.ZERO_PAGE),
    LDX_ZERO_PAGE(Mnemonic.LDX, 0xA6, AddressingMode.ZERO_PAGE),
    TAY(Mnemonic.TAY, 0xA8, AddressingMode.IMPLIED),
    LDA_IMMEDIATE(Mnemonic.LDA, 0xA9, AddressingMode.IMMEDIATE),
    TAX(Mnemonic.TAX, 0xAA, AddressingMode.IMPLIED),
    LDY_ABSOLUTE(Mnemonic.LDY, 0xAC, AddressingMode.ABSOLUTE),
    LDA_ABSOLUTE(Mnemonic.LDA, 0xAD, AddressingMode.ABSOLUTE),
    LDX_ABSOLUTE(Mnemonic.LDX, 0xAE, AddressingMode.ABSOLUTE),
    BCS(Mnemonic.BCS, 0xB0, AddressingMode.RELATIVE),
    LDA_INDIRECT_Y(Mnemonic.LDA, 0xB1, AddressingMode.INDIRECT_INDEXED),
    LDY_ZERO_PAGE_X(Mnemonic.LDY, 0xB4, AddressingMode.ZERO_PAGE_INDEXED_X),
    LDA_ZERO_PAGE_X(Mnemonic.LDA, 0xB5, AddressingMode.ZERO_PAGE_INDEXED_X),
    LDX_ZERO_PAGE_Y(Mnemonic.LDX, 0xB6, AddressingMode.ZERO_PAGE_INDEXED_Y),
    CLV(Mnemonic.CLV, 0xB8, AddressingMode.IMPLIED),
    LDA_ABSOLUTE_Y(Mnemonic.LDA, 0xB9, AddressingMode.ABSOLUTE_INDEXED_Y),
    TSX(Mnemonic.TSX, 0xBA, AddressingMode.IMPLIED),
    LDY_ABSOLUTE_X(Mnemonic.LDY, 0xBC, AddressingMode.ABSOLUTE_INDEXED_X),
    LDA_ABSOLUTE_X(Mnemonic.LDA, 0xBD, AddressingMode.ABSOLUTE_INDEXED_X),
    LDX_ABSOLUTE_Y(Mnemonic.LDX, 0xBE, AddressingMode.ABSOLUTE_INDEXED_Y),

    // 0xC0-0xDF
    CPY_IMMEDIATE(Mnemonic.CPY, 0xC0, AddressingMode.IMMEDIATE),
    CMP_INDIRECT_X(Mnemonic.CMP, 0xC1, AddressingMode.INDEXED_INDIRECT),
    CPY_ZERO_PAGE(Mnemonic.CPY, 0xC4, AddressingMode.ZERO_PAGE),
    CMP_ZERO_PAGE(Mnemonic.CMP, 0xC5, AddressingMode.ZERO_PAGE),
    DEC_ZERO_PAGE(Mnemonic.DEC, 0xC6, AddressingMode.ZERO_PAGE),
    INY(Mnemonic.INY, 0xC8, AddressingMode.IMPLIED),
    CMP_IMMEDIATE(Mnemonic.CMP, 0xC9, AddressingMode.IMMEDIATE),
    DEX(Mnemonic.DEX, 0xCA, AddressingMode.IMPLIED),
    CPY_ABSOLUTE(Mnemonic.CPY, 0xCC, AddressingMode.ABSOLUTE),
    CMP_ABSOLUTE(Mnemonic.CMP, 0xCD, AddressingMode.ABSOLUTE),
    DEC_ABSOLUTE(Mnemonic.DEC, 0xCE, AddressingMode.ABSOLUTE),
    BNE(Mnemonic.BNE, 0xD0, AddressingMode.RELATIVE),
    CMP_INDIRECT_Y(Mnemonic.CMP, 0xD1, AddressingMode.INDIRECT_INDEXED),
    CMP_ZERO_PAGE_X(Mnemonic.CMP, 0xD5, AddressingMode.ZERO_PAGE_INDEXED_X),
    DEC_ZERO_PAGE_X(Mnemonic.DEC, 0xD6, AddressingMode.ZERO_PAGE_INDEXED_X),
    CLD(Mnemonic.CLD, 0xD8, AddressingMode.IMPLIED),
    CMP_ABSOLUTE_Y(Mnemonic.CMP, 0xD9, AddressingMode.ABSOLUTE_INDEXED_Y),
    CMP_ABSOLUTE_X(Mnemonic.CMP, 0xDD, AddressingMode.ABSOLUTE_INDEXED_X),
    DEC_ABSOLUTE_X(Mnemonic.DEC, 0xDE, AddressingMode.ABSOLUTE_INDEXED_X),

    // 0xE0-0xFF
    CPX_IMMEDIATE(Mnemonic.CPX, 0xE0, AddressingMode.IMMEDIATE),
    SBC_INDIRECT_X(Mnemonic.SBC, 0xE1, AddressingMode.INDEXED_INDIRECT),
    CPX_ZERO_PAGE(Mnemonic.CPX, 0xE4, AddressingMode.ZERO_PAGE),
    SBC_ZERO_PAGE(Mnemonic.SBC, 0xE5, AddressingMode.ZERO_PAGE),
    INC_ZERO_PAGE(Mnemonic.INC, 0xE6, AddressingMode.ZERO_PAGE),
    INX(Mnemonic.INX, 0xE8, AddressingMode.IMPLIED),
    SBC_IMMEDIATE(Mnemonic.SBC, 0xE9, AddressingMode.IMMEDIATE),
    NOP(Mnemonic.NOP, 0xEA, AddressingMode.IMPLIED),
    CPX_ABSOLUTE(Mnemonic.CPX, 0xEC, AddressingMode.ABSOLUTE),
    SBC_ABSOLUTE(Mnemonic.SBC, 0xED, AddressingMode.ABSOLUTE),
    INC_ABSOLUTE(Mnemonic.INC, 0xEE, AddressingMode.ABSOLUTE),
    BEQ(Mnemonic.BEQ, 0xF0, AddressingMode.RELATIVE),
    SBC_INDIRECT_Y(Mnemonic.SBC, 0xF1, AddressingMode.INDIRECT_INDEXED),
    SBC_ZERO_PAGE_X(Mnemonic.SBC, 0xF5, AddressingMode.ZERO_PAGE_INDEXED_X),
    INC_ZERO_PAGE_X(Mnemonic.INC, 0xF6, AddressingMode.ZERO_PAGE_INDEXED_X),
    SED(Mnemonic.SED, 0xF8, AddressingMode.IMPLIED),
    SBC_ABSOLUTE_Y(Mnemonic.SBC, 0xF9, AddressingMode.ABSOLUTE_INDEXED_Y),
    SBC_ABSOLUTE_X(Mnemonic.SBC, 0xFD, AddressingMode.ABSOLUTE_INDEXED_X),
    INC_ABSOLUTE_X(Mnemonic.INC, 0xFE, AddressingMode.ABSOLUTE_INDEXED_X);

    private final Mnemonic mnemonic;
    private final byte opcodeNum;
    private final AddressingMode addressingMode;

    private static final Map<Byte, Opcode> byteOpcodeLut = new HashMap<>();

    static {
        for (final var opcode : Opcode.values())
            byteOpcodeLut.put(opcode.getOpcodeNum(), opcode);
    }

    public static Opcode fromRaw(final byte opcodeNum) {
        return byteOpcodeLut.get(opcodeNum);
    }
    
    Opcode(final Mnemonic mnemonic, final byte opcodeNum, final AddressingMode addressingMode) {
        this.mnemonic = mnemonic;
        this.opcodeNum = opcodeNum;
        this.addressingMode = addressingMode;
    }

    Opcode(final Mnemonic mnemonic, final int opcodeNum, final AddressingMode addressingMode) {
        this(mnemonic, (byte) opcodeNum, addressingMode);
    }

    public final Mnemonic getMnemonic() {
        return this.mnemonic;
    }

    public final byte getOpcodeNum() {
        return this.opcodeNum;
    }

    public final AddressingMode getAddressingMode() {
        return this.addressingMode;
    }
}
