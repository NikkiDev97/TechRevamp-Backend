package com.techrevamp.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.techrevamp.models.User;
import com.techrevamp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserIdToUserDeserializer extends JsonDeserializer<User> {
  @Autowired
  private UserService userService;
  
  @Override
  public User deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
    Long userId = jsonParser.getValueAsLong();
    if (userId != null) {
      return userService.getUserById(userId);
    }
    return null;
  }
}
