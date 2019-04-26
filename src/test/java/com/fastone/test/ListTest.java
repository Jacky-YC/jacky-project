package com.fastone.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ListTest {

    public static void main(String[] args) throws InterruptedException {

        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(6L);
        List<Long> queueIds = new ArrayList<>();
        queueIds.add(1L);
        queueIds.add(4L);
        do {
            ids.retainAll(queueIds);
            if (ids.isEmpty()) {
                System.out.println("所有子job全部停止，可以退出循环");
                break;
            } else {
                log.info("还有{}个job没有停止", ids.size());
                Thread.sleep(1000);
                queueIds.remove(0);
            }
        } while (!ids.isEmpty());

    }

}
