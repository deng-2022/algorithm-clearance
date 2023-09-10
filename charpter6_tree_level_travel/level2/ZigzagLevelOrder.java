package com.yugutou.charpter6_tree_level_travel.level2;

import com.yugutou.tools.BinaryTree;
import com.yugutou.tools.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode103 题，
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 */
public class ZigzagLevelOrder {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        List<List<Integer>> level = zigzagLevelOrder(bTree.root);
        System.out.println(level.toString());
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = queue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }

    public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        // 节点值列表
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        // 队列，控制遍历节点顺序
        Deque<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        // 控制存放节点值顺序
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            // 每层的节点值列表
            Deque<Integer> levelList = new LinkedList<>();
            // 该层节点数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 出队，存值
                TreeNode poll = queue.poll();
                if (isOrderLeft) {
                    levelList.offerFirst(poll.val);
                } else {
                    levelList.offerLast(poll.val);
                }
                // 左右孩子节点入队
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.left != null) {
                    queue.offer(poll.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            // 变换存放节点值顺序
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}

