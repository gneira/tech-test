package com.global.logic.technicaltest.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

  public static boolean validateEmail(String email){
    if (null != email) {
      String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(email);
      return matcher.matches();
    } else {
      return false;
    }
  }

  public static boolean validatePass(String pass){
    if (null != pass) {
      String regex = "^[A-Z][a-z]*[0-9]{2}$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(pass);
      return matcher.matches();
    } else {
      return false;
    }
  }


}
