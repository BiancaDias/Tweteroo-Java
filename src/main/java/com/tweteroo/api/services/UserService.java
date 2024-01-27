package com.tweteroo.api.services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    try{
      UserModel user = new UserModel(dto);
      return userRepository.save(user);
    }catch (DataIntegrityViolationException e){
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
}
}
