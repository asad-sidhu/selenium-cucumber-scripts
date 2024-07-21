package Misc;

import Utilities.PropertiesReader;

public class Constants {
    static PropertiesReader props = new PropertiesReader();

    public static String WEBTABLESURL = PropertiesReader.getValue("url")+"webtables";
    public static String TEXTBOXURL = PropertiesReader.getValue("url")+"text-box";
    public static String RADIOBUTTONURL = PropertiesReader.getValue("url")+"radio-button";
}
