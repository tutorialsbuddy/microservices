package com.tutorialsbuddy.userservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class UserRequest extends ApiRequest {
  private Long id;
  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private String email;
}
