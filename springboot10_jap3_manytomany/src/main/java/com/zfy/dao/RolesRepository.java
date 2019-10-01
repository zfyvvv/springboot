package com.zfy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zfy.pojo.Roles;
import com.zfy.pojo.Users;

public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
