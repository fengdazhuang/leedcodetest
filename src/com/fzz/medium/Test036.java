package com.fzz.medium;

import java.util.HashMap;
import java.util.Map;

public class Test036 {
    public static void main(String[] args) {
        Solution36 s=new Solution36();
        boolean validSudoku = s.isValidSudoku(new char[][]{{'.','1','.','5','2','.','.','.','.'},{'.','.','.','.','.','6','4','3','.'},
        {'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','9','.','.'},
        {'.','.','.','.','.','.','.','5','.'},{'.','.','.','5','.','.','.','.','.'},
        {'9','.','.','.','.','3','.','.','.'},
        {'.','.','6','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}});
        System.out.println(validSudoku);
    }
}

/**
 * 用两层for循环遍历数组，
 * 用双层map记录每个出现的数字及该数字的位置map
 * 对每个数字判断是否已经出现过（在map里），如果是：以该数字为key获取该数字出现过的位置，也是一个map，key为行，value为列，
 * 如果行或列重复，直接返回false，如果目前遍历到的数字所在3*3宫内已经出现过，也直接返回false，通过判断则更新双层map；
 * 如果否：添加该数字到map中
 */
class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        Map<Character,Map<Integer,Integer>> map=new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch=board[i][j];
                if(ch=='.'){
                    continue;
                }
                if(map.containsKey(ch)){
                    Map<Integer, Integer> integerMap = map.get(ch);
                    if (integerMap.containsKey(i)||integerMap.containsValue(j)){
                        return false;
                    }
                    if(!check(integerMap,i,j)){
                        return false;
                    }
                    integerMap.put(i,j);
                    map.put(ch,integerMap);
                }else{
                    Map<Integer,Integer> newMap = new HashMap<>();
                    newMap.put(i,j);
                    map.put(ch,newMap);
                }

            }
        }
        return true;
    }

    //检查该数字在所在3*3宫内是否重复存在
    private boolean check(Map<Integer,Integer> map,int row,int colum){
        //九宫格检查
        int rowDown,rowUp,colDown,colUp;
        if(row>=6){
            rowDown=6;
            rowUp=8;
        }else if(row>=3){
            rowDown=3;
            rowUp=5;
        }else {
            rowDown=0;
            rowUp=2;
        }
        if(colum>=6){
            colDown=6;
            colUp=8;
        }else if(colum>=3){
            colDown=3;
            colUp=5;
        }else {
            colDown=0;
            colUp=2;
        }
        for(int i=rowDown;i<=rowUp;i++){
            if(map.containsKey(i)){
                Integer col = map.get(i);
                if(col>=colDown&&col<=colUp){
                    return false;
                }
            }
        }
        return true;

    }
}