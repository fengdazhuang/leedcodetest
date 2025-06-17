package com.fzz.test;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;


public class Test01 {
    public static void main(String[] args) {

        //printStars();
        //printMutifyTable();
        deleteJumpTwoElement();
    }

    private static void deleteJumpTwoElement() {
        int[] nums=new int[1000];

        for(int i=0;i<nums.length;i++){
            nums[i]=i;
        }
        int count=1000;
        int jumpLen=3;
        while(count>1){

        }

    }


    private static void printMutifyTable() {
        for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                System.out.format("%d*%d=%d\t",j,i,i*j);
            }
            System.out.println();
        }
    }

    public static void printStars(){
        char ch1=' ',ch2='*';
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(ch1);
            }
            for (int j=0;j<2*i-1;j++){
                System.out.print(ch2);
            }
            System.out.println();

        }
    }
}
