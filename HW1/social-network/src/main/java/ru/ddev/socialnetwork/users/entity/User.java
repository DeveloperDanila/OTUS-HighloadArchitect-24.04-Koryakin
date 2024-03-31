package ru.ddev.socialnetwork.users.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class User {

  private Integer id;
  private String firstName;
  private String lastName;
  private Gender gender;
  private LocalDate birthday;
  private String interests;
  private String city;

}
