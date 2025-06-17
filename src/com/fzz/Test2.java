package com.fzz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
    List<List<Integer>> tasks;
    Integer[] task;

    public Test2(List<List<Integer>> tasks) {
        this.tasks=tasks;
        task= new Integer[]{-1, -1, -1};
    }

    public void add(int userId, int taskId, int priority) {
        for (List<Integer> task : tasks) {
            if(task.get(1) ==taskId){
                return;
            }
        }
        List<Integer> list=new ArrayList<>();
        list.add(userId);
        list.add(taskId);
        list.add(priority);
        tasks.add(list);
        if(task[2]<priority){
            task[2]=priority;
            task[1]=taskId;
            task[0]=userId;
        }else if(task[2]==priority&&task[1]<taskId){
            task[1]=taskId;
            task[0]=userId;
        }


    }

    public void edit(int taskId, int newPriority) {
        for (List<Integer> task : tasks) {
            if(task.get(1) ==taskId){
                task.set(2,newPriority);
            }
        }
    }

    public void rmv(int taskId) {
        for (List<Integer> task : tasks) {
            if(task.get(1) ==taskId){
                Integer userId = task.get(0);
                tasks.remove(task);


            }
        }


    }

    public int execTop() {
        if(tasks.size()==0) return -1;
        Integer integer = task[0];
        rmv(integer);
        return integer;
    }
}
