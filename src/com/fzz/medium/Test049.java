package com.fzz.medium;

import java.util.*;

public class Test049 {
}

/**
 * 思路：
 * 字母异位词所包含的字符及个数相同，则排序后相同。
 * 将排序后的字符串作为key存储到map中，value为对应的字母异位词，value为List集合
 */
class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key=Arrays.toString(charArray);
            List<String> list;
            if(map.containsKey(key)){
                list = map.get(key);
            }else{
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());

    }
}