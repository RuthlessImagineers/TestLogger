package com.ruthlessimagineers.testlogger;


import com.ruthlessimagineers.testlogger.core.ScenarioDetails;
import cucumber.api.Scenario;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Optional;

public class TestLogger {

    private Object o;
    public TestLogger(Object o) {
        this.o = o;
        makeLogsDirectory();
    }

    public void log(String message) {
        Logger logger = Logger.getLogger(o.getClass());
        System.out.println(logger.getName() +"=="+logger);
        logger.info(message);
    }

    private void makeLogsDirectory()  {
        System.setProperty("project.dir",System.getProperty("user.dir"));
        String currentPath = System.getProperty("project.dir");
        Optional<Field> first = getScenario();
        if(first.isPresent()) {
            Scenario o = null;
            try {
                o = (Scenario) first.get().get(this.o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            File file = getLogFile(currentPath, o);
            if (!file.exists()) {
                createFeatureDirectory(file);
                try {
                    createLogFile(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            configureLogProperty();
        }
    }

    private void createLogFile(File file) throws IOException {
        file.createNewFile();
        System.setProperty("logfile.name",file.getAbsolutePath());
    }

    private void createFeatureDirectory(File file) {
        File file1 = new File(file.getParent());
        file1.mkdirs();
    }

    private void configureLogProperty() {
        PropertyConfigurator.configure(getClass().getClassLoader().getResourceAsStream("log4j.properties"));
    }

    private File getLogFile(String currentPath, Scenario o) {
        ScenarioDetails scenarioDetails = new ScenarioDetails(o.getId());
        String directoryName = currentPath + File.separator + "logs" + File.separator + scenarioDetails.getFeatureName();
        String fileName = directoryName + File.separator + scenarioDetails.getScenarioName() + "_" + o.hashCode() + ".log";
        return new File(fileName);
    }

    private Optional<Field> getScenario() {
        return (Optional<Field>) Arrays.stream(o.getClass().getDeclaredFields()).filter(field -> {
                field.setAccessible(true);
                return field.getType().equals(Scenario.class);
            }).findFirst();
    }
}
