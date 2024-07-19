package Misc;

import Utilities.PropertiesReader;

public class Constants {
    static PropertiesReader props = new PropertiesReader();

    public static String WEBTABLESURL = PropertiesReader.getValue("url")+"webtables";
}
