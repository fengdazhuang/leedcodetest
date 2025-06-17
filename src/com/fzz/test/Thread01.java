package com.fzz.test;

import java.util.concurrent.Callable;

public class Thread01 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "java是最好的语言";
    }
}
