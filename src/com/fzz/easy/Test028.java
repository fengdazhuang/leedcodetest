package com.fzz.easy;

public class Test028 {
}


/**
 * 方法很多：
 * 1）暴力法，可以直接遍历
 * 2）kmp算法，经典字符串匹配算法
 * 3）api调用大法
 */
class Solution028 {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length(),len2 = needle.length();
        int i = 0, j = 0,count = 0,pre = 0;
        while(true){
            if(j == len2) return pre;
            if(i == len1) return -1;
            char c1 = haystack.charAt(i);
            char c2 = needle.charAt(j);
            if(c1 == c2){
                if(count == 0){
                    pre = i;
                    count++;
                }
                i++;
                j++;
            }else{
                if(count != 0){
                    i = pre;
                }
                i++;
                j = 0;
                count = 0;
            }
        }
    }
}
