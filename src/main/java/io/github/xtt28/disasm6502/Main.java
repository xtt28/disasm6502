package io.github.xtt28.disasm6502;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.github.xtt28.disasm6502.decoder.ProgramDecoder;

public class Main {
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("error: expected filename");
            return;
        }

        final var fileName = args[0];
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(Paths.get(fileName));
        } catch (final FileNotFoundException ex) {
            System.err.println("error: file not found");
            return;
        } catch (final IOException ex) {
            ex.printStackTrace();
            return;
        }

        final var decoder = new ProgramDecoder(bytes);
        while (decoder.hasNextInsn()) {
            final var insn = decoder.getNextInsn();
            System.out.println(insn.toString());
        }
    }
}
