package cn.spark2fire.edu.datastructure.easy.string;

public class BruteForce {

    public int matches(MyStr str, MyStr pattern) {
        int idx = -1;
        for (int i = 0; i < str.getLength(); i++) {
            int j;
            for (j = 0; j < pattern.getLength(); j++) {
                if (str.array[i + j] != pattern.array[j]) {
                    break;
                }
            }
            if (j == pattern.getLength()) {
                idx = j;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        MyStr str1 = new MyStr("ajdifasasdgyhcvpdhag".toCharArray());
        MyStr str2 = new MyStr("asdgyhcv".toCharArray());
        BruteForce bruteForce = new BruteForce();
        System.out.println(bruteForce.matches(str1, str2));
    }
}
