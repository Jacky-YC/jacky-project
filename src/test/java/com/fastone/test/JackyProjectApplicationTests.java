package com.fastone.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JackyProjectApplicationTests {

    @Test
    public void contextLoads() {
//        Map map = mock(Map.class);
//        Assert.assertTrue(map instanceof HashMap);
        List list = mock(ArrayList.class);
//        Assert.assertTrue(list instanceof List);
//        when(map.size()).thenReturn(100);
//        Assert.assertEquals(map.size(),100);
    }

    @Test
    public void AssertTest(){
        // 不为空抛异常
        Assert.isNull(null,"不为空！");
    }

    @Test
    public void verifyCount(){

        List list = mock(List.class);
        list.add(1);
        list.add(2);
        list.add(3);

        verify(list).add(1);



    }

    @Test(expected = IOException.class)
    public void when_Throw() throws IOException {
        OutputStream os = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(os);

        doThrow(new IOException()).when(os).close();
        os.close();
    }

}
