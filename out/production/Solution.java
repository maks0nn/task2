package com.company;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static List<Integer> joinSortedLists(List<Integer> list1, List<Integer> list2){
        if (list1.isEmpty()){
            return list2;
        }
        if (list2.isEmpty()){
            return list1;
        }
        List<Integer> listRes = new LinkedList<>();
        int v1 = list1.get(0);
        list1.remove(0);
        int v2 = list2.get(0);
        list2.remove(0);
//        if (v1 > v2){
//            listRes.add(v2);
//            v2 = list2.get(0);
//            list2.remove(0);
//        }else {
//            listRes.add(v1);
//            v1 = list2.get(0);
//            list1.remove(0);
//        }
        while (!list1.isEmpty() && !list2.isEmpty()){
            if (v1 > v2){
                listRes.add(v2);
                v2 = list2.get(0);
                list2.remove(0);
            }else {
                listRes.add(v1);
                v1 = list1.get(0);
                list1.remove(0);
            }
        }
        if (list1.isEmpty()){
            while (!list2.isEmpty()){
                listRes.add(v2);
                v2 = list2.get(0);
                list2.remove(0);
            }
            listRes.add(v2);
        }else {
            while (!list1.isEmpty()){
                listRes.add(v1);
                v1 = list1.get(0);
                list1.remove(0);
            }
            listRes.add(v1);
        }
        return listRes;
    }
}
