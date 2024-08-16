package com.hamaco.service;

import com.hamaco.dto.UserDTO;
import com.hamaco.interactor.in.IUserService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService implements IUserService {
  @Override
  public UserDTO login(String username, String password) {
    return UserDTO.builder()
        .username(username)
        .hashedPassword("This is a very strong password")
        .email("qkyn1212@gmail.com")
        .phone("0912121817")
        .build();
  }
}
