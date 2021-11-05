package com.global.logic.technicaltest.adapters.controllers;

import com.global.logic.technicaltest.adapters.mapper.UserMapper;
import com.global.logic.technicaltest.adapters.model.Error;
import com.global.logic.technicaltest.adapters.model.UserRequest;
import com.global.logic.technicaltest.adapters.model.UserResponse;
import com.global.logic.technicaltest.application.services.UserService;
import com.global.logic.technicaltest.configuration.jwt.JwtTokenUtil;
import com.global.logic.technicaltest.domain.enums.BusinessExceptionCode;
import com.global.logic.technicaltest.exception.BusinessException;
import com.global.logic.technicaltest.util.Validations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/v1")
@Slf4j
@CrossOrigin
public class UserController {

  private final AuthenticationManager authenticationManager;
  private final UserDetailsService jwtInMemoryUserDetailsService;
  private final JwtTokenUtil jwtTokenUtil;
  private final UserService userService;
  private final UserMapper mapper;


  public UserController(AuthenticationManager authenticationManager,
                        UserDetailsService jwtInMemoryUserDetailsService,
                        JwtTokenUtil jwtTokenUtil,
                        UserService userService,
                        UserMapper mapper) {
    this.authenticationManager = authenticationManager;
    this.jwtInMemoryUserDetailsService = jwtInMemoryUserDetailsService;
    this.jwtTokenUtil = jwtTokenUtil;
    this.userService = userService;
    this.mapper = mapper;
  }

  @PostMapping(
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE}
  )
  public ResponseEntity createOrUpdateEmployee(UserRequest userRequest) {
    log.info("The creation flow begins");
    UserResponse userResponse;
    try {
      validaciones(userRequest);
      userResponse = mapper.mapUserEnt(userService.create(mapper.mapUserReq(userRequest)));

      final UserDetails userDetails = jwtInMemoryUserDetailsService
          .loadUserByUsername(userRequest.getEmail());
      userResponse.setToken(jwtTokenUtil.generateToken(userDetails));
      return new ResponseEntity(userResponse, new HttpHeaders(), HttpStatus.OK);
    }catch (BusinessException e){
      log.error("A business error has occurred {}", e.getMessage(), e);
      return new ResponseEntity(new Error("A business error has occurred: ".concat( e.getMessage())),
          new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
    }catch (Exception e){
      log.error("An error has occurred in the process {}", e.getMessage(), e);
      return new ResponseEntity(new Error("An error has occurred in the process: ".concat( e.getMessage())),
          new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  private void validaciones(UserRequest userRequest) {
    log.info("start validations user {}",userRequest.getEmail());
    if (!Validations.validateEmail(userRequest.getEmail())) {
      throw new BusinessException(BusinessExceptionCode.INVALID_EMAIL, "invalid email");
    } else if (!Validations.validatePass(userRequest.getPassword())) {
      throw new BusinessException(BusinessExceptionCode.INVALID_PASSWORD, "invalid password");
    }

  }

}
