package org.example.dda.algorithm.sort;

import java.util.Arrays;

/**
 * 算法时间复杂度:
 * <p>
 * 构建堆时间复杂度O(n)，调整堆时间复杂度O(nlogn)，总的时间复杂度O(nlogn)，堆排序为就地排序，空间复杂度O(1)
 * 所谓就地排序：指不申请多余的空间或允许少量额外的辅助变量来进行的排序，就是在原来的排序数据中比较和交换的排序， 例如堆排序, 冒泡排序，快速排序
 *
 * @author Williami
 * @description
 * @date 2022/1/4
 */
public class HeapSort {


    /**
     * 堆排序
     */
    private static void heapSort(int[] arr) {
        // 将待排序的序列构建成一个大顶堆
        for (int i = arr.length - 1 >> 1; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }
        System.out.println("***********构造大顶堆结束****************");

        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            swap(arr, 0, i);
            // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
            heapAdjust(arr, 0, i);
        }

    }

    /**
     * https://blog.csdn.net/zdp072/article/details/44227317
     * 将待排序的序列构造成一个大顶堆。此时，整个序列的最大值就是堆顶的根节点。将它移走(其实就是将其与堆数组的末尾元素交换，此时末尾元素就是最大值)，
     * 然后将剩余的n-1个序列重新构造成一个堆，这样就会得到n个元素中的次最大值。如此反复执行，就能得到一个有序序列了。
     * <p>
     * 自上而下调整大顶堆（非递归）构建堆的过程
     *
     * @param arr 需要排序的数组
     * @param i   需要构建堆的根节点的序号
     * @param n   数组的长度
     */
    private static void heapAdjust(int[] arr, int i, int n) {
        System.out.println("调整前堆" + Arrays.toString(arr));
        int child;
        int father;
        for (father = arr[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);

            // 如果左子树小于右子树，则需要比较右子树和父节点
            if (child < n - 1 && arr[child] < arr[child + 1]) {
                child++; // 序号增1，指向右子树
            }

            // 如果父节点小于孩子结点，则需要交换
            if (father < arr[child]) {
                arr[i] = arr[child];
            } else {
                break; // 大顶堆结构未被破坏，不需要调整
            }
        }
        arr[i] = father;
        System.out.println("调整后堆" + Arrays.toString(arr));
        System.out.println("----------------------------------------------------------");

    }

    // 获取到左孩子结点
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    // 交换元素位置
    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    //自上而下调整大顶堆（递归）
    private static void heapAdjust2(int[] array, int k, int length) {
        int k1 = 2 * k + 1;
        if (k1 < length - 1 && array[k1] < array[k1 + 1]) {
            k1++; // 指向右子树
        }

        if (k1 > length - 1 || array[k] >= array[k1]) { // 没有破坏大顶堆，不需要调整
            return;
        }

        //将堆顶元素和左右子结点中较大节点交换
        swap(array, k1, k);
        heapAdjust2(array, k1, length);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 7, 4, 1, 9, 6, 7, 5, -1};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
