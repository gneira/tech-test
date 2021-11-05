package com.global.logic.technicaltest.application.services;

import com.global.logic.technicaltest.adapters.persistence.UserRepository;
import com.global.logic.technicaltest.domain.UserEntity;
import com.global.logic.technicaltest.domain.enums.BusinessExceptionCode;
import com.global.logic.technicaltest.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public UserEntity create(UserEntity user){
    log.info("The creation service starts");

    Optional<UserEntity> userEntity = userRepository.findByEmail(user.getEmail());
    if (userEntity.isPresent()) {
      throw new BusinessException(BusinessExceptionCode.EMAIL_ALREADY_EXISTS, "email already exists");
    }
    log.info("It will be saved in the database user {}", user.getEmail());
    return userRepository.save(user);
  }
}
