package com.fzz.easy;

public class Test021 {
    public static void main(String[] args) {
        ListNode listNode = new Solution21().mergeTwoLists(new ListNode(1), new ListNode(2));
        System.out.println(listNode.val);
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode p = list1;
        ListNode q = list2;
        ListNode newList;
        ListNode temp;
        if(p.val>q.val){
            temp=newList=new ListNode(q.val);
            q=q.next;
        }else{
            temp=newList=new ListNode(p.val);
            p=p.next;
        }
        while(p!=null&&q!=null){
            if(p.val<=q.val){
                temp.next=p;
                p=p.next;
            }else {
                temp.next=q;
                q=q.next;
            }
            temp=temp.next;
        }
        if(p==null){
            temp.next=q;
        }else{
            temp.next=p;
        }
        return newList;
    }
}