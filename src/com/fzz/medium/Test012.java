package com.fzz.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Test012 {
    public static String intToRoman(int num) {
        //3749
        StringBuilder stringBuilder=new StringBuilder();
        int t=num/1000; //3
        appendToString(stringBuilder,'M',t);
        int m1=num%1000; //749
        int h=m1/100;  //7
        if(h==9){
            stringBuilder.append('C');
            stringBuilder.append('M');
        }else if(h==4){
            stringBuilder.append('C');
            stringBuilder.append('D');
        }else if(h<4){
            appendToString(stringBuilder,'C',h);
        }else{
            stringBuilder.append('D');
            appendToString(stringBuilder,'C',h-5);
        }
        int m2=m1%100;
        int s=m2/10;
        if(s==9){
            stringBuilder.append('X');
            stringBuilder.append('C');
        }else if(s==4){
            stringBuilder.append('X');
            stringBuilder.append('L');
        }else if(s<4){
            appendToString(stringBuilder,'X',s);
        }else{
            stringBuilder.append('L');
            appendToString(stringBuilder,'X',s-5);
        }

        int m3=m2%10;

        if(m3==9){
            stringBuilder.append('I');
            stringBuilder.append('X');
        }else if(m3==4){
            stringBuilder.append('I');
            stringBuilder.append('V');
        }else if(m3<4){
            appendToString(stringBuilder,'I',m3);
        }else{
            stringBuilder.append('V');
            appendToString(stringBuilder,'I',m3-5);
        }

        return stringBuilder.toString();

    }

    public static void appendToString(StringBuilder stringBuilder,char ch,int times){
        for(int i=0;i<times;i++){
            stringBuilder.append(ch);
        }
    }


    public static void main(String[] args) {
        String s = intToRoman(3999);
        System.out.println(s);
    }
}
