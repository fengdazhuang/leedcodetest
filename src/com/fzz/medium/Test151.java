package com.fzz.medium;

import java.util.Stack;

public class Test151 {

    public static String reverseWords(String s) {
        StringBuilder stringBuilder=new StringBuilder();

        String s2 = s.trim();
        int index=s2.length()-1;
        StringBuilder temp=new StringBuilder();
        while(index>=0){
            if(s2.charAt(index)==' '){
                if(s2.charAt(index+1)!=' '){
                    String str = new StringBuilder(temp).reverse().toString();
                    stringBuilder.append(str);
                    stringBuilder.append(' ');
                    temp=new StringBuilder();
                }
            }else{
                temp.append(s2.charAt(index));
            }
            index--;
        }
        String str = new StringBuilder(temp).reverse().toString();
        stringBuilder.append(str);

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str="the sky is blue";
        System.out.println(reverseWords(str));
    }
}
