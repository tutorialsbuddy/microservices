package com.tutorialsbuddy.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
  private boolean success;
  private String message;
  private int errorCode;
  private Object data;

}
