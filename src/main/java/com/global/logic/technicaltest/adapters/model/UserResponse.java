package com.global.logic.technicaltest.adapters.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
public class UserResponse {

  private UUID id;
  private String name;
  private String email;
  private String password;
  private String token;
  private LocalDateTime created;
  private LocalDateTime modified;
  private LocalDateTime lastLogin;
  private boolean isActive;
  private Set<Phone> phones;
}
