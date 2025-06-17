package com.fzz.easy;

import java.util.HashMap;
import java.util.Map;

public class Test383 {
    /**
     * 时间复杂度：O(n+m)=>O(n)
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int ranLen = ransomNote.length();
        int magLen = magazine.length();
        //ransomNote的长度大于magazine时不可能由magazine构成
        if(ranLen>magLen) return false;
        Map<Character, Integer> map = new HashMap<>();
        //初始化map
        for (int i = 0; i < magLen; i++) {
            char c = magazine.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        //遍历ransomNote，如果map中不存在ransomNote的字符或者字符数量为0，则直接返回false
        for (int j = 0; j < ranLen; j++) {
            char c = ransomNote.charAt(j);
            Integer integer = map.get(c);
            if(integer==null||integer==0){
                return false;
            }
            map.put(c,integer-1);
        }
        return true;
    }


    /**
     * 时间复杂度：O(n+N)=>O(n)
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        int ranLen = ransomNote.length();
        int magLen = magazine.length();
        if(ranLen>magLen) return false;
        Map<Character, Integer> map = new HashMap<>();
        //按照magazine的长度进行遍历
        for (int i = 0; i < magLen; i++) {
            //对map中magazine出现的字符进行数量+1
            char c1 = magazine.charAt(i);
            map.put(c1,map.getOrDefault(c1,0)+1);
            //对map中ransomNote出现的的字符进行数量-1
            //注意边界判断，指针到达ransomNote的长度时停止遍历
            if(i<ranLen){
                char c2 = ransomNote.charAt(i);
                map.put(c2,map.getOrDefault(c2,0)-1);
            }
        }
        for (Integer value : map.values()) {
            if(value<0)
                return false;
        }
        return true;

    }

    /**
     * 时间复杂度：O(n)
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct3(String ransomNote, String magazine) {
        int ranLen = ransomNote.length();
        int magLen = magazine.length();
        if (ranLen > magLen) return false;
        int[] temp = new int[26];
        for (char c : magazine.toCharArray()){
            temp[c-'a']++;
        }
        for (char c : ransomNote.toCharArray()){
            if(temp[c-'a']==0) return false;
            temp[c-'a']--;
        }
        return true;
    }
}
