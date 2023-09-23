package com.fzz.easy;


public class Test1662 {
    public static void main(String[] args) {
        String[] word1 = new String[]{"abc", "d", "defg"};
        String[] word2 = new String[]{"abcddefg"};
        System.out.println(arrayStringsAreEqual(word1,word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i=0,j=0,m=0,n=0;
        while(i<word1.length&&j<word2.length){
            if(word1[i].charAt(m)!=word2[j].charAt(n)){
                return false;
            }
            m++;
            n++;
            if(m>=word1[i].length()){
                i++;
                m=0;
            }
            if(n>=word2[j].length()){
                j++;
                n=0;
            }

        }
        return (i>= word1.length)&&(j>= word2.length);
    }
}
