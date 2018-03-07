package com.glb.bootcamp.tae.testng;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class TestNGTest {

    private Map<String, String> map;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        map = new HashMap<>();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        map.clear();
    }

    @Test(dataProvider = "myDataProvider")
    public void myTestAgainSameName(String key, String value) {
        map.put(key, value);
        System.out.println("myTestAgainSameName:" + map.get(key));
    }

    @Test(dataProvider = "myDataProvider2")
    public void myTestAgainSameName2(String key, String value) {
        map.put(key, value);
        System.out.println("myTestAgainSameName2:" + map.get(key));
    }

    // It's very common to read data from external resources such as:
    // XML, JSON, XLS, CSV -> files
    // Services
    // Databases

    @DataProvider(name = "myDataProvider")
    public Object[][] myDataProvider(){
        return new Object[][]{{"key1","value1"},
                {"key2","value2"}};
    }

    @DataProvider(name = "myDataProvider2")
    public Iterator<Object[]> myDataProvider2(){
        List<Object[]> data = new ArrayList<>();
        data.add(new String[]{"key1", "value1"});
        data.add(new String[]{"key2", "value2"});
        return data.iterator();
    }

    class MyDataProvider {
        @DataProvider(name = "myDataProvider2")
        public Iterator<Object[]> myDataProvider2(){
            List<Object[]> data = new ArrayList<>();
            data.add(new String[]{"key1", "value1"});
            data.add(new String[]{"key2", "value2"});
            return data.iterator();
        }
    }

    class MyListener extends TestListenerAdapter {
        @Override
        public void onTestFailure(ITestResult tr) {
            super.onTestFailure(tr);
            // Connect to Test Management Tool API and inform the test status
        }
    }

}
