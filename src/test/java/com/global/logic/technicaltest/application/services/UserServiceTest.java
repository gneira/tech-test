package com.global.logic.technicaltest.application.services;

import com.global.logic.technicaltest.adapters.persistence.UserRepository;
import com.global.logic.technicaltest.domain.UserEntity;
import com.global.logic.technicaltest.testbuilders.UserBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.when;

class UserServiceTest {

  private final UserService userService;
  private final UserRepository userRepository;

  UserServiceTest() {
    this.userRepository =  Mockito.mock(UserRepository.class);;
    this.userService = new UserService(userRepository);
  }

  @Test
  public void userService(){
    UserEntity user = UserBuilder.userEntityData();
    when(userRepository.findByEmail(user.getEmail()))
        .thenReturn(Optional.ofNullable(null));
    when(userRepository.save(user))
        .thenReturn(user);
    userService.create(user);

  }


}