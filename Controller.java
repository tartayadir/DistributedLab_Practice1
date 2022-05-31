package HEX2DEC;

import java.math.BigInteger;
import java.util.Scanner;

public class Controller {

    public static String readNumberFromConsole(){

        String number;
        System.out.print("Enter number in HEX : ");
        number =  new Scanner(System.in).nextLine();
        System.out.println("Number byte length : " + countLengthBit(number));
        return number;
    }

    public static int countLengthBit(String hexNumber){
        return (hexNumber.length()-2)/2;
    }

    public static String HEXToBigEndian(String hexNumber){

        return new BigInteger(hexNumber.substring(2), 16).toString();
    }

    public static String HEXToLittleEndian(String hexNumber){
        return new BigInteger(new StringBuilder(hexNumber.substring(2)).reverse().toString(), 16).toString();
    }

    public static String LittleEndianToHEX(String littleEndianNumber, int bitLength){

        StringBuilder hexNumber = new StringBuilder(new BigInteger(littleEndianNumber).toString(16));
        int k = hexNumber.length();
        for (int i = 0;i < (bitLength * 2 ) - k; i++){
            hexNumber.append("0");
        }
        return "0x" + hexNumber;
    }
    public static String BigEndianToHEX(String bigEndianNumber){
        return "0x" + new BigInteger(bigEndianNumber).toString(16);
    }
}
