package com.fzz.medium;

import java.util.HashSet;
import java.util.Set;

public class Test003 {
}

/**
 * 思路：
 * 使用滑动窗口，每次将right+1的字符加入set中，如果set中存在该字符，则将left+1，直到set中不存在该字符，每次更新num
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int num=0;
        int len=s.length();
        int right=-1;
        Set<Character> set=new HashSet<>();
        for(int i=0;i<len;i++){
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while(right+1<len&&!set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                right++;
            }
            num=Math.max(num,right-i+1);
        }
        return num;
    }
}