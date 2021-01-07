package com.lxz.demo.test;

import com.lxz.demo.Sex;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class Test {
    Jedis jedis =new Jedis("localhost");
    List<Sex> sex = new ArrayList<>();

}
