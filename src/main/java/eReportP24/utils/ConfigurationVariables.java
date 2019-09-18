package eReportP24.utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigurationVariables {
    //используем Singleton
    private static final ConfigurationVariables instance;

    private static String configFilePath = "src/main/resources/testConfigs/config.properties";
    private static String testDataFilePath = "src/main/resources/testConfigs/testData.properties";

    private static Properties configurationData = new Properties();
    private static Properties testData = new Properties();

    final private static Logger LOGGER = Logger.getLogger(ConfigurationVariables.class);

    public String currentBrowser = System.getProperty("currentBrowser");
    public String locale = System.getProperty("locale");
    public String timeout = System.getProperty("selenide.timeout");
    public String userLogin = System.getProperty("userLogin");
    public String userPassword = System.getProperty("userPassword");
    public String techLogin = System.getProperty("techLogin");
    public String techPassword = System.getProperty("techPassword");
    public String enterPassword = System.getProperty("enterPassword");
    public String urlBase = System.getProperty("urlBase");
    public String comID = System.getProperty("comID");
    public String comName = System.getProperty("comName");
    public String downloadsDir = System.getProperty("user.dir") + System.getProperty("file.separator") + "downloads" + System.getProperty("file.separator");

    static {
        fillMyProperties(configurationData, configFilePath);
        fillMyProperties(testData, testDataFilePath);
        instance = new ConfigurationVariables();
    }

    private ConfigurationVariables () {
        if (currentBrowser == null || currentBrowser.equalsIgnoreCase(""))
            currentBrowser = getProperty(configurationData, "currentBrowser");

        if (userLogin == null || userLogin.equalsIgnoreCase(""))
            userLogin = getProperty(configurationData, "userLogin");

        if (userPassword == null || userPassword.equalsIgnoreCase(""))
            userPassword = getProperty(configurationData, "userPassword");

        if (techLogin == null || techLogin.equalsIgnoreCase(""))
            techLogin = getProperty(configurationData, "techLogin");

        if (techPassword == null || techPassword.equalsIgnoreCase(""))
            techPassword = getProperty(configurationData, "techPassword");

        if (enterPassword == null || enterPassword.equalsIgnoreCase(""))
            enterPassword = getProperty(configurationData, "enterPassword");

        if (locale == null || locale.equalsIgnoreCase(""))
            locale = getProperty(configurationData, "locale");

        if (urlBase == null || urlBase.equalsIgnoreCase(""))
            urlBase = getProperty(configurationData, "urlBase");

        if (comID == null || comID.equalsIgnoreCase(""))
            comID = getProperty(configurationData, "comID");

        if (comName == null || comName.equalsIgnoreCase(""))
            comName = getProperty(configurationData, "comName");

        if (timeout == null || timeout.trim().isEmpty()) timeout = getProperty(configurationData, "timeout");
    }

    private static void fillMyProperties(Properties properties, String filePath) {
        InputStreamReader input;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(filePath);
            input = new InputStreamReader(fileInputStream, "UTF8");

            // считываем свойства
            properties.load(input);
        } catch (java.io.FileNotFoundException e) {
            LOGGER.info("Ошибка. Файл config.properties не был найден." + filePath, e);
        } catch (java.io.IOException e) {
            LOGGER.info("IO ошибка в пользовательском методе.", e);
        }
    }

    private static String getProperty(Properties properties, String propertyKey) {
        // получаем значение свойства
        return properties.getProperty(propertyKey);
    }

    //возвращаем инстанс объекта
    public static ConfigurationVariables getInstance() {
        return instance;
    }

}
