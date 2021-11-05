package com.global.logic.technicaltest.testbuilders;

import com.global.logic.technicaltest.adapters.model.UserRequest;
import com.global.logic.technicaltest.domain.UserEntity;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class UserBuilder {

  private static final EasyRandomParameters parameters = new EasyRandomParameters()
      .collectionSizeRange(11, 15)
      .stringLengthRange(5, 10)
      .randomize(Integer.class, () -> (Integer) (int) Math.floor(Math.random() * (100) + 1));
  private static final EasyRandom easyRandom = new EasyRandom(parameters);

  public static UserEntity userEntityData(){
    return easyRandom.nextObject(UserEntity.class);
  }

  public static UserRequest userRequestData(){
    UserRequest userRequest = easyRandom.nextObject(UserRequest.class);
    userRequest.getPhones().forEach(phone -> {
      phone.setCitycode(String.valueOf(easyRandom.nextObject(Integer.class)));
      phone.setContrycode(String.valueOf(easyRandom.nextObject(Integer.class)));
      phone.setNumber(String.valueOf(easyRandom.nextObject(Long.class)));
    });
    return userRequest;
  }

}
