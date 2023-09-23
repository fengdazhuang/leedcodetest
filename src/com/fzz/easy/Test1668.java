package com.fzz.easy;

import java.util.Arrays;

public class Test1668 {

    public static void main(String[] args) {
        String sequence="aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word="aaaba";
        int i = maxRepeating(sequence, word);
        System.out.println(i);
    }

    public static int maxRepeating(String sequence, String word) {
        int k=0;
        String temp=word;
        while(word.length()<=sequence.length()){
            int res=kmp(sequence,temp);
            if(res!=-1){
                k++;
                temp=temp+word;
            }else{
                return k;
            }
        }
        return k;
    }

    public static int kmp(String sequence,String word){
        int[] next=next(word);
        System.out.println(Arrays.toString(next));
        for(int i=0,j=0;i<sequence.length();i++){
            while(j>0&&sequence.charAt(i)!=word.charAt(j)){
                j=next[j-1];
            }
            if(sequence.charAt(i)==word.charAt(j)){
                j++;
            }
            if(j==word.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    public static int[] next(String str){
        int[] next=new int[str.length()];
        next[0]=0;
        for(int i=1,j=0;i<str.length();i++){
            while(j>0&&str.charAt(i)!=str.charAt(j)){
                j=next[j-1];
            }
            if(str.charAt(i)==str.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
