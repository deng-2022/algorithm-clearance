package com.yugutou.charpter1_linklist.level2.topic2_2回文序列;

import com.yugutou.charpter1_linklist.level1.ListNode;

import java.util.Stack;

/***
 * 判断链表是否回文
 */
public class IsPalindromic {
    static ListNode temp;

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 4, 3, 2, 1};
        ListNode node = initLinkedList(a);
        int testMethod = 5;
        boolean result = false;
        switch (testMethod) {
            case 1://方法1：通过双指针的方式来判断
                result = isPalindromeByTwoPoints(node);
                break;
            case 2: //方法2：全部压栈遍历 全部出栈遍历
                result = isPalindromeByAllStack(node);
                break;
            case 3: //方法3：全部压栈遍历 一半出栈遍历
                result = isPalindromeByHalfStack(node);
                break;
            case 4: //方法5：通过递归来实现
                result = isPalindromeByRe(node);
                break;
            case 5:
                result = isPalindromeByReverseList(node);
                break;

        }
        System.out.println("result:" + result);
    }


    /**
     * 方法1：通过双指针的方式来判断
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeByTwoPoints(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 方法1：全部压栈遍历 全部出栈遍历
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeByAllStack(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        // 1.压栈 遍历
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        // 2.出栈 遍历
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 方法2：全部压栈遍历 一半出栈遍历
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeByHalfStack(ListNode head) {
        if (head == null)
            return true;
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        //链表的长度
        int len = 0;
        //把链表节点的值存放到栈中
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
            len++;
        }
        //len长度除以2
        len >>= 1;
        //然后再出栈
        while (len-- >= 0) {
            if (head.val != stack.pop())
                return false;
            head = head.next;
        }
        return true;
    }

    /**
     * 构造倒序链表
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeByReverseList(ListNode head) {
        // 1.构造反转链表
        ListNode newHead = head, temp = head;

        while (temp != null) {
            ListNode node = new ListNode(temp.val);
            node.next = newHead;

            newHead = node;
            temp = temp.next;
        }

        // 2.同时遍历两链表
        while (newHead != null && head != null) {
            if (head.val != newHead.val)
                return false;

            head = head.next;
            newHead = newHead.next;
        }

        return true;
    }

    /**
     * 方法4：通过递归来实现
     */

    public static boolean isPalindromeByRe(ListNode head) {
        temp = head;
        return check(head);
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

    private static boolean check(ListNode head) {
        if (head == null)
            return true;
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
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
