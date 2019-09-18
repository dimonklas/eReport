package eReportP24.utils;

import eReportP24.entity.SettingsData;
import eReportP24.entity.SettingsDataItem;

import java.util.Random;

public class Utils {

    public static int randomCl(){
        int min = 0, max = 2;
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static SettingsDataItem getNewSettingsDataItem() {
        return new SettingsData().getSettingsDataFromFile().getSettingsData().get(3);
    }
}
