package LargeNumbers;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class ControllerAndView {

    public final static int[] bitArray = {8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
    public final static char[] stringArr =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static void crackKey(String key, int bitLength){

        char[] tempKeyArr = new char[bitLength/4];
        Arrays.fill(tempKeyArr, '0');
        char[] keyArr = key.toCharArray();

        int size = bitLength/4;//кол-во элементов
        int[] arr = new int[size];//массив для хранения текущего варианта множества
        outer: while(!Arrays.equals(tempKeyArr, keyArr)){//вечный цикл

            //вывод варианта множества на экран
            for(int index = 0; index < keyArr.length ; index++){
                tempKeyArr[index] =  stringArr[arr[index]];
            }

            int i = size - 1;//ставим курсов в самую правую ячейку
            while(arr[i] == stringArr.length - 1){//движемся влево, если ячейка переполнена
                arr[i] = 0;//записываем в ячейку 0, т.к. идет перенос разряда
                i--;//сдвиг влево
                //если перенос влево невозможен, значит перебор закончен
                if(i < 0)break outer;
            }
            arr[i]++;//увеличиваем значение ячейки на единицу
        }

    }

    public static void viewVariousKeysForAllBitLength(){

        for(int n : ControllerAndView.bitArray){
            System.out.println("Key in " + n + "-bit system : " + ControllerAndView.createKey(n));
        }
    }

    public static String createKey(int bitLength){
        Random r = new Random();
        StringBuilder stringBuffer = new StringBuilder();
        while(stringBuffer.length() < bitLength){
            stringBuffer.append(Integer.toHexString(r.nextInt()));
        }

        return stringBuffer.substring(0, bitLength/4).toUpperCase();
    }

    public static void viewCountNumberOfKeys(){

        for(int integer : bitArray){

            System.out.println("Number of keys that can be created in a "
                    + integer + "-bit system : " + countNumberOfKeys(integer));
        }
    }

    public static BigInteger countNumberOfKeys(int bitLength){

        BigInteger bigInteger = BigInteger.valueOf(2);
        return bigInteger.pow(bitLength);
    }

    public static void timeTestForEachBitLength(){

        Arrays.stream(bitArray).parallel().forEach(bitLength -> {

            long timeStart = 0, timeEnd = 0;
            String key;

            timeStart = System.currentTimeMillis();
            key = createKey(bitLength);
            crackKey(key, bitLength);
            timeEnd = System.currentTimeMillis();

            System.out.println(bitLength + "-bit key break time : " + (timeEnd - timeStart));
        });
    }
}