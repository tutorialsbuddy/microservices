package com.tutorialsbuddy.userservice.service;

import com.tutorialsbuddy.userservice.dto.ApiResponse;
import com.tutorialsbuddy.userservice.dto.UserRequest;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

  ApiResponse addUser(UserRequest userRequest, HttpServletRequest httpRequest);

  ApiResponse getUserPayments(Long userId, HttpServletRequest httpRequest);

}
