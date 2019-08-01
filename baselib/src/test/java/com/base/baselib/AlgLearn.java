package com.base.baselib;

import org.junit.Test;

public class AlgLearn {

    /**
     * 冒泡排序
     * 相邻比较 大的往后放
     * 空间复杂程度 n*(n-1)/2   数值比较少适应  复杂程度基本为 n
     */
    @Test
    public void bubbleSort() {
        int[] nums = new int[]{2, 4, 1, 5, 9, 6, 5, 9, 7, 0};
        int size = nums.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 选择排序
     * 循环取第一个与其他比较 小的放前面
     */
    @Test
    public void selectSort() {
        int[] nums = new int[]{2, 4, 1, 5, 9, 6, 5, 9, 7, 0};
        int size = nums.length;
        if (size <= 1) {
            return;
        }
        int min;
        int temp;
        for (int i = 0; i < size - 1; i++) {
            min = i;
            for (int j = i + 1; j < size; j++) {
                if (nums[min] > nums[j]) {
                    //这次比较最小的指向j
                    min = j;
                }
            }

            //经过了交换
            if (min != i) {
                temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }


        for (int num : nums) {
            System.out.println(num);
        }
    }
}
