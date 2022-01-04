package org.example.dda.algorithm.array;

import java.awt.image.Kernel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Williami
 * @description
 * @date 2022/1/4
 */
public class IntersectionofTwoArraysII_350 {

    public static int[] intersect(int[] nums1, int[] nums2) {
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
        int[] nums1 = new int[]{1, 2, 2, 1, 3};
        int[] nums2 = new int[]{2, 2};
        int[] intersect = intersect(nums1, nums2);
        if (intersect != null) {
            System.out.println(Arrays.toString(intersect));
        } else {
            System.out.println("结果集为null");
        }
    }
}
