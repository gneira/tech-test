package com.global.logic.technicaltest.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "created")
  private LocalDateTime created;

  @Column(name = "modified")
  private LocalDateTime modified;

  @Column(name = "last_login")
  private LocalDateTime lastLogin;

  @Column(name = "is_active")
  private boolean isActive = true;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  @JsonManagedReference
  @ToString.Exclude
  private Set<PhoneEntity> phones = new HashSet<>();

  @PrePersist
  public void prePersist() {
    created = LocalDateTime.from(ZonedDateTime.now());
    modified = LocalDateTime.from(ZonedDateTime.now());
    lastLogin = LocalDateTime.from(ZonedDateTime.now());
  }
  @PreUpdate
  public void preUpdate() {
    modified = LocalDateTime.from(ZonedDateTime.now());
  }
}
