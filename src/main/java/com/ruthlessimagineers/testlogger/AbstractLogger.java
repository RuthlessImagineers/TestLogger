package com.ruthlessimagineers.testlogger;

import com.ruthlessimagineers.testlogger.core.ScenarioDetails;
import com.ruthlessimagineers.testlogger.utils.Level;
import cucumber.api.Scenario;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;

public abstract class AbstractLogger {

    private Object o;

    public AbstractLogger(Object o) {
        this.o = o;
        makeLogsDirectory();
    }

    protected void scribble(String message, Level level) {
        Logger logger = Logger.getLogger(o.getClass());
        switch (level) {
            case INFO:
                logger.info(message);
                break;
            case DEBUG:
                logger.debug(message);
                break;
            case ERROR:
                logger.error(message);
                break;
            case FATAL:
                logger.fatal(message);
        }

    }

    protected void scribble(String message, Level level, Throwable t) {
        Logger logger = Logger.getLogger(o.getClass());
        switch (level) {
            case INFO:
                logger.info(message,t);
                break;
            case DEBUG:
                logger.debug(message,t);
                break;
            case ERROR:
                logger.error(message,t);
                break;
            case FATAL:
                logger.fatal(message,t);
        }

    }

    protected void setStatus() throws IllegalAccessException {
        Optional<Field> scenario = getScenario();
        if(scenario.isPresent()) {
            Scenario scn = (Scenario) scenario.get().get(this.o);
            scribble("[Status] -- "+scn.getStatus(),Level.INFO);
        }
    }

    private void makeLogsDirectory()  {
        System.setProperty("project.dir",System.getProperty("user.dir"));
        String currentPath = System.getProperty("project.dir");
        Optional<Field> first = getScenario();
        if(first.isPresent()) {
            Scenario o = null;
            try {
                o = (Scenario) first.get().get(this.o);
                System.out.println(o.getStatus());
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
        Properties props = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("log4j.properties");
        try {
            props.load(inputStream);
            System.out.println(props.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        PropertyConfigurator.configure(props);
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
