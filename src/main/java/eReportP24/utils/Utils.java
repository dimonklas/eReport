package eReportP24.utils;

import eReportP24.entity.j3001001.J3001001Data;
import eReportP24.entity.j3001001.J3001001DataItem;
import eReportP24.entity.settingsData.SettingsData;
import eReportP24.entity.settingsData.SettingsDataItem;

import java.util.Random;

public class Utils {

    public static int randomCl(int min, int max){
//        int min = 0, max = 2;
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static SettingsDataItem getNewSettingsDataItem() {
        return new SettingsData().getSettingsDataFromFile().getSettingsData().get(3);
    }

    public static J3001001DataItem getJ3001001DataItem() {
        return new J3001001Data().getJ3001001DataFromFile().getJ3001001Data().get(0);
    }
}
