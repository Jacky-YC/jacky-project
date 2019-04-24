package com.fastone.test;

import com.fastone.test.util.TestStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStatusCode {

    @Test
    public void test() {
        if (TestStatus.QUEUED.ordinal()>TestStatus.FINISHED.ordinal()){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

}
