package com.fzz.easy;

import java.util.Arrays;
import java.util.Comparator;

public class Test014 {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder=new StringBuilder();
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        if(strs[strs.length-1].length()==0){
            return stringBuilder.toString();
        }
        for(int i=0;i<strs[0].length();i++){
            char temp=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=temp){
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        String[] str2={"ab", "a"};
        System.out.println(longestCommonPrefix(str2));

    }
}
