package ru.ddev.socialnetwork.users.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.ddev.socialnetwork.users.entity.User;
import ru.ddev.socialnetwork.utils.LocalDateUtils;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

  private final JdbcTemplate jdbcTemplate;

  private final static String SAVE_USER_SQL = "INSERT INTO users (first_name, last_name, birthday, gender, interests, city) VALUES (?, ?, ?, ?, ?, ?)";

  private final static String GET_USER_BY_ID_SQL = "SELECT * FROM users WHERE id = ? LIMIT 1";

  public User save(User user) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(connection -> {
          PreparedStatement statement = connection.prepareStatement(SAVE_USER_SQL, Statement.RETURN_GENERATED_KEYS);
          statement.setString(1, user.getFirstName());
          statement.setString(2, user.getLastName());
          statement.setDate(3, LocalDateUtils.toSqlDate(user.getBirthday()));
          statement.setObject(4, user.getGender().name().toLowerCase(), Types.OTHER);
          statement.setString(5, user.getInterests());
          statement.setString(6, user.getCity());
          return statement;
    }, keyHolder);
    Integer newId;
    if (keyHolder.getKeys().size() > 1) {
      newId = (Integer)keyHolder.getKeys().get("id");
    } else {
      newId= keyHolder.getKey().intValue();
    }
    user.setId(newId);
    return user;
  }

  public Optional<User> getUserById(Integer id) {
    return Optional.ofNullable(jdbcTemplate.queryForObject(GET_USER_BY_ID_SQL, User.class));
  }
}
