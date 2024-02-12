package com.tutorialsbuddy.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tutorialsbuddy.userservice.dto.ApiResponse;
import com.tutorialsbuddy.userservice.dto.UserRequest;
import com.tutorialsbuddy.userservice.service.UserService;
import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(path = "/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping(path = "/add")
  public ApiResponse addUser(@RequestBody UserRequest userRequest,
      HttpServletRequest httpRequest) {

    return userService.addUser(userRequest, httpRequest);
  }

  @GetMapping(path = "/{userId}/payments")
  public ApiResponse getUserPayments(@PathVariable(name = "userId") Long userId,
      HttpServletRequest httpRequest) {

    return userService.getUserPayments(userId, httpRequest);
  }

}
