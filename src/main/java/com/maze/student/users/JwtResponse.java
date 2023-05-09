package com.maze.student.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@RequiredArgsConstructor
public class JwtResponse {
  private Long id;
  private String token;
  private String type = "Bearer";
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private List<String> roles;

  public JwtResponse(String accessToken, Long id, String username,String firstName,
    String lastName, String email, List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.firstName=firstName;
    this.lastName=lastName;
    this.email = email;
    this.roles = roles;
  }
}
