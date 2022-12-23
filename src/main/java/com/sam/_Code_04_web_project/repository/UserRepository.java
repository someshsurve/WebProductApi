package com.sam._Code_04_web_project.repository;

import com.sam._Code_04_web_project.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User, String> {
}
