package com.fzz.test;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyString {

    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        Lock lock = new ReentrantLock();
        Condition condition=lock.newCondition();
        lock.lock();


    }


}
