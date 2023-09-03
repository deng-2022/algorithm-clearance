package com.yugutou.charpter2_reverselist.level2.topic_2_4链表加法;

import java.util.Stack;

/**
 * 两个链表相加
 */
public class ReverseList_AddList {
    public static void main(String[] args) {
        int[] a = {9, 3, 7};
        ListNode nodeA = initLinkedList(a);
        int[] b = {6, 3};
        ListNode nodeB = initLinkedList(b);

        ListNode d = null;
        int testMethod = 1;
        switch (testMethod) {
            case 1://方法1：通过栈实现
                d = addInListByStack(nodeA, nodeB);
                break;
            case 2://方法2：通过链表反转来实现
                d = addInListByReverse(nodeA, nodeB);
                break;

        }


        System.out.println(toString(d));

    }

    /**
     * 通过栈来实现
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addInListByStack(ListNode head1, ListNode head2) {
        // 1.两链表全入栈
        Stack<ListNode> st1 = new Stack<ListNode>();
        Stack<ListNode> st2 = new Stack<ListNode>();
        while (head1 != null) {
            st1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            st2.push(head2);
            head2 = head2.next;
        }
        // 2.定义进位、虚拟头节点
        ListNode dummy = new ListNode(-1);
        int carry = 0;

        //这里设置carry!=0,是因为当st1,st2都遍历完时，如果carry=0,就不需要进入循环了
        while (!st1.empty() || !st2.empty() || carry != 0) {
            // 1.出栈, 相加
            ListNode a = new ListNode(0);
            ListNode b = new ListNode(0);
            if (!st1.empty()) {
                a = st1.pop();
            }
            if (!st2.empty()) {
                b = st2.pop();
            }
            int get_sum = a.val + b.val + carry;
            // 2.取余数，取进位
            int ans = get_sum % 10;
            carry = get_sum / 10;
            // 3.链表链接
            ListNode cur = new ListNode(ans);
            cur.next = dummy.next;
            dummy.next = cur;
        }
        // 4.返回头节点
        return dummy.next;
    }

    /**
     * 方法2：通过链表反转来实现
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addInListByReverse(ListNode head1, ListNode head2) {
        // 1.分别反转链表
        head1 = reverse(head1);
        head2 = reverse(head2);
        // 2.定义进位、虚拟头节点
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;

        while (head1 != null || head2 != null) {
            // 3.链表相加
            int val = carry;
            if (head1 != null) {
                val += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                val += head2.val;
                head2 = head2.next;
            }
            // 4.取进位、求余
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            cur = cur.next;
        }
        // 5.进位处理
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        // 6.返回头节点
        return reverse(head.next);
    }

    private static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
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
