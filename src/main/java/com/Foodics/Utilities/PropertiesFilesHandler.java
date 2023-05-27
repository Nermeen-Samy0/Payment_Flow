package com.Foodics.Utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFilesHandler {

    private Properties properties = new Properties();

    public  PropertiesFilesHandler() {
        try {
            InputStream input = new FileInputStream("src\\test\\java\\resources\\configFiles\\GeneralConfigs.properties");
            properties.load(input);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String getUserEmail() {
        return properties.getProperty("userEmail");
    }
    public String getUserPassword() {return properties.getProperty("userPassword");}
    public String getAddressFullName() {return properties.getProperty("addressFullName");}
    public String getAddressPhoneNumber() {return properties.getProperty("addressPhoneNumber");}
    public String getAddressLine1() {return properties.getProperty("addressLine1");}
    public String getBuildingNameOrNumber() {return properties.getProperty("buildingNameOrNumber");}
    public String getAddressCity() {return properties.getProperty("addressCity");}
    public String getAddressDistrictOrCounty() {return properties.getProperty("addressDistrictOrCounty");}
    public String getAddressLandmark() {return properties.getProperty("addressLandmark");}
    public String getAmountCondition() {return properties.getProperty("amountCondition");}
}
