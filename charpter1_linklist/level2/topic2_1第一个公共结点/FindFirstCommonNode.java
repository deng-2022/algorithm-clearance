package com.yugutou.charpter1_linklist.level2.topic2_1第一个公共结点;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FindFirstCommonNode {
    public static void main(String[] args) {
        ListNode[] heads = initLinkedList();
        //la 为 1 2 3 4 5
        //lb 为 11 22 4 5
        ListNode la = heads[0];
        ListNode lb = heads[1];

        int testMethod = 4;
        ListNode node = new ListNode(0);
        switch (testMethod) {
            case 1: //方法1：通过Hash辅助查找
                node = findFirstCommonNodeByMap(la, lb);
                break;
            case 2: //方法2：通过集合辅助查找
                node = findFirstCommonNodeBySet(la, lb);
                break;
            case 3://方法3：通过栈辅助查找
                node = findFirstCommonNodeByStack(la, lb);
                break;
            case 4://方法4：通过拼接辅助查找
                node = findFirstCommonNodeByCombine(la, lb);
                break;
            case 5://方法5：通过差辅助查找
                node = findFirstCommonNodeBySub(la, lb);
                break;
        }

        System.out.println("公共结点为：" + node.val);

    }

    /**
     * 方法1：通过Hash辅助查找
     *
     * @param pHead1 链表a
     * @param pHead2 链表b
     * @return 第一个公共节点/null
     */
    public static ListNode findFirstCommonNodeByMap(ListNode pHead1, ListNode pHead2) {
        // 1.判断链表是否为空
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        // 2.保存两链表头节点
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;
        // 3.通过Hash存储链表a的所有节点
        HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();
        while (current1 != null) {
            hashMap.put(current1, null);
            current1 = current1.next;
        }
        // 4.从头结点开始, 依次比较hash表中的节点与链表b的节点
        while (current2 != null) {
            if (hashMap.containsKey(current2)) return current2;
            current2 = current2.next;
        }
        // 5.未发现公共节点
        return null;
    }

    /**
     * 方法2：通过集合来辅助查找
     *
     * @param headA 链表a
     * @param headB 链表b
     * @return 第一个公共节点/null
     */
    public static ListNode findFirstCommonNodeBySet(ListNode headA, ListNode headB) {
        // 1.通过Hash存储链表a的所有节点
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        // 2.从头结点开始, 依次比较hash表中的节点与链表b的节点
        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }
        // 3.未发现公共节点
        return null;
    }

    /**
     * 方法3：通过栈
     */
    public static ListNode findFirstCommonNodeByStack(ListNode headA, ListNode headB) {
        // 1.将两条链表从头节点开始, 分别压入栈中
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        // 2.两栈依次出栈, 当栈顶元素相同时, 保存该元素
        ListNode preNode = null;
        while (stackB.size() > 0 && stackA.size() > 0) {
            if (stackA.peek() == stackB.peek()) {
                preNode = stackA.pop();
                stackB.pop();
            } else {
                break;
            }
        }
        // 3.返回第一个公共节点
        return preNode;
    }

    /**
     * 方法4：通过序列拼接
     */
    public static ListNode findFirstCommonNodeByCombine(ListNode pHead1, ListNode pHead2) {
//        System.out.println("null == null" + (null == null));
        // 1.判断链表是否为空
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        // 2.依次遍历两条链表
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {// 这个判断不能少
                // 2.1.链表a遍历完, 切换遍历链表b
                if (p1 == null) {
                    p1 = pHead2;
                }
                // 2.2.链表b遍历完, 切换遍历链表a
                if (p2 == null) {
                    p2 = pHead1;
                }
            }
        }
        // 3.返回第一个公共节点
        return p1;
    }

    /**
     * 方法5：通过差值来实现
     *
     * @param pHead1 链表a
     * @param pHead2 链表b
     * @return
     */
    public static ListNode findFirstCommonNodeBySub(ListNode pHead1, ListNode pHead2) {
        // 1.判断链表是否为空
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode current1 = pHead1;
        ListNode current2 = pHead2;
        int l1 = 0, l2 = 0;

        // 2.分别拿到两链表的长度
        while (current1 != null) {
            current1 = current1.next;
            l1++;
        }

        while (current2 != null) {
            current2 = current2.next;
            l2++;
        }
        current1 = pHead1;
        current2 = pHead2;

        // 3.计算两链表长度之差
        int sub = l1 > l2 ? l1 - l2 : l2 - l1;

        // 4.长度较大的链表先遍历, 遍历次数即为长度之差
        if (l1 > l2) {
            int a = 0;
            while (a < sub) {
                current1 = current1.next;
                a++;
            }
        }

        if (l1 < l2) {
            int a = 0;
            while (a < sub) {
                current2 = current2.next;
                a++;
            }
        }

        // 5.同时遍历两链表
        while (current2 != current1) {
            current2 = current2.next;
            current1 = current1.next;
        }

        // 6.返回第一个公共节点
        return current1;
    }

    /**
     * 简单构造两个链表
     *
     * @return
     */
    private static ListNode[] initLinkedList() {
        ListNode[] heads = new ListNode[2];
//        构造第一个链表交点之前的元素 1 ->2-> 3
        heads[0] = new ListNode(1);
        ListNode current1 = heads[0];
        current1.next = new ListNode(2);
        current1 = current1.next;
        current1.next = new ListNode(3);
        current1 = current1.next;
//        11->22
//        构造第二个链表交点之前的元素
        heads[1] = new ListNode(11);
        ListNode current2 = heads[1];
        current2.next = new ListNode(22);
        current2 = current2.next;
//        构造公共交点以及之后的元素

        ListNode node4 = new ListNode(4);
        current1.next = node4;
        current2.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;


        ListNode node6 = new ListNode(6);
        node5.next = node6;

        return heads;
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
