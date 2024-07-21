package Misc;

import Utilities.PropertiesReader;

public class Constants {
    static PropertiesReader props = new PropertiesReader();

    public static String WEBTABLESURL = PropertiesReader.getValue("url")+"webtables";
    public static String TEXTBOXURL = PropertiesReader.getValue("url")+"text-box";
    public static String RADIOBUTTONURL = PropertiesReader.getValue("url")+"radio-button";
    public static String BUTTONSURL = PropertiesReader.getValue("url")+"buttons";
    public static String STUDENTFORMURL = PropertiesReader.getValue("url")+"automation-practice-form";
    public static String RESOURCESFOLDER = "src/test/resources/";
}
