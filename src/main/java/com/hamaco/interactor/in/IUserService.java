package com.hamaco.interactor.in;

import com.hamaco.dto.UserDTO;

public interface IUserService {
  UserDTO login(String username, String password);
}
