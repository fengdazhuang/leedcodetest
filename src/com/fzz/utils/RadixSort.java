package com.fzz.utils;

import java.util.Arrays;

public class RadixSort {

    // 获取数组中最大数的位数
    private static int getMaxDigits(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        return (int) Math.log10(max) + 1;
    }

    // 获取数字指定位上的数字
    private static int getDigit(int num, int digit) {
        return (num / (int) Math.pow(10, digit)) % 10;
    }

    // 基数排序主方法
    public static void radixSort(int[] arr) {
        if (arr.length == 0) return;

        int maxDigits = getMaxDigits(arr);
        int[] output = new int[arr.length];

        // 从最低位开始排序
        for (int digit = 0; digit < maxDigits; digit++) {
            int[] count = new int[10];

            // 统计每个桶中元素的个数
            for (int num : arr) {
                int d = getDigit(num, digit);
                count[d]++;
            }

            // 计算累计位置
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // 将元素放入输出数组的正确位置
            for (int i = arr.length - 1; i >= 0; i--) {
                int d = getDigit(arr[i], digit);
                output[count[d] - 1] = arr[i];
                count[d]--;
            }

            // 将排序结果复制回原数组
            System.arraycopy(output, 0, arr, 0, arr.length);
        }
    }
}
