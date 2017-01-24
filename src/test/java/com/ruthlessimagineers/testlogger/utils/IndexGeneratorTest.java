package com.ruthlessimagineers.testlogger.utils;

import gherkin.deps.com.google.gson.JsonObject;
import org.junit.Test;

import java.util.Date;

/**
 * Created by krishnanand on 22/01/17.
 */
public class IndexGeneratorTest {

    @Test
    public void test() {
        for(int i=0; i<10; i++) {
            IndexGenerator indexGenerator = new IndexGenerator();
            System.out.println(indexGenerator.generateName().toLowerCase());
        }
    }

    @Test
    public void jsonTest() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name","Krishna");
        jsonObject.addProperty("timestamp",new Date().toString());
        System.out.println(jsonObject.toString());


    }

}
