package com.yugutou.charpter3_array.level1;

/**
 * leetcode35 寻找插入位置
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        System.out.println(searchInsert(arr, 2));
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target 目标数字
     * @return 下标
     */
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        // 左边界, 右边界
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            // 中点
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
