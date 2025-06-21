package com.fzz.medium;

import java.util.List;

public class Test086 {
}


/**
 * 思路：
 * 设置两个链表的哨兵头节点head1和head2，遍历整个链表，每次判断当前节点值与x的关系，小于x插入head1中，大于等于x插入head2中
 * 最后将head2接到head1后面即可
 * 思路简单，但需要注意指针的移动和边界（即是否为空）的判断
 */
class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();
        ListNode left = head1;
        ListNode right = head2;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        left.next = null;
        right.next = null;
        if (head1.next == null) {
            return head2.next;
        } else {
            ListNode res = head1.next;
            while (head1.next != null) {
                head1 = head1.next;
            }
            head1.next = head2.next;
            return res;
        }
    }
}