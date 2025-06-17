package com.fzz.test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Predicate;

public class Test1231 {

    public static void main(String[] args) {
        Predicate<String> p = (s)-> s.length()>3;
        Predicate<Object> aaa = Predicate.isEqual(null);
        System.out.println(aaa.test(null));
        Map<Integer,String> set = new HashMap<>();
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<>();
        ArrayList<Integer> list = new ArrayList<>();


    }

}
