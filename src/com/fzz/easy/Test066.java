package com.fzz.easy;

import java.util.Arrays;

public class Test066 {
    public static void main(String[] args) {
        int[] digits = {9,9,9};
        System.out.println(Arrays.toString(new Solution66().plusOne(digits)));
    }
}


class Solution66 {
    public int[] plusOne(int[] digits) {
        int up=1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp=digits[i];
            digits[i]=(temp+up)%10;
            up=(temp+up)/10;
        }
        if(up==1){
            int[] res = new int[digits.length+1];
            System.arraycopy(digits,0,res,1,digits.length);
            res[0]=1;
            return res;
        }
        return digits;
    }
}