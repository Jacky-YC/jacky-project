package com.fastone.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {

        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
//        ids.add(4L);
        ids.add(6L);

        List<Long> ods = new ArrayList<>();
        ods.add(1L);
        ods.add(4L);

//        ids.retainAll(ods); // 交集
//        System.out.println(ids);

        ids.removeAll(ods);  // 差集
//        System.out.println(ids);
        ids.addAll(ods); // 差并集
        System.out.println(ids);


    }

}
