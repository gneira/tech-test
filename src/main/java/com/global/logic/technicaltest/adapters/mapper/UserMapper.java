package com.global.logic.technicaltest.adapters.mapper;

import com.global.logic.technicaltest.adapters.model.UserRequest;
import com.global.logic.technicaltest.adapters.model.UserResponse;
import com.global.logic.technicaltest.domain.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  private final ModelMapper mapper;

  public UserMapper(ModelMapper mapper) {
    this.mapper = mapper;
  }

  public UserResponse mapUserEnt(UserEntity userEntity){
    return mapper.map(userEntity, UserResponse.class);
  }

  public UserEntity mapUserReq(UserRequest userRequest){
    return mapper.map(userRequest, UserEntity.class);
  }
}
