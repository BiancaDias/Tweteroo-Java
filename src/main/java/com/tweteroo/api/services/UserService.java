package com.tweteroo.api.services;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repository.UserRepository;

@Service
public class UserService {
  final UserRepository userRepository;

  UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  public UserModel save(UserDTO dto) {
    UserModel user = new UserModel(dto);
    return userRepository.save(user);
}
}