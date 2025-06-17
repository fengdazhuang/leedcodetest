package com.fzz.easy;

import java.util.HashSet;
import java.util.Set;

public class Test083 {
    public static void main(String[] args) {
        Solution83 solution83=new Solution83();
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(1);
        listNode.next.next=new ListNode(2);
        listNode.next.next.next=new ListNode(3);
        listNode.next.next.next.next=new ListNode(3);
        listNode.next.next.next.next.next=new ListNode(4);
        listNode.next.next.next.next.next.next=new ListNode(4);
        listNode.next.next.next.next.next.next.next=new ListNode(5);
        listNode.next.next.next.next.next.next.next.next=new ListNode(6);
        System.out.println(solution83.deleteDuplicates(listNode));
    }
}



/*class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}*/

/**
 * 从发起请求到响应过程中，SpringBoot 处理流程及对应组件
 * 1. 客户端发送请求到DispatcherServlet
 * 2. DispatcherServlet根据请求路径找到对应的HandlerMapping
 * 3. HandlerMapping返回对应的HandlerExecutionChain
 * 4. DispatcherServlet调用HandlerAdapter执行Handler
 * 5. HandlerAdapter调用Handler处理请求
 * 6. Handler处理请求并返回ModelAndView
 * 7. HandlerAdapter将ModelAndView返回给DispatcherServlet
 * 8. DispatcherServlet根据ModelAndView选择对应的ViewResolver
 * 9. ViewResolver将ModelAndView解析为View
 * 10. DispatcherServlet将View返回给客户端
 * 11. 客户端接收到响应并显示
 *
 */
class Solution83 {

    //1->1->2->3->3->4->4->5->6
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode node=head;
        int temp= node.val;;
        while(node.next!=null){
            if(temp==node.next.val){
                node.next=node.next.next;
                if(temp!=node.next.val){
                    temp=node.next.val;
                }
            }else{
                temp=node.next.val;
            }
            node=node.next;
        }
        return head;
    }
}
