package com.fzz.easy;

import java.util.HashMap;
import java.util.Map;

public class Test290 {
}

/**
 * 思路：
 * 将字符串s按空格分割，之后进行遍历，将pattern中的字符和单词的映射关系存入map中，
 * 每次轮循环判断map中是否存在字符key，存在则比较value与对应单词是否相等
 */
class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if(strs.length!=pattern.length()) return false;
        Map<Character,String> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                String value = map.get(ch);
                if(!value.equals(strs[i])) return false;
            }else{
                if(map.containsValue(strs[i])) return false;
                map.put(ch,strs[i]);
            }
        }
        return true;
    }
}