package com.ruthlessimagineers.testlogger;

import cucumber.api.java.Before;
import gherkin.formatter.model.Scenario;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;
import org.elasticsearch.common.joda.Joda;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by krishnanand on 19/01/17.
 */
public class TestScribbleTest {

    @Test
    public void loggerTest() {
//        Scribble scribble = Scribbler.getPaper(this);
//        scribble.scribble("Test scribble");
//        TestScribbleTest loggerTest = new TestScribbleTest();
//        Scribbler logger1 = Scribbler.getPaper(loggerTest);
//        logger1.scribble("Test log1");
       // Joda joda = J

        System.out.println(new Joda().toString());
    }

    @Test
    public void classpathScannerTest() throws ClassNotFoundException {

        FastClasspathScanner fastClasspathScanner = new FastClasspathScanner();
        fastClasspathScanner.enableMethodAnnotationIndexing();
        ScanResult scanResult = fastClasspathScanner.scan();
        List<String> namesOfClassesWithAnnotation = scanResult.getNamesOfClassesWithMethodAnnotation(Before.class);
        Class<?> className = Class.forName(namesOfClassesWithAnnotation.get(0));
        Arrays.stream(className.getDeclaredMethods()).forEach(method -> System.out.println(method.getParameterTypes().toString()));

        Arrays.stream(Scenario.class.getSuperclass().getSuperclass().getSuperclass().getDeclaredFields()).forEach(System.out::println);
    }
}
