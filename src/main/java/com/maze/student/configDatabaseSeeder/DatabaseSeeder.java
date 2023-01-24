package com.maze.student.configDatabaseSeeder;

import com.maze.student.Role.Roles;
import com.maze.student.Role.RolesRepository;
import com.maze.student.users.ERole;
import com.maze.student.users.SystemUsers;
import com.maze.student.users.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static com.maze.student.users.ERole.*;

@Component
@RequiredArgsConstructor
@Log4j2
public class DatabaseSeeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        Set<Roles> setRoles = new HashSet<>();
        SystemUsers user = new SystemUsers();
        if (rolesRepository.findByName(ROLE_ADMIN).isEmpty()) {
            Roles roles = new Roles();
            roles.setName(ROLE_ADMIN);
            rolesRepository.save(roles);
        }
        if (rolesRepository.findByName(ROLE_MODERATOR).isEmpty()) {
            Roles roles = new Roles();
            roles.setName(ROLE_MODERATOR);
            rolesRepository.save(roles);
        }
        if (rolesRepository.findByName(ROLE_USER).isEmpty()) {
            Roles roles = new Roles();
            roles.setName(ROLE_USER);
            rolesRepository.save(roles);
        }
        if (userRepository.findByUsername("Admin").isEmpty()) {
            user.setUsername("Admin");
            user.setEmail("mz.tesfa@gmail.com");
            user.setPassword(passwordEncoder.encode("123456"));
            Roles adminRole = (Roles) rolesRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            setRoles.add(adminRole);
            user.setRoles(setRoles);
            userRepository.save(user);
        }
    }
}