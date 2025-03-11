package com.lirbraryapp.backend.utils;

import java.time.Year;

public class AccountUtils {
    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "This user alread has an account.";

    public static final String ACCOUNT_CREATION_CODE = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = "An account has successfully been created for this user.";
    
    public static final String ACCOUNT_NOT_EXIST_CODE = "003";
    public static final String ACCOUNT_NOT_EXIST_MESSAGE = "Sorry, an account could not be found with the number you provided.";
    
    public static final String ACCOUNT_FOUND_CODE = "004";
    public static final String ACCOUNT_FOUND_MESSAGE = "User account has been found.";

    public static final String ACCOUNT_AUTHORIZED_CODE = "005";
    public static final String ACCOUNT_AUTHORIZED_MESSAGE = "Congrats! This account has been authorized!";

    public static final String ACCOUNT_NOT_AUTHORIZED_CODE = "006";
    public static final String ACCOUNT_NOT_AUTHORIZED_MESSAGE = "Sorry, this account has not yet been authorized.";

    public static String generateAccountNumber() {
        /**
         * current year + randomSixDigitsBetweenMinAndMax
         */
    
        Year currentYear = Year.now();
        int min = 100000;
        int max = 999999;
    
        // Generates random number between min and max
        int randomNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
    
        // Convert current year and random number to strings, the concatenate
        String year = String.valueOf(currentYear);
        String number = String.valueOf(randomNumber);
        StringBuilder accountNumber = new StringBuilder();

        return accountNumber.append(year).append(number).toString();

    }
}
