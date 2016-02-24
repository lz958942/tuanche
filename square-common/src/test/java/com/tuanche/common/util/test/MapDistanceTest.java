package com.tuanche.common.util.test;

import com.tuanche.common.util.MapUtil;
import org.junit.Test;

/**
 * Created by tc on 2016/1/30.
 */
public class MapDistanceTest {

    @Test
    public void getDistance(){
        //测试西客站以及瑞达公寓距离 百度地图测距3公里,计算结果也为3公里
        System.out.println(MapUtil.GetShortDistance(116.294169,39.907994,116.32874,39.900874));
    }
}
