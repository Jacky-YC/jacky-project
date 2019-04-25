package com.fastone.test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {

        Set<Long> oldSet = new HashSet<Long>();
        oldSet.add(1L);
        oldSet.add(4L);
        oldSet.add(8L);
        oldSet.add(3L);

        Set<Long> newSet = new HashSet<Long>();
        newSet.add(1L);
        newSet.add(4L);

        System.out.println("oldSet:"+oldSet);
        System.out.println("newSet:"+newSet);

        HashSet<Long> set = new HashSet<>();
        set.clear();
        set.addAll(oldSet);
        set.addAll(newSet);
//        System.out.println(set.toString());
//        set.removeAll(newSet); // 差集
//        set.retainAll(newSet);// 交集
//        System.out.println("oldSet 与 newSet 的差集："+set.toString());
//        System.out.println("oldSet 与 newSet 的交集："+set.toString());
        System.out.println("oldSet 与 newSet 的并集："+set.toString());


    }

}
