package com.global.logic.technicaltest.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VadidationsTest {

  @Test
  public void validateEmail(){
    List<String> emailsValidos = new ArrayList<>(Arrays.asList("5arbaba13706@bookig.site",
        "rabdullh.sl@mymailcr.com", "mgamerdaantiga6@mbahtekno.net","wcor@nbobd.com", "8ugurdeniz.kurt.f@theanatoly.com"));

    List<String> emailsInvalidos = new ArrayList<>(Arrays.asList("5arbaba13706@bookig,site", "rabdullh.sl.mymailcr.com"));

    for (String email : emailsValidos){
      assertTrue(Validations.validateEmail(email));
    }

    for (String email : emailsInvalidos){
      assertFalse(Validations.validateEmail(email));
    }

  }

  @Test
  public void validatePass(){
    List<String> passValidos = new ArrayList<>(Arrays.asList("Fskjdcskb12",
        "Qoododood33", "Sdfgdfgdfg56","Cfdbdfbdbfd98", "Rsgsdvsdvs44"));

    List<String> passInvalidos = new ArrayList<>(Arrays.asList("5arbaba13706", "rabdullh"));

    for (String email : passValidos){
      assertTrue(Validations.validatePass(email));
    }

    for (String email : passInvalidos){
      assertFalse(Validations.validatePass(email));
    }
  }

}