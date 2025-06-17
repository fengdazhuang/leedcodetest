package com.fzz.medium;

import java.util.Arrays;

public class Test274 {
    /**
     * 先排序，遍历该升序数组
     * 如果当前引用次数大于等于列表长度减去当前索引（即当前论文被引用的次数大于等于剩余论文的数量），
     * 那么说明至少有len-i篇论文的引用次数大于等于len-i。
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len=citations.length;
        for(int i=0;i<len;i++){
            if(citations[i]>=len-i) return len-i;
        }
        return 0;
    }
}
