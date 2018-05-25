package com.core.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangkai
 * Date 2018/5/11
 */
public class ClassCastExceptionTest {
    public static Map map = new HashMap(){{
        put("a","2");
    }};

    public static void main(String[] args)  {
        System.out.println(map.get("a"));
        Integer aa = (Integer) map.get("a");
    }
}
