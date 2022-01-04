package org.example.dda.algorithm.array;

import com.sun.corba.se.impl.orbutil.ObjectStreamClass_1_3_1;

import java.awt.image.Kernel;
import java.util.*;


/**
 * @author Williami
 * @description
 * @date 2022/1/4
 */
public class IntersectionofTwoArraysII_350 {

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect_v1(int[] nums1, int[] nums2) {
        int mapCapacity = nums1.length <= nums2.length ? nums1.length : nums2.length;
        Map<Integer, Integer> map = new HashMap<>(tableSizeFor(mapCapacity));
        for (int ele : nums1) {
            Integer count = map.get(ele);
            if (count == null) {
                map.put(ele, 1);
            } else {
                map.put(ele, ++count);
            }
        }

        // 交集实际元素个数
        int k = 0;
        for (int ele : nums2) {
            Integer count = map.get(ele);
            if (count != null && count > 0) {
                map.put(ele, --count);
                nums2[k++] = ele;
            }
        }

        //
        int[] returnArray = new int[k];
        for (int i = 0; i < k; i++) {
            returnArray[i] = nums2[i];
        }
        return returnArray;
    }

    /**
     * 排序双指针算法: O(max(nlogn,mlogm,n+m))
     * 先对数组排序，再利用双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        sort(nums1);
        sort(nums2);
        // 排过序的数组，双指针任一指针走到最后都将结束
        int k = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            int top = nums1[i];
            int down = nums2[j];
            if (top == down) {
                i++;
                j++;
                // 遍历过的数据，已经没啥用了，重复利用，节省空间
                nums1[k++] = top;
                continue;
            }
            // 值小的指针往后走
            if (top > down) {
                j++;
            } else {
                i++;
            }
        }

        int[] newArray = new int[k];
        for (int i = 0; i < k; i++) {
            newArray[i] = nums1[i];
        }
        return newArray;
    }

    private static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        int p, i, j, temp;
        if (low >= high) {
            return;
        }
        // p 就是基准数,这里就是每个数组的第一个
        p = arr[low];
        i = low;
        j = high;
        while (i < j) {
            //右边当发现小于p的值时停止循环
            while (arr[j] >= p && i < j) {
                j--;
            }

            //这里一定是右边开始，上下这两个循环不能调换（下面有解析，可以先想想）

            //左边当发现大于p的值时停止循环
            while (arr[i] <= p && i < j) {
                i++;
            }
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[low] = arr[i];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
        arr[i] = p;
        quickSort(arr, low, j - 1);  //对左边快排
        quickSort(arr, j + 1, high); //对右边快排
    }

    /**
     * 使用集合实现
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect_1(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1) {
            list1.add(num);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            if (list1.contains(num)) {
                list2.add(num);
                // 从 list1 除去已匹配的数值
                list1.remove(Integer.valueOf(num));
            }
        }
        int[] res = new int[list2.size()];
        int i = 0;
        for (int num : list2) {
            res[i++] = num;
        }
        return res;
    }


    static final int MAXIMUM_CAPACITY = 1 << 30;

    // 计算 >= cap的2的最小幂次方
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 3, 4, 5, 1, 0, -1, 9, 3};
        //sort(nums1);
        //System.out.println(Arrays.toString(nums1));
        int[] nums2 = new int[]{2, 2, 3};

        int[] intersect = intersect(nums1, nums2);
        if (intersect != null) {
            System.out.println(Arrays.toString(intersect));
        } else {
            System.out.println("结果集为null");
        }
    }


}
