package cn.spark2fire.edu.datastructure.standard.string;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
// 这是最简单暴力的方法
/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class BruteForce {
    // 如果匹配, 就会返回匹配的第一个字符位置; 否则返回-1
    public int matches(String content, String pattern) {
        //主串的起始点
        int i = 0;
        //模式串的起始点
        int j = 0;
        // 保存当前主串的起始点
        int k = i;

        while (i < content.length() && j < pattern.length()) {
            if (content.charAt(i) == pattern.charAt(j)) {
                // 如果相同, 则比对下一个字符
                i++;
                j++;
            } else {
                // 如果不匹配, 模式串回退到0, 而主串从上一个起始点+1
                j = 0;
                i = ++k;
            }
        }
        if (j == pattern.length()) {
            return k;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        BruteForce bruteForce = new BruteForce();

        System.out.println(bruteForce.matches("adfdbasdgadbothasdag", "adkbot"));
    }
}
