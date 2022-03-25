package com.maze.student.Role;

import com.maze.student.security.SecuredRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/role")
public class RolesController  implements SecuredRestController {

    RolesService rolesService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public RolesDTO addRoles(@Valid @RequestBody Roles roles) {
         return rolesService.addRoles(roles);
    }

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        CollectionModel<RolesDTO> rolesDTOS = rolesService.findAll(page, size);
        if (rolesDTOS != null) {
            return ResponseEntity.ok(rolesDTOS);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findRolesById(@PathVariable Long id) {
        RolesDTO rolesDTO = rolesService.findRolesById(id);
        if (rolesDTO != null) {
            return ResponseEntity.ok(rolesDTO);
        }
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Long> deleteRole(@PathVariable Long id) {

        var isRemoved = rolesService.deleteById(id);

        if (isRemoved == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
