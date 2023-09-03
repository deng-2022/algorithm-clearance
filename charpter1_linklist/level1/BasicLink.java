package com.yugutou.charpter1_linklist.level1;

/**
 * 一个简单的链表实例，用于演示JVM怎么构造链表的
 */
public class BasicLink {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        Node head = initLinkedList(a);
        System.out.println(head);
    }

    // 使用数组构建单链表
    private static Node initLinkedList(int[] array) {
        // 1.定义head指针, cur指针
        Node head = null, cur = null;
        // 2.遍历数组, 构建单链表
        for (int i = 0; i < array.length; i++) {
            // 2.1.新建节点, 依次获取数组元素, 并赋值给该节点的数据域
            Node newNode = new Node(array[i]);
            // 2.2.链表为空, 插入头节点
            if (i == 0) {
                // 2.2.1.初始化head指针
                head = newNode;
                // 2.2.2.更新cur指针, 指向新节点
                cur = newNode;
                // 2.3.链表不为空, 插入后继节点
            } else {
                // 2.3.1.更新每个结点的指针域, 指向后继节点
                cur.next = newNode;
                // 2.3.2.更新cur指针, 指向新节点
                cur = newNode;
            }
        }
        // 3.单链表构建完成, 返回头指针
        return head;
    }

    // 单链表节点
    static class Node {
        // 数据域
        public int val;
        // 指针域
        public Node next;

        // 节点初始化
        Node(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
