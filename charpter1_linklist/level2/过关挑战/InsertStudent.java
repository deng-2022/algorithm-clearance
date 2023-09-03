package com.yugutou.charpter1_linklist.level2.过关挑战;

/**
 * @author 邓哈哈
 * 2023/7/27 9:17
 * Function:
 * Version 1.0
 */

public class InsertStudent {
    public static void main(String[] args) {
        ListNode node1 = new ListNode("Node 1", "Java");
        ListNode node2 = new ListNode("Node 2", "Python");
        ListNode node3 = new ListNode("Node 3", "C++");
        // 创建节点数组并存储节点
        ListNode[] nodes = new ListNode[3];
        nodes[0] = node1;
        nodes[1] = node2;
        nodes[2] = node3;
        // 初始化链表
        ListNode head = initLinkList(nodes);

        ListNode node4 = new ListNode("Node 4", "Java");
        ListNode node5 = new ListNode("Node 5", "C++");
        ListNode node6 = new ListNode("Node 6", "Python");
        ListNode node8 = new ListNode("Node 8", "C++");
        ListNode node9 = new ListNode("Node 9", "Python");
        ListNode node7 = new ListNode("Node 7", "Java");
        // 插入学生节点
        insertStudentByLanguage(node4, head);
        insertStudentByLanguage(node5, head);
        insertStudentByLanguage(node6, head);
        insertStudentByLanguage(node7, head);
        insertStudentByLanguage(node8, head);
        insertStudentByLanguage(node9, head);

        printLinkList(head);
    }
    // 插入学生节点
    public static void insertStudentByLanguage(ListNode node, ListNode head) {
        ListNode cur = head;
        String language = node.language;

        switch (language) {
            case "Java":
                while (!cur.next.language.equals("Python")) {
                    cur = cur.next;
                }
                node.next = cur.next;
                cur.next = node;
                break;
            case "Python":
                while (!cur.next.language.equals("C++")) {
                    cur = cur.next;
                }
                node.next = cur.next;
                cur.next = node;
                break;
            case "C++":
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = node;
                break;
            default:
                break;
        }
    }
    // 打印链表
    public static void printLinkList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp + "--> ");
            temp = temp.next;
        }
    }
    // 初始化链表
    public static ListNode initLinkList(ListNode[] array) {
        int i = 0;
        ListNode head = null, cur = null;
        while (i < array.length) {
            ListNode newNode = new ListNode(array[i].name, array[i].language);

            if (head == null) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
            i++;
        }
        return head;
    }

    // 节点结构
    static class ListNode {
        public String name;
        public String language;
        public ListNode next;
        public ListNode(String name, String language) {
            this.name = name;
            this.language = language;
        }
        @Override
        public String toString() {
            return "ListNode{" +
                    "name='" + name + '\'' +
                    ", language='" + language + '\'' +
                    '}';
        }
    }
}
