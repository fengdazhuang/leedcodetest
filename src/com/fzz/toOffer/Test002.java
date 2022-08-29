package com.fzz.toOffer;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 指针移动加入list集合中，并逆序加入创造的数组中。
 */
public class Test002 {
    public int[] reversePrint(ListNode head) {
        List list=new ArrayList();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        int[] members= new int[list.size()];
        for(int i=list.size()-1;i>=0;i--){
            members[list.size()-1-i]= (int) list.get(i);
        }
        return members;
    }
}
