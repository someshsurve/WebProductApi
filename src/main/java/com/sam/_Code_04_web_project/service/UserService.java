package com.sam._Code_04_web_project.service;

import com.sam._Code_04_web_project.repository.RoleRepository;
import com.sam._Code_04_web_project.repository.UserRepository;
import com.sam._Code_04_web_project.entity.Role;
import com.sam._Code_04_web_project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepository.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin_01");
        adminUser.setUserPassword(getEncodedPassword("admin_01"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("1");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);

        User adminUser2 = new User();
        adminUser2.setUserName("admin_01");
        adminUser2.setUserPassword(getEncodedPassword("admin_01"));
        adminUser2.setUserFirstName("admin");
        adminUser2.setUserLastName("1");
        Set<Role> adminRoles2 = new HashSet<>();
        adminRoles2.add(adminRole);
        adminUser2.setRole(adminRoles2);
        userRepository.save(adminUser2);

    }

    public User registerNewUser(User user) {
        Role role = roleRepository.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userRepository.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
