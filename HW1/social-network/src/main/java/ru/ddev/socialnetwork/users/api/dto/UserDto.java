package ru.ddev.socialnetwork.users.api.dto;

import lombok.Builder;
import lombok.Value;
import ru.ddev.socialnetwork.users.entity.Gender;

import java.time.LocalDate;

@Value
@Builder
public class UserDto {
   Integer id;
   String firstName;
   String lastName;
   Gender gender;
   LocalDate birthday;
   String interests;
   String city;
}
