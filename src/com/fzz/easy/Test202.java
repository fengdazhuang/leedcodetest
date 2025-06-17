
package com.fzz.easy;

import java.util.HashSet;
import java.util.Set;

public class Test202 {
    public static void main(String[] args) {
        Solution202 s = new Solution202();
        System.out.println(s.isHappy(2));
    }
}

/**
 * 1：一直循环，每次循环开始将其存入set中，每轮结束set中不存在该中间数则继续循环
 * 2：使用set存储每次的中间值可能占用很大的空间，事实上，如果不是循环数，n必定会再次出现，一定存在一个环，可以简化算法，
 *   不使用set，将temp！=n作为循环条件
 * 3：循环且有环，可以使用快慢指针
 * 4：1和7都是快乐数，可以直接判断
 *
 */
class Solution202 {
    public boolean isHappy(int n) {
        if(n/10==0) return n==1||n==7;
        int temp=n;
        //Set<Integer> set = new HashSet<>();
        do{
            //set.add(temp);
            temp=method(temp);
            if(temp/10==0) return temp==1||temp==7;
            if(temp==1) return true;
        }while(temp!=n);
        //while (!set.contains(temp));
        return false;
    }

    public static int method(int n){
        int a=n/10;
        int b=n%10;
        int res=0;
        while(a!=0){
            res+=b*b;
            b=a%10;
            a=a/10;

        }
        res+=b*b;
        return res;
    }
}