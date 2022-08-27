package com.fzz.medium;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Test002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0,null);
        int a=0;
        int b=0;
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode node=head;
        int next=0;
        int i=0;

        while(temp1!=null&&temp2!=null){

            a=(temp1.val+temp2.val+next)%10;
            b=(temp1.val+temp2.val+next)/10;
            if(i==0){
                head=node=new ListNode(a,null);
            }else{
                node.next=new ListNode(a,null);
                node=node.next;
            }
            temp1=temp1.next;
            temp2=temp2.next;
            next=b;

            i++;
        }
        if(temp1==null){
            while(temp2!=null){
                a=(temp2.val+next)%10;
                b=(temp2.val+next)/10;
                node.next=new ListNode(a,null);
                node=node.next;
                temp2=temp2.next;
                next=b;
            }
        }
        if(temp2==null){
            while(temp1!=null){
                a=(temp1.val+next)%10;
                b=(temp1.val+next)/10;
                node.next=new ListNode(a,null);
                node=node.next;
                temp1=temp1.next;
                next=b;
            }
        }
        if(next!=0){
            node.next=new ListNode(b,null);
        }

        return head;
    }
}
