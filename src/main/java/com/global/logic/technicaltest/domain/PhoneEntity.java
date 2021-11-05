package com.global.logic.technicaltest.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phone")
public class PhoneEntity {


  @Id
  @SequenceGenerator(name = "phone_id_seq", sequenceName = "phone_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_id_seq")
  @Column(name = "id")
  Long id;

  @Column(name = "number")
  private Long number;

  @Column(name = "citycode")
  private int citycode;

  @Column(name = "countrycode")
  private int contrycode;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", referencedColumnName = "id",
      foreignKey = @ForeignKey(name = "phone_user_id_fk"))
  @JsonBackReference
  @ToString.Exclude
  private UserEntity userEntity;


}
