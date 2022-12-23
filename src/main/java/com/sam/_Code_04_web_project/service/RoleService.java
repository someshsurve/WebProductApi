package com.sam._Code_04_web_project.service;

import com.sam._Code_04_web_project.repository.RoleRepository;
import com.sam._Code_04_web_project.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }
}
