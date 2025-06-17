package com.fzz.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test205 {
    public boolean isIsomorphic(String s, String t) {
        //定义两个map，存储s->t和t->s的映射关系
        Map<Character,Character> map1 = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        int len=s.length();
        //遍历字符串
        for(int i=0;i<len;i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            //如果map1中存在c1，则判断c1对应的值是否等于c2，如果不等，则直接返回false
            if(map1.containsKey(c1)){
                if(map1.get(c1)!=c2) return false;
            }else{
                //map1中没有key-c1,如果map2中存在key-c2(已经有映射关系),则直接返回false
                if(map2.containsKey(c2)) return false;
                //双方都没有映射关系，进行映射关系存储
                map1.put(c1,c2);
                map2.put(c2,c1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Test205 test205 = new Test205();
//        System.out.println(test205.isIsomorphic("badc", "baba"));
        System.out.println(test205.isIsomorphic("aaeaa", "uuxyy"));
    }

}
