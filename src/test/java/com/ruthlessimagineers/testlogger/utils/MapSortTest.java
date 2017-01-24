package com.ruthlessimagineers.testlogger.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by krishnanand on 20/01/17.
 */
public class MapSortTest {

    @Test
    public void mapSort() {
        Map<String,String> map = new HashMap<>();
        map.put("Delete","10.00AM");
        map.put("Add","09.00AM");
        map.put("Delete","09.00AM");
        System.out.println(map);
        Collections.sort(new ArrayList<>(map.keySet()));
        System.out.println(map);
    }
}
