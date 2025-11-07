# disasm6502

disasm6502 is a disassembler for the 6502 instruction set written in Java. It
converts compiled object code for the 6502 instruction set into standard 6502
assembly.

## Usage

### Build

```shell
./gradlew build # resulting jar file is in build/libs/disasm6502.jar
cp build/libs/disasm6502.jar . # copy compiled jar to project root
```

### Run

```shell
java -jar disasm6502.jar yourbinary.bin > result.txt # output written to result.txt
```

## Examples

See the [examples](examples/) directory for example object code files and their
respective disassemblies.

## License

This project (excluding example files provided in the examples/ folder) is
licensed under

    SPDX-License-Identifier: GPL-3.0-or-later

being in concordance with the terms found in the LICENSE file in the root of
this repository.

## Acknowledgements

The Snake example is taken from Nick Morgan's easy6502 website
(https://github.com/skilldrick/easy6502/blob/gh-pages/_includes/snake.html)
and licensed under a CC-BY 4.0 license.