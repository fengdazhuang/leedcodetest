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


/**
 * 思路：
 * 定义一个新链表，遍历两个链表，每次比较大小，小的优先加入链表，同时移动该链表指针和新链表指针
 */
class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode newList;
        ListNode temp;
        if (list1.val > list2.val) {
            temp = newList = new ListNode(list2.val);
            list2 = list2.next;
        } else {
            temp = newList = new ListNode(list1.val);
            list1 = list1.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 == null) {
            temp.next = list2;
        } else {
            temp.next = list1;
        }
        return newList;
    }
}