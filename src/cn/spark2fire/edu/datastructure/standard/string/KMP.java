package cn.spark2fire.edu.datastructure.standard.string;

/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class KMP {

    /**
     * abcabg, 前缀子串为["a", "ab", "abc", "abca", "abcab"], 后缀子串为["bcabg", "cabg", "abg", "bg", "g"]
     * next数组中储存的是这个字符串前缀和后缀中相同字符串的最长长度。比如abcdefgabc，前缀和后缀相同的是abc，长度是3。
     * <p>
     * next[i]储存的是string中前i+1位字符串前缀和后缀的最长长度。如abadefg，next[2]存的是aba这个字符串前缀和后缀的最长长度。
     */
    private int[] next;

    public int matches(String content, String pattern) {
        calculateNext(pattern);
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
            } else if (j > 0) {
                // 如果不匹配, 则一口气移动多个位置
                j = next[j];
            } else {
                i = ++k;
            }
        }
        if (j == pattern.length()) {
            return k;
        } else {
            return -1;
        }
    }

    /**
     * 如何快速计算出next数组是关键
     */
    private void calculateNext(String pattern) {
        next = new int[pattern.length()];
        int i = 1;
        int current = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(current)) {
                current++;
                next[i] = current;
                i++;
            } else if (current != 0) {
                current = next[current - 1];
            } else {
                i++;
                next[i] = current;
            }
        }
    }
}
