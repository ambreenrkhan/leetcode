package util;

public class Regexes {

    public static void main0(String[] args){
        /*
         * ^ used for starting character of the string.
         * (?=.*[0-9]) used for a digit must occur at least once.
         * (?=.*[a-z]) used for a lowercase alphabet must occur at least once.
         * (?=.*[A-Z]) used for an upper case alphabet that must occur at least once in the substring.
         * (?=.*[@#$%^&-+=()] used for a special character that must occur at least once.
         * (?=\\S+$) white spaces don’t allow in the entire string.
         * .{8, 20} used for at least 8 characters and at most 20 characters.
         * $ used for the end of the string.
         */
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$";


    }
}
