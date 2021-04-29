package cn.spark2fire.edu.datastructure.easy.string;

public class MyStr {
    public char array[];
    private int length = 0;

    public MyStr(char[] str) {
        this.array = str;
        length = str.length;
    }

    public MyStr(MyStr str) {
        array = str.array;
        length = str.length;
    }

    public int getLength() {
        return length;
    }

    public int compare(MyStr str) {
        int result = 0;
        for (int i = 0; i < length && i < str.length; i++) {
            if (array[i] > str.array[i]) {
                result = 1;
                break;
            } else if (array[i] < str.array[i]) {
                result = -1;
                break;
            }
        }
        return result;
    }

    public void append(MyStr str) {
        char[] temp = new char[length + str.getLength()];
        int j = 0;
        for (int i = 0; i < length; i++) {
            temp[j++] = array[i];
        }
        for (int i = 0; i < str.getLength(); i++) {
            temp[j++] = str.array[i];
        }
        array = temp;
    }

    public char[] subString(int start, int len) {
        char[] result = new char[len];

        for (int i = start; i < length && i < start + len; i++) {
            result[i - start] = array[i];
        }
        return result;
    }
}
