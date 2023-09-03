package com.yugutou.charpter3_array.level1.数组插入;

/**
 * @author 邓哈哈
 * 2023/8/9 10:57
 * Function:
 * Version 1.0
 */

public class addElement {
    /**
     * 初始化数组
     */
    public static void initArray() {
        int[] arr = new int[10];
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    /**
     * 查询单个元素
     *
     * @param arr     数组
     * @param size    元素数量
     * @param element 查询元素
     * @return element
     */
    public static int findByElement(int[] arr, int size, int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element)
                return element;
        }
        return -1;
    }

    /***
     * 插入数据
     * @param arr 数组
     * @param size 元素个数
     * @param element 插入元素
     * @return 下标
     */
    public static int addByElementSequence(int[] arr, int size, int element) {
        // 1.
        if (size >= arr.length)
            return -1;

        // 2.默认插入元素在数组末
        int index = size;
        // 3.查找插入位置
        for (int i = 0; i < size; i++) {
            if (element < arr[i]) {
                index = i;
                break;
            }
        }
        // 4.元素后移
        for (int j = size; j > index; j--) {
            arr[j] = arr[j - 1];
        }
        arr[index] = element;
        return 0;
    }

    /**
     * 删除元素
     *
     * @param arr  数组
     * @param size 数组元素个数
     * @param key  删除的下标
     * @return size
     */
    public static int removeByElement(int[] arr, int size, int key) {
        // 1.锁定删除元素下标
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            // 2.删除元素
            for (int i = index + 1; i < size; i++) {
                arr[i - 1] = arr[i];
            }
            // 3.更新数组元素个数
            size--;
        }
        return size;
    }
}
