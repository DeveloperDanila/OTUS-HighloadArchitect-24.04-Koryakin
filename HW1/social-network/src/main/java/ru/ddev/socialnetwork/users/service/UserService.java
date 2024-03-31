package ru.ddev.socialnetwork.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ddev.socialnetwork.users.api.dto.UserCreateDto;
import ru.ddev.socialnetwork.users.api.dto.UserDto;
import ru.ddev.socialnetwork.users.entity.User;
import ru.ddev.socialnetwork.users.mapper.UserMapper;
import ru.ddev.socialnetwork.users.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserMapper userMapper;
  private final UserRepository userRepository;

  public UserDto create(UserCreateDto dto) {
    User user = userMapper.toEntity(dto);
    user = userRepository.save(user);
    return userMapper.toDto(user);
  }
}
