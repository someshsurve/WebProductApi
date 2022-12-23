package com.sam._Code_04_web_project.repository;

import com.sam._Code_04_web_project.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepository extends CrudRepository<Role, String> {

}
