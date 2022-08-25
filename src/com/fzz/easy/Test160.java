package com.fzz.easy;

import java.util.HashSet;
import java.util.Set;

public class Test160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 方法一：
     * 将ListA遍历加入集合中，再对ListB中每一个节点判断集合中是否含有
     */
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();
        ListNode temp=headA;
        while(temp!=null){
            set.add(temp);
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            if(set.contains(temp)) return temp;
            temp=temp.next;
        }
        return null;
    }*/

    /**
     * 方法二：
     * 设置双指针，当两指针不相等时往下移动指针，当为空时指向另一条链表的头指针，利用A+B=B+A。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(tempA!=tempB){
            tempA=tempA==null?headB:tempA.next;
            tempB=tempB==null?headA:tempB.next;
        }
        return tempA;
    }
}
