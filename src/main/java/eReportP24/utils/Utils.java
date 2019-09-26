package eReportP24.utils;

import java.util.Random;

public class Utils {

    public static int randomCl(int min, int max) {
//        int min = 0, max = 2;
        return new Random().nextInt((max - min) + 1) + min;
    }
}
