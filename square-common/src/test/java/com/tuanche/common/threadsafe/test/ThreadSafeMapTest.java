package com.tuanche.common.threadsafe.test;
import com.tuanche.common.threadsafe.ThreadSafeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * Created by tc on 2016/1/30.
 */
public class ThreadSafeMapTest {
    String[][] params = null;
    CountDownLatch endLatch;

    @Before
    public void before() {
        params = new String[1000][100];
        for (int i = 0; i < params.length; i++) {
            for (int j = 0; j < params[i].length; j++) {
                params[i][j] = String.valueOf(i) + String.valueOf(j);
            }
        }
        endLatch = new CountDownLatch(params.length);
    }

    @Test
    /**
     * 测试多线程写入MAP是否存在数据丢失
     */
    public void testMutilThread() throws InterruptedException {

        ThreadSafeMap map = new ThreadSafeMap();
        for (int i = 0; i < params.length; i++) {
            Thread t = new Thread(new ManipulateMap(map, params[i], endLatch,i));
            t.start();
        }
        endLatch.await();

//        Assert.assertEquals(map.size(), params.length * params[0].length);
        for (int i = 0; i < params.length; i++) {
            for (int j = 0; j < params[i].length; j++) {
                Assert.assertEquals(params[i][j],map.get(String.valueOf(i) + String.valueOf(j)));
            }

        }
    }

//    System.out.println("结束");

    class ManipulateMap implements Runnable {

        Map map;
        String[] param;
        CountDownLatch cd;
        int rownum;

        public ManipulateMap(Map paramMap, String[] params, CountDownLatch cd,int rownum) {
            this.map = paramMap;
            this.param = params;
            this.cd = cd;
            this.rownum=rownum;
        }

        public void run() {
            for (int i = 0; i < param.length; i++) {
                map.put(String.valueOf(rownum)+String.valueOf(i), param[i]);
            }
            cd.countDown();
        }
    }
}
