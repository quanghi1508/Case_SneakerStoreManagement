package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class InputValidator {
    public static boolean isValidEmployeeID(String code) {
        String regex = "^NV-\\d{3}$";
        return Pattern.matches(regex, code);
    }
    public static boolean isValidDate(String dateofbirth) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateofbirth);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public static boolean isValidPhoneNumber(String phone) {
        String regex = "^09\\d{8}$";
        return Pattern.matches(regex, phone);
    }
    public static boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,6}$";
        return Pattern.matches(regex, email);
    }
    public static boolean isValidGender(String gender) {
        return gender.equalsIgnoreCase("nam") || gender.equalsIgnoreCase("nữ");
    }
    public static boolean isValidCCCD(String cccd) {
        String regex = "^079\\d{9}$"; // Bắt đầu với 079 và 12 chữ số
        return Pattern.matches(regex, cccd);
    }
    public static boolean isValidCustomerCode(String code) {
        String regex = "^KH-\\d{3}$";
        return Pattern.matches(regex, code);
    }
}
