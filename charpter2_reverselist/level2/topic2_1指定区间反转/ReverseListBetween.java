package com.yugutou.charpter2_reverselist.level2.topic2_1指定区间反转;

public class ReverseListBetween {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode nodeA = initLinkedList(a);

        ListNode d = null;
        int testMethod = 1;
        switch (testMethod) {
            case 1://方法1：穿针引线法
                d = reverseBetween(nodeA, 2, 4);
                break;
            case 2://方法2：头插法
                d = reverseBetween2(nodeA, 2, 4);
                break;

        }


        System.out.println(toString(d));

    }

    /**
     * 方法1：穿针引线法
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // 1.定义头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 2.pre来到left - 1个节点处，记录
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 3.pre来到right节点处，记录
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 4.截断链表
        ListNode leftNode = pre.next;
        ListNode succ = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        // 5.反转链表
        reverseList(leftNode);

        // 6.拼接链表
        pre.next = rightNode;
        leftNode.next = succ;

        return dummyNode.next;
    }

    /**
     * 基本的反转方法
     *
     * @param head
     * @return
     */
    public static ListNode  reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 方法1：头插法
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        // 1.定义虚拟头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        // 2.pre到达left前一节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 3.cur指向left
        ListNode cur = pre.next;
        ListNode next;
        // 4.反转链表
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        // 5.返回头节点
        return dummyNode.next;
    }


    /**
     * 初始化链表
     *
     * @param array
     * @return
     */
    private static ListNode initLinkedList(int[] array) {
        ListNode head = null, cur = null;

        for (int i = 0; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }


    /**
     * 输出链表
     *
     * @param head 头节点
     */
    public static String toString(ListNode head) {
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val).append("\t");
            current = current.next;
        }
        return sb.toString();
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
