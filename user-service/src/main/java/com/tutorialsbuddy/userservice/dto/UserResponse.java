package com.tutorialsbuddy.userservice.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tutorialsbuddy.userservice.constants.UserStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
  private Long id;
  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private String email;
  private UserStatus status;
  private Date createdDate;
  private Date modifiedDate;
  private String createdBy;
  private String modifiedBy;
  private Object payments;
}
