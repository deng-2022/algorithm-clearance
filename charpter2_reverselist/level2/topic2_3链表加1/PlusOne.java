package com.yugutou.charpter2_reverselist.level2.topic2_3链表加1;

import java.util.Stack;

/**
 * LeetCode369 单链表加1
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] a = {9, 9, 9};
//        int[] a = {1, 2, 3};
        ListNode nodeA = initLinkedList(a);

        ListNode node = plusOne(nodeA);

        System.out.println(toString(node));

    }

    /**
     * 压栈
     *
     * @param head
     * @return
     */
    public static ListNode plusOne(ListNode head) {
        // 1.全部压栈
        Stack<Integer> st = new Stack();
        while (head != null) {
            st.push(head.val);
            head = head.next;
        }
        // 2.定义进位、加数、虚拟头节点
        int carry = 0;
        int adder = 1;
        ListNode dummy = new ListNode(0);

        while (!st.empty() || adder != 0 || carry > 0) {
            // 4.执行加法运算
            int digit = st.pop();
            int sum = digit + adder + carry;
            // 5.保存进位和各位结果
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode cur = new ListNode(sum);
            // 6.链表链接
            cur.next = dummy.next;
            dummy.next = cur;
            adder = 0;
        }
        // 7.返回头节点
        return dummy.next;
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
