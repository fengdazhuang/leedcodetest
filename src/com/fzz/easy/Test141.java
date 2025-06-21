package com.fzz.easy;

public class Test141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=head;

        Solution141 solution141 = new Solution141();
        System.out.println(solution141.hasCycle(head));
    }
}

/**
 * 思路：
 * 设置快慢指针，慢指针一次一步，快指针一次两步，当快指针追上慢指针时代表有环，
 * 当快指针的next为null时代表走到链表尾没有环
 */
class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}