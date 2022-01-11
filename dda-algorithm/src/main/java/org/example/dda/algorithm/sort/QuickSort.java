package org.example.dda.algorithm.sort;

import java.util.Arrays;

/**
 * 时间复杂度参考：https://www.jianshu.com/p/45efd93fadae
 * 快速排序算法是不稳定的，例如数列 5 3 3 4 3 8 9 10 11
 * 快速排序时间复杂度：
 * 最好情况下：O(nlgn)
 * 最坏情况下：O(n*n)
 * 平均时间复杂度O(nlgn)
 *
 * @author Williami
 * @description
 * @date 2022/1/4
 */
public class QuickSort {

    static void quickSort(int[] nums, int L, int R) {
        // 左右指针相遇
        if (L >= R) {
            return;
        }
        int left = L, right = R;
        // 基准元素
        int pivot = nums[left];
        /**
         * 算法核心步骤：
         * ①从right开始与基数temp比较，如果n[right]>基数temp，则right指针向前移一位，继续与基数temp比较，直到不满足n[right]>基数temp
         *
         * 　　②将n[right]赋给n[left]
         *
         * 　　③从left开始与基数temp比较，如果n[left]<=基数temp，则left指针向后移一位，继续与基数temp比较，直到不满足n[left]<=基数temp
         *
         * 　　④将n[left]赋给n[rigth]
         *
         * 　　⑤重复①-④步，直到left==right结束，将基数temp赋给n[left]
         */
        while (left < right) {
            // 如果right指向的元素大于基准元素，没有发生数据交换，则指针左移
            // 从右向左查找第一个小于pivot的元素
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            // 入坑
            if (left < right) {
                nums[left] = nums[right];
            }

            // left指向的元素小于Pivot基准元素
            while (left < right && nums[left] < pivot) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
            }
            // Pivot最终位置,本轮排序结束
            if (left >= right) {
                nums[left] = pivot;
            }
        }

        // 跳出循环的条件  left >= right
        quickSort(nums, L, left - 1);
        quickSort(nums, right + 1, R);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, -2, 1, 5, 6, 7, -1, 0, 9};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}
