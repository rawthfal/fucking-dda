package org.example.dda.algorithm.sort;

import org.example.dda.algorithm.util.ArraysUtil;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>动画演示 :https://zhuanlan.zhihu.com/p/122284534
 *
 * @author Williami
 * @description
 * @date 2022/1/4
 */
public class BubbleSort {

    public static void sort_v2(int[] nums) {
        int temp;
        // 最外层nums.length-1表示：最多需要多少轮比较，例如 4, 3, 2, 6四个数需要三轮比较，每轮比较确定一个值的最终位置
        for (int i = 0; i < nums.length - 1; i++) {
            // nums.length - 1 - i表示本轮需要多少次两两相邻比较
            for (int j = 0; j < nums.length - 1 - i; j++) {
                // 相邻两个数据进行比较，较小值上浮
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 改进版，如果尾部数据有序，记录最后数据交换的位置
     *
     * @param nums
     */
    public static void sort(int[] nums) {
        int temp;
        // 最外层nums.length-1表示：最多需要多少轮比较，例如 4, 3, 2, 6四个数需要三轮比较，每轮比较确定一个值的最终位置
        int k;
        int flag = nums.length - 1;
        while (flag > 0) {
            k = flag;
            // 防止有序数组死循环
            flag = 0;
            // nums.length - 1 - i表示本轮需要多少次两两相邻比较
            for (int j = 0; j < k; ++j) {
                // 相邻两个数据进行比较，较小值上浮
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    // 下次最多遍历到这里
                    flag = j;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{8,7,6,5,4,-1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
