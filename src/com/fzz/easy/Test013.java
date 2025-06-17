package com.fzz.easy;

public class Test013 {
    public int romanToInt(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(i==s.length()-1){
                res+=transToInt(ch);
            }else{
                char next = s.charAt(i + 1);
                if(ch=='I'&&(next=='V'||next=='X')){
                    res+=transToInt(next)-1;
                    i++;
                }else if(ch=='X'&&(next=='L'||next=='C')){
                    res+=transToInt(next)-10;
                    i++;
                }else if(ch=='C'&&(next=='D'||next=='M')){
                    res+=transToInt(next)-100;
                    i++;
                }else {
                    res+=transToInt(ch);
                }
            }

        }
        return res;

    }

    public static int transToInt(char ch){
        switch (ch){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }


    public static void main(String[] args) {

    }



}
