package dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {
    protected boolean emailValid (String email){
       Pattern pattern = Pattern.compile("^((\\w|[+-])+(\\.[\\w-]+)*@+[\\w-]+((\\.[\\d\\p{Alpha}])*(\\.\\p{Alpha}{2,})*)*)$");
       Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    protected boolean phoneValid (String phone){
        Pattern pattern = Pattern.compile("^(\\+?380)([0-9]{9})$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
    protected boolean cityValid (String city){
        Pattern pattern = Pattern.compile("^([A-Za-z]+)$");
        Matcher matcher = pattern.matcher(city);
        return matcher.matches();
    }
    protected boolean passEq (String pass1, String pass2){
        return pass1.equals(pass2);
    }
    protected String validUser (boolean eValid, boolean pValid, boolean cValid, boolean passEq){
        String valid="";
        if(!eValid){valid+="Invalide email;";}
        if(!pValid){valid+="Invalide phone number;";}
        if(!cValid){valid+="Invalide city;";}
        if(!passEq){valid+="Passwords doesn't match;";}
        return valid;
    }
}
