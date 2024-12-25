package com.increment.meclip.config;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    private static Properties properties = null;

    public ConfigFileReader() {
        try {
            // Đọc file từ resources của project
            File root = new File(System.getProperty("user.dir"));
            File path = new File(root,"src/main/resources/config.properties");

            // Đọc file từ biến config_file trong file runner.bat. Phục vụ cho tool chạy, build tool
//            String path = System.getProperty("config_file");

            // Truyền vào new FileInputStream() biến path theo 1 trong 2 cách đọc file bên trên, cách 1 sẽ dùng chạy code, cách 2 để build tool
            FileInputStream fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
            fis.close();
        } catch (Exception e) {
            throw new RuntimeException("Configuration.properties not found at config.properties");
        }
    }

    public String getDriverPath() {
        String driverPath = null;
        try {
            //get values from properties file
            driverPath = properties.getProperty("driverPath");
//            System.out.println(driverPath);
            return driverPath;
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return driverPath;
//        if (driverPath != null) return driverPath;
//        else
//            throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) {
            try {
                return Long.parseLong(implicitlyWait);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
            }
        }
        return 30;
    }

    public int getViewSecond(){
        String second = properties.getProperty("viewSecond");
        if (second != null) {
            return Integer.parseInt(second);
        }
        else
            throw new RuntimeException("View second not specified in the Configuration.properties file for the Key:viewSecond");
    }

    // Lấy link truy cập
    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) {
            return url;
        }
        else
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
    }

    // Lấy tên đăng nhập
    public String getUserLogin(){
        String phone = properties.getProperty("phone");
        if (phone != null) {
            return phone;
        }
        else
            throw new RuntimeException("Email login not specified in the Configuration.properties file for the Key:phone");
    }

    // Lấy pass đăng nhập
    public String getPassLogin(){
        String pass = properties.getProperty("pass");
        if (pass != null) {
            return pass;
        }
        else
            throw new RuntimeException("Pass login not specified in the Configuration.properties file for the Key:pass");
    }

    // Lấy token
    public String getToken(){
        String token = properties.getProperty("token");
        if (token != null) {
            return token;
        }
        else
            throw new RuntimeException("Token not specified in the Configuration.properties file for the Key:token");
    }

    //Lấy dữ liệu từ file excel
    public String getDataPath() {
        File root = new File(System.getProperty("user.dir"));
        File path = new File(root, properties.getProperty("dataPath"));
        String dataPath = path.getPath();
//        String dataPath = properties.getProperty("dataPath");
//        System.out.println(dataPath);
        if (dataPath != null) return dataPath;
        else
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:dataPath");
    }

    // Lấy browser chạy
    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else if (browserName.equals("internetexplorer")) return DriverType.INTERNETEXPLORER;
        else if (browserName.equals("edge")) return DriverType.EDGE;
        else if (browserName.equals("safari")) return DriverType.SAFARI;
        else
            throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if (environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
        else if (environmentName.equals("remote")) return EnvironmentType.REMOTE;
        else
            throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }

    public Boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if (windowSize != null) return Boolean.valueOf(windowSize);
        return true;
    }

    public String getReportConfigPath() {
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if (reportConfigPath != null) return reportConfigPath;
        else
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public String getTestDataResourcePath() {
        String testDataResourcePath = properties.getProperty("testDataResourcePath");
        if (testDataResourcePath != null) return testDataResourcePath;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    // Lấy thông tin database
    public String getDatabaseUrl() {
        String testDataResourcePath = properties.getProperty("DATABASE_URL");
        if (testDataResourcePath != null) return testDataResourcePath;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getUserDatabase() {
        String testDataResourcePath = properties.getProperty("USERNAME");
        if (testDataResourcePath != null) return testDataResourcePath;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getPassDatabase() {
        String testDataResourcePath = properties.getProperty("PASSWORD");
        if (testDataResourcePath != null) return testDataResourcePath;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getMaxPool() {
        String testDataResourcePath = properties.getProperty("MAX_POOL");
        if (testDataResourcePath != null) return testDataResourcePath;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

}
