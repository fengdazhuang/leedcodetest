package com.fzz.easy;

import java.util.Arrays;

public class Test242 {

}


/**
 * 方法有两种：
 * 方法一：将两个字符串排序再转化为字符串比较是否相等
 * 方法二：用容量为26的数组或map存储字母出现的个数，遍历时s中出现的字母数量加1，t中出现的字母数量减一
 */
class Solution242 {

    //方法一：排序法
    public boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        return Arrays.toString(sCharArray).equals(Arrays.toString(tCharArray));

    }

    //方法二：计数法，效率更高
    public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] nums=new int[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            nums[ss[i]-'a']+=1;
            nums[tt[i]-'a']-=1;
        }
        for (int num : nums) {
            if (num < 0) return false;
        }
        return true;

    }
}