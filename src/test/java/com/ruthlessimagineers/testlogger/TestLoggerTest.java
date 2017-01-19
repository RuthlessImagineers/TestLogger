package com.ruthlessimagineers.testlogger;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import gherkin.formatter.model.BasicStatement;
import gherkin.formatter.model.Scenario;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ClassInfo;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.lukehutch.fastclasspathscanner.scanner.ScanResult.*;
/**
 * Created by krishnanand on 19/01/17.
 */
public class TestLoggerTest {

    @Test
    public void loggerTest() {
        TestLogger logger = new TestLogger(this);
        logger.log("Test log");
        TestLoggerTest loggerTest = new TestLoggerTest();
        TestLogger logger1 = new TestLogger(loggerTest);
        logger1.log("Test log1");
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
