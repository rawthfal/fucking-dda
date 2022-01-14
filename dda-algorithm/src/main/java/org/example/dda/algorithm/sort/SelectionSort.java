package org.example.dda.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序, 不稳定排序算法，例如数列 1 1 0 4 3
 * <p>
 * 时间复杂度：
 * 选择排序的复杂度分析。第一次内循环比较N - 1次，然后是N-2次，N-3次，……，最后一次内循环比较1次。
 * 共比较的次数是 (N - 1) + (N - 2) + ... + 1，求等差数列和，得 (N - 1 + 1)* N / 2 = N^2 / 2。
 * 舍去最高项系数，其时间复杂度为 O(N^2)。
 * <p>
 * 虽然选择排序和冒泡排序的时间复杂度一样，但实际上，选择排序进行的交换操作很少，最多会发生 N - 1次交换。
 * 而冒泡排序最坏的情况下要发生N^2 /2交换操作。从这个意义上讲，交换排序的性能略优于冒泡排序。
 * 而且，交换排序比冒泡排序的思想更加直观。
 *
 * @author Williami
 * @description
 * @date 2022/1/4
 */
public class SelectionSort {

    /**
     * 排序思想：选出最小的一个和第一个位置交换，选出其次小的和第二个位置交换 ……直到从第N个和第N-1个元素中选出最小的放在第N-1个位置。
     *
     * @param nums
     */
    //选择排序
    public static void selectSort(int[] nums) {
        //遍历所有的数
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            // 把当前遍历的数和后面所有的数依次进行比较，并记录下最小的数的下标
            for (int j = i + 1; j < nums.length; j++) {
                // 如果后面比较的数比记录的最小的数小
                if (nums[j] < nums[min]) {
                    //记录最小的那个数的下标
                    min = j;
                }
            }
            // 如果最小的数和当前遍历数的下标不一致，说明下标为min的数比当前遍历的数更小
            if (i != min) {
                swap(nums, i, min);
            }

        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
