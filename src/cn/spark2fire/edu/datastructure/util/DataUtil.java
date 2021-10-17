package cn.spark2fire.edu.datastructure.util;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Leon@cn.spark2fire
 * Date: 2021/8/19.
 * QQ Group: 493306318
 */
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class DataUtil {
    public static Integer genNumber(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }

    public static Integer[] genUniqueArray(int size, int range) {
        Set<Integer> set = new HashSet<>();
        while (set.size() < size) {
            set.add(genNumber(range));
        }
        Integer[] array = set.toArray(new Integer[size]);
        return array;
    }

    public static Integer[] genArray(int size, int range) {
        Integer[] result = new Integer[size];
        for (int i = 0; i < size; i++) {
            result[i] = genNumber(range);
        }
        return result;
    }

    public static String[] genStrArr(int size) {
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = getRandomString();
        }
        return result;
    }

    public static void printStrArr(String[] array) {
        for (String item : array) {
            System.out.printf("%7s", item);
        }
        System.out.println();
    }

    private static String getRandomString() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String number = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        int num = random.nextInt(26);
        sb.append(str.charAt(num));
        num = random.nextInt(10);
        sb.append(number.charAt(num));

        return sb.toString();
    }

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static void printArray(Integer[] array) {
        for (Integer item : array) {
            System.out.printf("%7d", item);
        }
        System.out.println();
    }

    public static void printArray(int[] array) {
        for (int item : array) {
            System.out.printf("%7d", item);
        }
        System.out.println();
    }

    public static void print2Array(int[][] array, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%7d", array[i][j]);
            }
            System.out.println();
        }
    }

    public static void printIndex(int size) {

        for (int i = 0; i < size; i++) {
            System.out.printf("%7d", i);
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print("-------");
        }
        System.out.println();
    }

    public static void printList(List<Integer> list) {
        for (Integer item : list) {
            System.out.printf("%7d", item);
        }
        System.out.println();
    }
}
