package org.example.dda.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序分为两种，直接插入排序和二分插入排序，本节我们只介绍直接插入排序。这两种插入排序实际上都是插入排序，唯一的不同就是插入的方式不一样。
 * 插入排序就是往数列里面插入数据元素。一般我们认为插入排序就是往一个已经排好序的待排序的数列中插入一个数，使得插入这个数之后，数列仍然有序。
 * 二分插入排序也是用了分治法的思想去排序的。实际上二分就是使用二分查找来找到这个插入的位置，剩余的插入的思想其实和直接插入排序一样。
 *
 * @author Williami
 * @description
 * @date 2022/1/4
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, -3, 23, 3, -12, -1, 2, 34, -30, 12, 2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        ;
    }

    /**
     * 直接插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        // 从第二个元素开始
        for (int i = 1; i < arr.length; i++) {
            // 依次遍历索引 i 之前的元素，直到找到合适的插入位置
            for (int j = i; j > 0; j--) {
                if (arr[j] >= arr[j - 1]) {
                    break;
                }
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    public void sort(int[] array) {
        int length = array.length;
        if (length > 0) {
            for (int i = 1; i < length; i++) {
                int temp = array[i];
                int j = i;
                for (; j > 0 && array[j - 1] > temp; j--) {
                    array[j] = array[j - 1];
                }
                array[j] = temp;
            }
        }
    }

    /**
     * 折半插入排序
     *
     */
    public void binInsertSort(int[] data) {
        int key, left, rigth, middle;
        for(int i = 1; i < data.length; i++) {
            key = data[i];
            left = 0;
            rigth = i - 1;
            while(left <= rigth) {
                middle = (left + rigth)/2;
                if (data[middle] > key) {
                    rigth = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            for(int j = i-1; j >= left; j--) {
                data[j+1] = data[j];
            }
            data[left] = key;
        }
    }
}

