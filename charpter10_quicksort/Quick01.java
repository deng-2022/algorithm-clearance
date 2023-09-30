package com.yugutou.charpter10_quicksort;

/**
 * @author 邓哈哈
 * 2023/9/19 11:12
 * Function:
 * Version 1.0
 */

/**
 * 快速排序 双向链表
 */
public class Quick01 {
    public static void main(String[] args) {
        int[] nums = {6, 1, 8, 4, 9, 2, 7};
        Quick01 qs = new Quick01();
        qs.quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void quickSort(int[] nums, int start, int end) {
        // 判断递归结束的条件
        if (start >= end) {
            return;
        }
        // 选定最左边的元素作为基准值
        int pivot = nums[start];
        // 初始化快慢指针
        int slow = start;
        int fast = start + 1;

        // 快慢指针法进行划分
        while (fast <= end) {
            if (nums[fast] < pivot) {
                // 如果当前元素小于基准值，将其交换到基准值的左侧
                slow++;
                swap(nums, slow, fast);
            }
            fast++;
        }
        // 将基准值交换到正确的位置
        swap(nums, start, slow);

        // 递归对基准值的左右两部分进行排序
        quickSort(nums, start, slow - 1);
        quickSort(nums, slow + 1, end);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
