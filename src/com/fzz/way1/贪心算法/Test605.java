package com.fzz.way1.贪心算法;

public class Test605 {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        boolean b = new Solution605().canPlaceFlowers(flowerbed, 1);
        System.out.println(b);
    }
}
class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length==1){
            if(flowerbed[0]==0){
                return n<=1;
            }else{
                return n==0;
            }
        }

        int res=0;
        for(int i=0;i<flowerbed.length;i++){
            if(res>=n){
                return true;
            }
            if(flowerbed[i]==0){
                if(i==0){
                    if(flowerbed[i+1]==0){
                        flowerbed[i]=1;
                        res++;
                    }
                }else if(i==flowerbed.length-1){
                    if(flowerbed[i-1]==0){
                        flowerbed[i]=1;
                        res++;
                    }
                }else{
                    if(flowerbed[i-1]==0&&flowerbed[i+1]==0){
                        flowerbed[i]=1;
                        res++;
                    }
                }

            }
        }
        return res>=n;
    }
}
