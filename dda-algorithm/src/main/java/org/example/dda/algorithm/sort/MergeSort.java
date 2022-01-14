package org.example.dda.algorithm.sort;

import java.util.Arrays;

/**
 * 稳定排序算法
 * 时间复杂度T(n)=2T(n/2)+O(n), 因此最坏、最佳、平均情况下归并排序时间复杂度均为O(nlogn)
 * @author Williami
 * @description
 * @date 2022/1/4
 */
public class MergeSort {

    private static void merge(int[] a, int low, int mid, int high) {
        // 本次排序临时数组
        int[] temp = new int[high - low + 1];
        // 左指针
        int i = low;
        // 右指针
        int j = mid + 1;

        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 左右子数列最多还剩一个数列存在剩余元素
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }

        // 把有序新数组中的数覆盖到原nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }

    }

    static int count = 0;
    public static void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) >> 1;
        if (low < high) {
            // 左边
            mergeSort(a, low, mid);
            // 右边
            mergeSort(a, mid + 1, high);
            // 左右归并
            merge(a, low, mid, high);
            System.out.println("第"+(++count)+"次排序结果= "+Arrays.toString(a));
        }

    }

    public static void main(String[] args) {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        System.out.println("原数组:"+Arrays.toString(a));
        mergeSort(a, 0, a.length - 1);
        System.out.println("最终排序结果：" + Arrays.toString(a));
    }

}
