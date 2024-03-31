package ru.ddev.socialnetwork.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ddev.socialnetwork.auth.api.dto.LoginDto;
import ru.ddev.socialnetwork.auth.api.dto.TokenDto;

import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

  public ResponseEntity<TokenDto> login(@RequestBody LoginDto dto) {
    return ResponseEntity.ok(new TokenDto(UUID.randomUUID().toString()));
  }

}
