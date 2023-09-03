package com.yugutou.charpter1_linklist.level1;

/**
 * 构造链表，使用静态内部类定表示结点，实现增加和删除元素的功能
 */
public class BasicLinkList {
    static class Node {
        final int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        // 头部添加节点1
        Node head = new Node(1);
        System.out.println("头部添加节点1：" + BasicLinkList.toString(head));

        System.out.println("链表长度为：" + getLength(head));

        // 头部添加节点666
        Node node = new Node(666);
        head = BasicLinkList.insertNode(head, node, 1);
        System.out.println("头部添加节点666：" + BasicLinkList.toString(head));

        // 尾部添加节点667
        node = new Node(667);
        head = BasicLinkList.insertNode(head, node, 3);
        System.out.println("尾部添加节点667：" + BasicLinkList.toString(head));
        System.out.println("链表长度为：" + getLength(head));

        // 中间添加节点668
        node = new Node(668);
        head = BasicLinkList.insertNode(head, node, 3);
        System.out.println("中间添加节点668：" + BasicLinkList.toString(head));

        // 删除中间节点668
        head = BasicLinkList.deleteNode(head, 3);
        System.out.println("删除中间节点668：" + BasicLinkList.toString(head));

        // 删除头部节点666
        head = BasicLinkList.deleteNode(head, 1);
        System.out.println("删除头部节点666：" + BasicLinkList.toString(head));
    }

    /**
     * 获取链表长度
     *
     * @param head 链表头节点
     * @return 链表长度
     */
    public static int getLength(Node head) {
        int length = 0;
        Node node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 链表插入
     *
     * @param head       链表头节点
     * @param nodeInsert 待插入节点
     * @param position   待插入位置，取值从2开始
     * @return 插入后得到的链表头节点
     */
    public static Node insertNode(Node head, Node nodeInsert, int position) {
        // 1.头节点判空
        if (head == null) {
            return nodeInsert;
        }
        // 2.越界判断
        int size = getLength(head);
        if (position > size + 1 || position < 1) {
            System.out.println("位置参数越界");
            return head;
        }

        // 3.表头插入
        if (position == 1) {
            nodeInsert.next = head;
            head = nodeInsert;
            return head;
        }
        // 4.表中/表尾插入
        Node pNode = head;
        int count = 1;
        while (count < position - 1) {
            pNode = pNode.next;
            count++;
        }
        nodeInsert.next = pNode.next;
        pNode.next = nodeInsert;

        // 5.插入完成, 返回头节点
        return head;
    }

    /**
     * 删除节点
     *
     * @param head     链表头节点
     * @param position 删除节点位置，取值从1开始
     * @return 删除后的链表头节点
     */
    public static Node deleteNode(Node head, int position) {
        // 1.头节点判空
        if (head == null) {
            return null;
        }
        // 2.越界判断
        int size = getLength(head);
        if (position > size || position <= 0) {
            System.out.println("输入的参数有误");
            return head;
        }
        // 3.表头删除
        if (position == 1) {
            // head.next就是链表的新head
            return head.next;
        }
        // 4.表中/表尾删除
        Node preNode = head;
        int count = 1;
        while (count < position - 1) {
            preNode = preNode.next;
            count++;
        }
        Node curNode = preNode.next;
        preNode.next = curNode.next;
        // 5.删除成功, 返回头节点
        return head;
    }

    /**
     * 输出链表
     *
     * @param head 头节点
     */
    public static String toString(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data).append("\t");
            current = current.next;
        }
        return sb.toString();
    }

}
