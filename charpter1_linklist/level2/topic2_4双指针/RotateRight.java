package com.yugutou.charpter1_linklist.level2.topic2_4双指针;

/**
 * Leetcode61.旋转数组
 */
public class RotateRight {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode nodeA = initLinkedList(a);
        ListNode node = rotateRight(nodeA, 2);
        System.out.println(toString(node));
    }

    /**
     * 旋转链表
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        // 1.快慢节点
        ListNode temp = head;
        ListNode fast = head;
        ListNode slow = head;
        // 2.获取链表长度
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        // 3.以首尾旋转
        if (k % len == 0) {
            return temp;
        }
        // 4.快指针先走K步
        while ((k % len) > 0) {
            k--;
            fast = fast.next;
        }
        // 5.快慢指针同时走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 6.获得截断处
        ListNode res = slow.next;
        slow.next = null;
        // 7.重置头节点
        fast.next = temp;
        return res;
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

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
