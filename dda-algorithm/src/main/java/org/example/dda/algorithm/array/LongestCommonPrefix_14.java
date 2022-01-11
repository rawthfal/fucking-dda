package org.example.dda.algorithm.array;

import java.util.Arrays;

/**
 * 最长公共前缀:编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
 * <p>
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * @author Williami
 * @description
 * @date 2022/1/7
 */
public class LongestCommonPrefix_14 {

    /**
     * 时间复杂度：数组所有字符串的长度？基准元素的长度？
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] consists of only lower-case English letters.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        String pivot = strs[0];
        for (int i = 1; i < len; i++) {
            int j = 0, m = 0;
            int pivotLen = pivot.length();
            int curLen = strs[i].length();
            int min = pivotLen < curLen ? pivotLen : curLen;
            while (j < min) {
                if (pivot.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                m++;
                ++j;
            }
            //
            if (m == 0) {
                return "";
            }
            pivot = pivot.substring(0, m);
        }

        return pivot;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"cir", "car"}));

        String[] strs = new String[]{"a", "ab", "adb", "ba", "b", "cb"};
        Arrays.sort(strs);
        // a, ab, adb, b , ba, cb
        System.out.println(Arrays.toString(strs));
    }

}
