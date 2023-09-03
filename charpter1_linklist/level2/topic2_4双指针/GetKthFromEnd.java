package com.yugutou.charpter1_linklist.level2.topic2_4双指针;

/**
 * 寻找链表倒数第K个结点
 */
public class GetKthFromEnd {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode nodeA = initLinkedList(a);
        ListNode node = getKthFromEnd(nodeA,2);
        System.out.println(node.val);
    }

    /**
     * 寻找倒数第K个节点
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        // 1.快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 2.快指针指向 K+1
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        // 3.快指针指向链表末
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 4.返回倒数第K节点
        return slow;
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
