package com.fzz.test;


public class Thread02 implements Runnable {
    @Override
    public void run() {
        int res=0;
        for (int i = 1; i < 101; i++) {
            res+=i;

        }
        System.out.println("1-100的和为："+res);
    }
}
