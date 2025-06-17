package com.fzz.test;

/**
 * 请设计并实现一个简单的线程安全的阻塞队列：MyLinkedBlockingQueue，要求：
 * （1）不使用JUC等工具，使用Object.wait()/Object.notify()/Object.notifyAll()等方法实现
 * （2）主要方法：添加、获取、查看、元素长度
 * （3）无需泛型，设计为存储元素类型为字符串即可，代码需添加适当的注释
 */
public class MyLinkedBlockingQueue {
    private final Node head;

    private Node tail;

    private int size;

    private final int capacity;


    static class Node{
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    public MyLinkedBlockingQueue() {
        this.capacity=10;
        this.tail = this.head=new Node(null);
        this.size=0;
    }

    public MyLinkedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.size=0;
        this.tail = this.head=new Node(null);
    }


    /**
     * 添加元素,队列满时等待
     */
    public synchronized void addItem(String data) {
        while(size>=capacity){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Node node=new Node(data);
        this.tail.next=node;
        this.tail=node;
        size++;
        this.notifyAll();
    }

    /**
     * 获取元素，当队列无数据时等待
     */
    public synchronized String removeItem(){
        while(size==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Node node=this.head.next;
        this.head.next=node.next;
        if (node==this.tail) {  // 如果移除的是最后一个元素，更新 tail
            this.tail=this.head;
        }
        size--;
        this.notifyAll();
        return node.data;
    }


    /**
     * 获取元素，当队列无数据时返回null
     */
    public synchronized String peek(){
        if (this.size==0) {
            return null;
        }
        return this.head.next.data;

    }


    /**
     * 获取队列元素个数
     *
     */
    public synchronized int getLength(){
        return this.size;
    }


}
