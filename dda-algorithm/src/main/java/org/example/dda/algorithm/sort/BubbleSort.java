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
            // 内部循环实现每一轮的冒泡处理，先进行元素比较，再进行元素交换
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
    public static void sort_v3(int[] nums) {
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

    /**
     * 冒泡排序优化版-如果剩下元素一已经有序
     *
     * @param nums
     */
    public static void sort_v1(int[] nums) {
        int temp;
        // 最外层nums.length-1表示：最多需要多少轮比较，例如 4, 3, 2, 6四个数需要三轮比较，每轮比较确定一个值的最终位置
        for (int i = 0; i < nums.length - 1; i++) {
            // nums.length - 1 - i表示本轮需要多少次两两相邻比较
            // 内部循环实现每一轮的冒泡处理，先进行元素比较，再进行元素交换
            boolean isSorted = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                // 相邻两个数据进行比较，较小值上浮
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    // false表明发生了元素交换，所以不是有序的
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 鸡尾酒排序：是对冒泡排序算法的优化，针对大部分数据有序的情况下
     * 鸡尾酒优点:特定条件下，减少排序的回合数
     * 鸡尾酒缺点：代码量增加了一倍
     * <p>鸡尾酒排序类似钟摆，第一轮从左往右，第二轮从右往左，第三轮从左到右
     *
     * @param nums
     */
    public static void sort_v13(int[] nums) {
        int temp;
        // 最外层nums.length-1表示：最多需要多少轮比较，例如 4, 3, 2, 6四个数需要三轮比较，每轮比较确定一个值的最终位置
        for (int i = 0; i < nums.length >>> 1; i++) {
            // nums.length - 1 - i表示本轮需要多少次两两相邻比较
            // 内部循环实现每一轮的冒泡处理，先进行元素比较，再进行元素交换
            boolean isSorted = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                // 相邻两个数据进行比较，较小值上浮
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    // false表明发生了元素交换，所以不是有序的
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            // 偶数轮之前，将isSorted置为true
            isSorted = true;

            // 偶数轮，从右向左比较和交换
            for (int j = nums.length - i - 1; j > i; j--) {
                // 相邻两个数据进行比较，较小值上浮
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    // false表明发生了元素交换，所以不是有序的
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }

        }
    }

    public static void sort_v12(int[] nums) {
        int temp;
        // 最外层nums.length-1表示：最多需要多少轮比较，例如 4, 3, 2, 6四个数需要三轮比较，每轮比较确定一个值的最终位置
        int lastExchangePos = -1;
        // 无序数列的边界，每次比较到这里为止
        int sortBorder = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            // nums.length - 1 - i表示本轮需要多少次两两相邻比较
            // 内部循环实现每一轮的冒泡处理，先进行元素比较，再进行元素交换
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                // 相邻两个数据进行比较，较小值上浮
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    // false表明发生了元素交换，所以不是有序的
                    isSorted = false;
                    // 更新为最后一次交换元素的位置
                    lastExchangePos = j;
                }
            }
            sortBorder = lastExchangePos;
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{-4, 2, 3, 5, 6, 1, -1, -2, 8, 9, 10, 1, -1, 2};
        sort_v13(array);
        System.out.println(Arrays.toString(array));
    }
}
