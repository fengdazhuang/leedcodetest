package com.fzz.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test228 {
    public static void main(String[] args) {
        Solution228 solution=new Solution228();
        int[] nums={0,1,2,4,5,7};
        System.out.println(solution.summaryRanges(nums));
    }
}


/**
 * 思路：
 * 遍历数组，记录当前连续序列的起始和结束位置，当遇到不连续的元素时，将当前序列加入list中，并更新起始和结束位置
 */
class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        List<String> list = new ArrayList<>();
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (end + 1 == nums[i]) {
                end = nums[i];
            } else {
                if (start == end) list.add(start + "");
                else list.add(start + "->" + end);
                start = end = nums[i];
            }
        }
        if (start == end) list.add(start + "");
        else list.add(start + "->" + end);
        return list;
    }
}