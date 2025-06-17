package com.fzz.way1.贪心算法;

import java.util.*;

public class Test763 {
    public static void main(String[] args) {
        String s="ababcbacadefegdehijhklij";
        List<Integer> list = new Solution763().partitionLabels(s);
        for(Integer i:list){
            System.out.print("["+i+"]"+" ");
        }
    }
}

class Solution763 {
    public List<Integer> partitionLabels(String s) {
        /*List<Integer> list=new ArrayList<>();
        int[][] temp=new int[26][1];
        int group=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(map.containsKey(ch)){
                Integer charGroup = map.get(ch);
                int sum=0;
                for(int j=charGroup;j<group;j++){
                    sum+=list.get(j);
                }
                list.set(charGroup,sum);
            }else{
                map.put(ch,group);
                list.add(1);
                group++;
            }
        }*/
        int[] last=new int[26];
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a']=i;
        }
        int start=0,end=0;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            end=Math.max(end,last[s.charAt(i)-'a']);
            if(i==end){
                list.add(end-start+1);
                start=end+1;

            }

        }
        return list;

    }
}
