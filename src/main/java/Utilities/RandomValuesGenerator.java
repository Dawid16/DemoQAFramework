package Utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;


/**
 * Created by Dawidek on 2018-01-31.
 */
public class RandomValuesGenerator {

    public static final String DATE_FORMAT_NOW = "YYYYMMddhhmmss";

    public RandomValuesGenerator(){
    }

    public static String generateRandomUserName() {
        String uuid = UUID.randomUUID().toString();
        return "uuid" + uuid;
    }

    public static String generateRandomEmail() {
        String uuid = UUID.randomUUID().toString();
        return "uuid" + uuid + "@gmail.com";
    }

    public static String generateRandomString(int lengthOfString){
        final String data = "0123456789abcdefghijklmnoprqstuvwxyz,./?!%^&*()";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(lengthOfString);

        for(int i = 0; i<lengthOfString; i++){
            stringBuilder.append(data.charAt(random.nextInt(data.length())));
        }
        return stringBuilder.toString();
    }

    public static int generateRandomNumber(int maxValue){
        Random random = new Random();
        return random.nextInt(maxValue);
    }

    public static String getCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(calendar.getTime());
    }

}
