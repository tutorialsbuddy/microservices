package com.tutorialsbuddy.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tutorialsbuddy.userservice.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
