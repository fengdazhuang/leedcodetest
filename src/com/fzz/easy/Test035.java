package com.fzz.easy;


import java.util.Arrays;

public class Test035 {
    public static void main(String[] args) {
        Solution35 solution = new Solution35();
        int[] nums = {1,3,5,6};
        int target = 0;
        System.out.println(solution.searchInsert(nums, target));
    }
}


class Solution35 {

    /**
     * 方法一：
     * 从头循环遍历，步长初始为1，每次循环判断当前索引所在值nums[i]与target的关系，
     * 当相等时，直接索引
     * 当nums[i]>target时，说明target在i之前，
     *      当nums[i-1]<target时，说明target大小在nums[i-1]和nums[i]之间，返回i
     *      否则，对i进行回退，且步长重置
     * 当nums[i]<target时，步长+1，继续循环
     * 当出现IndexOutOfBoundsException时，先判断step是否为2，如果是则表示数组中没有目标值且目标值大于数组中最大的元素，
     *      返回此时的索引i，否则，对i进行回退，且步长重置
     */
    public int searchInsert1(int[] nums, int target) {
        if (nums[0] > target) return 0;
        int step = 1;
        int i = 0;
        while (true) {
            try {
                if (nums[i] == target) return i;
                if (nums[i] > target) {
                    if (nums[i - 1] < target) return i;
                    i = i - step + 1;
                    step = 1;
                } else {
                    i = i + step;
                    step++;
                }
            } catch (IndexOutOfBoundsException e) {
                if (step == 2) return i;
                i = i - step + 1;
                step = 1;
            }
        }
    }

    /**
     * 方法二：
     * 二分查找法
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}