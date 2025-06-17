package com.fzz.medium;

import java.util.*;

public class Test380 {




}

class RandomizedSet{
    List<Integer> list;
    HashMap<Integer,Integer> map;
    Random random;

    public RandomizedSet() {
        map=new HashMap<>();
        random=new Random();
        list=new ArrayList<>();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val,list.size());
            list.add(val);
            return true;
        }
        return false;

    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(index,last);
        list.remove(list.size()-1);
        map.remove(val);
        return true;

    }

    public int getRandom() {
        int index = random.nextInt();
        return list.get(index);
    }
}
