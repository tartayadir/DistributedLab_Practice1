package HEX2DEC;

import static HEX2DEC.Controller.*;

public class Main {

    public static void main(String[] args) {

        String hexNumber = Controller.readNumberFromConsole();
        System.out.println("Number in Big Endian : " + HEXToBigEndian(hexNumber));
        System.out.println("Number in Little Endian : " + HEXToLittleEndian(hexNumber));
        System.out.println("Big Endian to hex number :    " + BigEndianToHEX(HEXToBigEndian(hexNumber)));
        System.out.println("Little Endian to hex number : " +
                LittleEndianToHEX(HEXToLittleEndian(hexNumber), countLengthBit(hexNumber)));
    }
}
