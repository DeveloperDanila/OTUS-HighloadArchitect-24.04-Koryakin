package ru.ddev.socialnetwork.users.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ddev.socialnetwork.users.api.dto.UserCreateDto;
import ru.ddev.socialnetwork.users.api.dto.UserDto;
import ru.ddev.socialnetwork.users.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<UserDto> create(@RequestBody UserCreateDto dto) {
    return ResponseEntity.ok(userService.create(dto));
  }
}
