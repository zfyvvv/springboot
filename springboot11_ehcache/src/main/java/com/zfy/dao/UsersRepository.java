package com.zfy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zfy.pojo.Users;



public interface UsersRepository extends JpaRepository<Users, Integer> {

}
