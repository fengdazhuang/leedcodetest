package com.fzz.easy;

public class Test125 {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int n=s.length();
        int i=0,j=n-1;
        while(i<j){
            while(i<n&&!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(j>=0&&!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(i>=j){
                return true;
            }
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }

        }
        return true;
    }



    public static void main(String[] args) {
        String str="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));

    }
}
