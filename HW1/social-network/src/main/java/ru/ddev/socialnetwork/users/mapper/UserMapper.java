package ru.ddev.socialnetwork.users.mapper;

import org.springframework.stereotype.Service;
import ru.ddev.socialnetwork.users.api.dto.UserCreateDto;
import ru.ddev.socialnetwork.users.api.dto.UserDto;
import ru.ddev.socialnetwork.users.entity.User;

@Service
public class UserMapper {
  public User toEntity(UserCreateDto dto) {
    return User.builder()
        .firstName(dto.firstName())
        .lastName(dto.lastName())
        .gender(dto.gender())
        .birthday(dto.birthday())
        .interests(dto.interests())
        .city(dto.city())
        .build();
  }

  public UserDto toDto(User entity) {
    return UserDto.builder()
        .id(entity.getId())
        .firstName(entity.getFirstName())
        .lastName(entity.getLastName())
        .gender(entity.getGender())
        .birthday(entity.getBirthday())
        .interests(entity.getInterests())
        .city(entity.getCity())
        .build();
  }
}
