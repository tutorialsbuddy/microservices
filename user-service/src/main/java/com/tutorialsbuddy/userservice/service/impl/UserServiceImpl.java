package com.tutorialsbuddy.userservice.service.impl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tutorialsbuddy.userservice.client.PaymentClient;
import com.tutorialsbuddy.userservice.dto.ApiResponse;
import com.tutorialsbuddy.userservice.dto.UserRequest;
import com.tutorialsbuddy.userservice.dto.UserResponse;
import com.tutorialsbuddy.userservice.entity.User;
import com.tutorialsbuddy.userservice.repository.UserRepository;
import com.tutorialsbuddy.userservice.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PaymentClient paymentClient;


  @Override
  public ApiResponse addUser(UserRequest userRequest, HttpServletRequest httpRequest) {
    LOGGER.info("addUser: userRequest={}", userRequest);

    User user =
        User.builder().firstName(userRequest.getFirstName()).lastName(userRequest.getLastName())
            .email(userRequest.getEmail()).dateOfBirth(userRequest.getDateOfBirth()).build();

    user = userRepository.save(user);
    UserResponse userResponse =
        UserResponse.builder().id(user.getId()).firstName(user.getFirstName())
            .lastName(user.getLastName()).email(user.getEmail()).dateOfBirth(user.getDateOfBirth())
            .createdBy(user.getCreatedBy()).createdDate(user.getCreatedDate())
            .modifiedBy(user.getModifiedBy()).modifiedDate(user.getModifiedDate()).build();

    // Assuming errorCode is a field in ApiResponse, replace it with the actual field if different
    return ApiResponse.builder().data(userResponse).success(true)
        .message("User added successfully.").build();
  }

  @Override
  public ApiResponse getUserPayments(Long userId, HttpServletRequest httpRequest) {
    LOGGER.info("getUserPayments: userId={}", userId);
    
    Optional<User> userOpt = userRepository.findById(userId);

    if (!userOpt.isPresent()) {
      return ApiResponse.builder().success(true).message("User not found.").build();
    }

    User user = userOpt.get();

    UserResponse userResponse =
        UserResponse.builder().id(user.getId()).firstName(user.getFirstName())
            .lastName(user.getLastName()).email(user.getEmail()).dateOfBirth(user.getDateOfBirth())
            .createdBy(user.getCreatedBy()).createdDate(user.getCreatedDate())
            .modifiedBy(user.getModifiedBy()).modifiedDate(user.getModifiedDate()).build();

    // calling payment service to retrieve payments history
    ApiResponse apiResponse = paymentClient.getPayments(userId);
    userResponse.setPayments(apiResponse.getData() != null ? apiResponse.getData() : null);

    return ApiResponse.builder().data(userResponse).success(true).message("Data found.").build();
  }

}
