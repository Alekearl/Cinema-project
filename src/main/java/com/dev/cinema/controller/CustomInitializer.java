package com.dev.cinema.controller;

import com.dev.cinema.model.Role;
import com.dev.cinema.model.User;
import com.dev.cinema.service.RoleService;
import com.dev.cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomInitializer {
    private RoleService roleService;
    private UserService userService;

    @Autowired
    public CustomInitializer(RoleService roleService,
                           UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role user = new Role();
        user.setRoleName("USER");
        Role roleAdmin = new Role();
        roleAdmin.setRoleName("ADMIN");
        roleService.add(user);
        roleService.add(roleAdmin);
        User admin = new User();
        admin.setEmail("admin@ukr.net");
        admin.setPassword("4321");
        admin.setRoles(Set.of(roleAdmin));
        userService.add(admin);
    }
}
