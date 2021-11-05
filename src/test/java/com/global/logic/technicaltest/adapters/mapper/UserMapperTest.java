package com.global.logic.technicaltest.adapters.mapper;

import com.global.logic.technicaltest.adapters.model.UserRequest;
import com.global.logic.technicaltest.adapters.model.UserResponse;
import com.global.logic.technicaltest.domain.UserEntity;
import com.global.logic.technicaltest.testbuilders.UserBuilder;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMapperTest {
  private final ModelMapper mapper;
  private final UserMapper userMapper;

  UserMapperTest() {
    this.mapper = new ModelMapper();
    userMapper = new UserMapper(mapper);
  }

  @Test
  public void mapUserEnt(){
    UserEntity userEntity = UserBuilder.userEntityData();
    UserResponse userResponse = userMapper.mapUserEnt(userEntity);
    assertEquals(userEntity.getEmail(), userResponse.getEmail());
    assertEquals(userEntity.getPassword(), userResponse.getPassword());
    assertEquals(userEntity.getCreated(), userResponse.getCreated());
    assertEquals(userEntity.getPhones(), userResponse.getPhones());
  }

  @Test
  public void mapUserReq(){
    UserRequest userRequest = UserBuilder.userRequestData();
    UserEntity userEntity = userMapper.mapUserReq(userRequest);
    assertEquals(userEntity.getEmail(), userRequest.getEmail());
    assertEquals(userEntity.getPassword(), userRequest.getPassword());
    assertEquals(userEntity.getName(), userRequest.getName());

  }
}