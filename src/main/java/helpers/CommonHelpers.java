package helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CommonHelpers {
    final static String TEXT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getCurrentDate(String format) {
        LocalDateTime currentDate = LocalDateTime.now();
        return currentDate.format(DateTimeFormatter.ofPattern(format));
    }

    public static String getRandomString(String charactersList, int length) {
        int size = charactersList.length();
        StringBuilder stringBuilder = new StringBuilder();
        while (length-- != 0) {
            stringBuilder.append(charactersList.charAt(new Random().nextInt(size)));
        }
        return stringBuilder.toString();
    }
}
