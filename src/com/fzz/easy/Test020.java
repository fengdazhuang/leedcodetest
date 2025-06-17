package com.fzz.easy;

import java.util.*;

public class Test020 {
    public static void main(String[] args) {
        boolean valid = new Solution20().isValid("()[]{}");
        System.out.println(valid);
    }
}


/**
 * 要点：
 * 1.用栈解决，但Stack是线程安全的，方法上加了synchronized，效率低，所以用其它代替，可以用ArrayDeque、LinkedList
 * ArrayDeque是Deque的实现类，可以实现栈的先进后出，且效率比LinkedList高
 * 2.用map存储括号对
 * 思路：
 * 1.遍历字符串，如果遇到左括号，则入栈
 * 2.如果遇到右括号，则判断栈顶元素是否为对应的左括号，如果是，则出栈，否则返回false
 * 3.遍历结束后，如果栈为空，则返回true，否则返回false
 *
 */
class Solution20 {
    public boolean isValid(String s) {
        int len=s.length();
        if(len%2!=0){
            return false;
        }
        Map<Character,Character> map=new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        ArrayDeque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            //c为右括号
            if(map.containsKey(c)){
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}