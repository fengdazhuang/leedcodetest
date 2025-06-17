package com.fzz.easy;

import java.util.Arrays;

public class Test067 {
    public static void main(String[] args) {
        String s = new Solution67().addBinary("11", "1");
        System.out.println(s);
    }
}

/**
 * 思路：
 * 都转为字符数组，将较小的数组扩容到同等大小，前面补'0'，倒序循环进行相加，根据二进制相加规则记录进位。
 *
 */
class Solution67 {
    public String addBinary(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        if(aa.length>bb.length){
            return get(aa,bb);
        }else{
            return get(bb,aa);
        }

    }

    private static String get(char[] longChars,char[] shortChars){
        char[] cc=new char[longChars.length];
        Arrays.fill(cc,'0');
        int up=0;
        System.arraycopy(shortChars,0,cc,longChars.length-shortChars.length,shortChars.length);
        for (int i = longChars.length-1; i >= 0; i--) {
            int temp=(longChars[i]-48)+(cc[i]-48)+up;
            int a=temp/2;
            int b=temp%2;
            longChars[i]=(char)(b+48);
            up=a;
        }
        if(up==1){
            char[] res=new char[longChars.length+1];
            res[0]='1';
            System.arraycopy(longChars,0,res,1,longChars.length);
            return new String(res);
        }
        return new String(longChars);
    }
}