package com.fzz.toOffer;


public class Test024 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 设置节点指针temp和新链表的头节点node，初始化新链表，
     * 后不断移动和判断temp是否为空，不为空则添加至新链表的头部
     *
     */
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode temp=head;
        temp=temp.next;
        ListNode node=head;
        head.next=null;
        while(temp!=null){
            head=temp;
            temp=temp.next;
            head.next=node;
            node=head;
        }
        return head;
    }



}

