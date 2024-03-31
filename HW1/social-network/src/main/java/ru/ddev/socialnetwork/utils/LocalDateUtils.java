package ru.ddev.socialnetwork.utils;

import lombok.experimental.UtilityClass;

import java.sql.Date;
import java.time.LocalDate;

@UtilityClass
public final class LocalDateUtils {

  public static Date toSqlDate(LocalDate localDate) {
    return Date.valueOf(localDate);
  }

}
