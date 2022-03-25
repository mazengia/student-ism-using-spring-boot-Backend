package com.maze.student.security;

 import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
public interface SecuredRestController {
}
