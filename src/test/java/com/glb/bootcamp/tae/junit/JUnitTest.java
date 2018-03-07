package com.glb.bootcamp.tae.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(MyRunner.class)
//@RunWith(Parameterized.class)
public class JUnitTest {

    private Map<String, String> map;

    private final String key;
    private final String value;

    public JUnitTest(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Before
    public void setUp() {
        map = new HashMap<>();
    }

    @After
    public void tearDown() {
        map.clear();
    }

    @Test
    public void myTestWithJunit() {
        map.put(key, value);
        System.out.println("myTestWithJunit:" + map.get(key));
    }

    @Parameterized.Parameters
    public static List<Object[]> myParameters() {
        List<Object[]> params = new ArrayList<>();
        params.add(new String[]{"key1", "value1"});
        params.add(new String[]{"key2", "value2"});
        return params;
    }

    @Test
    public void testSoftAssertions() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("a1", "a1", "assert1");
        softAssert.assertEquals("a2", "a2", "assert2");
        softAssert.assertEquals("a3", "a1", "assert3");
        softAssert.assertEquals("a4", "a4", "assert4");
        softAssert.assertEquals("a5", "a3", "assert5");
        softAssert.assertEquals("a6", "a6", "assert6");
        softAssert.assertAll();
    }

}
