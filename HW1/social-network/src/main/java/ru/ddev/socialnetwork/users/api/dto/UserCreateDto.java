package ru.ddev.socialnetwork.users.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import ru.ddev.socialnetwork.users.entity.Gender;

import java.time.LocalDate;

public record UserCreateDto(String firstName,
                            String lastName,
                            Gender gender,
                            @DateTimeFormat(pattern = "dd.MM.yyyy")
                            @JsonFormat(pattern = "dd.MM.yyyy")
                            LocalDate birthday,
                            String interests,
                            String city) {
}
