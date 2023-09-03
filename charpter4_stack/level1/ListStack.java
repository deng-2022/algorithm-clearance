package com.yugutou.charpter4_stack.level1;

import java.util.Arrays;

class ListStack<T> {
    //定义链表
    class Node<T> {
        public T t;
        public Node next;
    }

    public Node<T> head;

    //构造函数初始化头指针
    ListStack() {
        head = null;
    }

    //入栈
    public void push(T t) {
        if (t == null) {
            throw new NullPointerException("参数不能为空");
        }
        if (head == null) {
            head = new Node<T>();
            head.t = t;
            head.next = null;
        } else {
            Node<T> temp = head;
            head = new Node<>();
            head.t = t;
            head.next = temp;
        }
    }

    //出栈
    public T pop() {
        if (head == null) {
            return null;
        }
        T t = head.t;
        head = head.next;
        return t;
    }

    //取栈顶元素
    public T peek() {
        if (head == null) {
            return null;
        }
        T t = head.t;
        return t;
    }


    //栈空
    public boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        ListStack stack = new ListStack();
        System.out.println(stack.isEmpty());
        stack.push("Java");
        stack.push("is");
        stack.push("beautiful");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}

/**
 * 基于链表实现
 *
 * @param <T>
 */
class ListStack2<T> {
    // 栈顶节点
    private Node head;

    // 入栈
    public void push(T t) {
        if (t == null) {
            throw new NullPointerException("参数不能为空");
        }

        if (head == null) {
            head = new Node(t);
            head.next = null;
        } else {
            Node node = new Node(t);
            node.next = head;
        }
    }

    // 弹出栈顶元素
    public T peek() {
        return head.t;
    }

    // 出栈
    public T pop() {
        head = head.next;
        return head.t;
    }

    // 判断栈是否为空
    public boolean empty() {
        return head == null;
    }

    // 节点结构
    class Node {
        private T t;
        private Node next;

        public Node(T t) {
            this.t = t;
        }
    }
}